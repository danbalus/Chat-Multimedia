package Chat;
import java.sql.Connection;


import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
public class DataBaseEntry{
	String name,email,twdname,pass,gen,date,month,year,sques,sans;
	DataBaseEntry(String name,String email,String twdname,String pass,String gen,String date,String month,String year,String sques, String sans){
		this.name=name;
		this.email=email;
		this.twdname=twdname;
		this.pass=pass;
		this.gen=gen;
		this.date=date;
		this.month=month;
		this.year=year;
		this.sques=sques;
		this.sans=sans;
		
	}
	public void Entry() throws SQLException
	{
		DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
		System.out.println("Establishing Connection to Database");
		//Connection cn=DriverManager.getConnection("jdbc:oracle:schooldb:@127.0.0.1:3606:XE","root","1234");
		Connection cn=DriverManager.getConnection("jdbc:mysql://localhost:3306/schooldb","root","1234");

		System.out.println("Connected to Database");
		Statement st=cn.createStatement();
		try{
			
			st.executeUpdate("insert into conturi values('"+name+"','"+email+"','"+twdname+"','"+pass+"','"+gen+"','"+date+"','"+month+"','"+year+"','"+sques+"','"+sans+"')");
			System.out.println("Table Client/Server Created");
		}catch(SQLException ex){
			System.out.println("Exception is raised "+ex);
		}
		st.close();
		cn.close();
	}

}