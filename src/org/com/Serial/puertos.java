package org.com.Serial;

import gnu.io.CommPortIdentifier;

/**
 *
 * @author Jherson
 */
public class puertos {
    String nombre;
    CommPortIdentifier puerto;

    public puertos() {
    }

    public puertos(String nombre, CommPortIdentifier puerto) {
        this.nombre = nombre;
        this.puerto = puerto;
    }

    public String getNombre() {
        return nombre;
    }

    public CommPortIdentifier getPuerto() {
        return puerto;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setPuerto(CommPortIdentifier puerto) {
        this.puerto = puerto;
    }

    @Override
    public String toString() {
        return this.nombre;
    }
    
    
    
    
}
