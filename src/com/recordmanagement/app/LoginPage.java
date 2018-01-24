package com.recordmanagement.app;
/**
 *
 * @author Team Siomai
 */
public class LoginPage extends javax.swing.JFrame {
    public LoginPage() {
        initComponents();
        this.setLocationRelativeTo(null);        
        setIcon();
        cbhover.addMouseListener(new java.awt.event.MouseAdapter(){
        public void mouseEntered(java.awt.event.MouseEvent evt){
        lblTeam.setText("Powered by: University of the Immaculate Conception");}
        public void mouseExited(java.awt.event.MouseEvent evt){
        lblTeam.setText("Developed by: Team SE");}
      });
    }
    static java.sql.Connection conn  = null;
    static java.sql.Statement stmt = null;
    static java.io.File temp = new java.io.File("DiazDentalClinicSystem.sqlite");
//    static String url = "jdbc:sqlite:"+temp.getAbsolutePath().replace("\\","\\\\");
    static String url = "jdbc:sqlite:C:\\Users\\pc\\Desktop\\Files\\RecordManagement\\src\\com\\recordmanagement\\app\\RecordManagement.sqlite";
    final javax.swing.ImageIcon failed = new javax.swing.ImageIcon(getClass().getResource("Sad.png"));
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        MainPanel = new javax.swing.JPanel();
        lblUsername = new javax.swing.JLabel();
        lblPassword = new javax.swing.JLabel();
        lblTeam = new javax.swing.JLabel();
        lblClose = new javax.swing.JLabel();
        lblusernameseparator = new javax.swing.JLabel();
        lblpassseparator = new javax.swing.JLabel();
        txtUser = new javax.swing.JTextField();
        txtPass = new javax.swing.JPasswordField();
        cbhover = new javax.swing.JCheckBox();
        LogoPanel = new javax.swing.JPanel();
        lblMstudent = new javax.swing.JLabel();
        lblFstudent = new javax.swing.JLabel();
        lblForm = new javax.swing.JLabel();
        LoginPanel = new javax.swing.JPanel();
        lblLogin = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Login - Diaz Dental Clinic System");
        setBackground(new java.awt.Color(0, 102, 255));
        setUndecorated(true);

