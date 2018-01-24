package com.recordmanagement.app;
import static com.recordmanagement.app.SQLite.conn;
import static com.recordmanagement.app.SQLite.stmt;
import static com.recordmanagement.app.SQLite.url;
/**
 *
 * @author Glyde Llait
 */
public class FrmAppointments extends javax.swing.JFrame {
    public FrmAppointments() {
        initComponents();
        this.setLocationRelativeTo(null);
        setIcon();
        Patientcombo();
        Doctorcombo();
        showTable();    
        com.recordmanagement.classes.Date.dcSetReadOnly(dcDatePicked);
        CBPatient.getModel().setSelectedItem("Select Patient");
        CBTreatment.getModel().setSelectedItem("Select Treatment");      
    }   
    private void Doctorcombo(){
        try{
            String pname = (String) CBPatient.getSelectedItem();
            SQLite.openDB();
            String query = "Select * from login where division='Doctor'"; 
            java.sql.ResultSet rs = null;
            java.sql.PreparedStatement pstmt = null;             
            pstmt = conn.prepareStatement(query); 
            rs = pstmt.executeQuery();
            while(rs.next()){
            String division = rs.getString("name");
            CBDoctor.addItem(division);
            }
            SQLite.closeDB();
        }
        catch(Exception e){
            System.out.println("Doctor Error: " + e.getMessage());
        }
    }
    private void Treatmentcombo(){
        try{
            String pname = lblPatient.getText();
            SQLite.openDB();
            String query = "SELECT * from procedure where patientID='"+pname+"'"; 
            java.sql.ResultSet rs = null;
            java.sql.PreparedStatement pstmt = null;                      
            pstmt = conn.prepareStatement(query);            
            rs = pstmt.executeQuery();
            if(!rs.next()){
            CBTreatment.addItem("Empty");
            }
            SQLite.closeDB();
        }
        catch(Exception e){
            System.out.println("Treatment Error: " + e.getMessage());
        }
    }
    private void Treatmentcomboo(){
        try{
            String pname = lblPatient.getText();
            SQLite.openDB();
            String query = "SELECT * from procedure where patientID='"+pname+"'"; 
            java.sql.ResultSet rs = null;
            java.sql.PreparedStatement pstmt = null;                        
            pstmt = conn.prepareStatement(query);            
            rs = pstmt.executeQuery();
            while(rs.next()){
            String name = rs.getString("serviceID");
            CBTreatment.addItem(name);
            }
            SQLite.closeDB();
        }
        catch(Exception e){
            System.out.println("Treatment2 Error: " + e.getMessage());
        }
    }
    private void Patientcombo(){
        try{
            SQLite.openDB();
            String query = "SELECT printf("+"'%s %s'"+",fname,lname) as Name,id from patient where status='Active'"; 
            java.sql.ResultSet rs = null;
            java.sql.PreparedStatement pstmt = null;                 
            pstmt = conn.prepareStatement(query);            
            rs = pstmt.executeQuery();
            while(rs.next()){
            String name = rs.getString("name");
            String id = rs.getString("id");
            CBPatient.addItem(name);
            lblPatient.setText(id);
            }
            SQLite.closeDB();
        }
        catch(Exception e){
            System.out.println("Patient Error: " + e.getMessage());
        }
    }
    private void Patientcomboo(){
        try{
            String pname = (String) CBPatient.getSelectedItem();
            SQLite.openDB();
            String query = "SELECT id from patient where printf('%s %s',fname,lname)='"+pname+"'"; 
            java.sql.ResultSet rs = null;
            java.sql.PreparedStatement pstmt = null;                 
            pstmt = conn.prepareStatement(query);            
            rs = pstmt.executeQuery();
            while(rs.next()){
            String name = rs.getString("id");
            lblPatient.setText(name);
            }
            SQLite.closeDB();
        }
        catch(Exception e){
            System.out.println("Patient Error: " + e.getMessage());
        }
    }
    private void Hide(){
    CBPatient.getModel().setSelectedItem("Select Patient");
    CBTreatment.getModel().setSelectedItem("Select Treatment");
    CBDoctor.getModel().setSelectedItem("Select Doctor");
    dcDatePicked.setDate(null);
    }
    private void showTable(){
    if(SQLite.openDB()){
            String[][] data = SQLite.readOnly("appointment");
            String[] column = {"Appointment ID","Patient Name","Treatment Name","Doctor Name","Date","Time"};
            javax.swing.table.DefaultTableModel model = new javax.swing.table.DefaultTableModel(data, column){
            @Override
            public boolean isCellEditable(int row, int column){
               return false;
                    }
                };
             this.tblAppointment.setModel(model); 
            SQLite.closeDB();
        }
    }
    private void setIcon() {
        LoginPage setIconImage;
        setIconImage(java.awt.Toolkit.getDefaultToolkit().getImage(getClass().getResource("icon.png")));
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        MainPanel = new javax.swing.JPanel();
        TitlePanel = new javax.swing.JPanel();
        lblTitle = new javax.swing.JLabel();
        FixAppointmentPanel = new javax.swing.JPanel();
        lblSelectPatient = new javax.swing.JLabel();
        lblTreatment = new javax.swing.JLabel();
        lblSelectDate = new javax.swing.JLabel();
        lblTime = new javax.swing.JLabel();
        dcDatePicked = new com.toedter.calendar.JDateChooser();
        btnSubmit = new javax.swing.JButton();
        btnDone = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        CBPatient = new javax.swing.JComboBox<>();
        CBTreatment = new javax.swing.JComboBox<>();
        java.util.Date date = new java.util.Date();
        javax.swing.SpinnerDateModel sm =
        new javax.swing.SpinnerDateModel(date, null, null, java.util.Calendar.HOUR_OF_DAY);
        SpinnerTime = new javax.swing.JSpinner(sm);
        lblPatient = new javax.swing.JLabel();
        lblSelectDoctor = new javax.swing.JLabel();
        CBDoctor = new javax.swing.JComboBox<>();
        AllAppointmentPanel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblAppointment = new javax.swing.JTable();
        SearchEntry = new javax.swing.JLabel();
        dcDateChooser = new com.toedter.calendar.JDateChooser();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Appointment - Diaz Dental Clinic System");
        setUndecorated(true);

        MainPanel.setBackground(new java.awt.Color(17, 24, 42));
        MainPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));

        TitlePanel.setBackground(new java.awt.Color(17, 24, 42));
        TitlePanel.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lblTitle.setBackground(new java.awt.Color(255, 255, 255));
        lblTitle.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblTitle.setForeground(new java.awt.Color(255, 255, 255));
        lblTitle.setText("Appointment Records");

        javax.swing.GroupLayout TitlePanelLayout = new javax.swing.GroupLayout(TitlePanel);
        TitlePanel.setLayout(TitlePanelLayout);
        TitlePanelLayout.setHorizontalGroup(
            TitlePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TitlePanelLayout.createSequentialGroup()
                .addGap(333, 333, 333)
                .addComponent(lblTitle)
                .addContainerGap(363, Short.MAX_VALUE))
        );
        TitlePanelLayout.setVerticalGroup(
            TitlePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TitlePanelLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(lblTitle)
                .addContainerGap(21, Short.MAX_VALUE))
        );

        FixAppointmentPanel.setBackground(new java.awt.Color(17, 24, 42));
        FixAppointmentPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Fix Appointment", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14), new java.awt.Color(255, 255, 255))); // NOI18N

        lblSelectPatient.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblSelectPatient.setForeground(new java.awt.Color(255, 255, 255));
        lblSelectPatient.setText("Select Patient : ");

        lblTreatment.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblTreatment.setForeground(new java.awt.Color(255, 255, 255));
        lblTreatment.setText("Select Treatment : ");

        lblSelectDate.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblSelectDate.setForeground(new java.awt.Color(255, 255, 255));
        lblSelectDate.setText("Select Date :");

        lblTime.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblTime.setForeground(new java.awt.Color(255, 255, 255));
        lblTime.setText("Select Time : ");

        dcDatePicked.setAutoscrolls(true);
        dcDatePicked.setDateFormatString("MMM d, yyyy");
        dcDatePicked.setMinSelectableDate(new java.util.Date());

        btnSubmit.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnSubmit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/recordmanagement/assets/Submit.png"))); // NOI18N
        btnSubmit.setText("Submit");
        btnSubmit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSubmitActionPerformed(evt);
            }
        });

        btnDone.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnDone.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/recordmanagement/assets/check.png"))); // NOI18N
        btnDone.setText("Done");
        btnDone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDoneActionPerformed(evt);
            }
        });

        btnDelete.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/recordmanagement/assets/remove.png"))); // NOI18N
        btnDelete.setText("Delete");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        CBPatient.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CBPatientActionPerformed(evt);
            }
        });
        CBPatient.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                CBPatientKeyPressed(evt);
            }
        });

        javax.swing.JSpinner.DateEditor de = new javax.swing.JSpinner.DateEditor(SpinnerTime, "hh:mm a");
        SpinnerTime.setEditor(de);
        String spinner = de.getFormat().format(SpinnerTime.getValue());

        lblPatient.setText("jLabel1");

        lblSelectDoctor.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblSelectDoctor.setForeground(new java.awt.Color(255, 255, 255));
        lblSelectDoctor.setText("Select Doctor : ");

        CBDoctor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CBDoctorActionPerformed(evt);
            }
        });
        CBDoctor.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                CBDoctorKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout FixAppointmentPanelLayout = new javax.swing.GroupLayout(FixAppointmentPanel);
        FixAppointmentPanel.setLayout(FixAppointmentPanelLayout);
        FixAppointmentPanelLayout.setHorizontalGroup(
            FixAppointmentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(FixAppointmentPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(FixAppointmentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(FixAppointmentPanelLayout.createSequentialGroup()
                        .addComponent(lblPatient, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblTreatment))
                    .addComponent(CBTreatment, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(FixAppointmentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, FixAppointmentPanelLayout.createSequentialGroup()
                            .addComponent(lblSelectPatient)
                            .addGap(179, 179, 179))
                        .addGroup(FixAppointmentPanelLayout.createSequentialGroup()
                            .addComponent(CBPatient, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(107, 107, 107))))
                .addGroup(FixAppointmentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(FixAppointmentPanelLayout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(lblSelectDoctor))
                    .addGroup(FixAppointmentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(CBDoctor, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(FixAppointmentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblSelectDate)
                            .addComponent(dcDatePicked, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(69, 69, 69)
                .addGroup(FixAppointmentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblTime)
                    .addComponent(SpinnerTime, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(90, 90, 90)
                .addGroup(FixAppointmentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSubmit, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDone, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(97, 97, 97))
        );
        FixAppointmentPanelLayout.setVerticalGroup(
            FixAppointmentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(FixAppointmentPanelLayout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(FixAppointmentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(FixAppointmentPanelLayout.createSequentialGroup()
                        .addComponent(lblSelectDoctor)
                        .addGap(6, 6, 6)
                        .addComponent(CBDoctor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(FixAppointmentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblTime, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblSelectDate))
                        .addGap(4, 4, 4)
                        .addComponent(dcDatePicked, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(50, Short.MAX_VALUE))
                    .addGroup(FixAppointmentPanelLayout.createSequentialGroup()
                        .addComponent(btnSubmit)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnDelete)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(FixAppointmentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnDone)
                            .addComponent(SpinnerTime, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))))
            .addGroup(FixAppointmentPanelLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(lblSelectPatient)
                .addGap(6, 6, 6)
                .addComponent(CBPatient, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19)
                .addGroup(FixAppointmentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPatient, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblTreatment))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(CBTreatment, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        AllAppointmentPanel.setBackground(new java.awt.Color(17, 24, 42));
        AllAppointmentPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "All Appointments", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14), new java.awt.Color(255, 255, 255))); // NOI18N

        tblAppointment.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblAppointment.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tblAppointmentKeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(tblAppointment);

        SearchEntry.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        SearchEntry.setForeground(new java.awt.Color(255, 255, 255));
        SearchEntry.setText("Search Entry:");

        dcDateChooser.setDateFormatString("MMM dd, yyyy");

        javax.swing.GroupLayout AllAppointmentPanelLayout = new javax.swing.GroupLayout(AllAppointmentPanel);
        AllAppointmentPanel.setLayout(AllAppointmentPanelLayout);
        AllAppointmentPanelLayout.setHorizontalGroup(
            AllAppointmentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AllAppointmentPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(AllAppointmentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 862, Short.MAX_VALUE)
                    .addGroup(AllAppointmentPanelLayout.createSequentialGroup()
                        .addComponent(SearchEntry)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(dcDateChooser, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        AllAppointmentPanelLayout.setVerticalGroup(
            AllAppointmentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AllAppointmentPanelLayout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addGroup(AllAppointmentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(SearchEntry)
                    .addComponent(dcDateChooser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 273, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout MainPanelLayout = new javax.swing.GroupLayout(MainPanel);
        MainPanel.setLayout(MainPanelLayout);
        MainPanelLayout.setHorizontalGroup(
            MainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, MainPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(MainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(FixAppointmentPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 894, Short.MAX_VALUE)
                    .addComponent(AllAppointmentPanel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(TitlePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        MainPanelLayout.setVerticalGroup(
            MainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, MainPanelLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(TitlePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(FixAppointmentPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(AllAppointmentPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(78, 78, 78))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(MainPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(MainPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 648, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    private void btnDoneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDoneActionPerformed
        dispose();
    }//GEN-LAST:event_btnDoneActionPerformed
    private void btnSubmitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSubmitActionPerformed
        java.util.Date currentDate = java.util.GregorianCalendar.getInstance().getTime();
        java.text.DateFormat df = java.text.DateFormat.getDateInstance();
        String dateString = df.format(currentDate);
        String patient  = lblPatient.getText();
        String treatment = CBTreatment.getSelectedItem().toString();
        String doctor = CBDoctor.getSelectedItem().toString();
        javax.swing.JSpinner.DateEditor de = new javax.swing.JSpinner.DateEditor(SpinnerTime, "hh:mm a");
        SpinnerTime.setEditor(de);
        String time = de.getFormat().format(SpinnerTime.getValue());
        String column = "patientID,serviceID,doctor,date,time";
        if(patient.equals("Select Patient")){ javax.swing.JOptionPane.showMessageDialog(null, "You need to select Patient.","Error",2);}
        else if(treatment.equals("Select Treatment")){
        javax.swing.JOptionPane.showMessageDialog(null, "You need to select Treatment.","Error",2);}
        else if(doctor.equals("Select Doctor")){
        javax.swing.JOptionPane.showMessageDialog(null, "You need to select Doctor.","Error",2);}
        else if(treatment.equals("Empty")){
        javax.swing.JOptionPane.showMessageDialog(null, "No treatment found for "+patient,"Error",2);}
        else{
        String startdate = com.recordmanagement.classes.Date.dcGetDate(dcDateChooser);
        if(startdate.contentEquals(dateString)){
        javax.swing.JOptionPane.showMessageDialog(null, "ew");}
        SQLite.openDB();
        if(SQLite.createColumn("appointment",column,"'"+patient+"'"+","+"'"+treatment+"'"+","+"'"+doctor+"'"+","+"'"+startdate+"'"+","+"'"+time+"'")){
            javax.swing.JOptionPane.showMessageDialog(null, "New Appointment Inserted");}
            else{
            javax.swing.JOptionPane.showMessageDialog(null, "Unable to Insert");}
            java.util.Date d = new java.util.Date();
            java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("HH:mm:ss a");
            String timeString = sdf.format(d);
            
            String name = com.recordmanagement.classes.User.name;
            String timehistory = timeString;
            String date = dateString;

            SQLite.createHistory("name, date, status","'"+name+"','"+date+" / "+timehistory+"','Add new Appointment with "+patient+"'");
        SQLite.closeDB();
        this.showTable();
        javax.swing.JOptionPane.showMessageDialog(null, "Adding Successful","Completed!",0,success);  
        Hide();}
    }//GEN-LAST:event_btnSubmitActionPerformed
    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
      java.sql.PreparedStatement ps = null;  
      java.sql.ResultSet rs = null;
        String query = "Select * FROM appointment WHERE id=?";
        try{
            int id = Integer.parseInt(javax.swing.JOptionPane.showInputDialog("Input Appointment ID"));
            conn = java.sql.DriverManager.getConnection(url);
            ps  = conn.prepareStatement(query);
            ps.setInt(1,id);            
            rs = ps.executeQuery();
            if(rs.next()){
            int confirm = javax.swing.JOptionPane.showConfirmDialog(null, "Are you sure you want to delete this Appointment?","Warning!",0,2);
            if(confirm==0){
            String AppointmentName = rs.getString("pname");
            SQLite.delete("appointment", id);
            java.util.Date currentDate = java.util.GregorianCalendar.getInstance().getTime();
            java.text.DateFormat df = java.text.DateFormat.getDateInstance();
            String dateString = df.format(currentDate);
            java.util.Date d = new java.util.Date();
            java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("HH:mm:ss a");
            String timeString = sdf.format(d);
            String name = com.recordmanagement.classes.User.name;
            String time = timeString;
            String date = dateString;

            SQLite.createHistory("name, date, status","'"+name+"','"+date+" / "+time+"','Delete an Appointment with "+AppointmentName+"'");
                 this.showTable();
            javax.swing.JOptionPane.showMessageDialog(null,"Appointment with "+AppointmentName+" successfully deleted.","Completed!",0,success);
            }
            conn.close();
            }else{
            javax.swing.JOptionPane.showMessageDialog(null,"Please select existing ID","Error!",1);
            btnDelete.setVisible(true);
                }
        }
        catch(Exception e){
            System.out.println("Deleting Appointment Error:" + e.getMessage());
            javax.swing.JOptionPane.showMessageDialog(null,"Invalid ID","Error!",1);
        }    
        finally{
        try{
        rs.close();
        ps.close();
        }
        catch(Exception e){
        }
        }
    }//GEN-LAST:event_btnDeleteActionPerformed
    private void CBPatientKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_CBPatientKeyPressed
        if(evt.getKeyCode()==java.awt.event.KeyEvent.VK_ESCAPE){dispose();}
    }//GEN-LAST:event_CBPatientKeyPressed
    private void tblAppointmentKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tblAppointmentKeyPressed
        int index = this.tblAppointment.getSelectedRow();
        javax.swing.table.TableModel model = this.tblAppointment.getModel();
        String Id = model.getValueAt(index, 0).toString();
        int id = Integer.parseInt(Id);
        String Name = model.getValueAt(index, 1).toString();
        if(evt.getKeyCode()==java.awt.event.KeyEvent.VK_DELETE){
        int confirm = javax.swing.JOptionPane.showConfirmDialog(rootPane, "Are you sure you want to delete this appointment?","Warning!",0,2);
        if(confirm==0){SQLite.openDB();
        SQLite.delete("appointment", id);
            java.util.Date currentDate = java.util.GregorianCalendar.getInstance().getTime();
            java.text.DateFormat df = java.text.DateFormat.getDateInstance();
            String dateString = df.format(currentDate);
            java.util.Date d = new java.util.Date();
            java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("HH:mm:ss a");
            String timeString = sdf.format(d);
            
            String name = com.recordmanagement.classes.User.name;
            String time = timeString;
            String date = dateString;

            SQLite.createHistory("name, date, status","'"+name+"','"+date+" / "+time+"','Delete an Appointment with "+Name+"'");
            
        SQLite.closeDB();
        javax.swing.JOptionPane.showMessageDialog(null,"Appointment with "+Name+" has been deleted.","Completed!",0,success);
        this.showTable();   
        }
        }
    }//GEN-LAST:event_tblAppointmentKeyPressed
    private void CBPatientActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CBPatientActionPerformed
        Patientcomboo();
        CBTreatment.removeAllItems();   
        Treatmentcomboo();
        Treatmentcombo();
        CBTreatment.getModel().setSelectedItem("Select Treatment");
    }//GEN-LAST:event_CBPatientActionPerformed
    private void CBDoctorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CBDoctorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CBDoctorActionPerformed
    private void CBDoctorKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_CBDoctorKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_CBDoctorKeyPressed
    public java.util.ArrayList<com.recordmanagement.classes.Appointment> ListUsers(String Search)
    {
        java.util.ArrayList<com.recordmanagement.classes.Appointment> usersList = new java.util.ArrayList<com.recordmanagement.classes.Appointment>();
        try{
            Class.forName("org.sqlite.JDBC");
            conn=java.sql.DriverManager.getConnection(url);
            
            stmt = conn.createStatement();
            java.sql.ResultSet rs = stmt.executeQuery("SELECT * FROM appointment WHERE printf('%s %s %s %s %s',pname,tname,doctor,date,time) LIKE '%"+Search+"%'");   
            
            com.recordmanagement.classes.Appointment appointment;
            
            while(rs.next())
            {
                appointment = new com.recordmanagement.classes.Appointment(
                                 rs.getInt("id"),
                                 rs.getString("pname"),
                                 rs.getString("tname"),
                                 rs.getString("doctor"),
                                 rs.getString("date"),
                                 rs.getString("time"));
                usersList.add(appointment);
            }
             conn.close();            
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        return usersList;
    }
    public void findUsers(){
        String datee = com.recordmanagement.classes.Date.dcGetDate(dcDateChooser);
        java.util.ArrayList<com.recordmanagement.classes.Appointment> appointment = ListUsers(datee);
        javax.swing.table.DefaultTableModel model = new javax.swing.table.DefaultTableModel();
        model.setColumnIdentifiers(new Object[]{"Appointment ID","Patient Name","Treatment Name","Doctor Name","Date","Time"});
        Object[] row = new Object[6];
        
        for(int i = 0; i < appointment.size(); i++){
            row[0] = appointment.get(i).getId();
            row[1] = appointment.get(i).getName();
            row[2] = appointment.get(i).getTreatment();
            row[3] = appointment.get(i).getDoctor();
            row[4] = appointment.get(i).getDate();
            row[5] = appointment.get(i).getTime();
            model.addRow(row);
        }
       tblAppointment.setModel(model);
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
            java.util.logging.Logger.getLogger(FrmAppointments.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmAppointments.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmAppointments.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmAppointments.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmAppointments().setVisible(true);
            }
        });
    }
    final javax.swing.ImageIcon success = new javax.swing.ImageIcon(getClass().getResource("Success.png"));
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel AllAppointmentPanel;
    private javax.swing.JComboBox<String> CBDoctor;
    private javax.swing.JComboBox<String> CBPatient;
    private javax.swing.JComboBox<String> CBTreatment;
    private javax.swing.JPanel FixAppointmentPanel;
    private javax.swing.JPanel MainPanel;
    private javax.swing.JLabel SearchEntry;
    private javax.swing.JSpinner SpinnerTime;
    private javax.swing.JPanel TitlePanel;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnDone;
    private javax.swing.JButton btnSubmit;
    private com.toedter.calendar.JDateChooser dcDateChooser;
    private com.toedter.calendar.JDateChooser dcDatePicked;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblPatient;
    private javax.swing.JLabel lblSelectDate;
    private javax.swing.JLabel lblSelectDoctor;
    private javax.swing.JLabel lblSelectPatient;
    private javax.swing.JLabel lblTime;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JLabel lblTreatment;
    private javax.swing.JTable tblAppointment;
    // End of variables declaration//GEN-END:variables
}
