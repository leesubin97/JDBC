package main;

import jdbc.updateTest;

public class MainClass {
	public static void main(String[] args) {
		
		
		updateTest ut = new updateTest();
		// 실행했을때 드라이버 안뜨면 드라이버 프로젝트에 실행해줘야한다
		
		String id = "abc";
		int age =22;
		
		int count = ut.Update(id, age);
		
		if(count == 1) {
			System.out.println("정상적으로 수정되었습니다");
		}
	}
}
