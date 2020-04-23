


import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

import org.sqlite.JDBC;


public class SQLite {
	@SuppressWarnings("unused")
	private static Connection con;
	private static String url =  "jdbc:sqlite:src\\softwarepulse\\app\\main.db";

	@SuppressWarnings("unused")
	public Connection getConnection() throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		try {
			DriverManager.registerDriver(new org.sqlite.JDBC());
			Class.forName("org.sqlite.JDCB");
			con = DriverManager.getConnection("jdbc:sqlite:EmployeeData.db");
			JOptionPane.showMessageDialog(null, "Connection established......");
			return con;
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e);
			return null;
		}
//		DriverManager.registerDriver(new org.sqlite.JDBC());
//		Class.forName("org.sqlite.JDBC");
//		con = DriverManager.getConnection("jdbc:sqlite:EmployeeData.db");
//		JOptionPane.showMessageDialog(null, "Connection established......");
//		return con;
////		initialise();
	}
	
	public static void createNewDatabase() {
		 
        try (Connection conn = DriverManager.getConnection(url)) {
            if (conn != null) {
                DatabaseMetaData meta = conn.getMetaData();
                System.out.println("The driver name is " + meta.getDriverName());
                System.out.println("A new database has been created.");
            }
 
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
//	private String firstName;
//	private String lastName;
//	private String gender;
//	private	String phoneNumber;
//	private String address;
//	private Date dateOfBirth;
//	private int age;
//	private String personalID;
//	private int employeeID;
//	private Date startDate;
//	private float salary; // Per hour
//	public static final int MAXNumOfTasks = 5;
//	private int numOfTasks = 0;

	public static void createNewTable() {
        
        // SQL statement for creating a new table
        String sql = "CREATE TABLE IF NOT EXISTS Employee (\n"
                + "	id integer,\n"
                + "	user text NOT NULL,\n" + "password text,\n" + " fName text,\n"
                + " lName text,\n" + " gender text,\n" + " phoneNumber text,\n"
                + " address text,\n" + " dateOfBirth text,\n" + " age text,\n"
                + " startDate text,\n" + " salary text,\n"
                + " numOfTasks text"
                + ");";
        
        try (Connection conn = DriverManager.getConnection(url);
                Statement stmt = conn.createStatement()) {
            // create a new table
            stmt.execute(sql);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
	
	private Connection connect() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }
//	
//	public void newEmployee(Employee e) {
//        String sql = "INSERT INTO Employee(id,user,password,fName,lName,gender,phoneNumber,address,dateOfBirth,age,startDate,salary,numOfTasks) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?)";
//        
//        try (Connection conn = this.connect();
//                PreparedStatement pstmt = conn.prepareStatement(sql)) {
//        	pstmt.setInt(1, e.GetEmployeeID());
//            pstmt.setString(2, e.GetFullName());
//            pstmt.setString(3, "123456");
//            pstmt.setString(4, e.GetFirstName());
//            pstmt.setString(5, e.GetLastName());
//            pstmt.setString(6, e.GetGender());
//            pstmt.setString(7, e.getPhoneNumber());
//            pstmt.setString(8, e.getAddress());
//            pstmt.setString(9, e.getDateOfBirth().toString());
//            pstmt.setString(10, e.getAge() + "");
//            pstmt.setString(11, e.getStartDate().toString());
//            pstmt.setString(12, e.GetSalary() + "");
//            pstmt.setString(13, e.GetNumOfTaskToAdd() + "");
//            pstmt.executeUpdate();
//        } catch (SQLException ex) {
//            System.out.println(ex.getMessage());
//        }
//    }
	
	public void selectAll(){
        String sql = "SELECT id,user,password,fName,lName,gender,phoneNumber,address,dateOfBirth,age,startDate,salary,numOfTasks FROM Employee";
        
        try (Connection conn = this.connect();
             Statement stmt  = conn.createStatement();
             ResultSet rs    = stmt.executeQuery(sql)){
            
            // loop through the result set
            while (rs.next()) {
                System.out.println(rs.getInt("id") +  "\t" + 
                                   rs.getString("user") + "\t" + rs.getString("password") + "\t" +
                                   rs.getString("fName") + "\t" + rs.getString("lName") + "\t" +
                                   rs.getString("gender") + "\t" + rs.getString("phoneNumber") + "\t" +
                                   rs.getString("address") + "\t" + rs.getString("dateOfBirth") + "\t" +
                                   rs.getString("age") + "\t" +
                                   rs.getString("startDate") + "\t" + rs.getString("salary") + "\t" +
                                   rs.getString("numOfTasks"));
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
	
	public void update(int id, String user, String password) {
        String sql = "UPDATE login SET user = ? , "
                + "password = ? "
                + "WHERE id = ?";
 
        try (Connection conn = this.connect();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, user);
            pstmt.setString(2, password);
            pstmt.setInt(3, id);
            // update 
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
	public void delete(int id) {
        String sql = "DELETE FROM login WHERE id = ?";
 
        try (Connection conn = this.connect();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
 
            // set the corresponding param
            pstmt.setInt(1, id);
            // execute the delete statement
            pstmt.executeUpdate();
 
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
