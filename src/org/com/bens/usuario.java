package org.com.bens;

/**
 *
 * @author Jherson
 */
public class usuario {
   private Integer idUSUARIO;
   private String usuario;
   private String Nombre;
   private String Apellidos;
   private String Password;
   private Integer fRol;
   private String rol;

    public usuario() {
    }

    
    public usuario(Integer idUSUARIO, String usuario, String Nombre, String Apellidos, String Password,  Integer fRol,String rol) {
        this.idUSUARIO = idUSUARIO;
        this.usuario = usuario;
        this.Nombre = Nombre;
        this.Apellidos = Apellidos;
        this.Password = Password;
        this.fRol = fRol;
        this.rol = rol;
        
    }
    

    public Integer getIdUSUARIO() {
        return idUSUARIO;
    }

    public void setIdUSUARIO(Integer idUSUARIO) {
        this.idUSUARIO = idUSUARIO;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getApellidos() {
        return Apellidos;
    }

    public void setApellidos(String Apellidos) {
        this.Apellidos = Apellidos;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }



    public Integer getfRol() {
        return fRol;
    }

    public void setfRol(Integer fRol) {
        this.fRol = fRol;
    }

    @Override
    public String toString() {
        return  Nombre + " " + Apellidos;
    }


    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }
   
}
