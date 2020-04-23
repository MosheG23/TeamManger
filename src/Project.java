import java.util.ArrayList;

public class Project {
	private String projectName;
	private Manager projectManager;
	private ArrayList <Employee> WorkingTeam;
	private float budget,currentAmountOfMoney;
	private int numberOfTasks;
	private int numberOfShifts;
	
	public Project() {}
	//Constructor project with parameters
	public Project(String name,Manager manager,float budget,int numOfTasks,int numOfShifts) {
		this.projectName = name;
		this.projectManager = manager;
		this.budget = budget;
		this.currentAmountOfMoney = budget;
		this.numberOfTasks = numOfTasks;
		this.numberOfShifts = numOfShifts;
	}
	//Get the number of tasks in the project
	public int GetNumberOfTasks() { return this.numberOfTasks; }
	//Set the number of tasks in the project
	public void SetNumberOfTasks(int numberOftask) { this.numberOfTasks = numberOftask; }
	//Get the number of shifts that the project was the topic/mission
	public int GetNumberOfShifts() { return this.numberOfShifts; }
	//Set the number of shifts that the project was the topic/mission
	public void SetNumberOfShifts(int numberOfShifts) { this.numberOfShifts = numberOfShifts; }
	//Get the project name
	public String GetProjectName() { return projectName; }
	//Set the project name
	public void SetProjectName(String projectName) { this.projectName = projectName; }
	//Get the manager of the project
	public Manager GetProjectManager() { return projectManager; }
	//Set the manager of the project
	public void SetProjectManager(Manager projectManager) { this.projectManager = projectManager; }
	//Get the budget
	public float GetBudget() { return budget; }
	//Set the budget
	public void SetBudget(int budget) { this.budget = budget; }
	//Get the team that is working on the project
	public ArrayList<Employee> GetEmployeesWorkingOnProject(){ return this.WorkingTeam; }
	//Add a worker to the team of the project
	public void AddAnEmployee(Employee employee) { WorkingTeam.add(employee); }
	//Remove a worker from the team of the project
	public void RemoveAnEmployee(Employee employee) { WorkingTeam.remove(employee); }
	//Get the current amount of money that is left in project budget
	public float GetCurrentBudgetAmount() { return this.currentAmountOfMoney; }
	//Set the current amount of money
	public void SetCurrentMoney() { this.currentAmountOfMoney = this.budget; }
	//Set the current amount of money with expenses
	public void SetCurrentMoney(float expense) { this.currentAmountOfMoney = this.currentAmountOfMoney - expense; }
	
}
