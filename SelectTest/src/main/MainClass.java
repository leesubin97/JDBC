package main;

import java.util.List;

import db.DBConnection;
import dto.UserDto;
import jdbc.SelectTest;

public class MainClass {
	public static void main(String[] args) {
		DBConnection.initConnection();
		
		
		SelectTest st = new SelectTest();
		String id = "via";
		
		UserDto dto = st.search(id);
		if(dto != null) {
			System.out.println(dto.toString());
		}else {
			System.out.println("데이터를 찾을 수 없습니다");
		}
		
		id = "abc";
		UserDto user = st.search(id);
		if(user != null) {
			System.out.println(user.toString());
		}else {
			System.out.println("데이터를 찾을 수 없습니다");
		}
		
		System.out.println("---------------------------------");
		
		List<UserDto> list = st.getUserList();
		
		for (int i = 0; i < list.size(); i++) {
			UserDto u = list.get(i);
			System.out.println(u.toString());
			
		}
		
		//회원 5명
		//20 살이상 회원검색
		
		
	}
}
