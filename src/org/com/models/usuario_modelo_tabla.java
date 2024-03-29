package org.com.models;

import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;
import org.com.bens.usuario;
import org.com.db.usuario_db;

/**
 *
 * @author Jherson
 */
public class usuario_modelo_tabla extends AbstractTableModel{

    public List<usuario>lista;
    public String [] cabecera = {"USUARIO","NOMBRES","APELLIDOS","ROL"};
    private usuario_db usuario;
    
    public usuario_modelo_tabla() {
        usuario =new usuario_db();
        lista=usuario.retornarLista();
    }
    
    public usuario elementAt(int indice){
        return this.lista.get(indice);
    }
    
    @Override
    public int getRowCount() {
        return lista.size();
    }

    @Override
    public int getColumnCount() {
        return cabecera.length;
    }

      @Override
    public Object getValueAt(int a, int b) {
      usuario au = lista.get(a);
      String resultado=null;
      
      switch(b){
          case 0:
              resultado = au.getUsuario();
              break;
          case 1: resultado = au.getNombre();
              break;
          case 2:
              resultado = au.getApellidos();
              break;
          case 3:
              resultado = au.getRol();
              break;
      }
      
      return resultado;
    }
    
     @Override
    public String getColumnName(int i) {
        return cabecera[i];
    }
    
    
    public void agregar_usuario(usuario nuevo){
        int a = usuario.agregar_usuario(nuevo);
        if (a != 1) {
            JOptionPane.showMessageDialog(null, "Se guardo correctamente el usuario: " + nuevo.getNombre(), "Panel de Usuarios", 1);
            this.lista.add(nuevo);
        } else {
            JOptionPane.showMessageDialog(null, "ERROR al guardar el usuario: " + nuevo.getApellidos(), "Panel de Usuarios", 0);
        }
        this.fireTableDataChanged();
    }
    
    
    public void modificar_usuario(usuario nuevo){
        int a = usuario.modifica_usuario(nuevo);
        if (a != 1) {
            JOptionPane.showMessageDialog(null, "Se modifico correctamente el usuario: " + nuevo.getNombre(), "Panel de Usuarios", 1);
        } else {
            JOptionPane.showMessageDialog(null, "ERROR al modificar el usuario: " + nuevo.getApellidos(), "Panel de Usuarios", 0);
        }
        this.fireTableDataChanged();
    }
    
    
    public void eliminar_usuario(usuario nuevo){
        int a = usuario.eliminar_usuario(nuevo);
        if (a != 1) {
            JOptionPane.showMessageDialog(null, "Se elimino correctamente el usuario: " + nuevo.getNombre(), "Panel de Usuarios", 1);
             lista.remove(nuevo);
        } else {
            JOptionPane.showMessageDialog(null, "ERROR al eliminar el usuario: " + nuevo.getNombre(), "Panel de Usuarios", 0);
        }
        this.fireTableDataChanged();
    }
    
}
