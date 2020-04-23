
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
//import java.util.Scanner;
//import java.util.Comparator;

public class Employee extends Person {
	private Integer employeeID;
	private Date startDate;
	private float salary; // Per hour
	public final int MAXNumOfTasks = 5;
	private int numOfTasks = 0;
	protected ArrayList<Task> tasks = null;
	protected ArrayList<Shift> shifts = null;
	
	public Employee() {}
	//Constructor with parameters
	public Employee(int eID,String pID, int age, String fName, String lName, String gender, float salary, String phoneNumber,String address, 
			Date startDate, int numOfTasks, Date dOfBirth) {
		super(pID, fName, age, lName, gender, phoneNumber, address, dOfBirth);
		this.employeeID = eID;
		this.startDate = startDate;
		this.salary = salary;
		this.numOfTasks = numOfTasks;
		if (age <= 18) {
			System.out.println("The Employee is under age! We can't Hire Him!!");
		}
		while (salary < 30) {
			System.out.println("The salary is less than minimum, please enter again\n");
//			Scanner input = new Scanner(System.in);
//			salary = input.nextFloat();
		}
		this.tasks = new ArrayList<Task>();
	}
	//Copy constructor
	public Employee(Employee e) {
		this.employeeID = e.GetEmployeeID();
		this.startDate = e.GetStartDate();
		this.salary = e.GetSalary();
		this.tasks = e.GetTasks();
		this.shifts = e.GetShifts();
	}
	//Get the employee ID
	public Integer GetEmployeeID() { return employeeID; }
	//Get the salary
	public float GetSalary() { return this.salary; }
	//Set the salary
	public void SetSalary(float newSalary) { this.salary = newSalary; }
	//Get Number of Tasks
	public int GetNumberOfTasks() { return this.numOfTasks; }
	//Add a new task to the employee
	public void AddTask(Task t) {
		if (numOfTasks < MAXNumOfTasks) { this.tasks.add(t); numOfTasks++; }
		else { System.out.println("You've Reached Your Tasks Maximum"); }
	}
	//Get the number of tasks the employee can do
	@SuppressWarnings("static-access")
	public int GetNumOfTaskToAdd() { return MAXNumOfTasks - this.numOfTasks; }
	//Get the employee type
	public int GetTypeEmployee() { return this.employeeID % 10; }
	//Get the date that the employee started to work
	public Date GetStartDate() { return startDate; }
	//Set the date that the employee started to work
	public void SetStartDate(Date date) { this.startDate = date; }
	//Get the tasks of the employee
	public ArrayList<Task> GetTasks() { return this.tasks; }
	//Get the shifts of the employee
	public ArrayList<Shift> GetShifts(){ return this.shifts; }
	public static Date ConvertStringToDate(String date) throws ParseException{
		SimpleDateFormat formatter=new SimpleDateFormat("dd-M-yyyy");  
		Date date1 =(Date) formatter.parse(date);
		return date1;
	}
	public static String ConvertDateToString(Date date) {
		SimpleDateFormat formatter=new SimpleDateFormat("dd-M-yyyy"); 
		String stringDate = formatter.format(date);
		return stringDate;
	}
	
}
