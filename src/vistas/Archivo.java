package vistas;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import org.com.logica.controlador;

/**
 *
 * @author Jherson
 */
public class Archivo extends javax.swing.JInternalFrame {

    private boolean archivo_cargado;
    
    public Archivo() {
        initComponents();
        txt_puerto.setText("COM11");
        txt_velocidad.setText("9600");
    }

  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        btn_seleccionar_archivo = new javax.swing.JButton();
        btn_cargar_archivo = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txt_velocidad = new javax.swing.JTextField();
        txt_puerto = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        btn_guardar = new javax.swing.JButton();
        btn_salir = new javax.swing.JButton();

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Archivo"));

        btn_seleccionar_archivo.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        btn_seleccionar_archivo.setText("Seleccionar Archivo");
        btn_seleccionar_archivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_seleccionar_archivoActionPerformed(evt);
            }
        });

        btn_cargar_archivo.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        btn_cargar_archivo.setText("Cargar Archivo");
        btn_cargar_archivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cargar_archivoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btn_cargar_archivo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_seleccionar_archivo, javax.swing.GroupLayout.DEFAULT_SIZE, 187, Short.MAX_VALUE))
                .addContainerGap(55, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(btn_seleccionar_archivo, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_cargar_archivo, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(25, Short.MAX_VALUE))
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Puerto Serial"));

        jLabel1.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        jLabel1.setText("Velocidad:");

        jLabel2.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        jLabel2.setText("Puerto:");

        txt_velocidad.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        txt_velocidad.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_velocidadKeyReleased(evt);
            }
        });

        txt_puerto.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txt_velocidad)
                    .addComponent(txt_puerto, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(18, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txt_velocidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txt_puerto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel3.setText("CONFIGURACIONES INICIALES");

        btn_guardar.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        btn_guardar.setText("GUARDAR");
        btn_guardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_guardarActionPerformed(evt);
            }
        });

        btn_salir.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        btn_salir.setText("SALIR");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(91, 91, 91)
                        .addComponent(btn_guardar, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btn_salir, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addGap(100, 100, 100))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_guardar, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_salir, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(19, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_seleccionar_archivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_seleccionar_archivoActionPerformed
        // TODO add your handling code here:
        seleccionar_archivo();
    }//GEN-LAST:event_btn_seleccionar_archivoActionPerformed

    private void btn_cargar_archivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cargar_archivoActionPerformed
        // TODO add your handling code here:
        cargar_archivo();
    }//GEN-LAST:event_btn_cargar_archivoActionPerformed

    private void btn_guardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_guardarActionPerformed
        // TODO add your handling code here:
        if(guardar_velocidad()){
            if(guardar_puerto()){
                if(archivo_cargado){
                    JOptionPane.showMessageDialog(this, "Se cargaron correctamente los parametros para la impresion","EXITO",1);
                    controlador.listo=true;
                    controlador.preparar_impresora();
                    this.dispose();
                }
            }
        }
    }//GEN-LAST:event_btn_guardarActionPerformed

    private void txt_velocidadKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_velocidadKeyReleased
        // TODO add your handling code here:\
        try {
            Double.parseDouble(txt_velocidad.getText());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Debe ingresar solo numeros!","ERROR",0);
        }
    }//GEN-LAST:event_txt_velocidadKeyReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_cargar_archivo;
    private javax.swing.JButton btn_guardar;
    private javax.swing.JButton btn_salir;
    private javax.swing.JButton btn_seleccionar_archivo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JTextField txt_puerto;
    private javax.swing.JTextField txt_velocidad;
    // End of variables declaration//GEN-END:variables

    private void seleccionar_archivo() {
        JFileChooser jf = new JFileChooser("C:\\Users\\Jherson\\Documents\\UNIVERSIDAD\\2 SEM 2018\\EPS\\Softwares");
        
        jf.setFileSelectionMode(JFileChooser.FILES_ONLY);
        
        jf.setFileFilter(null);
        
        jf.setAcceptAllFileFilterUsed(false);
         
        FileFilter filtro1 = new FileNameExtensionFilter("Archivos G", "g","gcode"); 

        jf.setFileFilter(filtro1);
  
        int res = jf.showOpenDialog(this);
        
        if(res==JFileChooser.APPROVE_OPTION){
            controlador.archivo = jf.getSelectedFile();
        }
    }

    private void cargar_archivo() {
         try {
          String line="";
          String contenido="";
                 
          FileReader fr = new FileReader(controlador.archivo);
          BufferedReader br = 
                new BufferedReader(fr);

            while((line = br.readLine()) != null) {
                contenido+=line+"\n";
            }   
            //System.out.println(contenido);
            controlador.contenido_archivo=contenido;
            archivo_cargado=true;
            br.close();                                                     
        } catch (IOException ex) {
          System.out.println("problem accessing file"+controlador.archivo.getAbsolutePath());
        }
    }

    private boolean guardar_velocidad() {
        try {
            controlador.velocidad=Integer.parseInt(txt_velocidad.getText());
            return true;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error en el parametro de volocidad","Error",0);
        }
        return false;
    }

    private boolean guardar_puerto() {
        if(txt_puerto.getText().isEmpty())
        {
            if(txt_puerto.getText().contains("COM"))
            {
                controlador.puerto=txt_puerto.getText();
                return true;
            }
            return false;
        }else{
            
            return true;
        }
    }
}
