package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class updateTest {
	
	public updateTest() {

		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			
			System.out.println("Driver Loading Success");
			
		} catch (ClassNotFoundException e) {
			
			System.out.println("Driver가 없습니다");
			
		}
	}
	
	
	
	
	public Connection getConnection() {
		Connection conn = null;
		
		try {
			conn = DriverManager.getConnection("jdbc:oracle:thin:@192.168.0.235:1521:xe", "hr","hr");
													//주소는 DB 우클릭  Properties에서 가져온다.
			System.out.println("Oracle Connection Success");
			
		} catch (SQLException e) {
			
			System.out.println("DB를 연결하지 못했습니다");
		}
		
		return conn;
				
		
	}
	
	public int Update(String id, int age) {
		//아이디 수정
		//Query
		String sql = "UPDATE USERTEST "
				+ "SET AGE = " + age + " "
				+ "WHERE ID = '" + id + "'";
				
		System.out.println(sql);
		
		Connection conn = getConnection();
		Statement stmt = null;
		
		
		
		int count = 0;
		
		//db connect
		try {
			stmt = conn.createStatement();
			
		//db process
			count = stmt.executeUpdate(sql);
			
			System.out.println("성공적으로 수정되었습니다.");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			
			//db close
			try {
				if(stmt != null) {
					
				    stmt.close();
				
				
				}
				if(conn != null) {
					conn.close();
				}
				
			}
				
			
			catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		
		return count;
		
		
		
		
		
	}
	
	
	
}
