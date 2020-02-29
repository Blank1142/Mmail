import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import oracle.jdbc.driver.OracleDriver;

public class Model {
	private String Name;
	private String Email;
	private String Mobile;
	private String Password;
	Connection con;
	PreparedStatement pre;
	ResultSet res;
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public String getMobile() {
		return Mobile;
	}
	public void setMobile(String mobile) {
		Mobile = mobile;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}
	Model()
	{
		try
		{
			DriverManager.registerDriver(new OracleDriver());
			con = DriverManager.getConnection("jdbc:oracle:thin:@//localhost:1522/XE","SYSTEM","system");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	int register()
	{
		
		try {
			String s="INSERT INTO GMAIL VALUES(?,?,?,?)";
			pre = con.prepareStatement(s);
			pre.setString(1, Name);
			pre.setString(2, Email);
			pre.setString(3, Mobile);
			pre.setString(4, Password);
			
			int x=pre.executeUpdate();
			return x;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
	int login()
	{
		try {
			String s="SELECT * FROM GMAIL WHERE EMAIL=? AND PASSWORD=?";
			pre=con.prepareStatement(s);
			pre.setString(1, Email);
			pre.setString(2, Password);
		res = pre.executeQuery();
			if(res.next()==true)
			{
				Name=res.getString("Name");
				Email=res.getString("Email");
				Mobile=res.getString("Mobile");
				return 1;
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return 0;
	}
	int ref()
	{
		try
		{
			String s="SELECT EMAIL FROM GMAIL WHERE EMAIL=?";
			pre=con.prepareStatement(s);
			pre.setString(1, Email);
			res = pre.executeQuery();
			if(res.next()==true)
			{
				return 1;
			}
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return 0;
	}
	int Delete()
	{
		try
		{
			String s="DELETE FROM GMAIL WHERE EMAIL=?";
			pre=con.prepareStatement(s);
			pre.setString(1, Email);
			res = pre.executeQuery();
			if(res.next()==true)
			{
				return 1;
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return 0;
	}
}
