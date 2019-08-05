package org.com.logica;

import gnu.io.CommPortIdentifier;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.LinkedList;
import java.util.Properties;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JProgressBar;
import org.com.Serial.puerto;
import org.com.Serial.puertos;
import org.com.bens.usuario;
import org.com.db.impresion_db;
import vistas.Principal;
import vistas.impresion;

/**
 *
 * @author Jherson
 */
public class controlador {
    
    public  static File      archivo;
    public  static Integer   velocidad = 9600;
    public  static String    puerto;
    public  static String    contenido_archivo;
    public  static boolean   listo=false;
    private static String[]  coordenadas;
    private static int       puntero =0;
    public  static int       velocidad_entre_comando=1;
    private static boolean   proceso_impresion = false;
    private static Thread    hilo_impresion        ;
    private static impresion vista_impresora;
    
    private static Thread    hilo_motores        ;
    public static int p=0;
    static int i =0;
    
    private static puerto escritura;
    private static puerto lectura;
    
    private static CommPortIdentifier puerto_entrada;
    private static CommPortIdentifier puerto_salida;
    
    
    private static JProgressBar  barra_cemento;
    private static impresion_db  impresora_db;
    
    private static  usuario  usuario_actual;
    public  static  String   nombre_archivo;
    public  static  boolean  estado_impresion;
    
    private static String[] comandos_a_excluir;
    public static Principal Principal;
    
