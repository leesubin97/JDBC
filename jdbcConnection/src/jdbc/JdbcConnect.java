package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JdbcConnect {
	

		public JdbcConnect () {
			
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
			
}
		
