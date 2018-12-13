package Model;

import java.sql.ResultSet;
import java.text.NumberFormat;
import java.util.Locale;

import DAL.DataAccess;

public class Admin {
	int adminID;
	String name;
	double salary;
	String imagePath;
	
	public int getAdminID() {
		return adminID;
	}
	public void setAdminID(int adminID) {
		this.adminID = adminID;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public String getImagePath() {
		return imagePath;
	}
	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}
	
	// methods
	public ResultSet viewAdmin() throws Exception
	{
		String query ="select AdminID, Name, Salary,ImagePath from admin";
		DataAccess da = new DataAccess();
		return da.ExecuteQuery(query);
	}
	
	public int deleteAdmin(int id) throws Exception
	{
		String query ="delete from admin where adminID = " + id ;
		DataAccess da = new DataAccess();
		return da.ExecuteUpdate(query);
	}
	
	public int udpateAdmin(Admin a) throws Exception
	{
		String query =String.format("update admin set Name='%s', Salary=%s, ImagePath = '%s' where adminID = %d",
				a.getName(),a.getSalary(),a.getImagePath(),a.adminID) ;
		DataAccess da = new DataAccess();
		return da.ExecuteUpdate(query);
	}
	
	public int addAdmin(Admin a) throws Exception
	{
		String query =String.format("insert into admin(name, salary,ImagePath) values('%s', %s, '%s')",
				a.getName(),String.valueOf(a.getSalary()),a.getImagePath()) ;
		//System.out.println(query);
		DataAccess da = new DataAccess();
		return da.ExecuteUpdate(query);
	}
	
}
