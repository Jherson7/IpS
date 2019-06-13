package org.com.controler;

import org.com.models.usuario_modelo_tabla;

/**
 *
 * @author Jherson
 */

public class usuario_controller {
    
    private static usuario_modelo_tabla tabla;

    
    public static usuario_modelo_tabla getTabla(){
        tabla = new usuario_modelo_tabla();
        return tabla;
    }
    
}
