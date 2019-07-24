/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.com.db;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import org.com.bens.impresion;

/**
 *
 * @author Usuario
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
            con.setPreparado(con.getConn().prepareStatement(""
                    + "select u.id_usuario,u.usuario,u.nombres,u.apellidos,u.password,u.frol,r.nombre_rol\n" +
                             "from usuario u inner join rol r on u.fRol = r.idROL order by u.nombres asc"));
            res=con.getPreparado().executeQuery();

            while(res.next()){
                impresion imp = new impresion(0, 0, "nombre_archivo","fecha" , "estado", "usuario","CONTENIDO");
                lista.add(imp);
            }
        } catch (SQLException ex) {
            System.out.println("Error al obtener la lista de IMPRESIONES: "+ex.getLocalizedMessage());
        }
        return lista;
    }
     
}
