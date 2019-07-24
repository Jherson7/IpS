package org.com.logica;

import gnu.io.CommPortIdentifier;
import gnu.io.SerialPort;
import java.io.File;
import java.util.Enumeration;
import java.util.LinkedList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JProgressBar;
import jdk.nashorn.internal.parser.JSONParser;
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
    public  static int      velocidad_entre_comando=1;
    private static boolean  proceso_impresion = false;
    private static Thread   hilo_impresion        ;
    private static impresion vistaImpresora;
    
    private static Thread   hilo_motores        ;
    public static int p=0;
    static int i =0;
    
    private static puerto escritura;
    private static puerto lectura;
    
    private static CommPortIdentifier puerto_entrada;
    private static CommPortIdentifier puerto_salida;
    
    
    private static JProgressBar barra_cemento;
    
    public static boolean preparar_impresora() {

        try {
            coordenadas = contenido_archivo.split("\n");

            limpiar_comandos();
            
             // impresora = new last();
             // impresora.initialize();

            escritura = new puerto(puerto_salida, velocidad);
            //lectura = new puerto(puerto_entrada, velocidad);

            puntero = 0;
            
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
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
       
       
       System.out.println("Linea: {"+linea+"}, comando:{"+comando+"}");
       escritura.escribir_en_serial(comando);
       
   }
    
    public static void imprimir_comando(String comando){
           escritura.escribir_en_serial(comando);
    }

    public static void cancelar_impresion() {
        try {
            hilo_impresion.stop();
        } catch (Exception e) {
            System.out.println("Error al cancelar la impresion");
        }
    }

    private static void pintar_barra(JProgressBar barra) {
        double val = (double) puntero / (double) coordenadas.length;
        val = val * 100;
        int valor = (int) val;
        barra.setValue(valor);
        barra.repaint();
    }
    
    
    public static void pintar_barra_cemento(int val) {
        barra_cemento.setValue(val);
        barra_cemento.repaint();
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
                        
                        i++;
                        if(i==15){
                            vistaImpresora.eliminarDatos();
                            i=0;
                        }
                            
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

            puertos.add(new puertos(currPortId.getName(), currPortId));

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

    private static void limpiar_comandos() {
        String coordenadas2[] = new String[coordenadas.length];
        int p=0;
        for(String a : coordenadas){
            if(!(a.startsWith("(")||a.isEmpty())){
                coordenadas2[p++]=a;
            }
        }
        
        String coordenadas3[]=new String[p];
        for(int i=0; i< p ; i++)
            coordenadas3[i]=coordenadas2[i];
        
        coordenadas=coordenadas3;
    }
    
    public static void finalizar_impresion(){
        try {
            archivo=null;
            contenido_archivo="";
            hilo_impresion.stop();
            listo=false;
            proceso_impresion=false;
            
            escritura.close();
            //lectura.close();

        } catch (Exception e) {
            System.out.println("Error al finalizar impresion! "+e.getLocalizedMessage());
        }
    }

    public static void jsonMonitoreo(String json){
        
    }
}