        MainPanel.setBackground(new java.awt.Color(17, 24, 42));
        MainPanel.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        MainPanel.setForeground(new java.awt.Color(0, 51, 51));
        MainPanel.setName("Dental Clinic"); // NOI18N
        MainPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblUsername.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblUsername.setForeground(new java.awt.Color(0, 153, 0));
        lblUsername.setText("Username");
        MainPanel.add(lblUsername, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 220, -1, -1));

        lblPassword.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblPassword.setForeground(new java.awt.Color(0, 153, 0));
        lblPassword.setText("Password");
        MainPanel.add(lblPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 300, -1, -1));

        lblTeam.setFont(new java.awt.Font("Sitka Small", 0, 11)); // NOI18N
        lblTeam.setForeground(new java.awt.Color(255, 255, 255));
        lblTeam.setText("Developed by: Team SE");
        MainPanel.add(lblTeam, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 480, -1, -1));

        lblClose.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/recordmanagement/assets/close.png"))); // NOI18N
        lblClose.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblCloseMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblCloseMouseEntered(evt);
            }
        });
        MainPanel.add(lblClose, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 10, -1, -1));

        lblusernameseparator.setForeground(new java.awt.Color(204, 0, 0));
        lblusernameseparator.setText("__________________________________________________");
        MainPanel.add(lblusernameseparator, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 270, 300, 20));

        lblpassseparator.setForeground(new java.awt.Color(204, 0, 0));
        lblpassseparator.setText("__________________________________________________");
        MainPanel.add(lblpassseparator, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 350, 300, 20));

        txtUser.setBackground(new java.awt.Color(17, 24, 42));
        txtUser.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtUser.setForeground(new java.awt.Color(255, 255, 255));
        txtUser.setBorder(null);
        txtUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUserActionPerformed(evt);
            }
        });
        txtUser.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtUserKeyPressed(evt);
            }
        });
        MainPanel.add(txtUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 250, 300, 30));

        txtPass.setBackground(new java.awt.Color(17, 24, 42));
        txtPass.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtPass.setForeground(new java.awt.Color(255, 255, 255));
        txtPass.setBorder(null);
        txtPass.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtPassKeyPressed(evt);
            }
        });
        MainPanel.add(txtPass, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 330, 300, -1));

        cbhover.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/recordmanagement/assets/team.png"))); // NOI18N
        MainPanel.add(cbhover, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 480, -1, -1));

        LogoPanel.setBackground(new java.awt.Color(17, 24, 42));
        LogoPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 204, 204)), "Permanent Record Management", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.BOTTOM, new java.awt.Font("Tahoma", 0, 24), new java.awt.Color(153, 153, 0))); // NOI18N

        lblMstudent.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/recordmanagement/assets/Student_Male.png"))); // NOI18N

        lblFstudent.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/recordmanagement/assets/Student_Female.png"))); // NOI18N

        lblForm.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/recordmanagement/assets/Form.png"))); // NOI18N

        javax.swing.GroupLayout LogoPanelLayout = new javax.swing.GroupLayout(LogoPanel);
        LogoPanel.setLayout(LogoPanelLayout);
        LogoPanelLayout.setHorizontalGroup(
            LogoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(LogoPanelLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(lblMstudent)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
                .addComponent(lblForm)
                .addGap(18, 18, 18)
                .addComponent(lblFstudent)
                .addGap(32, 32, 32))
        );
        LogoPanelLayout.setVerticalGroup(
            LogoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(LogoPanelLayout.createSequentialGroup()
                .addGroup(LogoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(LogoPanelLayout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(LogoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblFstudent)
                            .addComponent(lblMstudent)))
                    .addGroup(LogoPanelLayout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addComponent(lblForm, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        MainPanel.add(LogoPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(84, 10, -1, -1));

        LoginPanel.setBackground(new java.awt.Color(17, 24, 42));
        LoginPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 0)));
        LoginPanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                LoginPanelMouseClicked(evt);
            }
        });
        LoginPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblLogin.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        lblLogin.setForeground(new java.awt.Color(204, 204, 204));
        lblLogin.setText("Login");
        lblLogin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblLoginMouseClicked(evt);
            }
        });
        LoginPanel.add(lblLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 10, -1, -1));

        MainPanel.add(LoginPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 410, 130, 40));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(MainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 570, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(MainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 512, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    private void txtPassKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPassKeyPressed
        if(evt.getKeyCode()==java.awt.event.KeyEvent.VK_ENTER)
        {
        String query = "Select * FROM login WHERE username=?";
        try{
            conn = java.sql.DriverManager.getConnection(url);
            java.sql.PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1,txtUser.getText());          
            java.sql.ResultSet rs = ps.executeQuery();
            while(rs.next()){
                String name = rs.getString("name");
                String username = rs.getString("username");
                String pass = rs.getString("password");
                String division = rs.getString("division");
                com.recordmanagement.classes.User.name = name;
                com.recordmanagement.classes.User.username = username;
                com.recordmanagement.classes.User.pass = pass;
                com.recordmanagement.classes.User.division = division;
            }if(!txtUser.getText().equals(com.recordmanagement.classes.User.username)){
            txtUser.setBackground(java.awt.Color.green);javax.swing.JOptionPane.showMessageDialog(null, "Username is incorrect.","Failed",1,failed);txtUser.setBackground(java.awt.Color.white);
            }else if(!txtPass.getText().equals(com.recordmanagement.classes.User.pass)){
            txtPass.setBackground(java.awt.Color.green);javax.swing.JOptionPane.showMessageDialog(null, "Password is incorrect.","Failed",1,failed);txtPass.setBackground(java.awt.Color.white);}
            else{
                FrmMain main = new FrmMain();
                main.setVisible(true);
                dispose();  
                java.util.Date currentDate = java.util.GregorianCalendar.getInstance().getTime();
                java.text.DateFormat df = java.text.DateFormat.getDateInstance();
                String dateString = df.format(currentDate);
                java.util.Date d = new java.util.Date();
                java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("HH:mm:ss a");
                String timeString = sdf.format(d);

                String namehistory = com.recordmanagement.classes.User.name;
                String time = timeString;
                String date = dateString;
                String queryhistory = "insert into History values ('"+namehistory+"','"+date+" / "+time+"','Logged in')";
                ps=conn.prepareStatement(queryhistory);
                ps.execute();             
            }
           conn.close();
        }
        catch(Exception e){
            System.out.println("Login Error:" + e.getMessage());
        } }
    }//GEN-LAST:event_txtPassKeyPressed
    private void txtUserKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtUserKeyPressed
        if(evt.getKeyCode()==java.awt.event.KeyEvent.VK_ESCAPE){
        System.exit(0);}else if(evt.getKeyCode()==java.awt.event.KeyEvent.VK_ENTER)
        {String query = "Select * FROM login WHERE username=?";
        try{
            conn = java.sql.DriverManager.getConnection(url);
            java.sql.PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1,txtUser.getText());          
            java.sql.ResultSet rs = ps.executeQuery();
            while(rs.next()){
                String name = rs.getString("name");
                String username = rs.getString("username");
                String pass = rs.getString("password");
                String division = rs.getString("division");
                com.recordmanagement.classes.User.name = name;
                com.recordmanagement.classes.User.username = username;
                com.recordmanagement.classes.User.pass = pass;
                com.recordmanagement.classes.User.division = division;
            }if(!txtUser.getText().equals(com.recordmanagement.classes.User.username)){
            txtUser.setBackground(java.awt.Color.green);javax.swing.JOptionPane.showMessageDialog(null, "Username is incorrect.","Failed",1,failed);txtUser.setBackground(java.awt.Color.white);
            }else if(!txtPass.getText().equals(com.recordmanagement.classes.User.pass)){
            txtPass.setBackground(java.awt.Color.green);javax.swing.JOptionPane.showMessageDialog(null, "Password is incorrect.","Failed",1,failed);txtPass.setBackground(java.awt.Color.white);}
            else{
                FrmMain main = new FrmMain();
                main.setVisible(true);
                dispose();  
                java.util.Date currentDate = java.util.GregorianCalendar.getInstance().getTime();
                java.text.DateFormat df = java.text.DateFormat.getDateInstance();
                String dateString = df.format(currentDate);
                java.util.Date d = new java.util.Date();
                java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("HH:mm:ss a");
                String timeString = sdf.format(d);

                String namehistory = com.recordmanagement.classes.User.name;
                String time = timeString;
                String date = dateString;
                String queryhistory = "insert into History values ('"+namehistory+"','"+date+" / "+time+"','Logged in')";
                ps=conn.prepareStatement(queryhistory);
                ps.execute();             
            }
           conn.close();
        }
        catch(Exception e){
            System.out.println("Login Error:" + e.getMessage());
        }}
    }//GEN-LAST:event_txtUserKeyPressed

    private void lblCloseMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblCloseMouseClicked
               System.exit(0);
    }//GEN-LAST:event_lblCloseMouseClicked

    private void txtUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUserActionPerformed

    }//GEN-LAST:event_txtUserActionPerformed

    private void LoginPanelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LoginPanelMouseClicked
        String query = "Select * FROM login WHERE username=?";
        try{
            conn = java.sql.DriverManager.getConnection(url);
            java.sql.PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1,txtUser.getText());          
            java.sql.ResultSet rs = ps.executeQuery();
            while(rs.next()){
                String name = rs.getString("name");
                String username = rs.getString("username");
                String pass = rs.getString("password");
                String division = rs.getString("division");
                com.recordmanagement.classes.User.name = name;
                com.recordmanagement.classes.User.username = username;
                com.recordmanagement.classes.User.pass = pass;
                com.recordmanagement.classes.User.division = division;
            }if(!txtUser.getText().equals(com.recordmanagement.classes.User.username)){
            txtUser.setBackground(java.awt.Color.green);javax.swing.JOptionPane.showMessageDialog(null, "Username is incorrect.","Failed",1,failed);txtUser.setBackground(java.awt.Color.white);
            }else if(!txtPass.getText().equals(com.recordmanagement.classes.User.pass)){
            txtPass.setBackground(java.awt.Color.green);javax.swing.JOptionPane.showMessageDialog(null, "Password is incorrect.","Failed",1,failed);txtPass.setBackground(java.awt.Color.white);}
            else{
                FrmMain main = new FrmMain();
                main.setVisible(true);
                dispose();  
                java.util.Date currentDate = java.util.GregorianCalendar.getInstance().getTime();
                java.text.DateFormat df = java.text.DateFormat.getDateInstance();
                String dateString = df.format(currentDate);
                java.util.Date d = new java.util.Date();
                java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("HH:mm:ss a");
                String timeString = sdf.format(d);

                String namehistory = com.recordmanagement.classes.User.name;
                String time = timeString;
                String date = dateString;
                String queryhistory = "insert into History values ('"+namehistory+"','"+date+" / "+time+"','Logged in')";
                ps=conn.prepareStatement(queryhistory);
                ps.execute();             
            }
           conn.close();
        }
        catch(Exception e){
            System.out.println("Login Error:" + e.getMessage());
        }
    }//GEN-LAST:event_LoginPanelMouseClicked

    private void lblLoginMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblLoginMouseClicked
        String query = "Select * FROM login WHERE username=?";
        try{
            conn = java.sql.DriverManager.getConnection(url);
            java.sql.PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1,txtUser.getText());          
            java.sql.ResultSet rs = ps.executeQuery();
            while(rs.next()){
                String name = rs.getString("name");
                String username = rs.getString("username");
                String pass = rs.getString("password");
                String division = rs.getString("division");
                com.recordmanagement.classes.User.name = name;
                com.recordmanagement.classes.User.username = username;
                com.recordmanagement.classes.User.pass = pass;
                com.recordmanagement.classes.User.division = division;
            }if(!txtUser.getText().equals(com.recordmanagement.classes.User.username)){
            txtUser.setBackground(java.awt.Color.green);javax.swing.JOptionPane.showMessageDialog(null, "Username is incorrect.","Failed",1,failed);txtUser.setBackground(java.awt.Color.white);
            }else if(!txtPass.getText().equals(com.recordmanagement.classes.User.pass)){
            txtPass.setBackground(java.awt.Color.green);javax.swing.JOptionPane.showMessageDialog(null, "Password is incorrect.","Failed",1,failed);txtPass.setBackground(java.awt.Color.white);}
            else{
                FrmMain main = new FrmMain();
                main.setVisible(true);
                dispose();  
                java.util.Date currentDate = java.util.GregorianCalendar.getInstance().getTime();
                java.text.DateFormat df = java.text.DateFormat.getDateInstance();
                String dateString = df.format(currentDate);
                java.util.Date d = new java.util.Date();
                java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("HH:mm:ss a");
                String timeString = sdf.format(d);

                String namehistory = com.recordmanagement.classes.User.name;
                String time = timeString;
                String date = dateString;
                String queryhistory = "insert into History values ('"+namehistory+"','"+date+" / "+time+"','Logged in')";
                ps=conn.prepareStatement(queryhistory);
                ps.execute();             
            }
           conn.close();
        }
        catch(Exception e){
            System.out.println("Login Error:" + e.getMessage());
        }
    }//GEN-LAST:event_lblLoginMouseClicked

    private void lblCloseMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblCloseMouseEntered
        
    }//GEN-LAST:event_lblCloseMouseEntered
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
            java.util.logging.Logger.getLogger(LoginPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LoginPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LoginPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LoginPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LoginPage().setVisible(true);
            }
        });
    }
    void setIcon() {
        LoginPage setIconImage;
        setIconImage(java.awt.Toolkit.getDefaultToolkit().getImage(getClass().getResource("icon.png")));
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel LoginPanel;
    private javax.swing.JPanel LogoPanel;
    private javax.swing.JPanel MainPanel;
    private javax.swing.JCheckBox cbhover;
    private javax.swing.JLabel lblClose;
    private javax.swing.JLabel lblForm;
    private javax.swing.JLabel lblFstudent;
    private javax.swing.JLabel lblLogin;
    private javax.swing.JLabel lblMstudent;
    private javax.swing.JLabel lblPassword;
    private javax.swing.JLabel lblTeam;
    private javax.swing.JLabel lblUsername;
    private javax.swing.JLabel lblpassseparator;
    private javax.swing.JLabel lblusernameseparator;
    private javax.swing.JPasswordField txtPass;
    private javax.swing.JTextField txtUser;
    // End of variables declaration//GEN-END:variables
}