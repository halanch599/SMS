package Model;

import java.sql.ResultSet;

import DAL.DataAccess;

public class Country {
	private long countryID;
	private String Name;
	
	public long getCountryID() {
		return countryID;
	}
	public void setCountryID(long countryID) {
		this.countryID = countryID;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	
	public ResultSet listCountry() throws Exception
	{
		DataAccess da = new DataAccess();
		String sql = "select 0 as countryID, 'Select country' as name union all  select * from Country";
		return da.ExecuteQuery(sql);
	}
	

}
