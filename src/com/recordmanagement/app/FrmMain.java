package com.recordmanagement.app;
import static com.recordmanagement.app.SQLite.conn;
import static com.recordmanagement.app.SQLite.stmt;
import static com.recordmanagement.app.SQLite.url;
/**
 *
 * @author Glyde Llait
 */
public class FrmMain extends javax.swing.JFrame {
    public FrmMain() {
        initComponents();
        this.setLocationRelativeTo(null);
        setExtendedState(javax.swing.JFrame.MAXIMIZED_BOTH);
        MainPanel.setSize(600,700);
        SeparatorTeam.setVisible(false);
        lblUser.setText(com.recordmanagement.classes.User.name); 
        lblUsername.setText(com.recordmanagement.classes.User.username);
        setIcon();  
        Time();
        Admin();
        Visible();
        emptyTable();
        lblShow.setVisible(false);
    }
    private void Admin(){
        if(com.recordmanagement.classes.User.division.equals("Admin")){
        MenuAdmin.setVisible(true);
        SeparatorTeam.setVisible(true);
        }else{
        MenuAdmin.setVisible(false);
        }
    }
    private void Visible(){
        SQLite.openDB();
        try{
            String username = com.recordmanagement.classes.User.username;
            byte[] in = SQLite.readString("login", "Image", username);
            javax.swing.ImageIcon icon =new javax.swing.ImageIcon(in);
                                
                                //stretching image
            java.awt.Toolkit toolkit = java.awt.Toolkit.getDefaultToolkit();
            java.awt.Image image = icon.getImage();
            java.awt.Image scaledImage = image.getScaledInstance(lblIMAGE.getWidth(),lblIMAGE.getHeight(), java.awt.Image.SCALE_DEFAULT);                                                                
            lblIMAGE.setIcon(new javax.swing.ImageIcon(scaledImage));  
            }
            catch(Exception e){
            System.out.println("Visible Error: " + e.getMessage());
            }
        SQLite.closeDB();
    }
    private void Search(){
    try{
            String pname = txtSearch.getText();
            SQLite.openDB();
            String query = "SELECT * from patient where printf('%s',fname) LIKE '%"+pname+"%'";
            java.sql.ResultSet rs = null;
            java.sql.PreparedStatement pstmt = null;                        
            pstmt = conn.prepareStatement(query);            
            rs = pstmt.executeQuery();
            while(rs.next()){
            int id = rs.getInt("id");
            String age = rs.getString("age");
            String gender = rs.getString("gender");
            String street = rs.getString("address");
            String city = rs.getString("medicalhistory");
            String phoneno = rs.getString("phoneNo");
            String dateReg = rs.getString("DateRegister");
            MyAge.setText(age);
            MyGender.setText(gender);
            MyStreet.setText(street);
            MyCity.setText(city);
            MyPhoneNo.setText(phoneno);
            MyReg.setText(dateReg);
            try{
                                byte[] in = SQLite.read("patient", "Image", id);
                                javax.swing.ImageIcon icon =new javax.swing.ImageIcon(in);
                                //stretching image
                                java.awt.Toolkit toolkit = java.awt.Toolkit.getDefaultToolkit();
                                java.awt.Image image = icon.getImage();
                                java.awt.Image scaledImage = image.getScaledInstance(lblIMAGE.getWidth(),lblIMAGE.getHeight(), java.awt.Image.SCALE_DEFAULT);                                                                
                                lblMyIMAGE.setIcon(new javax.swing.ImageIcon(scaledImage));  
                            }
                            catch(Exception e){
                               lblMyIMAGE.setIcon(null);
                                System.out.println("Image Error: " + e.getMessage());
                            }
            }
            SQLite.closeDB();
        }
        catch(Exception e){
            System.out.println("Search Error: " + e.getMessage());
        }
    }
    public java.util.ArrayList<com.recordmanagement.classes.Procedure> ListUsers(String search){
        java.util.ArrayList<com.recordmanagement.classes.Procedure> usersList = new java.util.ArrayList<com.recordmanagement.classes.Procedure>();
        
        try{
            Class.forName("org.sqlite.JDBC");
            conn=java.sql.DriverManager.getConnection(url);
            
            stmt = conn.createStatement();
            java.sql.ResultSet rs = stmt.executeQuery("SELECT printf('%s %s',p.fname,p.lname) as PatientName,t.name as TreatmentName,pro.date,pro.cost \n" +
            "from procedure as pro\n" +
            "inner join patient as p on\n" +
            "pro.patientID = p.ID\n"+
            "inner join service as t on \n" +
            "pro.serviceID = t.ID where PatientName like '%"+search+"%';");   
            
            com.recordmanagement.classes.Procedure user;
            
            while(rs.next())
            {
                user = new com.recordmanagement.classes.Procedure(
                                 rs.getString("patientname"),
                                 rs.getString("treatmentname"),
                                 rs.getString("date"),
                                 rs.getInt("cost")
                                );
                usersList.add(user);
            }
             conn.close();
            
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        
        return usersList;
    }
    public void findUsers(){
        java.util.ArrayList<com.recordmanagement.classes.Procedure> users = ListUsers(txtSearch.getText());
        javax.swing.table.DefaultTableModel model = new javax.swing.table.DefaultTableModel();
        model.setColumnIdentifiers(new Object[]{"Patient Name", "Treatment Name", "Date","Cost"});
        Object[] row = new Object[4];
        
        for(int i = 0; i < users.size(); i++)
        {
            row[0] = users.get(i).getPName();
            row[1] = users.get(i).getTName();
            row[2] = users.get(i).getDate();
            row[3] = users.get(i).getCost();
            model.addRow(row);
        }
       tblTreatment.setModel(model);      
    }
    private void setIcon() {
        LoginPage setIconImage;
        setIconImage(java.awt.Toolkit.getDefaultToolkit().getImage(getClass().getResource("icon.png")));
    }
    private void emptyTable(){
    if(SQLite.openDB()){
            String[][] data = SQLite.read("");
            String[] column = {"None"};
            javax.swing.table.DefaultTableModel model = new javax.swing.table.DefaultTableModel(data, column);
             this.tblTreatment.setModel(model); 
            SQLite.closeDB();}
    }
    private void showTable() {
        if(SQLite.openDB()){
            String[][] data = SQLite.readColumn("procedure","ID,patientID,serviceID,Cost,Date","ID");
            String[] column = {"ID","Patinet Name", "Service Name","Cost","Date"};
            javax.swing.table.DefaultTableModel model = new javax.swing.table.DefaultTableModel(data, column){
            @Override
            public boolean isCellEditable(int row, int column){
               return  false;
            }
                };
             this.tblTreatment.setModel(model);
        SQLite.closeDB();}
    }
    public void Time(){

        final java.text.DateFormat timeFormat = new java.text.SimpleDateFormat("h:mm:ss a");
        final java.text.SimpleDateFormat dateFormat = new java.text.SimpleDateFormat("EEE, MMM d, yyyy");
        java.awt.event.ActionListener timerListener = new java.awt.event.ActionListener(){
            public void actionPerformed(java.awt.event.ActionEvent e){
                java.util.Date date = new java.util.Date();
                String time = timeFormat.format(date);
                String day = dateFormat.format(date);
                timeLabel.setText(time);
                dateLabel.setText(day);
                
                String timelabel = timeLabel.getText();
                
                String query = "SELECT printf('%s %s',p.fname,p.lname) as PatientName,t.name as TreatmentName,app.time,app.doctor "
                        + "from appointment as app "
                        + "inner join service as t on app.serviceID = t.ID "
                        + "inner join patient as p on app.patientID = p.ID ";
                try{
                conn = java.sql.DriverManager.getConnection(url);
                java.sql.PreparedStatement ps = conn.prepareStatement(query);  
                java.sql.ResultSet rs = ps.executeQuery();
                while(rs.next()){
                    String pname = rs.getString("PatientName");
                    String tname = rs.getString("TreatmentName");
                    String timee = rs.getString("time");
                    String doc = rs.getString("doctor");
                    if(timelabel.equals(timee)){
                    java.awt.SystemTray tray = java.awt.SystemTray.getSystemTray();
                    java.awt.Image image = java.awt.Toolkit.getDefaultToolkit().createImage("icon.png");
                    java.awt.TrayIcon trayIcon = new java.awt.TrayIcon(image,"Appointment Notification");
                    trayIcon.setImageAutoSize(true);
                    trayIcon.setToolTip("System tray icon demo");
                        try {
                            tray.add(trayIcon);
                        } catch (java.awt.AWTException ex) {
                            java.util.logging.Logger.getLogger(FrmMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
                        }
                    trayIcon.displayMessage("Doctor "+doc+" has appointment", pname+" has a treatment "+tname, java.awt.TrayIcon.MessageType.INFO);}
                }
                conn.close();
        }
            catch(Exception ee){
                 System.out.println("Notification Error:" + ee.getMessage());
        }
                
        
       }
   };
        javax.swing.Timer timer = new javax.swing.Timer(1000, timerListener);
        timer.setInitialDelay(0);
        timer.start();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        MainPanel = new javax.swing.JPanel();
        DatePanel = new javax.swing.JPanel();
        lblDate = new javax.swing.JLabel();
        lblTime = new javax.swing.JLabel();
        dateLabel = new javax.swing.JLabel();
        timeLabel = new javax.swing.JLabel();
        lblLogged = new javax.swing.JLabel();
        lblUser = new javax.swing.JLabel();
        lblIMAGE = new javax.swing.JLabel();
        lblUsername = new javax.swing.JLabel();
        lblHappy = new javax.swing.JLabel();
        lblShow = new javax.swing.JLabel();
        lblExit = new javax.swing.JLabel();
        TabPanePatientCollection = new javax.swing.JTabbedPane();
        PanelPatientHistory = new javax.swing.JPanel();
        PanelPatientDetails = new javax.swing.JPanel();
        PanelSearch = new javax.swing.JPanel();
        lblSearch = new javax.swing.JLabel();
        txtSearch = new javax.swing.JTextField();
        PanelPatient = new javax.swing.JPanel();
        lblAge = new javax.swing.JLabel();
        lblGender = new javax.swing.JLabel();
        lblStreet = new javax.swing.JLabel();
        lblPhoneNo = new javax.swing.JLabel();
        lblCity = new javax.swing.JLabel();
        lblRegister = new javax.swing.JLabel();
        MyAge = new javax.swing.JTextField();
        MyGender = new javax.swing.JTextField();
        MyPhoneNo = new javax.swing.JTextField();
        MyStreet = new javax.swing.JTextField();
        MyCity = new javax.swing.JTextField();
        MyReg = new javax.swing.JTextField();
        PanelTreatment = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblTreatment = new javax.swing.JTable();
        lblMyIMAGE = new javax.swing.JLabel();
        PanelCollectionDetails = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblCollection = new javax.swing.JTable();
        lblSelectDate = new javax.swing.JLabel();
        lblTo = new javax.swing.JLabel();
        dcBy = new com.toedter.calendar.JDateChooser();
        dcTo = new com.toedter.calendar.JDateChooser();
        lblAmount = new javax.swing.JLabel();
        txtAmount = new javax.swing.JTextField();
        DentalMenu = new javax.swing.JMenuBar();
        File = new javax.swing.JMenu();
        VerifyPatient = new javax.swing.JMenuItem();
        VerifyTreatment = new javax.swing.JMenuItem();
        SeparatorFile = new javax.swing.JPopupMenu.Separator();
        Print = new javax.swing.JMenuItem();
        SeparatorPrint = new javax.swing.JPopupMenu.Separator();
        Quit = new javax.swing.JMenuItem();
        MenuAppointment = new javax.swing.JMenu();
        MenuTeam = new javax.swing.JMenu();
        MenuChangePass = new javax.swing.JMenuItem();
        MenuHistory = new javax.swing.JMenuItem();
        SeparatorTeam = new javax.swing.JPopupMenu.Separator();
        MenuAdmin = new javax.swing.JMenu();
        MenuAdd = new javax.swing.JMenuItem();
        MenuDelete = new javax.swing.JMenuItem();
        MenuList = new javax.swing.JMenuItem();
        About = new javax.swing.JMenu();
        SignOut = new javax.swing.JMenu();

        jMenuItem1.setText("jMenuItem1");

        jMenuItem2.setText("jMenuItem2");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Diaz Dental Clinic System");
        setUndecorated(true);

        MainPanel.setBackground(new java.awt.Color(17, 24, 42));
        MainPanel.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        MainPanel.setPreferredSize(new java.awt.Dimension(1006, 650));

        DatePanel.setBackground(new java.awt.Color(17, 24, 42));
        DatePanel.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lblDate.setFont(new java.awt.Font("Nirmala UI", 1, 14)); // NOI18N
        lblDate.setForeground(new java.awt.Color(255, 255, 255));
        lblDate.setText("Date: ");

        lblTime.setFont(new java.awt.Font("Nirmala UI", 1, 14)); // NOI18N
        lblTime.setForeground(new java.awt.Color(255, 255, 255));
        lblTime.setText("Time: ");

        dateLabel.setFont(new java.awt.Font("Nirmala UI", 1, 14)); // NOI18N
        dateLabel.setForeground(new java.awt.Color(255, 255, 255));
        dateLabel.setText("Team");

        timeLabel.setFont(new java.awt.Font("Nirmala UI", 1, 14)); // NOI18N
        timeLabel.setForeground(new java.awt.Color(255, 255, 255));
        timeLabel.setText("Siomai");

        javax.swing.GroupLayout DatePanelLayout = new javax.swing.GroupLayout(DatePanel);
        DatePanel.setLayout(DatePanelLayout);
        DatePanelLayout.setHorizontalGroup(
            DatePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DatePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(DatePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(DatePanelLayout.createSequentialGroup()
                        .addComponent(lblDate)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(dateLabel))
                    .addGroup(DatePanelLayout.createSequentialGroup()
                        .addComponent(lblTime)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(timeLabel)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        DatePanelLayout.setVerticalGroup(
            DatePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, DatePanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(DatePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(dateLabel)
                    .addComponent(lblDate))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(DatePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTime)
                    .addComponent(timeLabel))
                .addContainerGap())
        );

        lblLogged.setFont(new java.awt.Font("Nirmala UI", 1, 13)); // NOI18N
        lblLogged.setForeground(new java.awt.Color(255, 255, 255));
        lblLogged.setText("Logged in as:");

        lblUser.setFont(new java.awt.Font("Nirmala UI", 1, 14)); // NOI18N
        lblUser.setForeground(new java.awt.Color(153, 255, 51));
        lblUser.setText("User");

        lblIMAGE.setBackground(new java.awt.Color(17, 24, 42));
        lblIMAGE.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 204, 204)));
        lblIMAGE.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblIMAGEMouseClicked(evt);
            }
        });

        lblUsername.setFont(new java.awt.Font("Nirmala UI", 1, 13)); // NOI18N
        lblUsername.setForeground(new java.awt.Color(255, 255, 255));
        lblUsername.setText("Username");

        lblHappy.setFont(new java.awt.Font("Nirmala UI", 1, 14)); // NOI18N
        lblHappy.setForeground(new java.awt.Color(153, 255, 51));
        lblHappy.setText("is happy to serve :))");

        lblShow.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblShow.setForeground(new java.awt.Color(153, 255, 51));
        lblShow.setText("Click to show image.");
        lblShow.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblShowMouseClicked(evt);
            }
        });

        lblExit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/recordmanagement/assets/exit.png"))); // NOI18N
        lblExit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblExitMouseClicked(evt);
            }
        });

        TabPanePatientCollection.setBackground(new java.awt.Color(17, 24, 42));
        TabPanePatientCollection.setForeground(new java.awt.Color(0, 102, 0));
        TabPanePatientCollection.setTabLayoutPolicy(javax.swing.JTabbedPane.SCROLL_TAB_LAYOUT);
        TabPanePatientCollection.setTabPlacement(javax.swing.JTabbedPane.LEFT);
        TabPanePatientCollection.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        PanelPatientDetails.setBackground(new java.awt.Color(17, 24, 42));
        PanelPatientDetails.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Patient Information", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 14), new java.awt.Color(255, 255, 255))); // NOI18N

        PanelSearch.setBackground(new java.awt.Color(17, 24, 42));
        PanelSearch.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Search", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 14), new java.awt.Color(255, 255, 255))); // NOI18N

        lblSearch.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblSearch.setForeground(new java.awt.Color(255, 255, 255));
        lblSearch.setText("Search Name :");

        txtSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtSearchKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout PanelSearchLayout = new javax.swing.GroupLayout(PanelSearch);
        PanelSearch.setLayout(PanelSearchLayout);
        PanelSearchLayout.setHorizontalGroup(
            PanelSearchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelSearchLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblSearch)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(264, Short.MAX_VALUE))
        );
        PanelSearchLayout.setVerticalGroup(
            PanelSearchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelSearchLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(PanelSearchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblSearch)
                    .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(44, Short.MAX_VALUE))
        );

        PanelPatient.setBackground(new java.awt.Color(17, 24, 42));
        PanelPatient.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Patient Details", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 14), new java.awt.Color(255, 255, 255))); // NOI18N

        lblAge.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblAge.setForeground(new java.awt.Color(255, 255, 255));
        lblAge.setText("Age :");

        lblGender.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblGender.setForeground(new java.awt.Color(255, 255, 255));
        lblGender.setText("Gender :");

        lblStreet.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblStreet.setForeground(new java.awt.Color(255, 255, 255));
        lblStreet.setText("Address :");

        lblPhoneNo.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblPhoneNo.setForeground(new java.awt.Color(255, 255, 255));
        lblPhoneNo.setText("Phone No. :");

        lblCity.setForeground(new java.awt.Color(255, 255, 255));
        lblCity.setText("Medical History :");

        lblRegister.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblRegister.setForeground(new java.awt.Color(255, 255, 255));
        lblRegister.setText("Date Registered :");

        MyAge.setEditable(false);
        MyAge.setBackground(new java.awt.Color(17, 24, 42));
        MyAge.setBorder(null);

        MyGender.setEditable(false);
        MyGender.setBackground(new java.awt.Color(17, 24, 42));
        MyGender.setBorder(null);
        MyGender.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MyGenderActionPerformed(evt);
            }
        });

        MyPhoneNo.setEditable(false);
        MyPhoneNo.setBackground(new java.awt.Color(17, 24, 42));
        MyPhoneNo.setBorder(null);

        MyStreet.setEditable(false);
        MyStreet.setBackground(new java.awt.Color(17, 24, 42));
        MyStreet.setBorder(null);

        MyCity.setEditable(false);
        MyCity.setBackground(new java.awt.Color(17, 24, 42));
        MyCity.setBorder(null);

        MyReg.setEditable(false);
        MyReg.setBackground(new java.awt.Color(17, 24, 42));
        MyReg.setBorder(null);

        javax.swing.GroupLayout PanelPatientLayout = new javax.swing.GroupLayout(PanelPatient);
        PanelPatient.setLayout(PanelPatientLayout);
        PanelPatientLayout.setHorizontalGroup(
            PanelPatientLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelPatientLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanelPatientLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelPatientLayout.createSequentialGroup()
                        .addComponent(lblAge)
                        .addGap(18, 18, 18)
                        .addComponent(MyAge, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(PanelPatientLayout.createSequentialGroup()
                        .addComponent(lblGender)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(MyGender, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(10, 10, 10)
                .addGroup(PanelPatientLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblPhoneNo)
                    .addComponent(lblStreet))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PanelPatientLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(MyStreet, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(MyPhoneNo))
                .addGap(56, 56, 56)
                .addGroup(PanelPatientLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblRegister)
                    .addComponent(lblCity))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PanelPatientLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(MyCity, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(MyReg, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(75, 75, 75))
        );
        PanelPatientLayout.setVerticalGroup(
            PanelPatientLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelPatientLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(PanelPatientLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblAge)
                    .addComponent(lblPhoneNo)
                    .addComponent(MyAge, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(MyPhoneNo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblCity)
                    .addComponent(MyCity, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addGroup(PanelPatientLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblGender)
                    .addComponent(lblStreet)
                    .addComponent(MyGender, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(MyStreet, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblRegister)
                    .addComponent(MyReg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16))
        );

        PanelTreatment.setBackground(new java.awt.Color(17, 24, 42));
        PanelTreatment.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Treatment History", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 14), new java.awt.Color(255, 255, 255))); // NOI18N

        tblTreatment.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tblTreatment);

        javax.swing.GroupLayout PanelTreatmentLayout = new javax.swing.GroupLayout(PanelTreatment);
        PanelTreatment.setLayout(PanelTreatmentLayout);
        PanelTreatmentLayout.setHorizontalGroup(
            PanelTreatmentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelTreatmentLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 870, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39))
        );
        PanelTreatmentLayout.setVerticalGroup(
            PanelTreatmentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelTreatmentLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 380, Short.MAX_VALUE)
                .addContainerGap())
        );

        lblMyIMAGE.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblMyIMAGE.setForeground(new java.awt.Color(255, 255, 255));
        lblMyIMAGE.setText("                No Picture");
        lblMyIMAGE.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 204, 204)));

        javax.swing.GroupLayout PanelPatientDetailsLayout = new javax.swing.GroupLayout(PanelPatientDetails);
        PanelPatientDetails.setLayout(PanelPatientDetailsLayout);
        PanelPatientDetailsLayout.setHorizontalGroup(
            PanelPatientDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelPatientDetailsLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(PanelPatientDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(PanelTreatment, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(PanelPatientDetailsLayout.createSequentialGroup()
                        .addGroup(PanelPatientDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(PanelSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(PanelPatient, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblMyIMAGE, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(32, 32, 32))
        );
        PanelPatientDetailsLayout.setVerticalGroup(
            PanelPatientDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelPatientDetailsLayout.createSequentialGroup()
                .addGroup(PanelPatientDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelPatientDetailsLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(PanelSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(PanelPatient, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(PanelPatientDetailsLayout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(lblMyIMAGE, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(PanelTreatment, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout PanelPatientHistoryLayout = new javax.swing.GroupLayout(PanelPatientHistory);
        PanelPatientHistory.setLayout(PanelPatientHistoryLayout);
        PanelPatientHistoryLayout.setHorizontalGroup(
            PanelPatientHistoryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelPatientHistoryLayout.createSequentialGroup()
                .addComponent(PanelPatientDetails, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
        PanelPatientHistoryLayout.setVerticalGroup(
            PanelPatientHistoryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelPatientHistoryLayout.createSequentialGroup()
                .addComponent(PanelPatientDetails, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );

        TabPanePatientCollection.addTab("Patient Details", PanelPatientHistory);

        PanelCollectionDetails.setBackground(new java.awt.Color(17, 24, 42));
        PanelCollectionDetails.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Collection Details", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 14), new java.awt.Color(255, 255, 255))); // NOI18N

        tblCollection.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(tblCollection);

        lblSelectDate.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblSelectDate.setForeground(new java.awt.Color(255, 255, 255));
        lblSelectDate.setText("Select Date :");

        lblTo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblTo.setForeground(new java.awt.Color(255, 255, 255));
        lblTo.setText("To :");

        lblAmount.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblAmount.setForeground(new java.awt.Color(255, 255, 255));
        lblAmount.setText("Total Amount :      ");

        txtAmount.setEditable(false);
        txtAmount.setBackground(new java.awt.Color(153, 255, 255));

        javax.swing.GroupLayout PanelCollectionDetailsLayout = new javax.swing.GroupLayout(PanelCollectionDetails);
        PanelCollectionDetails.setLayout(PanelCollectionDetailsLayout);
        PanelCollectionDetailsLayout.setHorizontalGroup(
            PanelCollectionDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelCollectionDetailsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanelCollectionDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2)
                    .addGroup(PanelCollectionDetailsLayout.createSequentialGroup()
                        .addComponent(lblSelectDate)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(dcBy, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblTo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(dcTo, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 444, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelCollectionDetailsLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(lblAmount)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtAmount, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        PanelCollectionDetailsLayout.setVerticalGroup(
            PanelCollectionDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelCollectionDetailsLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(PanelCollectionDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelCollectionDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblSelectDate)
                        .addComponent(lblTo))
                    .addComponent(dcBy, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dcTo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 520, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 45, Short.MAX_VALUE)
                .addGroup(PanelCollectionDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblAmount)
                    .addComponent(txtAmount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(42, 42, 42))
        );

        TabPanePatientCollection.addTab("Collection Details", PanelCollectionDetails);

        javax.swing.GroupLayout MainPanelLayout = new javax.swing.GroupLayout(MainPanel);
        MainPanel.setLayout(MainPanelLayout);
        MainPanelLayout.setHorizontalGroup(
            MainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MainPanelLayout.createSequentialGroup()
                .addGroup(MainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(MainPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(MainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(MainPanelLayout.createSequentialGroup()
                                .addComponent(lblExit)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblShow))
                            .addComponent(lblIMAGE, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(MainPanelLayout.createSequentialGroup()
                                .addGap(36, 36, 36)
                                .addComponent(lblHappy))
                            .addGroup(MainPanelLayout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addGroup(MainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(DatePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblUser))))
                        .addComponent(TabPanePatientCollection, javax.swing.GroupLayout.PREFERRED_SIZE, 1114, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(MainPanelLayout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addComponent(lblLogged)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblUsername)))
                .addContainerGap(49, Short.MAX_VALUE))
        );
        MainPanelLayout.setVerticalGroup(
            MainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MainPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(TabPanePatientCollection, javax.swing.GroupLayout.PREFERRED_SIZE, 727, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(313, Short.MAX_VALUE))
            .addGroup(MainPanelLayout.createSequentialGroup()
                .addGap(2, 2, 2)
                .addGroup(MainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblExit)
                    .addComponent(lblShow, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblIMAGE, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblUser)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblHappy)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(MainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblLogged)
                    .addComponent(lblUsername))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(DatePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31))
        );

        File.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/recordmanagement/assets/menu.png"))); // NOI18N
        File.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        VerifyPatient.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_P, java.awt.event.InputEvent.CTRL_MASK));
        VerifyPatient.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        VerifyPatient.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/recordmanagement/assets/Add Patient.png"))); // NOI18N
        VerifyPatient.setText("Adding Patient");
        VerifyPatient.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                VerifyPatientActionPerformed(evt);
            }
        });
        File.add(VerifyPatient);

        VerifyTreatment.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_T, java.awt.event.InputEvent.CTRL_MASK));
        VerifyTreatment.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        VerifyTreatment.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/recordmanagement/assets/Add Treatment.png"))); // NOI18N
        VerifyTreatment.setText("Adding Service");
        VerifyTreatment.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                VerifyTreatmentActionPerformed(evt);
            }
        });
        File.add(VerifyTreatment);
        File.add(SeparatorFile);

        Print.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_P, java.awt.event.InputEvent.ALT_MASK | java.awt.event.InputEvent.SHIFT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        Print.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        Print.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/recordmanagement/assets/Printer.png"))); // NOI18N
        Print.setText("Print..");
        Print.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PrintActionPerformed(evt);
            }
        });
        File.add(Print);
        File.add(SeparatorPrint);

        Quit.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F4, java.awt.event.InputEvent.ALT_MASK));
        Quit.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        Quit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/recordmanagement/assets/exit.png"))); // NOI18N
        Quit.setText("Quit Application");
        Quit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                QuitActionPerformed(evt);
            }
        });
        File.add(Quit);

        DentalMenu.add(File);

        MenuAppointment.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/recordmanagement/assets/Health.png"))); // NOI18N
        MenuAppointment.setText("Appointments");
        MenuAppointment.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        MenuAppointment.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                MenuAppointmentMouseClicked(evt);
            }
        });
        DentalMenu.add(MenuAppointment);

        MenuTeam.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/recordmanagement/assets/team.png"))); // NOI18N
        MenuTeam.setText("Team");
        MenuTeam.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        MenuChangePass.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_P, java.awt.event.InputEvent.ALT_MASK));
        MenuChangePass.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        MenuChangePass.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/recordmanagement/assets/signup.png"))); // NOI18N
        MenuChangePass.setText("Change Password");
        MenuChangePass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuChangePassActionPerformed(evt);
            }
        });
        MenuTeam.add(MenuChangePass);

        MenuHistory.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_H, java.awt.event.InputEvent.CTRL_MASK));
        MenuHistory.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        MenuHistory.setText("History");
        MenuHistory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuHistoryActionPerformed(evt);
            }
        });
        MenuTeam.add(MenuHistory);
        MenuTeam.add(SeparatorTeam);

        MenuAdmin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/recordmanagement/assets/Doctor.png"))); // NOI18N
        MenuAdmin.setText("Admin");
        MenuAdmin.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N

        MenuAdd.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        MenuAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/recordmanagement/assets/signup.png"))); // NOI18N
        MenuAdd.setText("Add User");
        MenuAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuAddActionPerformed(evt);
            }
        });
        MenuAdmin.add(MenuAdd);

        MenuDelete.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        MenuDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/recordmanagement/assets/remove.png"))); // NOI18N
        MenuDelete.setText("Delete User");
        MenuDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuDeleteActionPerformed(evt);
            }
        });
        MenuAdmin.add(MenuDelete);

        MenuList.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        MenuList.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/recordmanagement/assets/Show.png"))); // NOI18N
        MenuList.setText("List of Users");
        MenuList.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuListActionPerformed(evt);
            }
        });
        MenuAdmin.add(MenuList);

        MenuTeam.add(MenuAdmin);

        DentalMenu.add(MenuTeam);

        About.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/recordmanagement/assets/Actions-help-about-icon.png"))); // NOI18N
        About.setText("About");
        About.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        About.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                AboutMouseClicked(evt);
            }
        });
        DentalMenu.add(About);

        SignOut.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/recordmanagement/assets/singout.png"))); // NOI18N
        SignOut.setText("Sign Out");
        SignOut.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        SignOut.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                SignOutMouseClicked(evt);
            }
        });
        DentalMenu.add(SignOut);

        setJMenuBar(DentalMenu);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(MainPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 1372, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(MainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 1057, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    private void VerifyPatientActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VerifyPatientActionPerformed
        verify.setVisible(true);
    }//GEN-LAST:event_VerifyPatientActionPerformed
    private void AboutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AboutMouseClicked
        about.setVisible(true);
    }//GEN-LAST:event_AboutMouseClicked
    private void QuitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_QuitActionPerformed
        if(SQLite.openDB()){
            java.util.Date currentDate = java.util.GregorianCalendar.getInstance().getTime();
            java.text.DateFormat df = java.text.DateFormat.getDateInstance();
            String dateString = df.format(currentDate);
            java.util.Date d = new java.util.Date();
            java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("HH:mm:ss a");
            String timeString = sdf.format(d);
            
            String name = com.recordmanagement.classes.User.name;
            String time = timeString;
            String date = dateString;

            SQLite.createHistory("name, date, status","'"+name+"','"+date+" / "+time+"','Signed out'");
            SQLite.closeDB();
        }
        System.exit(0);
    }//GEN-LAST:event_QuitActionPerformed
    private void MenuHistoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuHistoryActionPerformed
        FrmHistory history = new FrmHistory();  
        history.setVisible(true);
    }//GEN-LAST:event_MenuHistoryActionPerformed
    private void SignOutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SignOutMouseClicked
        final javax.swing.ImageIcon huhu = new javax.swing.ImageIcon(getClass().getResource("huhuhuh.png"));
        int confirm  = javax.swing.JOptionPane.showConfirmDialog(null, "Are you sure you want to sign out?", "Signing Out", javax.swing.JOptionPane.YES_NO_OPTION,javax.swing.JOptionPane.PLAIN_MESSAGE,huhu);
        if(confirm==0){
        if(SQLite.openDB()){
            java.util.Date currentDate = java.util.GregorianCalendar.getInstance().getTime();
            java.text.DateFormat df = java.text.DateFormat.getDateInstance();
            String dateString = df.format(currentDate);
            java.util.Date d = new java.util.Date();
            java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("HH:mm:ss a");
            String timeString = sdf.format(d);
            
            String name = com.recordmanagement.classes.User.name;
            String time = timeString;
            String date = dateString;

            SQLite.createHistory("name, date, status","'"+name+"','"+date+" / "+time+"','Signed out'");
            SQLite.closeDB();
        } 
            appointment.dispose();
            account.dispose();
            newpass.dispose();
            about.dispose();
            verify.dispose();
//            history.dispose();
            dispose();
            LoginPage login = new LoginPage();
            login.setVisible(true);}
    }//GEN-LAST:event_SignOutMouseClicked
    private void MenuAppointmentMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MenuAppointmentMouseClicked
        appointment.setVisible(true);
    }//GEN-LAST:event_MenuAppointmentMouseClicked
    private void VerifyTreatmentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VerifyTreatmentActionPerformed

    }//GEN-LAST:event_VerifyTreatmentActionPerformed
    private void MenuChangePassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuChangePassActionPerformed
        newpass.setVisible(true);
    }//GEN-LAST:event_MenuChangePassActionPerformed
    private void PrintActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PrintActionPerformed
        javax.swing.JFileChooser dialog = new javax.swing.JFileChooser();
        dialog.setSelectedFile(new java.io.File("Diaz Dental Clinic"+".pdf"));
        int dialogResult = dialog.showSaveDialog(null);
        if (dialogResult==javax.swing.JFileChooser.APPROVE_OPTION){
            String filePath = dialog.getSelectedFile().getPath();
            try {
                //ResultSet rs=null;
                //PreparedStatement pst=null;
                //            String sql ="select * from Deductions where emp_id = '"+value1+"'";
                //            pst=conn.prepareStatement(sql);
                //            rs=pst.executeQuery();
                //            String val = rs.getString(5);
                //            String reason = rs.getString(6);
                //            rs.close();
                //            pst.close();
                //
                //            String sq ="select * from Allowance where emp_id = '"+value1+"'";
                //            pst=conn.prepareStatement(sq);
                //            rs=pst.executeQuery();
                //
                //
                //           int calcTotal = Integer.parseInt(txt_salary.getText());
                //           float x = Float.valueOf(rs.getString(9));
                //           int v = Integer.parseInt(val);
                //           float total = calcTotal+ x -v;

                com.itextpdf.text.Document myDocument = new com.itextpdf.text.Document();
                com.itextpdf.text.pdf.PdfWriter myWriter = com.itextpdf.text.pdf.PdfWriter.getInstance(myDocument, new java.io.FileOutputStream(filePath));
                myDocument.open();

                myDocument.add(new com.itextpdf.text.Paragraph("Diaz Dental Clinic",com.itextpdf.text.FontFactory.getFont(com.itextpdf.text.FontFactory.TIMES_BOLD,20,java.awt.Font.BOLD )));
                myDocument.add(new com.itextpdf.text.Paragraph(new java.util.Date().toString()));
                myDocument.add(new com.itextpdf.text.Paragraph("-------------------------------------------------------------------------------------------"));
                //           myDocument.add((new Paragraph("EMPLOYEE DETAILS",FontFactory.getFont(FontFactory.TIMES_ROMAN,15,Font.BOLD))));
                //           myDocument.add((new Paragraph("Name of Employee: " +value + " "+value0,FontFactory.getFont(FontFactory.TIMES_ROMAN,10,Font.PLAIN))));
                //           myDocument.add((new Paragraph("Designation: "+value2,FontFactory.getFont(FontFactory.TIMES_ROMAN,10,Font.PLAIN))));
                //           myDocument.add((new Paragraph("Department: "+value3,FontFactory.getFont(FontFactory.TIMES_ROMAN,10,Font.PLAIN))));
                //           myDocument.add(new Paragraph("-------------------------------------------------------------------------------------------"));
                //           myDocument.add(new Paragraph("SALARY",FontFactory.getFont(FontFactory.TIMES_ROMAN,15,Font.BOLD)));
                //           myDocument.add(new Paragraph("Basic Salary: $"+calcTotal,FontFactory.getFont(FontFactory.TIMES_ROMAN,10,Font.PLAIN)));
                //           myDocument.add(new Paragraph("Overtime: "+rs.getString(2)+" Hours",FontFactory.getFont(FontFactory.TIMES_ROMAN,10,Font.PLAIN)));
                //           myDocument.add(new Paragraph("Medical: $" +rs.getString(3),FontFactory.getFont(FontFactory.TIMES_ROMAN,10,Font.PLAIN)));
                //           myDocument.add(new Paragraph("Bonus: $"+rs.getString(4),FontFactory.getFont(FontFactory.TIMES_ROMAN,10,Font.PLAIN)));
                //           myDocument.add(new Paragraph("Other: $"+rs.getString(5),FontFactory.getFont(FontFactory.TIMES_ROMAN,10,Font.PLAIN)));
                //           myDocument.add(new Paragraph("-------------------------------------------------------------------------------------------"));
                //           myDocument.add(new Paragraph("DEDUCTION",FontFactory.getFont(FontFactory.TIMES_ROMAN,15,Font.BOLD)));
                //           myDocument.add(new Paragraph("Deduction Details: "+reason,FontFactory.getFont(FontFactory.TIMES_ROMAN,10,Font.PLAIN)));
                //           myDocument.add(new Paragraph("Total Deductions : $"+val ,FontFactory.getFont(FontFactory.TIMES_ROMAN,10,Font.PLAIN)));
                //           myDocument.add(new Paragraph("-------------------------------------------------------------------------------------------"));
                //           myDocument.add(new Paragraph("TOTAL PAYMENT",FontFactory.getFont(FontFactory.TIMES_ROMAN,15,Font.BOLD)));
                //           myDocument.add(new Paragraph("Total Earnings: "+rs.getString(9),FontFactory.getFont(FontFactory.TIMES_ROMAN,10,Font.PLAIN)));
                //           myDocument.add(new Paragraph("Net Pay : " +total,FontFactory.getFont(FontFactory.TIMES_ROMAN,10,Font.PLAIN)));
                //           myDocument.add(new Paragraph("-------------------------------------------------------------------------------------------"));
                //

                myDocument.newPage();
                myDocument.close();
                javax.swing.JOptionPane.showMessageDialog(null,"Successfull saved!");
                setIcon();
            }
            catch(Exception e){
                System.out.println("Print Error: " + e.getMessage());
            }}
    }//GEN-LAST:event_PrintActionPerformed
    private void MenuDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuDeleteActionPerformed
      java.sql.PreparedStatement ps = null;  
      java.sql.ResultSet rs = null;
      String division = javax.swing.JOptionPane.showInputDialog("Input User division");
      if(division.equals("Admin")){javax.swing.JOptionPane.showMessageDialog(null, "Can't delete Admin!");                   
        }else if(!division.equals("Secretary") || !division.equals("Doctor") ){javax.swing.JOptionPane.showMessageDialog(null, "No division found!");                   
        }else{
        String username = javax.swing.JOptionPane.showInputDialog("Input Username to delete");
        String query = "Select username FROM login WHERE username=? and division=?";
        try{
            int confirm = javax.swing.JOptionPane.showConfirmDialog(null, "Are you sure you want to delete "+username+"?", "Confirm Delete", javax.swing.JOptionPane.YES_NO_OPTION, 0);
            if(confirm==0){
            conn = java.sql.DriverManager.getConnection(url);
            ps  = conn.prepareStatement(query);
            ps.setString(1,username); 
            ps.setString(2,division);
            rs = ps.executeQuery();
            if(rs.next()){
            String usernamee = rs.getString("username");
            SQLite.delete("login", username);
            javax.swing.JOptionPane.showMessageDialog(null, usernamee+" deleted successfully!","Sucess!",1);
            }else{javax.swing.JOptionPane.showMessageDialog(null, "Username "+username+" does not exist!","Error!",2);}
            conn.close();
            }
        }
        catch(Exception e){
            System.out.println("Deleting User Error:" + e.getMessage());
            javax.swing.JOptionPane.showMessageDialog(null,"Select treatment from treatment records to delete.","Error!",2);
        
        }    
        finally{
            try{
                rs.close();
                ps.close();
              }
            catch(Exception e){
                System.out.println("Close Error: " + e.getMessage());
            }
        }}
    }//GEN-LAST:event_MenuDeleteActionPerformed
    private void MenuAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuAddActionPerformed
        account.setVisible(true);
    }//GEN-LAST:event_MenuAddActionPerformed
    private void MenuListActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuListActionPerformed
        FrmUsers user = new FrmUsers();
        user.setVisible(true);
    }//GEN-LAST:event_MenuListActionPerformed
    private void lblIMAGEMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblIMAGEMouseClicked
    }//GEN-LAST:event_lblIMAGEMouseClicked
    private void lblShowMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblShowMouseClicked
        lblIMAGE.setVisible(true);
        lblUser.setVisible(true);
        lblHappy.setVisible(true);
        lblExit.setVisible(true);
        lblShow.setVisible(false);
    }//GEN-LAST:event_lblShowMouseClicked
    private void lblExitMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblExitMouseClicked
        lblIMAGE.setVisible(false);
        lblUser.setVisible(false);
        lblHappy.setVisible(false);
        lblShow.setVisible(true);
        lblExit.setVisible(false);
    }//GEN-LAST:event_lblExitMouseClicked
    private void txtSearchKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchKeyTyped
        String search = txtSearch.getText();
        if(search.equals("")){
            MyAge.setText("");
            MyGender.setText("");
            MyStreet.setText("");
            MyCity.setText("");
            MyPhoneNo.setText(""); 
            MyReg.setText("");
            lblMyIMAGE.setIcon(null);
            emptyTable();
        }else{Search();findUsers();}
    }//GEN-LAST:event_txtSearchKeyTyped
    private void MyGenderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MyGenderActionPerformed
    }//GEN-LAST:event_MyGenderActionPerformed
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
            java.util.logging.Logger.getLogger(FrmMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmMain().setVisible(true);
            }
        });
    }
    FrmAppointments appointment = new FrmAppointments();
    FrmAccountt account = new FrmAccountt();
    FrmPassword newpass = new FrmPassword();
    FrmAbout about = new FrmAbout();
    FrmAddingCustomer verify = new FrmAddingCustomer(); 
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu About;
    private javax.swing.JPanel DatePanel;
    private javax.swing.JMenuBar DentalMenu;
    private javax.swing.JMenu File;
    private javax.swing.JPanel MainPanel;
    private javax.swing.JMenuItem MenuAdd;
    private javax.swing.JMenu MenuAdmin;
    private javax.swing.JMenu MenuAppointment;
    private javax.swing.JMenuItem MenuChangePass;
    private javax.swing.JMenuItem MenuDelete;
    private javax.swing.JMenuItem MenuHistory;
    private javax.swing.JMenuItem MenuList;
    private javax.swing.JMenu MenuTeam;
    private javax.swing.JTextField MyAge;
    private javax.swing.JTextField MyCity;
    private javax.swing.JTextField MyGender;
    private javax.swing.JTextField MyPhoneNo;
    private javax.swing.JTextField MyReg;
    private javax.swing.JTextField MyStreet;
    private javax.swing.JPanel PanelCollectionDetails;
    private javax.swing.JPanel PanelPatient;
    private javax.swing.JPanel PanelPatientDetails;
    private javax.swing.JPanel PanelPatientHistory;
    private javax.swing.JPanel PanelSearch;
    private javax.swing.JPanel PanelTreatment;
    private javax.swing.JMenuItem Print;
    private javax.swing.JMenuItem Quit;
    private javax.swing.JPopupMenu.Separator SeparatorFile;
    private javax.swing.JPopupMenu.Separator SeparatorPrint;
    private javax.swing.JPopupMenu.Separator SeparatorTeam;
    private javax.swing.JMenu SignOut;
    private javax.swing.JTabbedPane TabPanePatientCollection;
    private javax.swing.JMenuItem VerifyPatient;
    private javax.swing.JMenuItem VerifyTreatment;
    private javax.swing.JLabel dateLabel;
    private com.toedter.calendar.JDateChooser dcBy;
    private com.toedter.calendar.JDateChooser dcTo;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblAge;
    private javax.swing.JLabel lblAmount;
    private javax.swing.JLabel lblCity;
    private javax.swing.JLabel lblDate;
    private javax.swing.JLabel lblExit;
    private javax.swing.JLabel lblGender;
    private javax.swing.JLabel lblHappy;
    private javax.swing.JLabel lblIMAGE;
    private javax.swing.JLabel lblLogged;
    private javax.swing.JLabel lblMyIMAGE;
    private javax.swing.JLabel lblPhoneNo;
    private javax.swing.JLabel lblRegister;
    private javax.swing.JLabel lblSearch;
    private javax.swing.JLabel lblSelectDate;
    private javax.swing.JLabel lblShow;
    private javax.swing.JLabel lblStreet;
    private javax.swing.JLabel lblTime;
    private javax.swing.JLabel lblTo;
    private javax.swing.JLabel lblUser;
    private javax.swing.JLabel lblUsername;
    private javax.swing.JTable tblCollection;
    private javax.swing.JTable tblTreatment;
    private javax.swing.JLabel timeLabel;
    private javax.swing.JTextField txtAmount;
    private javax.swing.JTextField txtSearch;
    // End of variables declaration//GEN-END:variables
}