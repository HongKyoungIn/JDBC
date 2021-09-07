package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Program {
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		String sql = "SELECT * FROM EMP WHERE SAL > 2000";
		
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection(url, "SCOTT", "TIGER");
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(sql);
		
		while(rs.next()) {
				String ename = rs.getString("ENAME");
				System.out.println(ename);
		}
		
		rs.close();
		st.close();
		con.close();
	}

}
