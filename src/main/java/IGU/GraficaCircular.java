package IGU;

import Logic.Mapa;
import Persistance.Guardar;
import java.awt.Color;
import java.awt.Graphics;

public class GraficaCircular extends javax.swing.JFrame {
    
    public void pintar(Mapa map, Graphics g, int mapa[][]){
        for (int x = 0; x < map.getSizeX(); x++) {
            for (int y = 0; y < map.getSizeY(); y++) {
                if(jRadioColoresBrillantes.isSelected()){
                    switch (mapa[x][y]) {
                        case 0 ->
                            g.setColor(new Color(35, 75, 249));
                        case 1 ->
                            g.setColor(new Color(0, 150, 201));
                        case 2 ->
                            g.setColor(new Color(0, 200, 143));
                        case 3 ->
                            g.setColor(new Color(255, 209, 0));
                        case 4 ->
                            g.setColor(new Color(255, 162, 0));
                        case 5 ->
                            g.setColor(new Color(169, 120, 20));
                        case 6 ->
                            g.setColor(new Color(169, 84, 8));
                        default ->
                            g.setColor(Color.red);        
                    }
                } else if (jRadioColoresGrises.isSelected()) {
                    switch (mapa[x][y]) {
                        case 0 ->
                            g.setColor(new Color(80, 80, 80));
                        case 1 ->
                            g.setColor(new Color(160, 160, 160));
                        case 2 ->
                            g.setColor(new Color(140, 140, 140));
                        case 3 ->
                            g.setColor(new Color(120, 120, 120));
                        case 4 ->
                            g.setColor(new Color(100, 100, 100));
                        case 5 ->
                            g.setColor(new Color(80, 80, 80));
                        case 6 ->
                            g.setColor(new Color(60, 60, 60));
                        default ->
                            g.setColor(new Color(140, 60, 60));
                    }
                } else {
                    switch (mapa[x][y]) {
                        case 0 ->
                            g.setColor(new Color(96, 140, 141));
                        case 1 ->
                            g.setColor(new Color(113, 161, 161));
                        case 2 ->
                            g.setColor(new Color(189, 188, 159));
                        case 3 ->
                            g.setColor(new Color(129, 128, 88));
                        case 4 ->
                            g.setColor(new Color(103, 108, 68));
                        case 5 ->
                            g.setColor(new Color(115, 84, 46));
                        case 6 ->
                            g.setColor(new Color(115, 64, 20));
                        default ->
                            g.setColor(new Color(115, 40, 12));
                    }
                }
                g.fillRect(x * 10 + 20, y * 10 + 80, 10, 10);
                if (radioBioma.isSelected()){
                    int biome[][] = map.generarBiomas();
                    switch (biome[x][y]) {
                        case 4 ->
                            g.setColor(new Color(0, 250, 0, 200));
                        case 3 ->
                            g.setColor(new Color(0, 120, 0, 200));
                        case 2 ->
                            g.setColor(new Color(50, 150, 50, 200));
                        //case 1 -> 
                        //    g.setColor(new Color(0, 0, 0, 0));
                    }
                }
                if (radioRadiacion.isSelected()){
                    int radiacion[][] = map.radiation();
                        switch (radiacion[x][y]) {
                            case 0 ->
                                g.setColor(new Color(35, 75, 249, 80));
                            case 1 ->
                                g.setColor(new Color(0, 150, 201, 80));
                            case 4 ->
                                g.setColor(new Color(0, 200, 143, 80));
                            case 5 ->
                                g.setColor(new Color(255, 209, 0, 80));
                            case 6 ->
                                g.setColor(new Color(255, 162, 0, 80));
                            case 7 ->
                                g.setColor(new Color(169, 120, 20, 80));
                            case 8 ->
                                g.setColor(new Color(169, 84, 8, 80));
                            default ->
                                g.setColor(new Color(200, 0, 0, 80));
                        }
                    }
                g.fillRect(x * 10 + 20, y * 10 + 80, 10, 10);
                g.setColor(new Color(120, 120, 120));
                g.drawRect(x * 10 + 20, y * 10 + 80, 10, 10);
            }
        }
    }
    
