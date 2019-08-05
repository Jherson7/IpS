package org.com.models;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import org.com.bens.impresion;
import org.com.db.impresion_db;

/**
 *
 * @author Usuario
 */
public class impresion_modelo_tabla extends AbstractTableModel{
    public List<impresion>lista;
    public String [] cabecera = {"LINEA","ARCHIVO","FECHA","USUARIO","ESTADO"};
    private impresion_db impresion;
    
    public impresion_modelo_tabla() {
        impresion =new impresion_db();
        lista=impresion.retornarLista();
    }
    
    public impresion elementAt(int indice){
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
        impresion imp = lista.get(a);
        String resultado = null;

        switch (b) {
            case 0:
                resultado = String.valueOf(imp.getLinea());
                break;
            case 1:
                resultado = imp.getNombre_archivo();
                break;
            case 2:
                resultado = imp.getFecha();
                break;
            case 3:
                resultado = imp.getNombre_usuario();
                break;
            case 4:
                resultado = (imp.getEstado().equals("1"))?"Completada":"Fallida";
                break;
        }

        return resultado;
    }

     @Override
    public String getColumnName(int i) {
        return cabecera[i];
    }
}
