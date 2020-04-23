import java.util.*;

public class Task {
	private int taskNum;
	private Date startDate = new Date();
	private Date endDate = new Date();
	private Date ActualDate = null;
	private char status;//N - Not started, F - Finished, I - In Process 
	private char priority;//H-High, M-medium, L-Low
	private String Details;
	private String projectName;
	
	public Task(int num) { this.status = 'N'; this.taskNum = num; }
	//change a task status
	public void ChangeStatus(char stat) { this.status = stat; }
	//start the task
	public void StartTask() { this.ChangeStatus('I'); }
	//get the task status
	public char GetStatus() { return this.status; }
	//helping function
	@SuppressWarnings("deprecation")
	private void SetCorrectDate(int day,int month,int year) {
		this.endDate.setDate(day);
		this.endDate.setHours(23);
		this.endDate.setMinutes(59);
		this.endDate.setMonth(month);
		this.endDate.setSeconds(0);
		this.endDate.setYear(year);
	}	
	//set the ending date for the task
	@SuppressWarnings("deprecation")
	public void SetEndDate(int day,int month,int year) {
		Date t=new Date();
		Scanner input = new Scanner(System.in);
		t.setDate(day);
		t.setMonth(month - 1);
		t.setYear(year - 1900);
		if(VerifyDate(day,month,year) == false || (t.after(this.startDate) == false)) {
			do {
					//day
					if(month > 12 || month < 1) System.out.println("The month you've entered is incorrect!");
					if(t.after(this.startDate)) System.out.println("The date you've entered is before the start of the Task!");
					System.out.println("Please enter a new date in the format of day/month/year.\n if you want to cancel please enter -1 for the day");
					System.out.println("Please enter the day: ");
					day = input.nextInt();
					if(day != -1) {
						System.out.println("Please enter the month: ");
						month = input.nextInt();
						System.out.println("Please enter the year: ");
						year = input.nextInt();
						t.setDate(day);
						t.setMonth(month - 1);
						t.setYear(year - 1900);
				}
			} while(day != -1 && ((VerifyDate(day, month, year) == false) || (t.after(this.startDate)) == false));
		}
		if(day != -1) SetCorrectDate(day,month - 1,year - 1900);
}
	//get the starting date
	public Date GetStartingYear() { return this.startDate; }
	//get the end date
	public Date GetEndYear() { return this.endDate; }
	//Verify the date
	private boolean VerifyDate(int day,int month, int year) {
		switch(month){
		case 1:
		case 3:
		case 5:
		case 7:
		case 8:
		case 10:
		case 12:
			if(day <= 31){ return true; }
			break;
		case 4:
		case 6:
		case 9:
		case 11:
			if(day <= 30){
				return true;
			}
			break;
		case 2:
			if((year % 4 == 0 && year % 100 != 0 ) || year % 400 == 0){
				if(day <= 29 ) return true;
			}
			else{
				if(day <= 28) return true;
			}
		}
		return false;
	}
	//get the task number
	public int GetTaskNum() { return this.taskNum; }
	//set the details for the task
	public void SetDetails() {
		Scanner input = new Scanner(System.in);
		System.out.println("Please enter the details for the task: ");
		this.Details = input.nextLine();
	}
	//return the details
	public String GetDetails() { return this.Details; }
	//finish the Task
	public void EndTask() { this.ChangeStatus('F'); this.ActualDate = new Date(); }
	
}
