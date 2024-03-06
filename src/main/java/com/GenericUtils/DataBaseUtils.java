package com.GenericUtils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.cj.jdbc.Driver;
import java.sql.Statement;

public class DataBaseUtils {
	Connection con=null;
	public void connectToDB() throws SQLException
	{
		Driver driver=new Driver();
		DriverManager.registerDriver(driver);
		con=DriverManager.getConnection(IpathConstants.DBURL,IpathConstants.DBusername,IpathConstants.DBpassword);
	}
	public void executeAndGetData(String query,int colindex,String expData) throws SQLException
	{
		
	Statement state=con.createStatement();
	ResultSet result = state.executeQuery(query);
	boolean flag=false;
	while(result.next())
	{
		String actualdata=result.getString(colindex);
				if(actualdata.equalsIgnoreCase(expData))
				{
					flag=true;
					break;
				}
	}
	if(flag)//or if(flag==true)
	{
	System.out.println("--data is present--");
	}
	else
	{
	System.out.println("--data is not present--");
	
	}
}
public void disconnectedDB() throws SQLException
{
	con.close();
}
}

