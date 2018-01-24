package com.recordmanagement.app;
public class SQLite {  
    //Static Variables
    static java.sql.Connection conn  = null;
    static java.sql.Statement stmt = null;
    static java.io.File temp = new java.io.File("DiazDentalClinicSystem.sqlite");
//    static String url = "jdbc:sqlite:"+temp.getAbsolutePath().replace("\\","\\\\");
    static String url = "jdbc:sqlite:C:\\Users\\pc\\Desktop\\Files\\RecordManagement\\src\\com\\recordmanagement\\app\\RecordManagement.sqlite";
    //Open DB Session Method
    public static boolean openDB(){
        boolean result = false;
        try{
            Class.forName("org.sqlite.JDBC");
            conn = java.sql.DriverManager.getConnection(url);

            System.out.println("Diaz Dental Clinic database is connected.");
            result = true;
        }
        catch(Exception e){
            System.out.println("Open DB Error:" + e.getMessage());
        } 
        return result;
    }
    //Close DB Session Method
    public static boolean closeDB(){
        boolean result = false;
        try{
            conn.close();

            System.out.println("Diaz Dental Clinic database is closed.");
            result = true;
        }
        catch(Exception e){
            System.out.println("Close DB Error: " + e.getMessage());
        }
        return result;
    }    
    //Create Record Method
    public static boolean create(String table, String values){
        boolean result = false;
        try{
            SQLite.stmt = conn.createStatement();
            String query = "INSERT INTO "+ table +" VALUES(" + values + ")";
            stmt.executeUpdate(query);
            //You can include exception handling here. (e.g. Duplicate Data, etc.)
            result = true;
        }
        catch(Exception e){
            System.out.println("Create Error: " + e.getMessage());
        }
        return result;
    } 
    public static boolean createColumn(String table,String column, String values){
        boolean result = false;
        try{
            SQLite.stmt = conn.createStatement();
            String query = "INSERT INTO "+ table +"("+column+") VALUES(" + values + ")";
            stmt.executeUpdate(query);
            //You can include exception handling here. (e.g. Duplicate Data, etc.)
            result = true;
        }
        catch(Exception e){
            System.out.println("Create Error: " + e.getMessage());
        }
        return result;
    }   
    public static boolean createHistory(String columns, String values){
        boolean result = false;
        try{
            SQLite.stmt = conn.createStatement();
            String query = "INSERT INTO history("+columns+") VALUES(" + values + ")";
            stmt.executeUpdate(query);
            //You can include exception handling here. (e.g. Duplicate Data, etc.)
            result = true;
        }
        catch(Exception e){
            System.out.println("Create Error: " + e.getMessage());
        }
        return result;
    } 
    //Read Record Method
    public static String[][] readColumn(String table,String column, String primary){
        String[][] records = null;
        try{
            SQLite.stmt = conn.createStatement();

            //Count total rows
            java.sql.ResultSet rs = stmt.executeQuery("SELECT count(*) FROM " + table);
            int totalRows = rs.getInt(1);

            //Count total columns
            rs = stmt.executeQuery("select "+column+" from " + table +" where id Order by '"+primary+"'");
            java.sql.ResultSetMetaData rsmd = rs.getMetaData();
            int totalColumns = rsmd.getColumnCount();

            //Initialize 2D Array "records" with totalRows by totalColumns
            records = new String[totalRows][totalColumns];

            //Retrieve the record and store it to 2D Array "records"
            int row=0;
            while(rs.next()){                
                for(int col=0,index=1;col<totalColumns;col++,index++){
                    records[row][col] = rs.getObject(index).toString();
                }
                row++;
            }            
        }
        catch(Exception e){
            System.out.println("Read Error: " + e.getMessage());
        }
        return records;
    }
    public static String[][] readJoin(int search){
        String[][] records = null;
        try{
            SQLite.stmt = conn.createStatement();
            //Count total rows
            java.sql.ResultSet rs = stmt.executeQuery("SELECT count(*) \n" +
            "from procedure as pro\n" +
            "inner join patient as p on\n" +
            "pro.patientID = p.ID\n"+
            "inner join service as t on \n" +
            "pro.serviceID = t.ID;");
//          java.sql.ResultSet rs = stmt.executeQuery("select count(*) from procedure");
            int totalRows = rs.getInt(1);
//          rs = stmt.executeQuery("select * from procedure");
//          Count total columns
            rs = stmt.executeQuery("SELECT printf('%s %s',p.fname,p.lname) as PatientName,t.name as TreatmentName,pro.date,pro.cost \n" +
            "from procedure as pro\n" +
            "inner join patient as p on\n" +
            "pro.patientID = p.ID\n"+
            "inner join service as t on \n" +
            "pro.serviceID = t.ID where p.id="+search+";");
            java.sql.ResultSetMetaData rsmd = rs.getMetaData();
            int totalColumns = rsmd.getColumnCount();

            //Initialize 2D Array "records" with totalRows by totalColumns
            records = new String[totalRows][totalColumns];

            //Retrieve the record and store it to 2D Array "records"
            int row=0;
            while(rs.next()){                
                for(int col=0,index=1;col<totalColumns;col++,index++){
                    records[row][col] = rs.getObject(index).toString();
                }
                row++;
            }            
        }
        catch(Exception e){
            System.out.println("Read Error: " + e.getMessage());
        }
        return records;
    }
    public static String[][] read(String table){
        String[][] records = null;
        try{
            SQLite.stmt = conn.createStatement();

            //Count total rows
            java.sql.ResultSet rs = stmt.executeQuery("SELECT count(*) FROM " + table);
            int totalRows = rs.getInt(1);

            //Count total columns
            rs = stmt.executeQuery("SELECT * FROM " + table);
            java.sql.ResultSetMetaData rsmd = rs.getMetaData();
            int totalColumns = rsmd.getColumnCount();

            //Initialize 2D Array "records" with totalRows by totalColumns
            records = new String[totalRows][totalColumns];

            //Retrieve the record and store it to 2D Array "records"
            int row=0;
            while(rs.next()){                
                for(int col=0,index=1;col<totalColumns;col++,index++){
                    records[row][col] = rs.getObject(index).toString();
                }
                row++;
            }            
        }
        catch(Exception e){
            System.out.println("Read Error: " + e.getMessage());
        }
        return records;
    }
    public static String[][] readOnly(String table){
        String[][] records = null;
        try{
            SQLite.stmt = conn.createStatement();

            //Count total rows
            java.sql.ResultSet rs = stmt.executeQuery("SELECT count(*) FROM " + table+ " where patientID IN (SELECT id FROM patient WHERE status='Active')");
            int totalRows = rs.getInt(1);

            //Count total columns
            rs = stmt.executeQuery("SELECT * FROM " + table+ " where patientID IN (SELECT id FROM patient WHERE status='Active')");
            java.sql.ResultSetMetaData rsmd = rs.getMetaData();
            int totalColumns = rsmd.getColumnCount();

            //Initialize 2D Array "records" with totalRows by totalColumns
            records = new String[totalRows][totalColumns];

            //Retrieve the record and store it to 2D Array "records"
            int row=0;
            while(rs.next()){                
                for(int col=0,index=1;col<totalColumns;col++,index++){
                    records[row][col] = rs.getObject(index).toString();
                }
                row++;
            }            
        }
        catch(Exception e){
            System.out.println("Read Only Error: " + e.getMessage());
        }
        return records;
    }           
    public static String[][] read(String table, String[] columns){
        String[][] records = null;
        try{
            SQLite.stmt = conn.createStatement();

            //Count total rows
            java.sql.ResultSet rs = stmt.executeQuery("SELECT count(*) FROM " + table);
            int totalRows = rs.getInt(1);

            //Count total columns
            int totalColumns = columns.length;
            String cols = "";
            for(int i=0;i<totalColumns;i++){
                cols += columns[i];
                if((i+1)!=totalColumns)cols+=", ";
            }
            rs = stmt.executeQuery("SELECT "+ cols +" FROM " + table);

            //Initialize 2D Array "records" with totalRows by totalColumns
            records = new String[totalRows][totalColumns];

            //Retrieve the record and store it to 2D Array "records"
            int row=0;
            while(rs.next()){                
                for(int col=0,index=1;col<totalColumns;col++,index++){
                    records[row][col] = rs.getObject(index).toString();
                }
                row++;
            }            
        }
        catch(Exception e){
            System.out.println("Read Error: " + e.getMessage());
        }
        return records;
    }  
    public static String[][] read(String table, String where){
        String[][] records = null;
        try{
            SQLite.stmt = conn.createStatement();

            //Count total rows
            java.sql.ResultSet rs = stmt.executeQuery("SELECT count(*) FROM " + table + " WHERE " + where);
            int totalRows = rs.getInt(1);

            //Count total columns
            rs = stmt.executeQuery("SELECT * FROM " + table + " WHERE " + where);
            java.sql.ResultSetMetaData rsmd = rs.getMetaData();
            int totalColumns = rsmd.getColumnCount();

            //Initialize 2D Array "records" with totalRows by totalColumns
            records = new String[totalRows][totalColumns];

            //Retrieve the record and store it to 2D Array "records"
            int row=0;
            while(rs.next()){                
                for(int col=0,index=1;col<totalColumns;col++,index++){
                    records[row][col] = rs.getObject(index).toString();
                }
                row++;
            }            
        }
        catch(Exception e){
            System.out.println("Read Error: " + e.getMessage());
        }
        return records;
    }       
    public static byte[] read(String table, String column, int id){
        byte[] buffer = null;
        try{
            String query = "SELECT " + column +" FROM " + table + " WHERE id=?"; 
            java.sql.ResultSet rs = null;
            java.sql.PreparedStatement pstmt = null;            
             
            pstmt = conn.prepareStatement(query);
            pstmt.setInt(1, id);
            
            rs = pstmt.executeQuery();

            while (rs.next()) {
                buffer = rs.getBytes("image");
            }
        }
        catch(Exception e){
            System.out.println("Read Error: " + e.getMessage());
        }
        return buffer;
    }
    public static byte[] readString(String table, String column, String username){
        byte[] buffer = null;
        try{
            String query = "SELECT " + column +" FROM " + table + " WHERE username=?"; 
            java.sql.ResultSet rs = null;
            java.sql.PreparedStatement pstmt = null;            
             
            pstmt = conn.prepareStatement(query);
            pstmt.setString(1, username);
            
            rs = pstmt.executeQuery();

            while (rs.next()) {
                buffer = rs.getBytes("image");
            }
        }
        catch(Exception e){
            System.out.println("Read Error: " + e.getMessage());
        }
        return buffer;
    }  
    //Update Record Method
    public static boolean update(String table, String set, int id){
        boolean result = false;
        try{
            SQLite.stmt = conn.createStatement();
            String query = "UPDATE "+ table +" SET " + set + " WHERE id=" + id;
            stmt.executeUpdate(query);
            //You can include exception handling here. (e.g. Duplicate Data, etc.)
            result = true;
        }
        catch(Exception e){
            System.out.println("Update Error: " + e.getMessage());
        }
        return result;
    }    
    public static boolean updateNoID(String set, String foreign){
        boolean result = false;
        try{
            SQLite.stmt = conn.createStatement();
            String query = "UPDATE login SET " + set + " WHERE username='" + foreign +"'";
            stmt.executeUpdate(query);
            //You can include exception handling here. (e.g. Duplicate Data, etc.)
            result = true;
        }
        catch(Exception e){
            System.out.println("Update Error: " + e.getMessage());
        }
        return result;
    }   
    public static boolean updateTeeth(String table, String set, int foreign){
        boolean result = false;
        try{
            SQLite.stmt = conn.createStatement();
            String query = "UPDATE "+table+" SET " + set + " WHERE id=" + foreign;
            stmt.executeUpdate(query);
            //You can include exception handling here. (e.g. Duplicate Data, etc.)
            result = true;
        }
        catch(Exception e){
            System.out.println("Update Teeth Error: " + e.getMessage());
        }
        return result;
    }   
    public static boolean updateTeeth(String table, String set, String foreign){
        boolean result = false;
        try{
            SQLite.stmt = conn.createStatement();
            String query = "UPDATE "+table+" SET " + set + " WHERE patientid=" + foreign;
            stmt.executeUpdate(query);
            //You can include exception handling here. (e.g. Duplicate Data, etc.)
            result = true;
        }
        catch(Exception e){
            System.out.println("Update Teeth Error: " + e.getMessage());
        }
        return result;
    }
    public static boolean updateImage(String table, byte[] image, String column, int id){
//      byte[] buffer = null;
        boolean result = false;
        try{
            String query = "UPDATE " + table +" SET "+ column +"=? WHERE id=" + id; 
            java.sql.ResultSet rs = null;
            java.sql.PreparedStatement pstmt = null;            
            
            pstmt = conn.prepareStatement(query);
            pstmt.setBytes(1, image);
            
            pstmt.executeUpdate();
            System.out.println("Image saved to database successfully!");
            result = true;
//            while (rs.next()) {
//                buffer = rs.getBytes("image");
//            }
        }
        catch(Exception e){
            System.out.println("Update Error: " + e.getMessage());
        }
        return result;
    }    
    public static boolean updateImage(String table, byte[] image, String column, String primary){
//      byte[] buffer = null;
        boolean result = false;
        try{
            String query = "UPDATE " + table +" SET "+ column +"=? WHERE fname='" +primary; 
            java.sql.ResultSet rs = null;
            java.sql.PreparedStatement pstmt = null;            
            
            pstmt = conn.prepareStatement(query);
            pstmt.setBytes(1, image);
            
            pstmt.executeUpdate();
            result = true;
//            while (rs.next()) {
//                buffer = rs.getBytes("image");
//            }
        }
        catch(Exception e){
            System.out.println("Update Error: " + e.getMessage());
        }
        return result;
    }   
    public static boolean update(String table, byte[] image, String column, String primary){
//      byte[] buffer = null;
        boolean result = false;
        try{
            String query = "UPDATE " + table +" SET "+ column +"=? WHERE username='" +primary+"'"; 
            java.sql.ResultSet rs = null;
            java.sql.PreparedStatement pstmt = null;            
            
            pstmt = conn.prepareStatement(query);
            pstmt.setBytes(1, image);
            
            pstmt.executeUpdate();
            result = true;
//            while (rs.next()) {
//                buffer = rs.getBytes("image");
//            }
        }
        catch(Exception e){
            System.out.println("Update Error: " + e.getMessage());
        }
        return result;
    }   
    //Delete Record Method
    public static boolean delete(String table, int id){
        boolean result = false;
        try{
            SQLite.stmt = conn.createStatement();
            String query = "DELETE FROM "+ table + " WHERE id=" + id;
            stmt.executeUpdate(query);
            result = true;
        }
        catch(Exception e){
            System.out.println("Delete Error: " + e.getMessage());
        }
        return result;
    }    
    public static boolean delete(String table, String id){
        boolean result = false;
        try{
            SQLite.stmt = conn.createStatement();
            String query = "DELETE FROM "+ table + " WHERE username='" +id+ "'";
            stmt.executeUpdate(query);
            result = true;
        }
        catch(Exception e){
            System.out.println("Delete Error: " + e.getMessage());
        }
        return result;
    }    
    public static boolean deleteAll(String table){
        boolean result = false;
        try{
            SQLite.stmt = conn.createStatement();
            String query = "DELETE FROM "+ table;
            stmt.executeUpdate(query);
            result = true;
        }
        catch(Exception e){
            System.out.println("Delete Error: " + e.getMessage());
        }
        return result;
    }
}