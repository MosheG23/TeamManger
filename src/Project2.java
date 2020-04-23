import java.util.ArrayList;

public class Project {
	private String projectName;
	private Manager projectManager;
	private int budget;
	private int NumberOftask;
	private int NumberOfShifts;

	public int getNumberOftask() {
		return NumberOftask;
	}

	public void setNumberOftask(int numberOftask) {
		NumberOftask = numberOftask;
	}

	public int getNumberOfShifts() {
		return NumberOfShifts;
	}

	public void setNumberOfShifts(int numberOfShifts) {
		NumberOfShifts = numberOfShifts;
	}

	{
		
	}
	
	
	public Project() {
		
	}

	/**
	 * @return the projectName
	 */
	public String getProjectName() {
		return projectName;
	}

	/**
	 * @param projectName the projectName to set
	 */
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	/**
	 * @return the projectManager
	 */
	public Manager getProjectManager() {
		return projectManager;
	}

	/**
	 * @param projectManager the projectManager to set
	 */
	public void setProjectManager(Manager projectManager) {
		this.projectManager = projectManager;
	}

	/**
	 * @return the budget
	 */
	public int getBudget() {
		return budget;
	}

	/**
	 * @param budget the budget to set
	 */
	public void setBudget(int budget) {
		this.budget = budget;
	}
	
	public ArrayList<Employee> GetEmployeesWorkingOnProject(){
		return this.projectManager.getTeam();
	}
}