    public static boolean preparar_impresora(JProgressBar cemento) {
        
        barra_cemento=cemento;
        
        try {
            coordenadas = contenido_archivo.split("\n");
            nombre_archivo= archivo.getName();
            
            cargar_comandos_a_excluir();
            limpiar_comandos();
            
             // impresora = new last();
             // impresora.initialize();

            escritura = new puerto(puerto_salida, velocidad);
            //lectura = new puerto(puerto_entrada, velocidad,true);

            puntero = 0;
            
            impresora_db = new impresion_db();
            
            estado_impresion = false;
            
         
            
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
    
    public static void  iniciar_impresion(JProgressBar barra) {
        
        proceso_impresion = true;
        
        hilo_impresion = new Thread() {
            public void run() {
                try {
                    while (proceso_impresion) {
                        
                        Thread.sleep(velocidad_entre_comando*50);
                        
                        pintar_barra(barra);
                        
                        if(puntero<coordenadas.length)
                            imprimir_figura(puntero,coordenadas[puntero++]);
                        else{
                            
                            estado_impresion = true;
                            finalizar_impresion();
                            this.stop();
                            
                        }
                            
                    }
                } catch (InterruptedException ie) {
                    System.out.println(ie.getMessage());
                }
            }
        };
        
        hilo_impresion.start();
   
        impresora_db.insertar_archivo(usuario_actual.getIdUSUARIO(),nombre_archivo,contenido_archivo);
        
    }
    
    public static void  detener_impresion(){
        try {
            if(hilo_impresion.isAlive()){
                hilo_impresion.suspend();
            }
            
        } catch (Exception e) {
            System.out.println("error al detener impresion"); 
       }
    }
    
    public static void  reanudar_impresion(){
        try {
           hilo_impresion.resume();
        } catch (Exception e) {
            System.out.println("Error al reanudar la impresion");
        }
    }
    
    private static void imprimir_figura(int linea,String comando){
       
        try {
            System.out.println("Linea: {"+linea+"}, comando:{"+comando+"}");
            escritura.escribir_en_serial(comando); 
        } catch (Exception e) {
            estado_impresion=false;
            finalizar_impresion();
        }
   }
    
    public static void  imprimir_comando(String comando){
           escritura.escribir_en_serial(comando);
    }

    public static void  cancelar_impresion() {
        try {
            hilo_impresion.stop();
            estado_impresion=false;
            
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
  
    public static void  pintar_barra_cemento(int val) {
        barra_cemento.setValue(val);
        barra_cemento.repaint();
    }
    
    public static void  setImpresora(impresion imp) {
        vista_impresora = imp;
        //iniciarHiloMotores();
    }
    
    public static void  graficarMotores(int val, String nombre, int valor){
        vista_impresora.repintarGraficaMotores(val, nombre, valor);
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
                            vista_impresora.eliminarDatos();
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
    
    public static void  setPuertoLectura( CommPortIdentifier  lectura_puerto){
        puerto_entrada = lectura_puerto;
    }
    
    public static void  setPuertoEscritura(CommPortIdentifier escritura_puerto){
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
            if(!(a.startsWith("(")||a.isEmpty()||verificar_comandos(a))){
                coordenadas2[p++]=a;
            }
        }
        
        String coordenadas3[]=new String[p];
        for(int i=0; i< p ; i++)
            coordenadas3[i]=coordenadas2[i];
        
        coordenadas=coordenadas3;
    }
    
    public static void  finalizar_impresion(){
        try {
            archivo=null;
            contenido_archivo="";
           
            listo=false;
            proceso_impresion=false;
            
            escritura.close();
            //lectura.close();
            
            impresora_db.modificar_estado(estado_impresion,puntero);
            
            hilo_impresion.stop();
            
            if(!estado_impresion)
                vista_impresora.terminar_con_error();
            else
                vista_impresora.terminar_con_exito();

        } catch (Exception e) {
            System.out.println("Error al finalizar impresion! "+e.getLocalizedMessage());
        }
    }

    public static void  json_monitoreo(String msn) {
        
        msn = msn.trim().replace("\n", "").replace("\t", "");
        
        msn = msn.substring(msn.indexOf("{") + 1, msn.length() - 2);

        System.out.println(msn);

        String[] estadisticas = msn.split(";");

        for (String a : estadisticas) {
            String aux = a;
            String[] comando = a.split(":");
            switch (comando[0].trim()) {
                case "cemento":
                    graficar_cantidad_cemento(comando[1]);
                    break;
                case "motores":
                    graficar_motores(aux);
                    break;
            }
        }
    }

    private static void graficar_motores(String motor) {
        motor = motor.substring(motor.indexOf(":") + 1).replace("[", "").replace("]", "").trim();

        String[] motores = motor.split(",");
        p++;
        
        
        if ((p % 15)==0) {
            vista_impresora.eliminarDatos();
        }
        
        for (String mot : motores) {

            mot = mot.replace("{", "").replace("}", "").replace("\"", "").trim();

            String[] datos_motor = mot.split(":");
            int valor = Integer.valueOf(datos_motor[1].trim());
            
            controlador.graficarMotores(valor, datos_motor[0], controlador.p);
        }
    }

    private static void graficar_cantidad_cemento(String cemento) {
        pintar_barra_cemento(Integer.parseInt(cemento));
    }

    public static void  set_usuario(usuario usu) {
        usuario_actual = usu;
    }

    private static void cargar_comandos_a_excluir(){
        try {
            Properties prop = new Properties();
            //InputStream input = Conexion.class.getResourceAsStream("src/db_properties.properties");
            InputStream input = new FileInputStream("src/comandos.properties");
            prop.load(input);
            
            
            String comando  = prop.getProperty(("comandos"));
     
            comandos_a_excluir = comando.split(",");
       
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        } 
    }

    private static boolean verificar_comandos(String a) {
         for(String comando: comandos_a_excluir ){
              if(a.equalsIgnoreCase(comando)) 
                  return true;
         }
         return false;    
    } 

    public static void cargar_contenido_archivo(String name, String contenido) {
       controlador.contenido_archivo=contenido;
       controlador.nombre_archivo= name;
    }

    public static void reimprimir() {
        Principal.mostrarVentanaReimpresion();
   }

    public static void mostrar_controlador_impresora() {
       Principal.mostrar_controlador_imp();
    }
    
}
