
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class GUIRed extends javax.swing.JFrame 
{
    
    NeuralNetwork net;
    Red cerebro = new Red();

    public GUIRed() throws Exception 
    {
        initComponents();
        this.setTitle("Red Neuronal de Predicción del Clima en Caracas");
        this.setLocationRelativeTo(null);
        //net = new NeuralNetwork();
        this.labelExclamacion.setVisible(false);
        this.labelTemperaturaPredecida.setVisible(false);
        //this.net.guardar.crearArchivo(this.net.getCerebro());
        //System.out.println("BIAS: "+net.getCerebro().getBias());
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        temperaturaMedia = new javax.swing.JTextField();
        humedadRelativa = new javax.swing.JTextField();
        velocidadViento = new javax.swing.JTextField();
        botonPredecir = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        noticias = new javax.swing.JTextArea();
        labelExclamacion = new javax.swing.JLabel();
        labelTemperaturaPredecida = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        temperaturaAPredecir = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(204, 204, 255));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("Predicción del clima en Caracas");

        jLabel2.setText("Temperatura media del día (°C)");

        jLabel3.setText("Humedad relativa del día (%)");

        jLabel4.setText("Velocidad del viento (km/h)");

        temperaturaMedia.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                temperaturaMediaMouseClicked(evt);
            }
        });

        humedadRelativa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                humedadRelativaMouseClicked(evt);
            }
        });

        velocidadViento.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                velocidadVientoMouseClicked(evt);
            }
        });

        botonPredecir.setText("Predecir");
        botonPredecir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                botonPredecirMouseClicked(evt);
            }
        });

        noticias.setEditable(false);
        noticias.setColumns(20);
        noticias.setRows(5);
        jScrollPane1.setViewportView(noticias);

        labelExclamacion.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        labelExclamacion.setText("La temperatura de mañana será: °C ");

        labelTemperaturaPredecida.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        labelTemperaturaPredecida.setText("X");

        jLabel7.setText("Temperatura media a predecir (°C)");

        temperaturaAPredecir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                temperaturaAPredecirMouseClicked(evt);
            }
        });

        jButton1.setText("Entrenar");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
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
                        .addComponent(labelExclamacion)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(labelTemperaturaPredecida, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                            .addComponent(jLabel2)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(temperaturaMedia, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                            .addComponent(jLabel3)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(humedadRelativa))
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                            .addComponent(jLabel4)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(velocidadViento))
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                            .addComponent(jLabel7)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(temperaturaAPredecir))
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                            .addComponent(botonPredecir, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addGap(2, 2, 2)))
                                    .addComponent(jLabel1))
                                .addGap(0, 22, Short.MAX_VALUE)))
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(temperaturaMedia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(humedadRelativa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(velocidadViento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(temperaturaAPredecir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 23, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botonPredecir)
                    .addComponent(jButton1))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelExclamacion)
                    .addComponent(labelTemperaturaPredecida, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botonPredecirMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonPredecirMouseClicked
        if("".equals(this.temperaturaMedia.getText()) || "".equals(this.humedadRelativa.getText()) || "".equals(this.velocidadViento.getText()))
        {
            JOptionPane.showMessageDialog(null, "Debes introducir la temperatura media, la humedad relativa y la velocidad del viento", "Alert", JOptionPane.ERROR_MESSAGE);
        }
        else
        {
            System.out.println("BIAS: "+this.cerebro.getBias());
            this.cerebro.inicioPredecir(Double.parseDouble(this.temperaturaMedia.getText()), Double.parseDouble(this.humedadRelativa.getText()), Double.parseDouble(this.velocidadViento.getText()),this.labelExclamacion, this.labelTemperaturaPredecida);
            this.temperaturaMedia.setText("");
            this.humedadRelativa.setText("");
            this.velocidadViento.setText("");
            this.noticias.setText("");
        }
    }//GEN-LAST:event_botonPredecirMouseClicked

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        if("".equals(this.temperaturaMedia.getText()) || "".equals(this.humedadRelativa.getText()) || "".equals(this.velocidadViento.getText()) || "".equals(this.temperaturaAPredecir.getText()))
        {
            JOptionPane.showMessageDialog(null, "Debes introducir la temperatura media, la humedad relativa, la velocidad del viento y la temperatura a predecir", "Alert", JOptionPane.ERROR_MESSAGE);
        }
        else
        {
            this.cerebro.inicioEntrenar(Double.parseDouble(this.temperaturaMedia.getText()), Double.parseDouble(this.humedadRelativa.getText()), Double.parseDouble(this.velocidadViento.getText()), Double.parseDouble(this.temperaturaAPredecir.getText()), this.noticias);
            this.temperaturaMedia.setText("");
            this.humedadRelativa.setText("");
            this.velocidadViento.setText("");
            this.temperaturaAPredecir.setText("");
            JOptionPane.showMessageDialog(null, "La red ha finalizado de entrenarse");
            /*try {
                net.guardar.crearArchivo(net.getCerebro());
            } catch (IOException ex) {
                Logger.getLogger(GUIRed.class.getName()).log(Level.SEVERE, null, ex);
            }*/
        }
    }//GEN-LAST:event_jButton1MouseClicked

    private void temperaturaAPredecirMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_temperaturaAPredecirMouseClicked
        this.labelExclamacion.setVisible(false);
        this.labelTemperaturaPredecida.setVisible(false);
    }//GEN-LAST:event_temperaturaAPredecirMouseClicked

    private void temperaturaMediaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_temperaturaMediaMouseClicked
        this.labelExclamacion.setVisible(false);
        this.labelTemperaturaPredecida.setVisible(false);
    }//GEN-LAST:event_temperaturaMediaMouseClicked

    private void humedadRelativaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_humedadRelativaMouseClicked
        this.labelExclamacion.setVisible(false);
        this.labelTemperaturaPredecida.setVisible(false);
    }//GEN-LAST:event_humedadRelativaMouseClicked

    private void velocidadVientoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_velocidadVientoMouseClicked
        this.labelExclamacion.setVisible(false);
        this.labelTemperaturaPredecida.setVisible(false);
    }//GEN-LAST:event_velocidadVientoMouseClicked

    public static void main(String args[]) 
    {
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(GUIRed.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GUIRed.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GUIRed.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GUIRed.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() 
        {
            public void run() 
            {
                try {
                    new GUIRed().setVisible(true);
                } catch (Exception ex) {
                    Logger.getLogger(GUIRed.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonPredecir;
    private javax.swing.JTextField humedadRelativa;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelExclamacion;
    private javax.swing.JLabel labelTemperaturaPredecida;
    private javax.swing.JTextArea noticias;
    private javax.swing.JTextField temperaturaAPredecir;
    private javax.swing.JTextField temperaturaMedia;
    private javax.swing.JTextField velocidadViento;
    // End of variables declaration//GEN-END:variables
}
