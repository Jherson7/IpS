package vistas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import org.com.logica.controlador;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

/**
 *
 * @author Jherson
 */
public class impresion extends javax.swing.JInternalFrame {

    
    int p=1;
    String [][]graficas = {{"Negocio 1", "Lunes"},{"Negocio 1", "Martes"},
            {"Negocio 1", "Miércoles"},{"Negocio 1", "Jueves"},{"Negocio 1", "Viernes"},{"Negocio 1", "Sábado"},{"Negocio 1", "Domingo"}};
    JFreeChart Grafica;
    
    DefaultCategoryDataset Datos = new DefaultCategoryDataset(); 

    
    private void cargar_grafico_motores() {
    
        
       // Datos.addValue(1, "Negocio 1", "Lunes");

        Grafica = ChartFactory.createLineChart(null,
                "Tiempo", "Temperatura", Datos,
                PlotOrientation.VERTICAL, true, true, false);

        ChartPanel Panel = chart();//new ChartPanel(Grafica);

        this.panel_motores.setLayout(new BorderLayout());
        this.panel_motores.setSize(new Dimension(300, 300));
        panel_motores.add(Panel, BorderLayout.NORTH);
        this.pack();
        this.repaint();
    }
    
    
    private enum estados {INICIO,IMPRESION,REANUDAR,DETENER,CANCELAR};
    
    private void Estado(estados estado){
        switch(estado){
            case INICIO:
                
                btn_iniciar.setEnabled(true);
                btn_cancelar.setEnabled(false);
                btn_reanudar.setEnabled(false);
                btn_pausar.setEnabled(false);
                
                break;
            case IMPRESION:
                btn_iniciar.setEnabled(false);
                btn_cancelar.setEnabled(true);
                btn_reanudar.setEnabled(false);
                btn_pausar.setEnabled(true);
                break;
            case REANUDAR:
                btn_iniciar.setEnabled(false);
                btn_cancelar.setEnabled(true);
                btn_reanudar.setEnabled(false);
                btn_pausar.setEnabled(true);
                break;
            case DETENER:
                btn_iniciar.setEnabled(false);
                btn_cancelar.setEnabled(true);
                btn_reanudar.setEnabled(true);
                btn_pausar.setEnabled(false);
                break;
            case CANCELAR:
                btn_iniciar.setEnabled(true);
                btn_cancelar.setEnabled(false);
                btn_reanudar.setEnabled(false);
                btn_pausar.setEnabled(false);
                break;
        }
    }
    
    
    
