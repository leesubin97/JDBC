package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import cls.InsertClass;
import db.DBClose;
import db.DBConnection;
import dto.AccountDto;



// Data Access Object


public class AccountDao{
	private static AccountDao dao =null;
	
	public List<AccountDto> list = new ArrayList<AccountDto>();
	
	public AccountDao() {
			//Connection conn = DBConnection.getConnection();여기다 호출도 가능
		
	}
		public static AccountDao getInstance() {
			if(dao == null) {
				dao	= new AccountDao();
			}
			
			return dao;
		}
		
		
		public boolean insert(String dateTime, String use, String classify, int money, String memo){
			
			
			//AccountDao se = AccountDao.getInstance();
			
			
			
		
			
			String sql = " INSERT INTO ACCOUNTBOOK(DATETIME, TITLE, CLASSIFY, MONEY,MEMO)"
					+ "VALUES('"+ dateTime +"','" + use + "','" 
					+ classify + "', "  + money + ",'" + memo +"')";
			
			
			System.out.println(sql); //확인작업은 하는게 맞다 꾸준히 확인하자
			
			Connection conn = DBConnection.getConnection();
			Statement stmt = null;
			
			
			int count = 0;
			
			try {
				stmt = conn.createStatement();
				count = stmt.executeUpdate(sql);
				
				
				
				System.out.println("성공적으로 추가되었습니다");
				
				AccountDto dto = new AccountDto(dateTime, use, classify, money, memo);
				
				list.add(dto);
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				DBClose.close(conn, stmt, null);
			}
			return count>0?true:false;
					 
		}
		
		
		
		public boolean delete(String use) {
			
				String sql = " DELETE FROM ACCOUNTBOOK "
						+ " WHERE TITLE ='" + use + "' ";
				System.out.println(sql);
				
				Connection conn = DBConnection.getConnection();
				Statement stmt = null;
				
				int count = 0;
				try {
					stmt = conn.createStatement();
					count = stmt.executeUpdate(sql);
					
					System.out.println("삭제되었습니다");
					
					
					
					
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}finally {
					DBClose.close(conn, stmt, null);
				}
				
				return count > 0?true:false;
				
				}
			
		
		public AccountDto select(String use) {
			String sql = "SELECT DATETIME, TITLE, CLASSIFY, MONEY,MEMO "
					+ " FROM ACCOUNTBOOK "
					+ " WHERE TITLE = ? ";  //데이터를 입력
			
			System.out.println(sql);
			
			Connection conn = DBConnection.getConnection();
			PreparedStatement psmt = null;
			ResultSet rs = null;
			
			AccountDto dto = null;
			
			try {
				psmt = conn.prepareStatement(sql);
				psmt.setString(1, use);//물음표 표시의 첫번째에 id를 넣어라.
				
				rs = psmt.executeQuery();
				
				if(rs.next()) {
					String dateTime = rs.getString("DATETIME");
					String userUse = rs.getString("TITLE");
					int money = rs.getInt("MONEY");
					String classify = rs.getString("CLASSIFY");
					String memo = rs.getString("MEMO");
					
					dto = new AccountDto(dateTime,userUse,classify,money,memo);
					
				}
				
				
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				DBClose.close(conn, psmt, rs);
			}
			
			return dto;
			
		}
	
		public void upDate(String use, int money) {
			String sql = "UPDATE ACCOUNTBOOK "
					+ "SET MONEY = " + money + " "
					+ "WHERE TITLE = '" + use + "'";
					
			System.out.println(sql);
			
			Connection conn = DBConnection.getConnection();
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
			}finally 
			{
				DBClose.close(conn, stmt, null);
			}	
				
			
			
		}
		
		public List<AccountDto> getUserList(){
			String sql = "SELECT * FROM ACCOUNTBOOK ";
			
			Connection conn = DBConnection.getConnection();
			PreparedStatement psmt = null;   //쿼리문을 세팅해줄것
			ResultSet rs = null;		
			
			
			
			
			
			
			try {
				psmt = conn.prepareStatement(sql);
				//쿼리를 전달하고 결과값을 반환
				
				rs = psmt.executeQuery();
				//SELECT를 통한 정보 조회 전송
				
				
			
				
				if(rs.next()) {
					String dateTime = rs.getString("DATETIME");
					String userUse = rs.getString("TITLE");
					int money = rs.getInt("MONEY");
					String classify = rs.getString("CLASSIFY");
					String memo = rs.getString("MEMO");
					
					AccountDto dto = new AccountDto(dateTime,userUse,classify,money,memo);
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
	
	


