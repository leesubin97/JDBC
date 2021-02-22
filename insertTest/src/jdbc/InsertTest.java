package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class InsertTest {
	

		public InsertTest () {
			
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
			
			public int insertData(String id, String name, int age) {
				//Query(String)를 준비한다
				String sql = " INSERT INTO USERTEST(ID, NAME, AGE, JOINDATE)"
						+ "VALUES('"+ id + "','" + name + "'," + age + ", SYSDATE)"; ///**
				System.out.println(sql);
				
				//DB Connection
				Connection conn = getConnection();
				Statement state = null;
				
				int count = 0;  //몇개가 추가되었는가.
				
				//DB processing
				
				try {
					state = conn.createStatement();					
					count = state.executeUpdate(sql);   //sql 쿼리문이 실행된다. **
					
					System.out.println("성공적으로 추가되었습니다");
					
				} catch (SQLException e) {
					
					e.printStackTrace();
				}finally {//예외관계없이 실행
					
				
					try {
					//DB close
					if(state != null) {
						state.close();
					}
					if(conn != null) {
						conn.close();
					}
					}catch(SQLException e) {
						
						e.printStackTrace();
						}
					}
					return count;
				}
				
				
				//DE Close
			}
			

		
