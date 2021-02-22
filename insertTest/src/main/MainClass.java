package main;

import jdbc.InsertTest;

public class MainClass {
	public static void main(String[] args) {
		
		InsertTest it = new InsertTest();
		
		int count = it.insertData("cde", "일지메", 10);
		
		if(count == 1) {
		System.out.println("데이터가" +count + " 개 추가되었습니다");
		}else {
			System.out.println("데이터가 추가되지않았습니다");
		}
		
		
	}//main
}//MainClass
