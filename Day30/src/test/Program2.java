package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Program2 {
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		String ename = "HONG2";
		String job = "SALESMAN";
		int mgr = 7698;
		int sal = 3000;
		int comm = 400;
		int deptno = 30;
		
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		String sql = "INSERT INTO emp (" + 
				"    ename," + 
				"    job," + 
				"    mgr," + 
				"    sal," + 
				"    comm," + 
				"    deptno" + 
				") VALUES (?,?,?,?,?,?)";
		
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection(url, "SCOTT", "TIGER");
		//Statement st = con.createStatement();
		PreparedStatement st =  con.prepareStatement(sql);
		st.setString(1, ename);
		st.setString(2, job);
		st.setInt(3, mgr);
		st.setInt(4, sal);
		st.setInt(5, comm);
		st.setInt(6, deptno);
		
		int result = st.executeUpdate();
		
		System.out.println(result);
		
		st.close();
		con.close();
	}

}
