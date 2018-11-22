package Model;

public class Person {
	// data member
	private String Name;
	private String Email;
	private String Password;
	private String Address;
	private String Gender;
	private String DateofBirth;
	private String MobileNo;
	private long CountryID;
	
	//data hiding / Encapsulation
	// get and setter properties
	public void setName(String name){
		Name =name;
	}
	public String getName(){
		return Name ;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}
	public String getAddress() {
		return Address;
	}
	public void setAddress(String address) {
		Address = address;
	}
	public String getGender() {
		return Gender;
	}
	public void setGender(String gender) {
		Gender = gender;
	}
	public String getDateofBirth() {
		return DateofBirth;
	}
	public void setDateofBirth(String dateofBirth) {
		DateofBirth = dateofBirth;
	}
	public String getMobileNo() {
		return MobileNo;
	}
	public void setMobileNo(String mobileNo) {
		MobileNo = mobileNo;
	}
	public long getCountryID() {
		return CountryID;
	}
	public void setCountryID(long countryID) {
		CountryID = countryID;
	}	
	
	public void Login(String email, String password)
	{
		
	}

	public void Logout()
	{
		
	}
}
