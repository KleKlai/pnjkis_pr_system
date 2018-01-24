package com.recordmanagement.app;
/**
 *
 * @author Glyde Llait
 */
public class FrmAbout extends javax.swing.JFrame {
    public FrmAbout() {
        initComponents();
        this.setLocationRelativeTo(null);
        setIcon(); 
        lblEmail.setText("<html> Contact : <a href=\"\"><font color=\"white\">Harryn Glyde Llait</font></a></html>");
        lblAbout.setText("Diaz Dental Clinic System v1.0 is created in Netbeans IDE 8.2\n"
                + "platform using java programming language. "
                + "It has monitoring \nsystem and more features that helps a clinic more proggressive.\n\n"
                + "   If any bugs or errors found in the system you can contact \n             Harryn Glyde Llait or approach us through email "
                + "\n           teamsiomai@gmail.com or lordglyde@gmail.com. ");
    }
    private void setIcon() {
        LoginPage setIconImage;
        setIconImage(java.awt.Toolkit.getDefaultToolkit().getImage(getClass().getResource("icon.png")));
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PanelAbout = new javax.swing.JPanel();
        PanelDetail = new javax.swing.JPanel();
        lblEmail = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        lblAbout = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("About - Diaz Dental Clinic System");
        setBackground(new java.awt.Color(0, 102, 102));

        PanelAbout.setBackground(new java.awt.Color(17, 24, 42));

        PanelDetail.setBackground(new java.awt.Color(17, 24, 42));
        PanelDetail.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        PanelDetail.setForeground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout PanelDetailLayout = new javax.swing.GroupLayout(PanelDetail);
        PanelDetail.setLayout(PanelDetailLayout);
        PanelDetailLayout.setHorizontalGroup(
            PanelDetailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 351, Short.MAX_VALUE)
        );
        PanelDetailLayout.setVerticalGroup(
            PanelDetailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 126, Short.MAX_VALUE)
        );

        lblEmail.setFont(new java.awt.Font("Monospaced", 0, 13)); // NOI18N
        lblEmail.setForeground(new java.awt.Color(255, 255, 255));
        lblEmail.setText("Contact");
        lblEmail.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblEmailMouseClicked(evt);
            }
        });

        lblAbout.setEditable(false);
        lblAbout.setBackground(new java.awt.Color(17, 24, 42));
        lblAbout.setColumns(20);
        lblAbout.setForeground(new java.awt.Color(255, 255, 255));
        lblAbout.setRows(5);
        jScrollPane1.setViewportView(lblAbout);

        javax.swing.GroupLayout PanelAboutLayout = new javax.swing.GroupLayout(PanelAbout);
        PanelAbout.setLayout(PanelAboutLayout);
        PanelAboutLayout.setHorizontalGroup(
            PanelAboutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelAboutLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(PanelAboutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1)
                    .addComponent(PanelDetail, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(PanelAboutLayout.createSequentialGroup()
                        .addGap(69, 69, 69)
                        .addComponent(lblEmail)))
                .addContainerGap(22, Short.MAX_VALUE))
        );
        PanelAboutLayout.setVerticalGroup(
            PanelAboutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelAboutLayout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addComponent(PanelDetail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblEmail)
                .addContainerGap(18, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PanelAbout, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PanelAbout, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    private void lblEmailMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblEmailMouseClicked
        try {
            java.awt.Desktop.getDesktop().browse(new java.net.URI("www.facebook.com/hgllait"));
        } catch (java.net.URISyntaxException | java.io.IOException ex) {
            javax.swing.JOptionPane.showMessageDialog(null, "facebook.com/hgllait");
        }
    }//GEN-LAST:event_lblEmailMouseClicked
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
            java.util.logging.Logger.getLogger(FrmAbout.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmAbout.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmAbout.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmAbout.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmAbout().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel PanelAbout;
    private javax.swing.JPanel PanelDetail;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea lblAbout;
    private javax.swing.JLabel lblEmail;
    // End of variables declaration//GEN-END:variables
}
