package Model;

import java.sql.ResultSet;

public class Person  {
	// data member
	private String Name;
	private String Email;
	private String Password;
	private String Address;
	private String Gender;
	private String DateofBirth;
	private String MobileNo;
	private String Country;
	
	//data hiding or Encapsulation
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
	public String getCountry() {
		return Country;
	}
	public void setCountry(String country) {
		Country = country;
	}	
	
	public ResultSet Login(String email, String password)throws Exception
	{
		return null;
	}

	public void Logout()
	{
		
	}
}
