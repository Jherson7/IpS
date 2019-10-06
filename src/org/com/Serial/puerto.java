package org.com.Serial;


//import gnu.io.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import gnu.io.CommPortIdentifier;
import gnu.io.SerialPort;
import gnu.io.SerialPortEvent;
import gnu.io.SerialPortEventListener;
import java.awt.HeadlessException;
import java.io.PrintStream;
import javax.swing.JOptionPane;
import org.com.logica.controlador;

public class puerto extends javax.swing.JFrame implements SerialPortEventListener {

    SerialPort serialPort;
    CommPortIdentifier portId = null;
    Boolean flag =false;
    Boolean leyendo = false;
    String  comando="";
    int no_errores=0;
    /**
     * A BufferedReader which will be fed by a InputStreamReader converting the
     * bytes into characters making the displayed results codepage independent
     */
    private BufferedReader input;
    /**
     * The output stream to the port
     */
    private OutputStream output;
    /**
     * Milliseconds to block while waiting for port open
     */
    private static final int TIME_OUT = 2000;
    /**
     * Default bits per second for COM port.
     */
    private static int DATA_RATE = 9600;

    
    public puerto(CommPortIdentifier puerto, int velocidad) throws HeadlessException {
        this.portId = puerto;
        DATA_RATE = velocidad;
        
        initialize();
    }
    
       public puerto(CommPortIdentifier puerto, int velocidad, boolean flag) throws HeadlessException {
        this.portId = puerto;
        DATA_RATE = velocidad;
        this.flag=flag;
        initialize();
    }
    
    
    public void initialize() {
           
        if (portId == null) {
            System.out.println("Could not find COM port.");
            return;
        }

        try {
            // open serial port, and use class name for the appName.
            serialPort = (SerialPort) portId.open(this.getClass().getName(),
                    TIME_OUT);

            // set port parameters
            serialPort.setSerialPortParams(DATA_RATE,
                    SerialPort.DATABITS_8,
                    SerialPort.STOPBITS_1,
                    SerialPort.PARITY_NONE);

            // open the streams
            input = new BufferedReader(new InputStreamReader(serialPort.getInputStream()));
            output = serialPort.getOutputStream();

            // add event listeners
            serialPort.addEventListener(this);
            serialPort.notifyOnDataAvailable(true);

        } catch (Exception e) {
            System.err.println("Error iniciando" + e.toString());
        }
    }

    /**
     * This should be called when you stop using the port. This will prevent
     * port locking on platforms like Linux.
     */
    public synchronized void close() {
        if (serialPort != null) {
            serialPort.removeEventListener();
            serialPort.close();
        }
    }

    /**
     * Handle an event on the serial port. Read the data and print it.
     */
    public synchronized void serialEvent(SerialPortEvent oEvent) {
        String codigo = "";
        if (oEvent.getEventType() == SerialPortEvent.DATA_AVAILABLE) {
            try {
                codigo = input.readLine();
                
                System.out.println("Recibido: " + codigo);
                leer_del_puerto(codigo);
                //String res = getRandomHexa();
            } catch (Exception e) {
                System.err.println("Hay error recibiendo: " + codigo + "," + e.toString());
                no_errores++;
                if(no_errores>=100){
                    JOptionPane.showMessageDialog(null, "Se ha perdido la comunicacion con uno de los puertos, finalice la impresion","ERROR",0);
                    this.close();
                }
            }
            // Ignore all the other eventTypes, but you should consider the other ones.
        }
    }

    private void leer_del_puerto(String codigo) {
       if(flag){
            if (codigo.equals("{")) {
                leyendo = true;
                comando = "{";
            } else if (leyendo) {
                if (codigo.equals("}")) {
                    comando += "}";
                    try {
                        controlador.json_monitoreo(comando);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    leyendo = false;
                } else {
                    comando += codigo;
                }
            }
        }
       else{//si no es flag este puerto es de escritura
           //por lo que debe recibir un ok despues que se le envia un comando
           //en caso contrario se perdio la comunicacion.
           //if(codigo.contains("ok"))
           
       }
    }

    public void escribir_en_serial(String men) {
        //try {
        men = men + "\n";
        PrintStream printStream = new PrintStream(output);
        printStream.print(men);
        printStream.close();

        // output.write(men.getBytes());
        /*  } catch (IOException ex) {
                System.out.println("Erro al escribir el mensaje: "+men+", "+ex.getMessage());
            }*/
    }


}
