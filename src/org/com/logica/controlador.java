package org.com.logica;

import gnu.io.CommPortIdentifier;
import gnu.io.SerialPort;
import java.io.File;
import java.util.Enumeration;
import java.util.LinkedList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JProgressBar;
import org.com.Serial.last;
import org.com.Serial.puerto;
import org.com.Serial.puertos;
import vistas.impresion;

/**
 *
 * @author Jherson
 */
public class controlador {
    
    public  static File     archivo;
    public  static Integer  velocidad = 9600;
    public  static String   puerto;
    public  static String   contenido_archivo;
    public  static boolean  listo=false;
    private static String[] coordenadas;
    private static int      puntero =0;
    private static last     impresora;
    public  static int      velocidad_entre_comando=1;
    private static boolean  proceso_impresion = false;
    private static Thread   hilo_impresion        ;
    private static impresion vistaImpresora;
    
    private static Thread   hilo_motores        ;
    static int p=0;
    
    private static puerto escritura;
    private static puerto lectura;
    private static CommPortIdentifier puerto_entrada;
    private static CommPortIdentifier puerto_salida;
    
    public static boolean preparar_impresora() {

        try {
            coordenadas = contenido_archivo.split("\n");

            impresora = new last();
            impresora.initialize();

            escritura = new puerto(puerto_salida, velocidad);
            lectura = new puerto(puerto_entrada, velocidad);

            puntero = 0;
            
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    
    public static void iniciar_impresion(JProgressBar barra) {
        
        proceso_impresion = true;
        
        hilo_impresion = new Thread() {
            public void run() {
                try {
                    while (proceso_impresion) {
                        Thread.sleep(velocidad_entre_comando*50);
                        
                        pintar_barra(barra);
                        
                        if(puntero<coordenadas.length)
                            imprimir_figura(puntero,coordenadas[puntero++]);
                        else
                            this.stop();
                    }
                } catch (InterruptedException ie) {
                    System.out.println(ie.getMessage());
                }
            }
        };
        
        hilo_impresion.start();
        
        
        
    }
    
    public static void detener_impresion(){
        try {
            if(hilo_impresion.isAlive()){
                hilo_impresion.suspend();
            }
            
        } catch (Exception e) {
            System.out.println("error al detener impresion"); 
       }
    }
    
    public static void reanudar_impresion(){
        try {
                hilo_impresion.resume();
        } catch (Exception e) {
            System.out.println("Error al reanudar la impresion");
        }
    }
    
    private static void imprimir_figura(int linea,String comando){
       
        System.out.println("Linea: "+linea+", "+comando);
        escritura.escribir_en_serial(comando);
          /*  comando = verificar_comando(comando);
            if (!comando.equals("error") && !comando.equals("")) {
                 System.out.println(comando);
                // impresora.escribir_en_serial(comando);
            }*/
   }

    public static void cancelar_impresion() {
        try {
            hilo_impresion.stop();
        } catch (Exception e) {
            System.out.println("Error al cancelar la impresion");
        }
    }

    private static String verificar_comando(String comando) {
        try{
            return comando.substring(0,comando.indexOf("("));
        }catch(Exception e){
             return "error";
        }
    }

    private static void pintar_barra(JProgressBar barra) {
        double val = (double) puntero / (double) coordenadas.length;
        val = val * 100;
        int valor = (int) val;
        barra.setValue(valor);
        barra.repaint();
    }

    public static void setImpresora(impresion imp) {
        vistaImpresora = imp;
        iniciarHiloMotores();
    }
    
    public static void graficarMotores(int val, String nombre, int valor){
        vistaImpresora.repintarGraficaMotores(val, nombre, valor);
    }

    private static void iniciarHiloMotores() {
         hilo_motores = new Thread() {
            public void run() {
                try {
                    while (true) {
                        Thread.sleep(1000);
                        int val  = (int)Math.floor(Math.random()*100) + 3;
                        //graficarMotores(p++, "Motor x",String.valueOf(val));
                        graficarMotores(val, "Motor x",p++);
                        val  = (int)Math.floor(Math.random()*100) + 3;
                        graficarMotores(val, "Motor y",p);
                        val  = (int)Math.floor(Math.random()*100) + 3;
                        graficarMotores(val, "Motor z",p);
                            
                    }
                } catch (InterruptedException ie) {
                    System.out.println(ie.getMessage());
                }
            }
        };
        
        hilo_motores.start();
    }

    public static LinkedList< puertos>  obtenerPuertosDisponibles(){
  
        LinkedList< puertos> puertos = new LinkedList<>();

        CommPortIdentifier portId = null;

        Enumeration portEnum = CommPortIdentifier.getPortIdentifiers();

        while (portEnum.hasMoreElements()) {

            CommPortIdentifier currPortId = (CommPortIdentifier) portEnum.nextElement();

            puertos.add(new puertos(currPortId.getName(), portId));

        }
        return puertos;
    }
    
    public static void setPuertoLectura( CommPortIdentifier  lectura_puerto){
        puerto_entrada = lectura_puerto;
    }
    
    public static void setPuertoEscritura(CommPortIdentifier escritura_puerto){
        puerto_salida = escritura_puerto;
    }
    
    public static DefaultComboBoxModel<puertos> getModeloPuertos(){
        
        DefaultComboBoxModel<puertos> modelo = new DefaultComboBoxModel<>();
        
        LinkedList< puertos> lista = obtenerPuertosDisponibles();
        
        if(!lista.isEmpty()){
            for(puertos p : lista){
                modelo.addElement(p);
            }
        }
       
        return modelo;
    }
    
}
