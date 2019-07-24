/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.com.controler;

import org.com.models.impresion_modelo_tabla;

/**
 *
 * @author Usuario
 */
public class impresion_controller {
    private static impresion_modelo_tabla tabla;

    
    public static impresion_modelo_tabla getTabla(){
        tabla = new impresion_modelo_tabla();
        return tabla;
    }
}
