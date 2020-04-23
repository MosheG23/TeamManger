import java.util.Date;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;

public class Shift {
	Date startDate = null;
	Date endDate = null;
	
	public Shift() {}	
	//Create a shift with parameters
	public Shift(Date startDate,Date endDate) { this.startDate = startDate; this.endDate = endDate; }
	//set the ending date for the shift
	@SuppressWarnings("deprecation")
	public void SetEndDate(int day,int month,int year,int hours,int min) {
		Date t= new Date();
		Scanner input = new Scanner(System.in);
		t.setDate(day);
		t.setMonth(month - 1);
		t.setYear(year - 1900);
		t.setHours(hours);
		t.setMinutes(min);
		t.setSeconds(0);
		if(VerifyDate(day,month,year) == false || (t.after(this.startDate) == false)) {
			do {
					System.out.println("The date you have entered is incorrect!\n Please enter a new date in the format of day/month/year.\n if you want to cancel please enter -1 for the day");
					System.out.println("Please enter the day: ");
					day = input.nextInt();
					if(day != -1) {
						System.out.println("Please enter the month: ");
						month = input.nextInt();
						System.out.println("Please enter the year: ");
						year = input.nextInt();
						System.out.println("Please enter the hour you've started: ");
						hours = input.nextInt();
						System.out.println("Please enter the minute you've started: ");
						min = input.nextInt();
						t.setDate(day);
						t.setMonth(month - 1);
						t.setYear(year - 1900);
						t.setHours(hours);
						t.setMinutes(min);
						t.setSeconds(0);
				}
			} while(day != -1 && ((VerifyDate(day, month, year) == false) || (t.after(this.startDate)) == false));
		}
		if(day != -1) this.endDate = t;
	}
	//set the starting date of the shift
	@SuppressWarnings("deprecation")
	public void SetStartDate(int day,int month,int year,int hours,int min) {
		Date t= new Date();
		Scanner input = new Scanner(System.in);
		t.setDate(day);
		t.setMonth(month - 1);
		t.setYear(year - 1900);
		t.setHours(hours);
		t.setMinutes(min);
		t.setSeconds(0);
		if(VerifyDate(day,month,year) == false && this.startDate == null) {
			do {
					System.out.println("The date you have entered is incorrect!\n Please enter a new date in the format of day/month/year.\n if you want to cancel please enter -1 for the day");
					System.out.println("Please enter the day: ");
					day = input.nextInt();
					if(day != -1) {
						System.out.println("Please enter the month: ");
						month = input.nextInt();
						System.out.println("Please enter the year: ");
						year = input.nextInt();
						System.out.println("Please enter the hour you have started: ");
						hours = input.nextInt();
						System.out.println("Please enter the minute you've started: ");
						min = input.nextInt();
						t.setDate(day);
						t.setMonth(month - 1);
						t.setYear(year - 1900);
						t.setHours(hours);
						t.setMinutes(min);
						t.setSeconds(0);
				}
			} while(day != -1 && VerifyDate(day, month, year) == false);
		}
		if(day != -1) this.startDate = t;
	}
	//get the start of the shift
	public Date GetStartDate() {
		if(this.startDate != null) return this.startDate; return null;
	}
	//get the end of the shift
	public Date GetEndDate() { if(this.endDate != null) return this.endDate; return null; }
	//print the total shift time
	public void TotalShiftTime() {
		 long diffInMillies = Math.abs(startDate.getTime() - endDate.getTime());
		 float diffDays = (float) (diffInMillies / (24 * 60 * 60 * 1000));
		 float diffhours = (float) (diffInMillies / (60 * 60 * 1000));
		 float diffmin = (float) (diffInMillies / (60 * 1000));
		System.out.println("difference between days: " + diffDays);
		System.out.println("difference between hours: " + diffhours);
		System.out.println("difference between minutues: " + diffmin);	
	}
	//get the total shift time
	public float GetShiftTime() {
		long diffInMillies = Math.abs(startDate.getTime() - endDate.getTime());
		float diffhours = (float) (diffInMillies / (60 * 60 * 1000));
		float diffmin = (float) (diffInMillies / (60 * 1000));
		float result = diffhours + (diffmin - diffhours * 60)/60;
		return result;
	}
	//helping function
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
	
}