package Model;

import DAL.DataAccess;

public class Role {
	private long roleID;
	private String Name;

	// Encapsulation
	public long getRoleID() {
		return roleID;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public Role(String role) {
		setName(role);
	}
	public int RoleAdd(String Name) throws Exception
	{
		DataAccess da = new DataAccess();
		String sql =String.format("insert into Role(Name) values('%s')",Name);
		return da.ExecuteUpdate(sql);
	}

}
