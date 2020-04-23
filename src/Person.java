import java.util.Date;

public abstract class Person {
	private String firstName;
	private String lastName;
	private String gender;
	private	String phoneNumber;
	private String address;
	private Date dateOfBirth;
	private int age;
	private String personalID;
	
	public Person() {}
	//Constructor with parameters
	public Person(String personalID, String fName,int age, String lName, String gender, String phoneNumber, String address, Date dOfBrith) {
		this.personalID = personalID;
		this.firstName = fName;
		this.lastName = lName;
		this.age = age;
		this.gender = gender;
		this.phoneNumber = phoneNumber;
		this.address = address;
		this.dateOfBirth = dOfBrith;
	}
	//Get the first name
	public String GetFirstName() { return firstName; }
	//Set the first name
	public void SetFirstName(String firstName) { this.firstName = firstName; }
	//Get the last name
	public String GetLastName() { return lastName; }
	//Set the last name
	public void SetLastName(String lastName) { this.lastName = lastName; }
	//Get the full name
	public String GetFullName() { return this.firstName + " " + this.lastName; }
	//Get the gender
	public String GetGender() { return gender; }
	//Set the gender
	public void SetGender(String gender) { this.gender = gender; }
	//Get the phone number
	public String GetPhoneNumber() { return phoneNumber; }
	//Set the phone number
	public void SetPhoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber; }
	//Get the address
	public String GetAddress() { return address; }
	//Set the address
	public void SetAddress(String address) { this.address = address; }
	//Get the age
	public int GetAge() { return age; }
	//Set the age
	public void SetAge(int age) { this.age = age; }
	//Get the ID
	public String GetpersonalID() { return personalID; }
	//Set the ID
	public void SetpersonalID(String id) { this.personalID = id; }
	//Get The birth day
	public Date GetDateOfBirth() { return dateOfBirth; }
	//Set the birthday
	public void SetDateOfBirth(Date dateOfBirth) { this.dateOfBirth = dateOfBirth; }
	
}