    public impresion() {
//        if(!controlador.listo){
//            JOptionPane.showMessageDialog(this, "No se han cargado las configuraciones iiciales","ERROR",0);
//            this.dispose();
//            return;
//        }
    
        initComponents();
        lbl_vel.setText(sld_velocidad.getValue() + "Seg");
        Estado(estados.INICIO);
        this.getContentPane().setBackground(new Color(53, 19, 48));
        barra_cemento.setOrientation(SwingConstants.VERTICAL);
        //this.repaint();
     
        cargar_grafico_motores();
        
        controlador.preparar_impresora();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        btn_iniciar = new javax.swing.JButton();
        btn_reanudar = new javax.swing.JButton();
        btn_pausar = new javax.swing.JButton();
        btn_cancelar = new javax.swing.JButton();
        sld_velocidad = new javax.swing.JSlider();
        jLabel4 = new javax.swing.JLabel();
        lbl_vel = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        prg_bar = new javax.swing.JProgressBar();
        jPanel8 = new javax.swing.JPanel();
        lbl_progreso = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        barra_cemento = new javax.swing.JProgressBar();
        Porcentaje = new javax.swing.JLabel();
        panel_motores = new javax.swing.JPanel();
        panel_extrusor = new javax.swing.JPanel();
        btn_salir = new javax.swing.JButton();

        jPanel1.setBackground(new java.awt.Color(204, 42, 65));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Controlador"));

        btn_iniciar.setFont(new java.awt.Font("Trebuchet MS", 1, 11)); // NOI18N
        btn_iniciar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/com/pictures/boton-de-reproduccion.png"))); // NOI18N
        btn_iniciar.setText("INICIAR IMPRESION");
        btn_iniciar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_iniciarActionPerformed(evt);
            }
        });

        btn_reanudar.setFont(new java.awt.Font("Trebuchet MS", 1, 11)); // NOI18N
        btn_reanudar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/com/pictures/reanudar.png"))); // NOI18N
        btn_reanudar.setText("REANUDAR IMPRESION");
        btn_reanudar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_reanudarActionPerformed(evt);
            }
        });

        btn_pausar.setFont(new java.awt.Font("Trebuchet MS", 1, 11)); // NOI18N
        btn_pausar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/com/pictures/pausa.png"))); // NOI18N
        btn_pausar.setText("PAUSAR IMPRESION");
        btn_pausar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_pausarActionPerformed(evt);
            }
        });

        btn_cancelar.setFont(new java.awt.Font("Trebuchet MS", 1, 11)); // NOI18N
        btn_cancelar.setText("CANCELAR IMPRESION");
        btn_cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cancelarActionPerformed(evt);
            }
        });

        sld_velocidad.setMinimum(1);
        sld_velocidad.setValue(1);
        sld_velocidad.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                sld_velocidadStateChanged(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Velocidad entre instruccion:");

        lbl_vel.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lbl_vel.setText("lbl_vel");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btn_cancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_pausar, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_reanudar, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lbl_vel)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btn_iniciar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(sld_velocidad, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(20, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(lbl_vel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(sld_velocidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btn_iniciar, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btn_pausar, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btn_reanudar, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_cancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jLabel1.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(232, 202, 164));
        jLabel1.setText("CONTROL Y MONITOREO DE LA IMPRESORA");

        jPanel2.setBackground(new java.awt.Color(66, 66, 84));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("MONITOREO"));
        jPanel2.setForeground(new java.awt.Color(255, 255, 255));

        jPanel3.setBackground(new java.awt.Color(100, 144, 138));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "PROGRESO DE IMPRESION", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11), new java.awt.Color(255, 255, 255))); // NOI18N

        prg_bar.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                prg_barStateChanged(evt);
            }
        });

        jPanel8.setBackground(new java.awt.Color(100, 144, 138));
        jPanel8.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbl_progreso.setBackground(new java.awt.Color(100, 144, 138));
        lbl_progreso.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        lbl_progreso.setText("00%");
        jPanel8.add(lbl_progreso, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, 140, -1));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(prg_bar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(71, 71, 71)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(104, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 39, Short.MAX_VALUE)
                .addComponent(prg_bar, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30))
        );

        jPanel4.setBackground(new java.awt.Color(204, 95, 61));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "CANTIDAD DE CEMENTO", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11), new java.awt.Color(255, 255, 255))); // NOI18N

        Porcentaje.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        Porcentaje.setText("00%");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(Porcentaje)
                .addGap(18, 18, 18)
                .addComponent(barra_cemento, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(barra_cemento, javax.swing.GroupLayout.DEFAULT_SIZE, 196, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(66, 66, 66)
                .addComponent(Porcentaje)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        panel_motores.setBackground(new java.awt.Color(204, 95, 61));
        panel_motores.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "MOTORES", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11), new java.awt.Color(255, 255, 255))); // NOI18N

        javax.swing.GroupLayout panel_motoresLayout = new javax.swing.GroupLayout(panel_motores);
        panel_motores.setLayout(panel_motoresLayout);
        panel_motoresLayout.setHorizontalGroup(
            panel_motoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        panel_motoresLayout.setVerticalGroup(
            panel_motoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        panel_extrusor.setBackground(new java.awt.Color(100, 144, 138));
        panel_extrusor.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "EXTRUSOR", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11), new java.awt.Color(255, 255, 255))); // NOI18N

        javax.swing.GroupLayout panel_extrusorLayout = new javax.swing.GroupLayout(panel_extrusor);
        panel_extrusor.setLayout(panel_extrusorLayout);
        panel_extrusorLayout.setHorizontalGroup(
            panel_extrusorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 345, Short.MAX_VALUE)
        );
        panel_extrusorLayout.setVerticalGroup(
            panel_extrusorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 199, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panel_extrusor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panel_motores, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(panel_extrusor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panel_motores, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btn_salir.setFont(new java.awt.Font("Trebuchet MS", 1, 11)); // NOI18N
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
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btn_salir, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(35, 35, 35)))
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(103, 103, 103))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(36, 36, 36)
                        .addComponent(btn_salir, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 85, Short.MAX_VALUE)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_iniciarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_iniciarActionPerformed
        controlador.iniciar_impresion(prg_bar);
        Estado(estados.IMPRESION);
    }//GEN-LAST:event_btn_iniciarActionPerformed

    private void sld_velocidadStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_sld_velocidadStateChanged
        lbl_vel.setText(sld_velocidad.getValue()+"  seg");
        controlador.velocidad_entre_comando=(int)sld_velocidad.getValue();
    }//GEN-LAST:event_sld_velocidadStateChanged

    private void btn_pausarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_pausarActionPerformed
        controlador.detener_impresion();
        Estado(estados.DETENER);
    }//GEN-LAST:event_btn_pausarActionPerformed

    private void btn_reanudarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_reanudarActionPerformed
        controlador.reanudar_impresion();
        Estado(estados.REANUDAR);
    }//GEN-LAST:event_btn_reanudarActionPerformed

    private void btn_cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cancelarActionPerformed
        controlador.cancelar_impresion();
        Estado(estados.CANCELAR);
    }//GEN-LAST:event_btn_cancelarActionPerformed

    private void btn_salirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_salirActionPerformed
        // TODO add your handling code here:
        //this.dispose();
        try {
            //this.jPanel1.removeAll();
            Datos.addValue(p + 1, graficas[p][0], graficas[p][1]);
            p++;
            Grafica.fireChartChanged();
            
            this.repaint();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        System.out.println(panel_extrusor.getPreferredSize().getHeight()+", "+panel_extrusor.getPreferredSize().getWidth());
    }//GEN-LAST:event_btn_salirActionPerformed

    private void prg_barStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_prg_barStateChanged
        // TODO add your handling code here:
        lbl_progreso.setText(""+prg_bar.getValue()+" %");
    }//GEN-LAST:event_prg_barStateChanged

    ChartPanel chart() {
        //... custom code here
       /* JFreeChart chart = ChartFactory.createLineChart("Visitas diarias",
        "Días", "Visitas", Datos,
            PlotOrientation.HORIZONTAL, true, true, false);
*/
    // Now: this is the trick to manage setting the size of a chart into a panel!:
        return new ChartPanel(Grafica) {
            public Dimension getPreferredSize() {//239.0, 353.0
                return new Dimension(340, 230);
            }
        };
    } 

    
    
    public  void repintarGraficaMotores(int val,String nombre, int valor){
        Datos.addValue(val, nombre,""+ valor);
        Grafica.fireChartChanged();
        this.repaint();
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Porcentaje;
    private javax.swing.JProgressBar barra_cemento;
    private javax.swing.JButton btn_cancelar;
    private javax.swing.JButton btn_iniciar;
    private javax.swing.JButton btn_pausar;
    private javax.swing.JButton btn_reanudar;
    private javax.swing.JButton btn_salir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JLabel lbl_progreso;
    private javax.swing.JLabel lbl_vel;
    private javax.swing.JPanel panel_extrusor;
    private javax.swing.JPanel panel_motores;
    private javax.swing.JProgressBar prg_bar;
    private javax.swing.JSlider sld_velocidad;
    // End of variables declaration//GEN-END:variables
}
