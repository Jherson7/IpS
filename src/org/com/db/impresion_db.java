package org.com.db;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import org.com.bens.impresion;

/**
 *
 * @author Jherson
 */
public class impresion_db {
    ResultSet res;
    Conexion con;
    
    
    public impresion_db() {
        con = Conexion.getInstancia();
    }
    
    
    public List<impresion> retornarLista(){
        List<impresion> lista = new LinkedList<>();
        try {
            con.setPreparado(con.getConn().prepareStatement("select * from impresion"));
            res=con.getPreparado().executeQuery();

            while(res.next()){
                
                impresion imp = new impresion(res.getInt(1), res.getString(2), res.getString(3),
                        res.getString(4), res.getString(5), res.getInt(6),res.getInt(7));
                
                lista.add(imp);
            }
        } catch (SQLException ex) {
            System.out.println("Error al obtener la lista de IMPRESIONES: "+ex.getLocalizedMessage());
        }
        return lista;
    }
    
    public List<impresion> retornarListaConFecha(Date inicio, Date fin){
        List<impresion> lista = new LinkedList<>();
        try {
            con.setPreparado(con.getConn().prepareStatement("select * from impresion where fecha between "
                    + "'" + new java.sql.Date(inicio.getTime()) + "' and '" + new java.sql.Date(fin.getTime())
                    + "'"));
            res=con.getPreparado().executeQuery();

            while(res.next()){
                
                impresion imp = new impresion(res.getInt(1), res.getString(2), res.getString(3),
                        res.getString(4), res.getString(5), res.getInt(6),res.getInt(7));
                
                lista.add(imp);
            }
        } catch (SQLException ex) {
            System.out.println("Error al obtener la lista de IMPRESIONES: "+ex.getLocalizedMessage());
        }
        return lista;
    }

    public void insertar_archivo(String usuario,String nombre_archivo,String contenido_archivo) {
        try {
            con.setPreparado(con.getConn().prepareStatement("insert into impresion "
                    + "(usuario, nombre_archivo, contenido_archivo,fecha)"
                    + " values(?,?,?,current_date())"));
            
            
            con.getPreparado().setString(1, usuario);
            con.getPreparado().setString(2, nombre_archivo);
            con.getPreparado().setString(3, contenido_archivo);
            
            con.getPreparado().executeUpdate();

          
        } catch (SQLException ex) {
            System.out.println("Error al insertar el archivo en BD: "+ex.getLocalizedMessage());
        }
    }

    public void modificar_estado(boolean estado_impresion, int puntero) {
        
        try {
            con.setPreparado(con.getConn().prepareStatement("update impresion "
                    + "set estado = ? , linea = ? where id_impresion = last_insert_id()"));
            
            int estado = 0;
            if(estado_impresion)
                estado=1;
            
            con.getPreparado().setInt(1, estado);
            con.getPreparado().setInt(2, puntero);
            
            con.getPreparado().executeUpdate();

          
        } catch (SQLException ex) {
            System.out.println("Error al modificar el archivo en BD: "+ex.getLocalizedMessage());
        }
        
    }
     
}
