package org.com.db;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import org.com.bens.usuario;

/**
 *
 * @author Jherson
 */
public class usuario_db {
    ResultSet res;
    Conexion con;
    
    
    public usuario_db() {
        con = Conexion.getInstancia();
    }
    
    
    
    public List<usuario> retornarLista(){
        List<usuario> lista = new LinkedList<>();
        try {
            con.setPreparado(con.getConn().prepareStatement(""
                    + "select u.id_usuario,u.usuario,u.nombres,u.apellidos,u.password,u.frol,r.nombre_rol\n" +
                             "from usuario u inner join rol r on u.fRol = r.idROL order by u.nombres asc"));
            res=con.getPreparado().executeQuery();

            while(res.next()){
                usuario au= new usuario(res.getInt(1), res.getString(2),res.getString(3), res.getString(4), res.getString(5), res.getInt(6), res.getString(7));
                lista.add(au);
            }
        } catch (SQLException ex) {
            System.out.println("Error al obtener la lista de USUARIOS: "+ex.getLocalizedMessage());
        }
        return lista;
    }
     
     
    public Integer agregar_usuario(usuario usu){
         try {
            con.setPreparado(con.getConn().prepareStatement("insert into usuario(usuario,nombres,apellidos,password,frol) values(?,?,?,?,?)"));
            con.getPreparado().setString(1, usu.getUsuario());
            con.getPreparado().setString(2, usu.getNombre());
            con.getPreparado().setString(3, usu.getApellidos());
            con.getPreparado().setString(4,usu.getPassword());
            con.getPreparado().setInt(5,usu.getfRol());
            
            con.getPreparado().executeUpdate();
            
            
        } catch (SQLException ex) {
            System.out.println("Error al insertar USUARIO a DB"+ex.getLocalizedMessage());
            return 1;
        }
        return 0;
     }
     
    public Integer modifica_usuario(usuario usu){
          try {
            con.setPreparado(con.getConn().prepareStatement("update usuario set nombres=?,apellidos=?,password=?,frol=?,usuario=? where idusuario=?"));
            con.getPreparado().setString(1, usu.getNombre());
            con.getPreparado().setString(2, usu.getApellidos());
            con.getPreparado().setString(3,usu.getPassword());
            con.getPreparado().setInt(4,usu.getfRol());
            con.getPreparado().setString(5,usu.getUsuario());
            con.getPreparado().setInt(6, usu.getIdUSUARIO());
            
            con.getPreparado().executeUpdate();
            
        } catch (SQLException ex) {
            System.out.println("Error al modificar USUARIO a DB"+ex.getLocalizedMessage());
            return 1;
        }
        return 0;
     }
    
    public Integer eliminar_usuario(usuario usu){
          try {
            con.setPreparado(con.getConn().prepareStatement("delete from usuario where idusuario=?"));
            con.getPreparado().setInt(1, usu.getIdUSUARIO());
            
            con.getPreparado().executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Error al eliminar USUARIO a DB"+ex.getLocalizedMessage());
            return 1;
        }
        return 0;
     }
    
    
      
    public usuario login(String user,String contrasenia){
        usuario usu = null;
        try {
            con.setPreparado(con.getConn().prepareStatement("select * from usuario where usuario=? and password=?"));
            con.getPreparado().setString(1, user);
            con.getPreparado().setString(2, contrasenia);
            
            res=con.getPreparado().executeQuery();

            if(res.next()){
                                        
                usu= new usuario(res.getInt(1), res.getString(2),res.getString(3), res.getString(4), res.getString(5), res.getInt(6),"");
            }
        } catch (SQLException ex) {
            System.out.println("Error al obtener el Usuario en login: "+ex.getLocalizedMessage());
        }
        return usu;
    }
 }
