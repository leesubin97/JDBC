package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
	public static void initConnection() {
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//Class.forName() 을 이용해서 드라이버 로드
			
			System.out.println("Driver Loading Success");
			
		} catch (ClassNotFoundException e) {
			
			System.out.println("Driver가 없습니다");
			
		}
		
	}
	
	
	public static Connection getConnection() {
		//static 붙여준이유는 언제 어디서든 불러 올 수 있게 한다
		Connection conn = null;
		
		try {
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "hr","hr");
													//주소는 DB 우클릭  Properties에서 가져온다.
			System.out.println("Oracle Connection Success");
			
		} catch (SQLException e) {
			
			System.out.println("DB를 연결하지 못했습니다");
		}
		
		return conn;
				
	}
}
