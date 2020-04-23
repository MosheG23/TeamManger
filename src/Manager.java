import java.sql.Date;
import java.util.ArrayList;

public class Manager extends Employee {
	private int numOfEmployee = 0;
	public static final int NUMOfMaxEmployees = 15;
	private ArrayList<Employee> team = null;
	
	public Manager() {}
	//Manager with no team for now
	public Manager(Employee e) { super(e); }
	//Manager with a team
	public Manager(Employee e, ArrayList<Employee> team) { super(e); this.SetNumOfEmployee(team.size()); this.team = team; }
	//Get the number of employees in the team
	public int GetNumOfEmployee() { return this.numOfEmployee; }
	//Set the number of employees in the team
	private void SetNumOfEmployee(int numOfEmployee) { this.numOfEmployee = numOfEmployee; }
	//Get the team of the manager(Manager excluded)
	public ArrayList<Employee> getTeam(){ return this.team; }
	//Get the employee by his employee ID
	public int GetTeamMemberIDByEID(int id) {
		for (int i = 0; i< this.numOfEmployee; i++) { 
			if(this.team.get(i).GetEmployeeID() == id) 
				return i; 
		}
		return -1;
	}
	//Adding Employee To The Team
	public void AddEmployeeToTeam(Employee employee) {
		if (NUMOfMaxEmployees < this.numOfEmployee) { this.team.add(employee); this.numOfEmployee++; }
		else { System.out.println("You Can't Add More Employees to the Team.\nYou've Reached Your Max!"); }
	}
	//Removing Employee To The Team
	public void RemoveFromTeam(Employee employee) {
		if (this.team.contains(employee)) { this.team.remove(employee); this.numOfEmployee--; }
		else { System.out.println("This Employee isn't on the Team!"); }
	}
	//Adding a Task to a Team Member by His ID
	public void AddTaskToTeamMember(int id, Task t) {
		int eIdTeam = this.GetTeamMemberIDByEID(id);
		if (eIdTeam >= 0) {
			if (this.team.get(eIdTeam).GetNumOfTaskToAdd() == 0) System.out.println("The employee have reached the max of tasks.");
			else this.team.get(eIdTeam).AddTask(t); 
		}
		else System.out.println("This Employee isn't on the Team!");
	}
	//Adding a Task to a Team Member by Sending the Employee Object
	public void AddTaskToTeamMember(Employee e, Task t) {
		if (team.contains(e) == true) {
			int eIdTeam = this.team.indexOf(e);
			if (this.team.get(eIdTeam).GetNumOfTaskToAdd() == 0) System.out.println("The employee have reached the max of tasks.");
			else this.team.get(eIdTeam).AddTask(t);
		}
		else System.out.println("This Employee isn't on the Team!");
	}
	//Getting total of Team Tasks
	@SuppressWarnings("null")
	public ArrayList<Task> GetTeamTasks(){
		ArrayList<Task> result = null;
		for (int i = 0; i<this.numOfEmployee;i++) { result.addAll(this.team.get(i).GetTasks());	}
		return result;
	}	
	//Adding a Shift to an Employee
	public void AddShiftToEmployee(Employee e, Date startDate, Date endDate) {
		if (team.contains(e) == true) { Shift shift = new Shift(startDate, endDate); e.shifts.add(shift); }
		else System.out.println("This Employee isn't on the Team!");
	}
	//Updating a Shift to an Employee
	public void UpdateShiftToEmployee(Employee e, Shift s, Date startDate, Date endDate) {
		if (team.contains(e) == true) {
			int i = team.indexOf(e);
			if (team.get(i).shifts.contains(s) == true) {
				this.team.get(i).shifts.remove(i);
				Shift shift = new Shift(startDate, endDate);
				e.shifts.add(shift);
			}
			else System.out.println("No Shift Found to Update!");
		}
		else System.out.println("This Employee isn't on the Team!"); 
	}
	//Removing a Shift to an Employee
	public void RemoveShiftToEmployee(Employee e, Shift s) {
		if (team.contains(e) == true) {
			int i = team.indexOf(e);
			if (team.get(i).shifts.contains(s) == true) { this.team.get(i).shifts.remove(i); }
			else System.out.println("No shift have been found to remove!");
		}
		else System.out.println("This employee isn't on your team!");
	}
	
}
