/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vistas;

import org.com.logica.controlador;

/**
 *
 * @author Usuario
 */
public class json {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        String json ="         {" +
"   	cemento: 90;\n" +
"   	motores : [{\"motor1\": 35},{\"motor2\": 40}]\n" +
"\n" +
"   }           ";
        json = json.trim().replace("\n", "").replace("\t", "");
        
        parsear(json);
    }
    
    
    public static void parsear(String msn){
        msn = msn.substring(msn.indexOf("{")+1,msn.length()-2);
        
        System.out.println(msn);
        
        String []estadisticas = msn.split(";");
        
        for(String a : estadisticas){
            String aux =a  ;
            String []comando = a.split(":");
            switch(comando[0].trim()){
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
       motor =motor.substring(motor.indexOf(":")+1).replace("[", "").replace("]", "").trim();
       
       String []motores = motor.split(",");
       controlador.p++;
       for(String mot : motores){
           
           mot = mot.replace("{", "").replace("}", "").replace("\"", "").trim();
           
           String []datos_motor = mot.split(":");
           
           controlador.graficarMotores(Integer.valueOf(datos_motor[1]), datos_motor[0], controlador.p);
        }
    }

    private static void graficar_cantidad_cemento(String cemento) {
        //controlador.pintar_barra_cemento(Integer.parseInt(cemento));
    }
    
}
