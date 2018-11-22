package Model;

import java.util.ArrayList;

import DAL.DataAccess;

public class Employee extends Person {
	//data members
	private long EmployeeId;
	private long RoleId;
	private String HireDate;
	private float Salary;
	private long ETypeId;
	
	// properties for get and set
	public long getEmployeeId() {
		return EmployeeId;
	}
//	public void setEmployeeId(long employeeId) {
//		EmployeeId = employeeId;
//	}
	public long getRoleId() {
		return RoleId;
	}
	public void setRoleId(long roleId) {
		RoleId = roleId;
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
	public long getETypeId() {
		return ETypeId;
	}
	public void setETypeId(long eTypeId) {
		ETypeId = eTypeId;
	}
	
	// Methods
	public int  addEmployee(Employee e) throws Exception {
		String query =String.format("insert into Employee(Name" + 
				",Address,Email,Password,Gender,DateOfBirth,MobileNo" + 
				",CountryID,HireDate,Salary,RoleID,EmployementTypeID)"
				+ "values('%s','%s','%s','%s','%s','%s','%s','%s','%s','%s','%s','%s')",
				e.getName()
				,e.getAddress()
				,e.getEmail()
				,e.getPassword()
				,e.getGender()
				,e.getDateofBirth()
				,e.getMobileNo()
				,e.getCountryID()
				,e.getHireDate()
				,e.getSalary()
				,e.getRoleId()
				,e.getETypeId());
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
				",CountryID=%s,HireDate=%s,Salary=%s,RoleID=%s,EmployementTypeID=%s"+
				" where employeeId =%s",
				e.getName()
				+e.getAddress()
				+e.getPassword()
				+e.getGender()
				+e.getDateofBirth()
				+e.getMobileNo()
				+e.getCountryID()
				+e.getHireDate()
				+e.getSalary()
				+e.getRoleId()
				+e.getEmployeeId());
		DataAccess da = new DataAccess();
		return da.ExecuteUpdate(query);
	}
	public void listEmployee() {
		
	}
	public void  searchByName(String name) {
		
	}
	public void  searchByID(long Id) {
		
	}
	public void  searchByDepartment(long Id) {
		
	}
	

}
