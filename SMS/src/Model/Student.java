package Model;

import java.sql.ResultSet;
import java.util.ArrayList;

import DAL.DataAccess;

public class Student extends Person {
	private long StudentId;
	private long ClassId;
	private long DepartmentId;
	
	public long getStudentId() {
		return StudentId;
	}

	
	public long getDepartmentId() {
		return DepartmentId;
	}
	public void setDepartmentId(long departmentId) {
		DepartmentId = departmentId;
	}
	public long getClassId() {
		return ClassId;
	}
	public void setClassId(long classId) {
		ClassId = classId;
	}

	@Override
	public ResultSet Login(String email, String password) throws Exception {
		DataAccess da = new DataAccess();
		String sql = String.format("select * from student where email='%s' and password='%s'",email, password);
		return da.ExecuteQuery(sql);
	}


	public int addStudent(Student std) throws Exception
	{
		String sql = "insert into student ";
		DataAccess da = new DataAccess();
		da.ExecuteUpdate(sql);
		return 0;
	}
	public int deleteStudent(long id) throws Exception
	{
		String sql = "delete from student where studentID = " +id;
		DataAccess da = new DataAccess();
		da.ExecuteUpdate(sql);
		return 0;
	}
	public int udateStudent(Student std)
	{
		return 0;
	}
	public ResultSet searchByName(String name)
	{
		return null;
	}
	public ResultSet searchByID(long id)
	{
		return null;
	}
	public ResultSet searchByClass(String name,long classId)
	{
		return null;
	}
	public ResultSet searchByDepartment(String name,long dId)
	{
		return null;
	}
	public ResultSet listByDepartment(long deptID)
	{
		return null;
	}
	public ResultSet listByClass(long classID)
	{
		return null;
	}
	public ResultSet listStudent()
	{
		return null;
	}

	
}
