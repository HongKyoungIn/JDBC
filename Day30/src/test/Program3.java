package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Program3 {
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		int sal = 4000;
		int comm = 1000;
		int empno = 7937;
		
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		String sql = "UPDATE EMP " + // +로 SQL문을 작성할 때는 문법 조심! 띄어쓰기 주의
				"SET" + 
				"    SAL = ?," + 
				"    COMM = ?" + 
				"WHERE EMPNO = ?";
		
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection(url, "SCOTT", "TIGER");
		//Statement st = con.createStatement();
		PreparedStatement st =  con.prepareStatement(sql);
		st.setInt(1, sal);
		st.setInt(2, comm);
		st.setInt(3, empno);
		
		int result = st.executeUpdate();
		
		System.out.println(result);
		
		st.close();
		con.close();
	}

}
