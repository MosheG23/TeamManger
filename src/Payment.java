import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Payment extends Employee{
	private String department;
	private ArrayList<Employee> employees = null;
	//A payment employee
	public Payment(Employee employee, String deprtment) { super(employee);  this.SetDepartment(deprtment); }
	//Get department
	public String GetDepartment() { return department; }
	//Set department
	public void SetDepartment(String department) { this.department = department; }
	//Helping function
	private float GetPaid(ArrayList<Shift> s, float salary) {
		float paid = 0, sum = 0;
		for(int i = 0; i < s.size();i++) { sum += s.get(i).GetShiftTime(); }
		paid = sum * salary;
		return paid;
	}
	//Print monthly report
	public void GetMonthlyReport() {
		int size = employees.size();
		float sum = 0;
		for(int i = 0 ;i < size;i++) {
			System.out.println(this.employees.get(i).GetFirstName() + " : " + GetPaid(employees.get(i).GetShifts(),this.employees.get(i).GetSalary()));
			sum += GetPaid(this.employees.get(i).GetShifts(),this.employees.get(i).GetSalary());
		}
		System.out.println("The total expenses for the " + size + " people are: " + sum);
	}
	//three 'ChangeSalary' Functions with different parameters
	public void ChangeSalary(String name) {
		Scanner input = new Scanner(System.in);
		boolean flg = false;
		for(int i = 0; i < employees.size(); i++) {
			if(employees.get(i).GetFullName() == name) {
				flg = true;
				System.out.println("Please enter the new salary of the ");
				this.employees.get(i).SetSalary(input.nextFloat());
			}
		}
		if(flg == false) { System.out.println("You can't change the worker's salary because he isn't in your authority!"); }
	}
	
	public void ChangeSalary(String fName,String lName) {
		Scanner input = new Scanner(System.in);
		boolean flg = false;
		for(int i = 0; i < employees.size(); i++) {
			if(employees.get(i).GetFirstName() == fName && employees.get(i).GetLastName() == lName) {
				flg = true;
				System.out.println("Please enter the new salary of the ");
				this.employees.get(i).SetSalary(input.nextInt());
			}
		}
		if(flg == false) { System.out.println("You can't change the worker's salary because he isn't in your authority!"); }
	}

	public void ChangeSalary(Employee e) {
		Scanner input = new Scanner(System.in);
		boolean flg = false;
		for(int i = 0; i < employees.size(); i++) {
			if(employees.get(i).GetEmployeeID() == e.GetEmployeeID()) { 
				flg = true; 
				System.out.println("Please enter the new salary of the "); 
				this.employees.get(i).SetSalary(input.nextInt());
			}
		}
		if(flg == false) { System.out.println("You can't change the worker's salary because he isn't in your authority!"); }
	}
	//Print project report
	public void GetProjectReport(Project p) {
		ArrayList <Employee> team = p.GetEmployeesWorkingOnProject();
		System.out.println("The Project is named " + p.GetProjectName() + " ");
		System.out.println("The project manager is " + p.GetProjectManager());
		System.out.println("The people who work in the project are:");
		for (int i = 0; i < team.size(); i++) { System.out.println(team.get(i).GetFullName()); }
		System.out.println("The project has a budget of " + p.GetBudget());
		System.out.println(p.GetCurrentBudgetAmount() + " is left of the budget.");
		System.out.println("There are currently " + p.GetNumberOfTasks() + " task(s) in the project.");
		System.out.println();
	}

}
