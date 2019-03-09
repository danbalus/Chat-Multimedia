package Chat;
import java.sql.*;
public class CheckAvail{
	String name,pass;
	CheckAvail(String name,String pass){
		this.name=name;
		this.pass=pass;
	}
	CheckAvail(String name){
		this.name=name;
	}
	boolean Check_Signup() throws SQLException
	{
		int found=0;
		DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
		System.out.println("Establishing Connection to Database");
		Connection cn=DriverManager.getConnection("jdbc:mysql://localhost:3306/schooldb","root","1234");

		System.out.println("Connected to Database");
		Statement st=cn.createStatement();
		ResultSet resultSet =st.executeQuery("SELECT USER_NAME FROM CONTURI");
		while(resultSet.next()){
			String check_name=resultSet.getString(1);
			//System.out.println(check_name);
			if(check_name.equalsIgnoreCase(name))
				found++;	
			}
		st.close();
		cn.close();
		if(found!=0)
		return false;
		return true;
	}
	boolean Check_Login()throws SQLException{
		int found=0;
		DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
		System.out.println("Establishing Connection to Database");
		Connection cn=DriverManager.getConnection("jdbc:mysql://localhost:3306/schooldb","root","1234");
		System.out.println("Connected to Database");
		Statement st=cn.createStatement();
		ResultSet resultSet =st.executeQuery("SELECT USER_NAME,PASSWORD FROM CONTURI");
		while(resultSet.next()){
			String check_name=resultSet.getString(1);
			String check_pass=resultSet.getString(2);
		//	System.out.println(check_name);
		//	System.out.println(check_pass);
			if((check_name.equalsIgnoreCase(name)) &&(check_pass.equals(pass)))
				found++;	
			}
		st.close();
		cn.close();
		if(found==1)
		return true;
		return false;
	}
	boolean Check_Email() throws SQLException
	{
		int found=0;
		DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
		System.out.println("Establishing Connection to Database");
		Connection cn=DriverManager.getConnection("jdbc:mysql://localhost:3306/schooldb","root","1234");

		System.out.println("Connected to Database");
		Statement st=cn.createStatement();
		ResultSet resultSet =st.executeQuery("SELECT EMAIL FROM CONTURI");
		while(resultSet.next()){
			String check_name=resultSet.getString(1);
			//System.out.println(check_name);
			if(check_name.equalsIgnoreCase(name))
				found++;	
			}
		st.close();
		cn.close();
		if(found!=0)
		return false;
		return true;
	}
}