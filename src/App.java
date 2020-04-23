import java.util.Date;

public class App {

	@SuppressWarnings({ "static-access", "deprecation" })
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Employee moshe = new Employee();
		moshe.SetAddress("Ashdod");
		moshe.SetAge(27);
		moshe.SetDateOfBirth("9/1/1992");
		moshe.SetFirstName("Moshe");
		moshe.SetLastName("Gotam");
		moshe.SetpersonalID("1234");
		moshe.SetPhoneNumber("050-2191798");
		moshe.SetStartDate("9/1/2019");
		
		SQLite test = new SQLite();
		test.createNewDatabase();
		test.createNewTable();
	        // insert three new rows
		test.newEmployee(moshe);
		test.selectAll();
	}

}
