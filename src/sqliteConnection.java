
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JOptionPane;

/**
 *
 * @author sqlitetutorial.net
 */
public class sqliteConnection {
	/**
	 * Connect to a sample database
	 */
	public static Connection conn = null;
	
	public static Connection connect() {
		try {
			String url = "jdbc:sqlite:myDB";
			// create a connection to the database
			conn = DriverManager.getConnection(url);
			return conn;
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e);
			return null;
		} finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
    			JOptionPane.showMessageDialog(null, ex);
            }
        }
	}

	/**
	 * select all rows in the warehouses table
	 * @throws SQLException 
	 */
	public static int selectUsernameAndPasswordFromDB(Connection con, String type, String usr, String psw) throws SQLException {
		String sql = "SELECT COUNT(*) FROM " + type +"Data\r\n" + "  WHERE user ='" + usr + "' AND password ='" + psw + "'";
		
		if (con != null) {
			try (	
					Statement stmt = conn.createStatement();  
					ResultSet rs = stmt.executeQuery(sql)) {
					return rs.getInt("COUNT(*)");
			} catch (SQLException ex) {
				System.out.println(ex.getMessage());
			}
		}
		return 0;
	}
	
	public static String GetFName(Connection connection, String type, String user) {
		  String sql = "SELECT fName\r\n" + "FROM " + type +"Data WHERE user='"+user+"'";
//		conn = connection;
		if (conn != null) {
			try (	
					Statement stmt = conn.createStatement();  
					ResultSet rs = stmt.executeQuery(sql)) {
					return rs.getString("fName");
			} catch (SQLException ex) {
				return ex.getMessage().toString();
			}
		}
		return null;
	}
	
	public static String GetTypeIDByUser(Connection conn, String type, String user) {
		String sql = "SELECT *\r\n" + 
				"  FROM " + type +"Data\r\n" + 
				"  WHERE user = '" + user + "'";
		if (conn != null) {
			try (	
					Statement stmt = conn.createStatement();  
					ResultSet rs = stmt.executeQuery(sql)) {
					return rs.getString("employeeID");
			} catch (SQLException ex) {
				JOptionPane.showMessageDialog(null, ex);
				return null;
			}
		}
		return null;
	}
	
	public static Integer GetNumOfTasks(Connection connection, String user) {
		String sql = "SELECT numOfTasks\r\n" + "FROM EmployeeData WHERE user='"+user+"'";
//		conn = connection;
		if (conn != null) {
			try (	
					Statement stmt = conn.createStatement();  
					ResultSet rs = stmt.executeQuery(sql)) {
					return rs.getInt("numOfTasks");
			} catch (SQLException ex) {
				JOptionPane.showMessageDialog(null, ex);
				return null;
			}
		}
		return null;
	}
	
	public static void AddEmployee(Connection connection, Employee employee, String userName, String password) {
		String fName = employee.GetFirstName(), lName = employee.GetLastName(), gender = employee.GetGender(), pNumber = employee.GetPhoneNumber(),
				address = employee.GetAddress(), pID = employee.GetpersonalID(), eID = employee.GetEmployeeID().toString();
		String sDate = Employee.ConvertDateToString(employee.GetStartDate()), dOfBirth = Employee.ConvertDateToString(employee.GetDateOfBirth());
		int numOfT = employee.GetNumberOfTasks(), age = employee.GetAge();
		String sql = "INSERT INTO EmployeeData(fName,lName,gender, phoneNumber, address, dateOfBirth, age, personalID, startDate, numOfTasks, user, password, employeeID)\r\n" + 
				"  VALUES('" + fName + "','"+ lName + "','"+ gender +"','"+ pNumber +"', '"+ address +"', '"+ dOfBirth +"', "+ age +", '" + pID +
				"', '" + sDate +"', " +numOfT + ", '"+ userName +"', '"+ password +"', " +eID +")";
		if (conn != null) {
			try (	
					Statement stmt = conn.createStatement();  
					ResultSet rs = stmt.executeQuery(sql)) {
					String messege = userName + "was added!";
					JOptionPane.showMessageDialog(null, messege);
			} catch (SQLException ex) {
				JOptionPane.showMessageDialog(null, ex);
			}
		}
	}
	
	public static Employee CreateEmployeeByEID(Connection conn, String user) {
		Employee employee = new Employee();
		String sql = "SELECT *\r\n" + 
				"  FROM EmployeeData\r\n" + 
				"  WHERE user = '" + user + "'";
		if (conn != null) {
			try (	
					Statement stmt = conn.createStatement();  
					ResultSet rs = stmt.executeQuery(sql)) {
					int age = rs.getInt("age"), numOfTasks = rs.getInt("numOfTasks"), eID = rs.getInt("employeeID");
					float salary =rs.getFloat("salary");
					String fName = rs.getString("fName"), lName = rs.getString("lName"), gender = rs.getString("gender"), 
							pNumber = rs.getString("phoneNumber"), dateOB = rs.getString("dateOfBirth"), pID = rs.getString("personalID"), 
							sDate = rs.getString("startDate"), address = rs.getString("address");
					Date dateOfBirth = Employee.ConvertStringToDate(dateOB), startDate = Employee.ConvertStringToDate(sDate);
					employee = new Employee(eID, pID, age, fName, lName, gender, salary, pNumber, address, startDate, numOfTasks, dateOfBirth);
					return employee;
			} catch (SQLException | ParseException ex) {
				JOptionPane.showMessageDialog(null, ex);
			}
		}
		return null;
	}
	
	public static Manager CreateManagerByUser(Connection conn, String user) {
		Employee employee = new Employee();
		Manager manager = null;
		String sql = "SELECT *\r\n" + 
				"  FROM EmployeeData\r\n" + 
				"  WHERE user = '" + user + "'";
		if (conn != null) {
			try (	
					Statement stmt = conn.createStatement();  
					ResultSet rs = stmt.executeQuery(sql)) {
					int age = rs.getInt("age"), numOfTasks = rs.getInt("numOfTasks"), eID = rs.getInt("employeeID"), numOfE = rs.getInt("numOfEmployee");
					float salary =rs.getFloat("salary");
					String fName = rs.getString("fName"), lName = rs.getString("lName"), gender = rs.getString("gender"), 
							pNumber = rs.getString("phoneNumber"), dateOB = rs.getString("dateOfBirth"), pID = rs.getString("personalID"), 
							sDate = rs.getString("startDate"), address = rs.getString("address");
					Date dateOfBirth = Employee.ConvertStringToDate(dateOB), startDate = Employee.ConvertStringToDate(sDate);
					employee = new Employee(eID, pID, age, fName, lName, gender, salary, pNumber, address, startDate, numOfTasks, dateOfBirth);
					if (numOfE > 0) {
						String employeeList = rs.getNString("employeeListID");
						String[] employeeListByID = employeeList.split(",");
						ArrayList<Employee> team = new ArrayList<Employee>();
						for (int i=0;i<numOfE;i++) {
							team.add(sqliteConnection.CreateEmployeeByEID(conn, GetTypeIDByUser(conn, "Employee", employeeListByID[i])));
						}
						manager = new Manager(employee, team);
					}
					else {
						manager = new Manager(employee);
					}
					return manager;
			} catch (SQLException | ParseException ex) {
				JOptionPane.showMessageDialog(null, ex);
			}
		}
		return null;
	
//	public int GetEmployeeID(Connection conn, String user) {
//		
////		int eID = Integer.parseInt(rs.getString("employeeID"));
//		return 0;
//	}
	
	public static int GetEmployeeTableID(Connection connection,Employee employee) {
		String sql = "SELECT ID\r\n" + 
				"  FROM EmployeeData \r\n" + 
				"  WHERE employeeID = " + employee.GetEmployeeID();
		if (connection != null) {
			try (	
					Statement stmt = conn.createStatement();  
					ResultSet rs = stmt.executeQuery(sql)) {
					return rs.getInt("ID");
			} catch (SQLException ex) {
				JOptionPane.showMessageDialog(null, ex);
			}
		}
		return 0;
	}
	
	public static ArrayList<Employee> GetAllEmployeeButOne(Connection connection, Employee employee){
		ArrayList<Employee> names = new ArrayList<Employee>();
		int numOfEmployees;
		String sql = "SELECT COUNT(phoneNumber)\r\n" + 
				"  FROM EmployeeData \r\n" + 
				"  WHERE NOT employeeID = " + employee.GetEmployeeID();
		if (conn != null) {
			try (	
					Statement stmt = conn.createStatement();  
					ResultSet rs = stmt.executeQuery(sql)) {
					numOfEmployees = rs.getInt("COUNT(phoneNumber)");
					int currEmployeeID = sqliteConnection.GetEmployeeTableID(connection, employee);
					for (int i = 1; i <= numOfEmployees; i++) {
						if (i != currEmployeeID) {
							String sqlLoop = "SELECT user\r\n" + 
									"  FROM EmployeeData\r\n" + 
									"  WHERE ID ="+ i;
							ResultSet rs2 = stmt.executeQuery(sqlLoop);
							Employee currPhoneNumber = CreateEmployeeByEID(connection, rs2.getString("user"));
							names.add(currPhoneNumber);
						}
					}
					return names;
					
			} catch (SQLException ex) {
				JOptionPane.showMessageDialog(null, ex);
			}
		}
		return null;
	}
	
	public static String GetQuote(Connection connection) {
		String count = "SELECT COUNT (*)\r\n" + 
				"  FROM MotivationalQuotes";
		if(connection != null) {
			try (	
					Statement stmt = conn.createStatement();  
					ResultSet rs = stmt.executeQuery(count)) {
					int numOfQuotes = rs.getInt("COUNT (*)");
					int random = (int)(Math.random() * numOfQuotes + 1);
					String sql = "SELECT *\r\n" + 
							"  FROM MotivationalQuotes \r\n" + 
							"  WHERE primary_key = " + random;
					ResultSet rs2 = stmt.executeQuery(sql);
					return rs2.getString("Quote");
					
			} catch (SQLException ex) {
				JOptionPane.showMessageDialog(null, ex);
			}
		}
		return null;
	}
	
	public static void ChangePassword(Connection connection, String user, String newPassword) {
		String sql = "UPDATE EmployeeData\r\n" + 
				"  SET \"password\" = '" + newPassword + "'\r\n" + 
				"  WHERE user = '" + user+"'";
		if(connection != null) {
				Statement stmt;
				try {
					stmt = conn.createStatement();
					stmt.executeQuery(sql);
				} catch (SQLException e1) {
					
				}
				JOptionPane.showMessageDialog(null, "Password Successfully Changed");
		}
	}
	
//	public Task GetTaskByEmployeeUser(Connection connection, Employee employee) {
//		int eID = employee.GetEmployeeID();
//		String sqlNum = "SELECT COUNT (*)\r\n" + 
//				"  FROM Tasks\r\n" + 
//				"  WHERE employeeID = " + eID;
////		String sqlTask
//		if (connection != null) {
//			try (	
//					Statement stmt = conn.createStatement();  
//					ResultSet rs = stmt.executeQuery(sqlNum)) {
//					int taskNum = rs.getInt("taskNum"), numOfTasks = rs.getInt("numOfTasks"), eID = rs.getInt("employeeID");
//					float salary =rs.getFloat("salary");
//					String fName = rs.getString("fName"), lName = rs.getString("lName"), gender = rs.getString("gender"), 
//							pNumber = rs.getString("phoneNumber"), dateOB = rs.getString("dateOfBirth"), pID = rs.getString("personalID"), 
//							sDate = rs.getString("startDate"), address = rs.getString("address");
//					Date dateOfBirth = Employee.ConvertStringToDate(dateOB), startDate = Employee.ConvertStringToDate(sDate);
//					employee = new Employee(eID, pID, age, fName, lName, gender, salary, pNumber, address, startDate, numOfTasks, dateOfBirth);
//					
//					return employee;
//			} catch (SQLException | ParseException ex) {
//				JOptionPane.showMessageDialog(null, ex);
//			}
//		}
//		return new Task(employeeID);
//	}
}
