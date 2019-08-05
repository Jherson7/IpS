package vistas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.KeyEvent;
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
    JFreeChart Grafica;
    DefaultCategoryDataset Datos = new DefaultCategoryDataset(); 
    estados estado_actual;
    
    private void cargar_grafico_motores() {
    
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

    private void verificar_salida() {
        switch(estado_actual){
            case INICIO:
            case IMPRESION:
            case REANUDAR:
            case DETENER:
                int val = JOptionPane.showConfirmDialog(this, "Desea salir? aun se encuentra en impresion", "Impresion en curso", 0, 1);
                if(val==0){
                    controlador.finalizar_impresion();
                    this.dispose();
                }
                break;
            
            //break;
            case CANCELAR:
                controlador.finalizar_impresion();
                break;
        }
    }
    
    private enum estados {INICIO,IMPRESION,REANUDAR,DETENER,CANCELAR};
    
    private void Estado(estados estado){
        estado_actual=estado;
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
                btn_iniciar.setEnabled(false);
                btn_cancelar.setEnabled(false);
                btn_reanudar.setEnabled(false);
                btn_pausar.setEnabled(false);
                break;
        }
    }
    
    public impresion() {
   
        initComponents();
        lbl_vel.setText(sld_velocidad.getValue() + "ms");
        Estado(estados.INICIO);
        this.getContentPane().setBackground(new Color(53, 19, 48));
        barra_cemento.setOrientation(SwingConstants.VERTICAL);
      
     
        cargar_grafico_motores();
        
        controlador.preparar_impresora(this.barra_cemento);
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
        btn_salir = new javax.swing.JButton();
        tab_pane = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        prg_bar = new javax.swing.JProgressBar();
        jPanel8 = new javax.swing.JPanel();
        lbl_progreso = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        barra_cemento = new javax.swing.JProgressBar();
        lbl_porcentaje = new javax.swing.JLabel();
        panel_motores = new javax.swing.JPanel();
        panel_extrusor = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        panel_calibracion = new javax.swing.JPanel();
        y_mas = new javax.swing.JButton();
        x_menos = new javax.swing.JButton();
        x_mas = new javax.swing.JButton();
        z_mas = new javax.swing.JButton();
        z_menos = new javax.swing.JButton();
        y_menos = new javax.swing.JButton();
        txt_comando = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();

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

        btn_salir.setFont(new java.awt.Font("Trebuchet MS", 1, 11)); // NOI18N
        btn_salir.setText("SALIR");
        btn_salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_salirActionPerformed(evt);
            }
        });

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

        barra_cemento.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                barra_cementoStateChanged(evt);
            }
        });

        lbl_porcentaje.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        lbl_porcentaje.setText("00%");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(lbl_porcentaje)
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
                .addComponent(lbl_porcentaje)
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
            .addGap(0, 301, Short.MAX_VALUE)
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
            .addGap(0, 0, Short.MAX_VALUE)
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
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panel_motores, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panel_extrusor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        tab_pane.addTab("tab1", jPanel2);

        panel_calibracion.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Calibrador", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 18))); // NOI18N

        y_mas.setBackground(new java.awt.Color(51, 255, 51));
        y_mas.setFont(new java.awt.Font("Segoe Print", 0, 24)); // NOI18N
        y_mas.setText("X +");
        y_mas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                y_masActionPerformed(evt);
            }
        });

        x_menos.setBackground(new java.awt.Color(204, 51, 0));
        x_menos.setFont(new java.awt.Font("Segoe Print", 0, 24)); // NOI18N
        x_menos.setText("Y -");
        x_menos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                x_menosActionPerformed(evt);
            }
        });

        x_mas.setBackground(new java.awt.Color(51, 255, 51));
        x_mas.setFont(new java.awt.Font("Segoe Print", 0, 24)); // NOI18N
        x_mas.setText("Y +");
        x_mas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                x_masActionPerformed(evt);
            }
        });

        z_mas.setBackground(new java.awt.Color(51, 255, 51));
        z_mas.setFont(new java.awt.Font("Segoe Print", 0, 24)); // NOI18N
        z_mas.setText("Z +");
        z_mas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                z_masActionPerformed(evt);
            }
        });

        z_menos.setBackground(new java.awt.Color(204, 51, 0));
        z_menos.setFont(new java.awt.Font("Segoe Print", 0, 24)); // NOI18N
        z_menos.setText("Z -");
        z_menos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                z_menosActionPerformed(evt);
            }
        });

        y_menos.setBackground(new java.awt.Color(204, 51, 0));
        y_menos.setFont(new java.awt.Font("Segoe Print", 0, 24)); // NOI18N
        y_menos.setText("X -");
        y_menos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                y_menosActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panel_calibracionLayout = new javax.swing.GroupLayout(panel_calibracion);
        panel_calibracion.setLayout(panel_calibracionLayout);
        panel_calibracionLayout.setHorizontalGroup(
            panel_calibracionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel_calibracionLayout.createSequentialGroup()
                .addGroup(panel_calibracionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel_calibracionLayout.createSequentialGroup()
                        .addGap(91, 91, 91)
                        .addGroup(panel_calibracionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(y_menos)
                            .addComponent(y_mas)))
                    .addGroup(panel_calibracionLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(x_menos)))
                .addGap(7, 7, 7)
                .addComponent(x_mas)
                .addGap(47, 47, 47)
                .addGroup(panel_calibracionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(z_mas)
                    .addComponent(z_menos, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );
        panel_calibracionLayout.setVerticalGroup(
            panel_calibracionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel_calibracionLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panel_calibracionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(panel_calibracionLayout.createSequentialGroup()
                        .addComponent(y_mas, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(panel_calibracionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(x_menos, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(x_mas, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(y_menos, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panel_calibracionLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(z_mas, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(z_menos, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        txt_comando.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_comandoKeyReleased(evt);
            }
        });

        jLabel2.setText("Comando:");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(panel_calibracion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(txt_comando, javax.swing.GroupLayout.PREFERRED_SIZE, 314, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(513, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_comando, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 105, Short.MAX_VALUE)
                .addComponent(panel_calibracion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(179, Short.MAX_VALUE))
        );

        tab_pane.addTab("tab2", jPanel5);

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
                .addComponent(tab_pane))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(114, 114, 114))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(36, 36, 36)
                        .addComponent(btn_salir, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(tab_pane))
                .addContainerGap())
        );

        tab_pane.getAccessibleContext().setAccessibleName("Monitoreo");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_iniciarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_iniciarActionPerformed
        controlador.iniciar_impresion(prg_bar);
        Estado(estados.IMPRESION);
    }//GEN-LAST:event_btn_iniciarActionPerformed

    private void sld_velocidadStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_sld_velocidadStateChanged
        lbl_vel.setText(sld_velocidad.getValue()+"  ms");
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
        
        verificar_salida();
    }//GEN-LAST:event_btn_salirActionPerformed

    private void prg_barStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_prg_barStateChanged
        // TODO add your handling code here:
        lbl_progreso.setText(""+prg_bar.getValue()+" %");
    }//GEN-LAST:event_prg_barStateChanged

    private void txt_comandoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_comandoKeyReleased
        // TODO add your handling code here:
        if(evt.getKeyCode()==KeyEvent.VK_ENTER){
            String comando = txt_comando.getText();
            if(!comando.isEmpty())
                controlador.imprimir_comando(comando);
        }
    }//GEN-LAST:event_txt_comandoKeyReleased

    private void y_masActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_y_masActionPerformed
        // TODO add your handling code here:
        controlador.imprimir_comando("G91 G0  X1");
    }//GEN-LAST:event_y_masActionPerformed

    private void y_menosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_y_menosActionPerformed
        // TODO add your handling code here:
        controlador.imprimir_comando("G91 G0  X-1");
    }//GEN-LAST:event_y_menosActionPerformed

    private void x_menosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_x_menosActionPerformed
        // TODO add your handling code here:
        controlador.imprimir_comando("G91 G0  Y-1");
    }//GEN-LAST:event_x_menosActionPerformed

    private void x_masActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_x_masActionPerformed
        // TODO add your handling code here:
        controlador.imprimir_comando("G91 G0  Y1");
    }//GEN-LAST:event_x_masActionPerformed

    private void z_masActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_z_masActionPerformed
        // TODO add your handling code here:
        controlador.imprimir_comando("G91 G0  Z1");
    }//GEN-LAST:event_z_masActionPerformed

    private void z_menosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_z_menosActionPerformed
        // TODO add your handling code here:
        controlador.imprimir_comando("G91 G0  Z-1");
    }//GEN-LAST:event_z_menosActionPerformed

    private void barra_cementoStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_barra_cementoStateChanged
        // TODO add your handling code here:
        lbl_porcentaje.setText(barra_cemento.getValue()+"%");
    }//GEN-LAST:event_barra_cementoStateChanged

    ChartPanel chart() {
        //... custom code here
       /* JFreeChart chart = ChartFactory.createLineChart("Visitas diarias",
        "Días", "Visitas", Datos,
            PlotOrientation.HORIZONTAL, true, true, false);
*/

        return new ChartPanel(Grafica) {
            public Dimension getPreferredSize() {//239.0, 353.0
                return new Dimension(340, 230);
            }
        };
    } 

    public void terminar_con_error(){
        JOptionPane.showMessageDialog(this, "Error al imprimir, revise estado de impresion en seccion de impresiones","ERROR",0);
        this.dispose();
        
    }
    
    public void terminar_con_exito(){
        JOptionPane.showMessageDialog(this, "Impresion terminada con Exito","FINALIZADO",1);
        this.dispose();
        
    }
    
    public  void repintarGraficaMotores(int val,String nombre, int valor){
        Datos.addValue(val, nombre,""+ valor);
        Grafica.fireChartChanged();
        this.repaint();
    }
    
    public void eliminarDatos(){
        Datos.clear();
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JProgressBar barra_cemento;
    private javax.swing.JButton btn_cancelar;
    private javax.swing.JButton btn_iniciar;
    private javax.swing.JButton btn_pausar;
    private javax.swing.JButton btn_reanudar;
    private javax.swing.JButton btn_salir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JLabel lbl_porcentaje;
    private javax.swing.JLabel lbl_progreso;
    private javax.swing.JLabel lbl_vel;
    private javax.swing.JPanel panel_calibracion;
    private javax.swing.JPanel panel_extrusor;
    private javax.swing.JPanel panel_motores;
    private javax.swing.JProgressBar prg_bar;
    private javax.swing.JSlider sld_velocidad;
    private javax.swing.JTabbedPane tab_pane;
    private javax.swing.JTextField txt_comando;
    private javax.swing.JButton x_mas;
    private javax.swing.JButton x_menos;
    private javax.swing.JButton y_mas;
    private javax.swing.JButton y_menos;
    private javax.swing.JButton z_mas;
    private javax.swing.JButton z_menos;
    // End of variables declaration//GEN-END:variables
}
