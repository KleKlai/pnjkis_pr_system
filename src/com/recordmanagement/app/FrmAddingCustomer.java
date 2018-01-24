package com.recordmanagement.app;
import static com.recordmanagement.app.SQLite.conn;
import static com.recordmanagement.app.SQLite.stmt;
import static com.recordmanagement.app.SQLite.url;
/**
 *
 * @author Glyde Llait
 */
public class FrmAddingCustomer extends javax.swing.JFrame {
    public FrmAddingCustomer() {
        initComponents();
        this.setLocationRelativeTo(null);
        setIcon();
    }
    private void setIcon() {      
        LoginPage setIconImage;
        setIconImage(java.awt.Toolkit.getDefaultToolkit().getImage(getClass().getResource("icon.png")));
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnGender = new javax.swing.ButtonGroup();
        btnStatus = new javax.swing.ButtonGroup();
        MainPanel = new javax.swing.JPanel();
        TitlePanel = new javax.swing.JPanel();
        lblTitle = new javax.swing.JLabel();
        VerifyPatient = new javax.swing.JPanel();
        txtPhone = new javax.swing.JTextField();
        txtAge = new javax.swing.JTextField();
        lbllname = new javax.swing.JLabel();
        lblfname = new javax.swing.JLabel();
        lblGender = new javax.swing.JLabel();
        lblAge = new javax.swing.JLabel();
        lblStreet = new javax.swing.JLabel();
        lblCity = new javax.swing.JLabel();
        lblPhoneNo = new javax.swing.JLabel();
        lblPicture = new javax.swing.JLabel();
        lblIMAGE = new javax.swing.JLabel();
        rbM = new javax.swing.JRadioButton();
        rbF = new javax.swing.JRadioButton();
        btnBrowse = new javax.swing.JButton();
        bntRemove = new javax.swing.JButton();
        txtlname = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtAddress = new javax.swing.JEditorPane();
        txtfname = new javax.swing.JTextField();
        txtID = new javax.swing.JTextField();
        lblStatus = new javax.swing.JLabel();
        cbActive = new javax.swing.JCheckBox();
        cbInactive = new javax.swing.JCheckBox();
        jScrollPane3 = new javax.swing.JScrollPane();
        txtMeds = new javax.swing.JEditorPane();
        btnDone = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        btnSave = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnReset = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Patient Information - Diaz Dental Clinic System");
        setBackground(new java.awt.Color(51, 204, 255));
        setUndecorated(true);

        MainPanel.setBackground(new java.awt.Color(17, 24, 42));
        MainPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));

        TitlePanel.setBackground(new java.awt.Color(17, 24, 42));
        TitlePanel.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        TitlePanel.setForeground(new java.awt.Color(0, 255, 255));

        lblTitle.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lblTitle.setForeground(new java.awt.Color(255, 255, 255));
        lblTitle.setText("Add Patient Information");

        javax.swing.GroupLayout TitlePanelLayout = new javax.swing.GroupLayout(TitlePanel);
        TitlePanel.setLayout(TitlePanelLayout);
        TitlePanelLayout.setHorizontalGroup(
            TitlePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, TitlePanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 351, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(361, 361, 361))
        );
        TitlePanelLayout.setVerticalGroup(
            TitlePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TitlePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTitle)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        VerifyPatient.setBackground(new java.awt.Color(17, 24, 42));
        VerifyPatient.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Patient Information", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 18), new java.awt.Color(255, 255, 255))); // NOI18N

        txtPhone.setNextFocusableComponent(btnBrowse);
        txtPhone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPhoneActionPerformed(evt);
            }
        });

        txtAge.setNextFocusableComponent(lblStreet);
        txtAge.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtAgeActionPerformed(evt);
            }
        });

        lbllname.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lbllname.setForeground(new java.awt.Color(255, 255, 255));
        lbllname.setText("Last Name:");

        lblfname.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblfname.setForeground(new java.awt.Color(255, 255, 255));
        lblfname.setText("First Name:");

        lblGender.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblGender.setForeground(new java.awt.Color(255, 255, 255));
        lblGender.setText("Gender");

        lblAge.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblAge.setForeground(new java.awt.Color(255, 255, 255));
        lblAge.setText("Age");

        lblStreet.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblStreet.setForeground(new java.awt.Color(255, 255, 255));
        lblStreet.setText("Address :");

        lblCity.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblCity.setForeground(new java.awt.Color(255, 255, 255));
        lblCity.setText("Medical History :");

        lblPhoneNo.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblPhoneNo.setForeground(new java.awt.Color(255, 255, 255));
        lblPhoneNo.setText("Phone Number :");

        lblPicture.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblPicture.setForeground(new java.awt.Color(255, 255, 255));
        lblPicture.setText("Patient Picture");

        lblIMAGE.setForeground(new java.awt.Color(255, 255, 255));
        lblIMAGE.setText("                      Optional");
        lblIMAGE.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));

        rbM.setBackground(new java.awt.Color(17, 24, 42));
        btnGender.add(rbM);
        rbM.setForeground(new java.awt.Color(255, 255, 255));
        rbM.setText("Male");
        rbM.setNextFocusableComponent(txtAge);
        rbM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbMActionPerformed(evt);
            }
        });

        rbF.setBackground(new java.awt.Color(17, 24, 42));
        btnGender.add(rbF);
        rbF.setForeground(new java.awt.Color(255, 255, 255));
        rbF.setText("Female");
        rbF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbFActionPerformed(evt);
            }
        });

        btnBrowse.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnBrowse.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/recordmanagement/assets/browse.png"))); // NOI18N
        btnBrowse.setText("Browse");
        btnBrowse.setNextFocusableComponent(bntRemove);
        btnBrowse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBrowseActionPerformed(evt);
            }
        });

        bntRemove.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        bntRemove.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/recordmanagement/assets/Delete.png"))); // NOI18N
        bntRemove.setText("Remove");
        bntRemove.setNextFocusableComponent(btnSave);
        bntRemove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntRemoveActionPerformed(evt);
            }
        });

        txtlname.setNextFocusableComponent(rbM);
        txtlname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtlnameActionPerformed(evt);
            }
        });

        txtAddress.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtAddressKeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(txtAddress);

        txtfname.setNextFocusableComponent(txtlname);

        lblStatus.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblStatus.setForeground(new java.awt.Color(255, 255, 255));
        lblStatus.setText("Status :");

        cbActive.setBackground(new java.awt.Color(17, 24, 42));
        btnStatus.add(cbActive);
        cbActive.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        cbActive.setForeground(new java.awt.Color(255, 255, 255));
        cbActive.setSelected(true);
        cbActive.setText("ACTIVE");

        cbInactive.setBackground(new java.awt.Color(17, 24, 42));
        btnStatus.add(cbInactive);
        cbInactive.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        cbInactive.setForeground(new java.awt.Color(255, 255, 255));
        cbInactive.setText("INACTIVE");

        jScrollPane3.setViewportView(txtMeds);

        javax.swing.GroupLayout VerifyPatientLayout = new javax.swing.GroupLayout(VerifyPatient);
        VerifyPatient.setLayout(VerifyPatientLayout);
        VerifyPatientLayout.setHorizontalGroup(
            VerifyPatientLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(VerifyPatientLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(VerifyPatientLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(VerifyPatientLayout.createSequentialGroup()
                        .addGroup(VerifyPatientLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(VerifyPatientLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(VerifyPatientLayout.createSequentialGroup()
                                    .addComponent(lblfname)
                                    .addGap(55, 55, 55))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, VerifyPatientLayout.createSequentialGroup()
                                    .addComponent(lblCity)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                            .addGroup(VerifyPatientLayout.createSequentialGroup()
                                .addGroup(VerifyPatientLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblStreet)
                                    .addComponent(lblPhoneNo)
                                    .addComponent(lblStatus))
                                .addGap(26, 26, 26)))
                        .addGroup(VerifyPatientLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtPhone)
                            .addComponent(txtfname)
                            .addGroup(VerifyPatientLayout.createSequentialGroup()
                                .addComponent(cbActive)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cbInactive, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 175, Short.MAX_VALUE)
                            .addComponent(jScrollPane3)))
                    .addGroup(VerifyPatientLayout.createSequentialGroup()
                        .addComponent(lbllname)
                        .addGap(55, 55, 55)
                        .addComponent(txtlname, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(VerifyPatientLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(VerifyPatientLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, VerifyPatientLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 410, Short.MAX_VALUE)
                        .addGroup(VerifyPatientLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(VerifyPatientLayout.createSequentialGroup()
                                .addComponent(btnBrowse)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(bntRemove))
                            .addGroup(VerifyPatientLayout.createSequentialGroup()
                                .addGap(15, 15, 15)
                                .addGroup(VerifyPatientLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblPicture)
                                    .addComponent(lblIMAGE, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(VerifyPatientLayout.createSequentialGroup()
                                        .addGroup(VerifyPatientLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(VerifyPatientLayout.createSequentialGroup()
                                                .addComponent(lblAge)
                                                .addGap(39, 39, 39))
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, VerifyPatientLayout.createSequentialGroup()
                                                .addComponent(lblGender)
                                                .addGap(21, 21, 21)))
                                        .addGroup(VerifyPatientLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(txtAge)
                                            .addComponent(rbM, javax.swing.GroupLayout.DEFAULT_SIZE, 59, Short.MAX_VALUE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(rbF)))))
                        .addContainerGap())))
        );
        VerifyPatientLayout.setVerticalGroup(
            VerifyPatientLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(VerifyPatientLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(VerifyPatientLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(VerifyPatientLayout.createSequentialGroup()
                        .addGroup(VerifyPatientLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblfname)
                            .addComponent(txtfname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(VerifyPatientLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtlname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbllname))
                        .addGap(18, 18, 18)
                        .addGroup(VerifyPatientLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblStreet)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(22, 22, 22)
                        .addGroup(VerifyPatientLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(VerifyPatientLayout.createSequentialGroup()
                                .addComponent(lblCity)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(jScrollPane3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(VerifyPatientLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblPhoneNo)
                            .addComponent(txtPhone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(29, 29, 29)
                        .addGroup(VerifyPatientLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblStatus)
                            .addComponent(cbActive)
                            .addComponent(cbInactive))
                        .addGap(26, 26, 26))
                    .addGroup(VerifyPatientLayout.createSequentialGroup()
                        .addGroup(VerifyPatientLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblAge)
                            .addComponent(txtAge, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(VerifyPatientLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblGender)
                            .addGroup(VerifyPatientLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(rbF)
                                .addComponent(rbM)))
                        .addGap(25, 25, 25)
                        .addComponent(lblPicture)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblIMAGE, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(VerifyPatientLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnBrowse)
                            .addComponent(bntRemove))
                        .addGap(25, 25, 25)
                        .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(30, 30, 30))
        );

        btnDone.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        btnDone.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/recordmanagement/assets/check.png"))); // NOI18N
        btnDone.setText("Done");
        btnDone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDoneActionPerformed(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(17, 24, 42));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Commands", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 12), new java.awt.Color(255, 255, 255))); // NOI18N
        jPanel1.setForeground(new java.awt.Color(255, 255, 255));

        btnSave.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnSave.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/recordmanagement/assets/Submit.png"))); // NOI18N
        btnSave.setText("Submit");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        btnUpdate.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnUpdate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/recordmanagement/assets/Update.png"))); // NOI18N
        btnUpdate.setText("Update");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        btnReset.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnReset.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/recordmanagement/assets/cancel.png"))); // NOI18N
        btnReset.setText("Reset");
        btnReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(btnSave)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(109, 109, 109)
                .addComponent(btnReset, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(46, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSave)
                    .addComponent(btnUpdate)
                    .addComponent(btnReset))
                .addContainerGap(22, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout MainPanelLayout = new javax.swing.GroupLayout(MainPanel);
        MainPanel.setLayout(MainPanelLayout);
        MainPanelLayout.setHorizontalGroup(
            MainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MainPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(MainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(VerifyPatient, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(MainPanelLayout.createSequentialGroup()
                        .addGroup(MainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(TitlePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(MainPanelLayout.createSequentialGroup()
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(194, 194, 194)
                                .addComponent(btnDone, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap())))
        );
        MainPanelLayout.setVerticalGroup(
            MainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MainPanelLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(TitlePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(VerifyPatient, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                .addGroup(MainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, MainPanelLayout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(22, 22, 22))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, MainPanelLayout.createSequentialGroup()
                        .addComponent(btnDone)
                        .addGap(45, 45, 45))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(MainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(MainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    private void btnResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetActionPerformed
        txtID.setText("");
        txtfname.setText("");
        txtlname.setText("");
        txtAddress.setText("");
        txtMeds.setText("");
        txtPhone.setText("");
        txtAge.setText("");
        btnGender.clearSelection();
        btnStatus.clearSelection();
        txtID.setEditable(true);
        lblIMAGE.setIcon(null);
    }//GEN-LAST:event_btnResetActionPerformed
    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
//javax.swing.table.DefaultTableModel mod;
//if(SQLite.openDB()){
//        mod = (javax.swing.table.DefaultTableModel) tblPatient.getModel();  
//        if(tblPatient.getSelectedRow()==-1){
//            if(tblPatient.getRowCount()==0){
//                javax.swing.JOptionPane.showMessageDialog(rootPane,"Table is Empty");
//            }else{
//                javax.swing.JOptionPane.showMessageDialog(rootPane, "You must select a record");
//            }}else{         
//        int index = this.tblPatient.getSelectedRow();
//        javax.swing.table.TableModel model = this.tblPatient.getModel();
//        String Id = model.getValueAt(index, 0).toString();
//        int id = Integer.parseInt(Id);
//          
//        rbM.setActionCommand("Male");
//        rbF.setActionCommand("Female");
//        cbActive.setActionCommand("Active");
//        cbInactive.setActionCommand("Inactive");
//        String fname = txtfname.getText();
//        String lname = txtlname.getText();
//        String street = txtAddress.getText();
//        String meds = txtMeds.getText();
//        String phone = txtPhone.getText();
//        String agee = txtAge.getText(); 
//
//        if(fname.equals("")){txtfname.setBackground(java.awt.Color.green);javax.swing.JOptionPane.showMessageDialog(null, "Invalid  First Name input!","Failed",javax.swing.JOptionPane.INFORMATION_MESSAGE,failed);txtfname.setBackground(java.awt.Color.white);}
//        else if(lname.equals("")){txtlname.setBackground(java.awt.Color.green);javax.swing.JOptionPane.showMessageDialog(null, "Invalid  Last Name input","Failed",javax.swing.JOptionPane.INFORMATION_MESSAGE,failed);txtlname.setBackground(java.awt.Color.white);}
//        else if(btnGender.isSelected(null)){rbF.setBackground(java.awt.Color.green);rbM.setBackground(java.awt.Color.green);javax.swing.JOptionPane.showMessageDialog(null, "Invalid Gender input!","Failed",javax.swing.JOptionPane.INFORMATION_MESSAGE,failed);rbM.setBackground(java.awt.Color.white);rbF.setBackground(java.awt.Color.white);}
//        else if(agee.equals("")){txtAge.setBackground(java.awt.Color.green);javax.swing.JOptionPane.showMessageDialog(null, "Invalid Age input!","Failed",javax.swing.JOptionPane.INFORMATION_MESSAGE,failed);txtAge.setBackground(java.awt.Color.white);}
//        else if(street.equals("")){txtAddress.setBackground(java.awt.Color.green);javax.swing.JOptionPane.showMessageDialog(null, "Invalid Address input!","Failed",javax.swing.JOptionPane.INFORMATION_MESSAGE,failed);txtAddress.setBackground(java.awt.Color.white);}
//        else if(meds.equals("")){txtMeds.setBackground(java.awt.Color.green);javax.swing.JOptionPane.showMessageDialog(null, "Invalid Medical input!","Failed",javax.swing.JOptionPane.INFORMATION_MESSAGE,failed);txtMeds.setBackground(java.awt.Color.white);} 
//        else if(phone.equals("")){txtPhone.setBackground(java.awt.Color.green);javax.swing.JOptionPane.showMessageDialog(null, "Invalid Phone Number input!","Failed",javax.swing.JOptionPane.INFORMATION_MESSAGE,failed);txtPhone.setBackground(java.awt.Color.white);}
//        else if(btnStatus.isSelected(null)){cbActive.setBackground(java.awt.Color.green);cbInactive.setBackground(java.awt.Color.green);javax.swing.JOptionPane.showMessageDialog(null, "Invalid Status input!","Failed",javax.swing.JOptionPane.INFORMATION_MESSAGE,failed);cbActive.setBackground(java.awt.Color.white);cbInactive.setBackground(java.awt.Color.white);}else{
//        int confirm = javax.swing.JOptionPane.showConfirmDialog(null, "Are you sure you want to update "+fname+"?", "Update Patient", javax.swing.JOptionPane.YES_NO_OPTION, 1);
//        if(confirm==0){
//        String gender = btnGender.getSelection().getActionCommand();
//        String status = btnStatus.getSelection().getActionCommand();
//        byte[] image = this.imgdata;
//            String set = "fname='"+fname+"' ,lname='"+lname+"' , gender='"+gender+"', age='"+agee+"' ,  address='"+street+"', medicalhistory='"+meds+"',  phoneNo='"+phone+"', status='"+status+"',"+"Image=''";
//            SQLite.update("patient", set, id);
//            SQLite.updateImage("patient", image, "Image", id);
//            javax.swing.JOptionPane.showMessageDialog(null, fname+" "+lname+" updated successfully!","Completed!",0,success);           
//            
//            java.util.Date currentDate = java.util.GregorianCalendar.getInstance().getTime();
//            java.text.DateFormat df = java.text.DateFormat.getDateInstance();
//            String dateString = df.format(currentDate);
//            java.util.Date d = new java.util.Date();
//            java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("HH:mm:ss a");
//            String timeString = sdf.format(d);
//            
//            String name = com.recordmanagement.classes.User.name;
//            String time = timeString;
//            String date = dateString;
//
//            SQLite.createHistory("name, date, status","'"+name+"','"+date+" / "+time+"','Updated Customer no. "+id+"'");
//            SQLite.closeDB();}
//        } 
//}
//        this.showTable();}
    }//GEN-LAST:event_btnUpdateActionPerformed
    private void btnDoneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDoneActionPerformed
        dispose();
    }//GEN-LAST:event_btnDoneActionPerformed
    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        rbM.setActionCommand("Male");
        rbF.setActionCommand("Female");
        cbActive.setActionCommand("Active");
        cbInactive.setActionCommand("Inactive");
        String fname = txtfname.getText();
        String lname = txtlname.getText();
        String street =txtAddress.getText();
        String meds =txtMeds.getText();
        String phone = txtPhone.getText();
        String agee = txtAge.getText(); 
        java.util.Date currentDate = java.util.GregorianCalendar.getInstance().getTime();
            java.text.DateFormat df = java.text.DateFormat.getDateInstance();
            String dateString = df.format(currentDate);
            java.util.Date d = new java.util.Date();
            java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("HH:mm:ss a");
            String timeString = sdf.format(d);
            
            String name = com.recordmanagement.classes.User.name;
            String time = timeString;
            String date = dateString;
        if(fname.equals("")){txtfname.setBackground(java.awt.Color.green);javax.swing.JOptionPane.showMessageDialog(null, "Invalid  First Name input!","Failed",javax.swing.JOptionPane.INFORMATION_MESSAGE,failed);txtfname.setBackground(java.awt.Color.white);}
        else if(lname.equals("")){txtlname.setBackground(java.awt.Color.green);javax.swing.JOptionPane.showMessageDialog(null, "Invalid  Last Name input","Failed",javax.swing.JOptionPane.INFORMATION_MESSAGE,failed);txtlname.setBackground(java.awt.Color.white);}
        else if(btnGender.isSelected(null)){rbF.setBackground(java.awt.Color.green);rbM.setBackground(java.awt.Color.green);javax.swing.JOptionPane.showMessageDialog(null, "Invalid Gender input!","Failed",javax.swing.JOptionPane.INFORMATION_MESSAGE,failed);rbM.setBackground(java.awt.Color.white);rbF.setBackground(java.awt.Color.white);}
        else if(agee.equals("")){txtAge.setBackground(java.awt.Color.green);javax.swing.JOptionPane.showMessageDialog(null, "Invalid Age input!","Failed",javax.swing.JOptionPane.INFORMATION_MESSAGE,failed);txtAge.setBackground(java.awt.Color.white);}
        else if(street.equals("")){txtAddress.setBackground(java.awt.Color.green);javax.swing.JOptionPane.showMessageDialog(null, "Invalid Address input!","Failed",javax.swing.JOptionPane.INFORMATION_MESSAGE,failed);txtAddress.setBackground(java.awt.Color.white);}
        else if(meds.equals("")){txtMeds.setBackground(java.awt.Color.green);javax.swing.JOptionPane.showMessageDialog(null, "Invalid Medical input!","Failed",javax.swing.JOptionPane.INFORMATION_MESSAGE,failed);txtMeds.setBackground(java.awt.Color.white);} 
        else if(phone.equals("")){txtPhone.setBackground(java.awt.Color.green);javax.swing.JOptionPane.showMessageDialog(null, "Invalid Phone Number input!","Failed",javax.swing.JOptionPane.INFORMATION_MESSAGE,failed);txtPhone.setBackground(java.awt.Color.white);}
        else if(btnStatus.isSelected(null)){cbActive.setBackground(java.awt.Color.green);cbInactive.setBackground(java.awt.Color.green);javax.swing.JOptionPane.showMessageDialog(null, "Invalid Status input!","Failed",javax.swing.JOptionPane.INFORMATION_MESSAGE,failed);cbActive.setBackground(java.awt.Color.white);cbInactive.setBackground(java.awt.Color.white);}else{
        String gender = btnGender.getSelection().getActionCommand();
        String status = btnStatus.getSelection().getActionCommand();
        byte[] image = this.imgdata;
        String column = "fname,lname,gender,age,address,medicalhistory,phoneNo,status,DateRegister,Image";
        String primary = fname+"' and lname='"+lname+"' and gender='"+gender+"' and age='"+agee+"' and phoneNo='"+phone+"' and status='"+status+"'";
        SQLite.openDB();
        SQLite.createColumn("patient",column,"'"+fname+"'"+","+"'"+lname+"'"+","+"'"+gender+"'"+","+"'"+agee+"'"+","+"'"+street+"'"+","+"'"+meds+"'"+","+"'"+phone+"'"+","+"'"+status+"'"+","+"'"+date+"'"+","+"'[B@7b492370'"+"");
        SQLite.updateImage("patient", image, "image", primary);
        SQLite.createHistory("name, date, status","'"+name+"','"+date+" / "+time+"','Add Customer "+fname+" "+lname+"'");
        SQLite.closeDB();
        javax.swing.JOptionPane.showMessageDialog(null, fname+" "+lname+" has beed added.","Completed!",0,success);
        }
    }//GEN-LAST:event_btnSaveActionPerformed
    private void txtAddressKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtAddressKeyPressed

    }//GEN-LAST:event_txtAddressKeyPressed
    private void txtlnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtlnameActionPerformed

    }//GEN-LAST:event_txtlnameActionPerformed
    private void bntRemoveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntRemoveActionPerformed
        lblIMAGE.setIcon(null);
    }//GEN-LAST:event_bntRemoveActionPerformed
    private void btnBrowseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBrowseActionPerformed
        javax.swing.JFileChooser chooser = new javax.swing.JFileChooser();
        chooser.showOpenDialog(null);

        java.io.File f = chooser.getSelectedFile();
        String filename = f.getAbsolutePath();

        java.io.File fimage = new java.io.File(filename);
        try{
            java.io.FileInputStream fis = new java.io.FileInputStream(fimage);
            java.io.ByteArrayOutputStream bos = new java.io.ByteArrayOutputStream();
            byte[] buf = new byte[1024];
            for(int readNum; (readNum=fis.read(buf))!=-1;){
                bos.write(buf,0,readNum);
            }
            imgdata = bos.toByteArray();

            java.awt.Image image = stretchImage(filename,this.lblIMAGE);
            this.lblIMAGE.setIcon(new javax.swing.ImageIcon(image));
        }
        catch(Exception e){
            System.out.println("FileInputStream Error: " + e.getMessage());
        }
    }//GEN-LAST:event_btnBrowseActionPerformed
    private void rbFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rbFActionPerformed
    private void rbMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbMActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rbMActionPerformed
    private void txtAgeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtAgeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtAgeActionPerformed
    private void txtPhoneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPhoneActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPhoneActionPerformed
    public java.util.ArrayList<com.recordmanagement.classes.User> ListUsers(String ValToSearch)
    {
        java.util.ArrayList<com.recordmanagement.classes.User> usersList = new java.util.ArrayList<com.recordmanagement.classes.User>();
        
        try{
            Class.forName("org.sqlite.JDBC");
            conn=java.sql.DriverManager.getConnection(url);
            
            stmt = conn.createStatement();
            java.sql.ResultSet rs = stmt.executeQuery("SELECT * FROM patient WHERE printf('%s %s', fname, lname) LIKE '%"+ValToSearch+"%'");   
            
            com.recordmanagement.classes.User user;
            
            while(rs.next())
            {
                user = new com.recordmanagement.classes.User(
                                 rs.getInt("id"),
                                 rs.getString("fname"),
                                 rs.getString("lname"),
                                 rs.getString("gender"),
                                 rs.getString("age"),
                                 rs.getString("address"),
                                 rs.getString("medicalhistory"),
                                 rs.getString("phoneno"),
                                 rs.getString("status")
                                );
                usersList.add(user);
            }
             conn.close();
            
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        return usersList;
    }
    
    public java.awt.Image stretchImage(String path,javax.swing.JLabel label){
        java.awt.Toolkit toolkit = java.awt.Toolkit.getDefaultToolkit();
        java.awt.Image image = toolkit.getImage(path);
        java.awt.Image scaledImage = image.getScaledInstance(label.getWidth(),label.getHeight(), java.awt.Image.SCALE_DEFAULT);
        return scaledImage;
    }   
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
            java.util.logging.Logger.getLogger(FrmAddingCustomer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmAddingCustomer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmAddingCustomer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmAddingCustomer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new FrmAddingCustomer().setVisible(true);
            }
        });
    }
    final javax.swing.ImageIcon failed = new javax.swing.ImageIcon(getClass().getResource("failed.png"));
    final javax.swing.ImageIcon success = new javax.swing.ImageIcon(getClass().getResource("Success.png"));
    private byte[] imgdata;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel MainPanel;
    private javax.swing.JPanel TitlePanel;
    private javax.swing.JPanel VerifyPatient;
    private javax.swing.JButton bntRemove;
    private javax.swing.JButton btnBrowse;
    private javax.swing.JButton btnDone;
    private javax.swing.ButtonGroup btnGender;
    private javax.swing.JButton btnReset;
    private javax.swing.JButton btnSave;
    private javax.swing.ButtonGroup btnStatus;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JCheckBox cbActive;
    private javax.swing.JCheckBox cbInactive;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lblAge;
    private javax.swing.JLabel lblCity;
    private javax.swing.JLabel lblGender;
    private javax.swing.JLabel lblIMAGE;
    private javax.swing.JLabel lblPhoneNo;
    private javax.swing.JLabel lblPicture;
    private javax.swing.JLabel lblStatus;
    private javax.swing.JLabel lblStreet;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JLabel lblfname;
    private javax.swing.JLabel lbllname;
    private javax.swing.JRadioButton rbF;
    private javax.swing.JRadioButton rbM;
    private javax.swing.JEditorPane txtAddress;
    private javax.swing.JTextField txtAge;
    private javax.swing.JTextField txtID;
    private javax.swing.JEditorPane txtMeds;
    private javax.swing.JTextField txtPhone;
    private javax.swing.JTextField txtfname;
    private javax.swing.JTextField txtlname;
    // End of variables declaration//GEN-END:variables
}