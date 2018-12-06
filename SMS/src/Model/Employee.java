package Model;

import java.sql.ResultSet;
import java.util.ArrayList;

import DAL.DataAccess;

public class Employee extends Person {
	//data members
	private long EmployeeId;
	private String Role;
	private String HireDate;
	private float Salary;
	private String EployeeType;
	
	// properties for get and set
	public long getEmployeeId() {
		return EmployeeId;
	}
//	public void setEmployeeId(long employeeId) {
//		EmployeeId = employeeId;
//	}
	public String getRole() {
		return Role;
	}
	public void setRole(String role) {
		Role = role;
	}
	public String getHireDate() {
		return HireDate;
	}
	public void setHireDate(String hireDate) {
		// 2020
		//validation dogrulaamk
		HireDate = hireDate;
	}
	public float getSalary() {
		return Salary;
	}
	public void setSalary(float salary) {
		Salary = salary;
	}
	
	public String getEployeeType() {
		return EployeeType;
	}
	public void setEployeeType(String eployeeType) {
		EployeeType = eployeeType;
	}
	// Methods
	@Override
	public ResultSet Login(String email, String password) throws Exception {
		DataAccess da = new DataAccess();
		String sql = String.format("select * from employee where email='%s' and password='%s'",email, password);
		return da.ExecuteQuery(sql);
	}
	
	public int  addEmployee(Employee e) throws Exception {
		String query =String.format("insert into Employee(Name" + 
				",Address,Email,Password,Gender,DateOfBirth,MobileNo" + 
				",Country,HireDate,Salary,Role,EmployementType)"
				+ "values('%s','%s','%s','%s','%s','%s','%s','%s','%s','%s','%s','%s')",
				e.getName()
				,e.getAddress()
				,e.getEmail()
				,e.getPassword()
				,e.getGender()
				,e.getDateofBirth()
				,e.getMobileNo()
				,e.getCountry()
				,e.getHireDate()
				,e.getSalary()
				,e.getRole()
				,e.getEployeeType());
		DataAccess da = new DataAccess();
		return da.ExecuteUpdate(query);
	}
	public int  deleteEmployee(long Id) throws Exception {
		String query =String.format("delete from Employee where employeeid = %s",Id);
		DataAccess da = new DataAccess();
		return da.ExecuteUpdate(query);
	}
	public int  updateEmployees(Employee e) throws Exception {
		String query =String.format("update Employee set Name=%s " + 
				",Address = %s,Email=%s,Password=%s,Gender=%s,DateOfBirth=%s,MobileNo=%s" + 
				",Country=%s,HireDate=%s,Salary=%s,Role=%s,EmployementType=%s"+
				" where employeeId =%s",
				e.getName()
				+e.getAddress()
				+e.getPassword()
				+e.getGender()
				+e.getDateofBirth()
				+e.getMobileNo()
				+e.getCountry()
				+e.getHireDate()
				+e.getSalary()
				+e.getRole()
				+e.getEmployeeId());
		DataAccess da = new DataAccess();
		return da.ExecuteUpdate(query);
	}
	public ResultSet listEmployee() throws Exception {
		String query ="select * from employee"; 
		DataAccess da = new DataAccess();
		return da.ExecuteQuery(query);
	}
	public void  searchByName(String name) {
		
	}
	public void  searchByID(long Id) {
		
	}
	public void  searchByDepartment(long Id) {
		
	}
	

}
