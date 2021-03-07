package cls;

import java.util.Scanner;

import dao.AccountDao;
import dto.AccountDto;



public class SelectClass {
	public void SelectData(){
		
		Scanner sc = new Scanner(System.in);
		AccountDao ss =  new AccountDao();
		
		
		System.out.print("타이틀의 정보를 출력해줍니다 (타이틀입력) = ");
		String title = sc.next();	
		
		
		 AccountDto user = ss.select(title);
		
		if(user != null) {
			System.out.println(user.toString());
		}else {
			System.out.println("데이터를 찾을 수 없습니다");
		}
		
		
	}
}
