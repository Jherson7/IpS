package vistas;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import org.com.Serial.puertos;
import org.com.logica.controlador;
import org.com.visor.VisualizerWindow;

/**
 *
 * @author Jherson
 */
public class Archivo_reimpresion extends javax.swing.JInternalFrame {

    private boolean archivo_cargado;
    
    public Archivo_reimpresion() {
        initComponents();
       // txt_puerto.setText("COM11");
        txt_velocidad.setText("9600");
        
        this.cmb_salida.setModel(controlador.getModeloPuertos());
        this.cmb_entrada.setModel(controlador.getModeloPuertos());
        
        if(this.cmb_entrada.getSelectedIndex() == -1)
            JOptionPane.showMessageDialog(this, "No se han detectado puertos disponibles, "
                    + "conecte impresora y vuelva a intentar","ERROR",0);
    }

  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txt_velocidad = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        cmb_salida = new javax.swing.JComboBox();
        cmb_entrada = new javax.swing.JComboBox();
        jLabel3 = new javax.swing.JLabel();
        btn_guardar = new javax.swing.JButton();
        btn_salir = new javax.swing.JButton();

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Puerto Serial"));

        jLabel1.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        jLabel1.setText("Velocidad:");

        txt_velocidad.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        txt_velocidad.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_velocidadKeyReleased(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        jLabel4.setText("Salida:");

        jLabel5.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        jLabel5.setText("Entrada:");

        cmb_salida.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        cmb_entrada.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel5)
                    .addComponent(jLabel4))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cmb_entrada, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txt_velocidad, javax.swing.GroupLayout.DEFAULT_SIZE, 94, Short.MAX_VALUE)
                    .addComponent(cmb_salida, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txt_velocidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(cmb_salida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(cmb_entrada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(46, Short.MAX_VALUE))
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
        btn_salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_salirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(141, 141, 141)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(48, 48, 48)
                        .addComponent(btn_guardar, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(49, 49, 49)
                        .addComponent(btn_salir, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(72, 72, 72)
                        .addComponent(jLabel3)))
                .addContainerGap(18, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_guardar, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_salir, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_guardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_guardarActionPerformed
        // TODO add your handling code here:
        
        if (guardar_velocidad()) {
            if (guardar_puerto()) {

                JOptionPane.showMessageDialog(this, "Se cargaron correctamente los parametros para la impresion", "EXITO", 1);
                controlador.listo = true;
                //controlador.preparar_impresora();
                controlador.mostrar_controlador_impresora();
                this.dispose();

            }
         } else {
            JOptionPane.showMessageDialog(this, "Aun no se ha cargado el archivo gcode", "ERROR", 0);
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

    private void btn_salirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_salirActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_btn_salirActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_guardar;
    private javax.swing.JButton btn_salir;
    private javax.swing.JComboBox cmb_entrada;
    private javax.swing.JComboBox cmb_salida;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel4;
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
            
            VisualizerWindow vw = new VisualizerWindow();
            //if (this.fileTextField.getText().length() > 1) {
            vw.setGcodeFile(jf.getSelectedFile().toString());
            //}
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
            controlador.cargar_contenido_archivo(controlador.archivo.getName(),contenido);
            archivo_cargado=true;
            br.close();                                                     
        } catch (IOException ex) {
          System.out.println("problem accessing file"+controlador.archivo.getAbsolutePath());
        }
    }

    private boolean guardar_velocidad() {
        try {
            controlador.velocidad = Integer.parseInt(txt_velocidad.getText());
            return true;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error en el parametro de velocidad","Error",0);
            return false;
        }
    }

    private boolean guardar_puerto() {
        
        puertos entrada =(puertos)cmb_entrada.getSelectedItem();
        puertos salida = (puertos)cmb_salida.getSelectedItem();        
        
      /*  if(entrada.getNombre() .equals(salida.getNombre())){
             JOptionPane.showMessageDialog(this, "Debe seleccionar puerto distinto de S/E","ERROR",0);
             return false;
        }*/
        
        controlador.setPuertoEscritura(salida.getPuerto());
        controlador.setPuertoLectura(entrada.getPuerto());
        
        return true;
        
        /*if (txt_puerto.getText().isEmpty()) {
            if (txt_puerto.getText().contains("COM")) {
                controlador.puerto = txt_puerto.getText();
                return true;
            }
            return false;
        } else {

            return true;
        }*/
    }
}