    public GraficaCircular() {
        initComponents();
        BGBotonesColores.add(jRadioColoresGrises);
        BGBotonesColores.add(jRadioColoresTradicional);
        BGBotonesColores.add(jRadioColoresBrillantes);
        this.setLocationRelativeTo(null);
    }
    
    boolean banderaGen = false;
    boolean activar = false;
    boolean isGuardar = false;
    boolean isCargar = false;
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        BGBotonesColores = new javax.swing.ButtonGroup();
        Background = new javax.swing.JPanel();
        Titulo = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        spi_1 = new javax.swing.JSpinner();
        jLabel3 = new javax.swing.JLabel();
        spi_2 = new javax.swing.JSpinner();
        radialContinentes = new javax.swing.JRadioButton();
        jPanel2 = new javax.swing.JPanel();
        radioBioma = new javax.swing.JRadioButton();
        butMostrar = new javax.swing.JButton();
        radioRadiacion = new javax.swing.JRadioButton();
        jPanel3 = new javax.swing.JPanel();
        jRadioColoresGrises = new javax.swing.JRadioButton();
        jRadioColoresTradicional = new javax.swing.JRadioButton();
        jRadioColoresBrillantes = new javax.swing.JRadioButton();
        jBCargar = new javax.swing.JButton();
        jBGuardar1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Background.setBackground(new java.awt.Color(51, 51, 51));
        Background.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Titulo.setFont(new java.awt.Font("Agency FB", 1, 24)); // NOI18N
        Titulo.setForeground(new java.awt.Color(255, 255, 255));
        Titulo.setText("Mapa");
        Background.add(Titulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 10, -1, -1));

        jButton1.setText("Generar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        Background.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1170, 800, -1, -1));

        jPanel1.setBackground(new java.awt.Color(102, 102, 102));

        jLabel2.setText("Montes:");

        spi_1.setValue(7);

        jLabel3.setText("Altura:");

        spi_2.setValue(5);

        radialContinentes.setBackground(new java.awt.Color(102, 102, 102));
        radialContinentes.setText("Continentes");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(radialContinentes)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2))
                        .addGap(47, 47, 47)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(spi_2)
                            .addComponent(spi_1, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(96, 96, 96))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(spi_1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(spi_2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(radialContinentes)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        Background.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 810, 181, 110));

        jPanel2.setBackground(new java.awt.Color(102, 102, 102));

        radioBioma.setBackground(new java.awt.Color(102, 102, 102));
        radioBioma.setText("Biomas");

        butMostrar.setText("Mostrar");
        butMostrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butMostrarActionPerformed(evt);
            }
        });

        radioRadiacion.setBackground(new java.awt.Color(102, 102, 102));
        radioRadiacion.setText("Radiacion");
        radioRadiacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioRadiacionActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(radioBioma)
                    .addComponent(butMostrar)
                    .addComponent(radioRadiacion))
                .addContainerGap(77, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(radioBioma)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 4, Short.MAX_VALUE)
                .addComponent(radioRadiacion)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(butMostrar)
                .addContainerGap())
        );

        Background.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 810, -1, 110));

        jPanel3.setBackground(new java.awt.Color(102, 102, 102));

        jRadioColoresGrises.setBackground(new java.awt.Color(102, 102, 102));
        jRadioColoresGrises.setText("Colores Grises");
        jRadioColoresGrises.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jRadioColoresTradicional.setBackground(new java.awt.Color(102, 102, 102));
        jRadioColoresTradicional.setText("Colores Tradicional");

        jRadioColoresBrillantes.setBackground(new java.awt.Color(102, 102, 102));
        jRadioColoresBrillantes.setText("Colores Brillantes");
        jRadioColoresBrillantes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioColoresBrillantesActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jRadioColoresGrises)
                    .addComponent(jRadioColoresTradicional)
                    .addComponent(jRadioColoresBrillantes))
                .addContainerGap(25, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jRadioColoresBrillantes)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jRadioColoresGrises)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jRadioColoresTradicional)
                .addContainerGap(16, Short.MAX_VALUE))
        );

        Background.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 810, 160, 110));

        jBCargar.setText("Cargar");
        jBCargar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBCargarActionPerformed(evt);
            }
        });
        Background.add(jBCargar, new org.netbeans.lib.awtextra.AbsoluteConstraints(1170, 880, -1, -1));

        jBGuardar1.setText("Guardar");
        jBGuardar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBGuardar1ActionPerformed(evt);
            }
        });
        Background.add(jBGuardar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1170, 840, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Background, javax.swing.GroupLayout.DEFAULT_SIZE, 1263, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Background, javax.swing.GroupLayout.DEFAULT_SIZE, 926, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        banderaGen = true;
        isCreated = false;
        repaint();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void butMostrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butMostrarActionPerformed
        repaint();
        activar = true;
    }//GEN-LAST:event_butMostrarActionPerformed

    private void radioRadiacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioRadiacionActionPerformed
    }//GEN-LAST:event_radioRadiacionActionPerformed

    private void jRadioColoresBrillantesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioColoresBrillantesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioColoresBrillantesActionPerformed

    private void jBCargarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBCargarActionPerformed
        isCargar = true;
        repaint();
    }//GEN-LAST:event_jBCargarActionPerformed

    private void jBGuardar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBGuardar1ActionPerformed
        
        isGuardar = true;
    }//GEN-LAST:event_jBGuardar1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
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
            java.util.logging.Logger.getLogger(GraficaCircular.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GraficaCircular.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GraficaCircular.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GraficaCircular.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                GraficaCircular grafico = new GraficaCircular();
                grafico.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup BGBotonesColores;
    private javax.swing.JPanel Background;
    private javax.swing.JLabel Titulo;
    private javax.swing.JButton butMostrar;
    private javax.swing.JButton jBCargar;
    private javax.swing.JButton jBGuardar1;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JRadioButton jRadioColoresBrillantes;
    private javax.swing.JRadioButton jRadioColoresGrises;
    private javax.swing.JRadioButton jRadioColoresTradicional;
    private javax.swing.JRadioButton radialContinentes;
    private javax.swing.JRadioButton radioBioma;
    private javax.swing.JRadioButton radioRadiacion;
    private javax.swing.JSpinner spi_1;
    private javax.swing.JSpinner spi_2;
    // End of variables declaration//GEN-END:variables

    boolean isCreated = false;
    Mapa map = new Mapa(124,70);
    int mapa[][] = new int[500][500];
    
    @Override
    public void paint(Graphics g){
        super.paint(g);
                
        if(banderaGen == true){
            
            if (isCreated == false){
                map = new Mapa(124,70);
                map.setQuantityMounts((int)(spi_1.getValue()));
                map.setHeightMounts((int)(spi_2.getValue()));
                map.setIsContinent(radialContinentes.isSelected());
                int mapa[][] = map.generateMounts();
                map.setMap(mapa);
                isCreated = true;
                pintar(map, g, mapa);
            }   
        }
        
        if(isCreated){
            int mapaLoad[][] = map.getMap();
            if (activar){
                pintar(map, g, mapaLoad);
            }
            if (isGuardar){
                Guardar guardar = new Guardar();
                guardar.arrayToFichero(mapaLoad);
                isGuardar = false;
            }
        }
        if(isCargar){
                Guardar guardar = new Guardar();
                int[][] mapLoad = guardar.lee();
                pintar(map, g, mapLoad);
                isCargar=false;
            }
        
        Titulo.setText("Mapa de: " + map.getNombreMapa());
    }
}
