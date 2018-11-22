package DAL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import org.sqlite.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

public class DataAccess {
	//SQL Connection OBjects
	Connection con = null;
	Statement st = null;
	ResultSet rs=null;

	public DataAccess() throws Exception
	{
		//1. Use this code for connection to SQL Server
		
		String url = "jdbc:sqlserver://localhost:58339;databaseName=sms;integratedSecurity=true;";
		// load driver for SQL Server database
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		con = DriverManager.getConnection(url);
		st = con.createStatement();
		
		//2. Use this code for connection to MySQL 
		//String url ="jdbc:mysql://localhost:3340/sms?useSSL=false&allowPublicKeyRetrieval=true";
		// load driver for MySQL database
		//Class.forName("com.mysql.jdbc.Driver");
		//con = DriverManager.getConnection(url, "root", "mysql");
		//st = con.createStatement();
		
		// yeni edlke
		
		//3. Use this code for connection to Sqlite 
		//String url ="jdbc:sqlite:C:\\Users\\akhtar.jamil\\eclipse-workspace\\sms.sqlite";
		// load driver for sqlite database
		//Class.forName("org.sqlite.JDBC");
		//con = DriverManager.getConnection(url);
		//st = con.createStatement();		
	}
	
	public DataAccess(String url, String username, String password) throws Exception
	{
		con = DriverManager.getConnection(url, username, password);
		Statement st = con.createStatement();		
	}
	
	
	public ResultSet ExecuteQuery(String sql) throws Exception
	{
		ResultSet rs = st.executeQuery(sql);
		return st.executeQuery(sql);
	}
	public int ExecuteUpdate(String sql) throws Exception
	{
		return st.executeUpdate(sql);
	}
	
	public TableModel ExecuteQueryTableModel(String sql) throws Exception
	{
		st = con.createStatement();
		return buildTableModel(st.executeQuery(sql));
	}

	public static DefaultTableModel buildTableModel(ResultSet rs)throws SQLException 
	{
	    ResultSetMetaData metaData = rs.getMetaData();

	    // names of columns
	    Vector<String> columnNames = new Vector<String>();
	    int columnCount = metaData.getColumnCount();
	    for (int column = 1; column <= columnCount; column++) {
	        columnNames.add(metaData.getColumnName(column));
	    }

	    // data of the table
	    Vector<Vector<Object>> data = new Vector<Vector<Object>>();
	    while (rs.next()) {
	        Vector<Object> vector = new Vector<Object>();
	        for (int columnIndex = 1; columnIndex <= columnCount; columnIndex++) {
	            vector.add(rs.getObject(columnIndex));
	        }
	        data.add(vector);
	    }

	    return new DefaultTableModel(data, columnNames);

	}
	
	
	

}
