package org.com.logica;

import java.io.File;
import javax.swing.JProgressBar;
import org.com.Serial.last;

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
    
    
    
    public static void preparar_impresora(){
        coordenadas = contenido_archivo.split("\n");
        impresora = new last();
        impresora.initialize();
        puntero=0;
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

}
