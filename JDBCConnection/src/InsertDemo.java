import java.sql.Connection;
// import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class InsertDemo {
	public static void main(String arg[]) throws SQLException {
		
		
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the employee id");
		int empId=sc.nextInt();
		System.out.println("Enter the full name");
		String name=sc.next();
		System.out.println("Enter the gender");
		String gender=sc.next();
		System.out.println("Enter the age");
		int age=sc.nextInt();
		System.out.println("Enter the company name");
		String compName=sc.next();
		System.out.println("Enter the mail id");
		String mail=sc.next();

		

		
		
		String url="jdbc:mysql://localhost:3306/db1"; //db1 is a database name
		String user="root"; // username of a database
		String password="devika"; //password of a database
		
		String sql="insert into customer (empId,fullName,gender,age,companyName,mailId) values(?,?,?,?,?,?)";
		
		//Loading a driver is not required after java 8 
		// Driver driver=new com.mysql.cj.jdbc.Driver(); //loading a driver
		// DriverManager.registerDriver(driver); //loading a driver
		
		//Establishing the Connection to a database
		Connection conn=DriverManager.getConnection(url, user, password);
		
		//Prepare a statement
		PreparedStatement stmt=conn.prepareStatement(sql);
		
		//Append the data
		stmt.setInt(1, empId);
		stmt.setString(2, name);
		stmt.setString(3, gender);
		stmt.setInt(4, age);
		stmt.setString(5, compName);
		stmt.setString(6, mail);
		
		//Execute the statement for insert/update/delete
		int count=stmt.executeUpdate();
		
		if(count>=1){
			System.out.println("Registered successfully");
		}
		//System.out.println("Connected");
	}
}
