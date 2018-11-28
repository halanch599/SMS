package Model;

import java.sql.ResultSet;

import DAL.DataAccess;

public  class department {
	private int Id;
	private String Name;
	
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	
	//default constructor
	public department() {
	}
	
	public department(int id, String name) {
		Id = id;
		Name = name;
	}
	
	public int addDepartment(department d) throws Exception
	{
		DataAccess da = new DataAccess();
		String query = String.format("insert into department(name) values('%s')",d.getName());
		return da.ExecuteUpdate(query);
	}
	
	public int updateDepartment(department d) throws Exception
	{
		DataAccess da = new DataAccess();
		String query = String.format("update department set name  = '%s'"
				+ " where departmentid =",d.getId());
		return da.ExecuteUpdate(query);
	}
	
	
	public int deleteDepartment(long id) throws Exception
	{
		DataAccess da = new DataAccess();
		String query = String.format("delete from department where departmentid = %s)",id);
		return da.ExecuteUpdate(query);
	}

	public ResultSet searchDepartmentByID(long id) throws Exception
	{
		DataAccess da = new DataAccess();
		String query = String.format("select * from department where departmentid = ",id);
		return da.ExecuteQuery(query);
	}
	
	public ResultSet searchDepartmentByName(String name) throws Exception
	{
		DataAccess da = new DataAccess();
		String query = String.format("select * from department where Name ='%s%'",name);
		return da.ExecuteQuery(query);
	}
	public ResultSet viewDepartment() throws Exception
	{
		DataAccess da = new DataAccess();
		String query = "select * from department";
		return da.ExecuteQuery(query);
	}
	
	

}
