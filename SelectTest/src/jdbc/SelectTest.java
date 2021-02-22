package jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import db.DBClose;
import db.DBConnection;
import dto.UserDto;

public class SelectTest {
	// 1개 데이터의 취득
	public UserDto search(String id) {
		String sql = "SELECT ID, NAME, AGE, JOINDATE "
				+ " FROM USERTEST "
				+ " WHERE ID = '" + id  +"' ";
		
		System.out.println(sql); //확인작업은 하는게 맞다 꾸준히 확인하자
		
		Connection conn = DBConnection.getConnection();
		Statement stmt = null; //실무에서 쓰인다.
		ResultSet rs = null; // db로부터 결과를 return 받는
		
		UserDto dto = null;
		
		try {
			stmt = conn.createStatement();
			
			rs = stmt.executeQuery(sql);
			
			if(rs.next()) {//데이터가 있는 경우
				String userid = rs.getString("id");
				//디비로부터 넘어온 데이터를 아이디라는 컬럼으로 받겠다는 것이다.
				String username = rs.getString("name");
				int userage = rs.getInt("age");
				String userjoindate = rs.getString("joindate");
				
				
				dto = new UserDto(userid, username, userage, userjoindate);
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBClose.close(conn,stmt,rs);
		}
		 return dto;
	}
	
	
	
	//이걸 더 실무에서 많이 사용한다
	public UserDto select(String id) {
		String sql = "SELECT ID, NAME, AGE, JOINDATE "
				+ " FROM USERTEST "
				+ " WHERE ID = ? ";  //데이터를 입력
		
		System.out.println(sql);
		
		Connection conn = DBConnection.getConnection();
		PreparedStatement psmt = null;
		ResultSet rs = null;
		
		UserDto dto = null;
		
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, id);//물음표 표시의 첫번째에 id를 넣어라.
			
			rs = psmt.executeQuery();
			
			if(rs.next()) {
				String userid = rs.getString("id");
				String username = rs.getString("name");
				int userage = rs.getInt("age");
				String userjoindate = rs.getString("joindate");
				
				
				dto = new UserDto(userid, username, userage, userjoindate);
				
			}
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBClose.close(conn, psmt, rs);
		}
		
		return dto;
		
	}
	
	
	// 다수 데이터의 취득
	public List<UserDto> getUserList(){
		String sql = "SELECT * "
				+ " FROM USERTEST ";
		
		Connection conn = DBConnection.getConnection();
		PreparedStatement psmt = null;   //쿼리문을 세팅해줄것
		ResultSet rs = null;		
		
		
		List<UserDto> list = new ArrayList<UserDto>();
		
		
		
		try {
			psmt = conn.prepareStatement(sql);
			
			
			rs = psmt.executeQuery();
			
			
			while(rs.next()) {
				
				String id = rs.getString("id");
				String name = rs.getString("name");
				int age = rs.getInt("age");
				String joindate = rs.getString("joindate");
				
				UserDto dto = new UserDto(id, name, age, joindate);
				
				list.add(dto);
				
			}
			
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBClose.close(conn, psmt, rs);
		}
		
		return list;
		
	}
	
	
	
	
	
	
}
