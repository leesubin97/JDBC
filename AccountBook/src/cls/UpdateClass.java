package cls;

import java.util.Scanner;

import dao.AccountDao;

public class UpdateClass {
	public void UpdateData() {
		Scanner sc = new Scanner(System.in);
		AccountDao sy = new AccountDao();
		
		System.out.println("비용을 바꿔야되는 타이틀을 작성하세요 = " );
		String use = sc.next();
		System.out.println("변경된 비용 = " );
		int money = sc.nextInt();
		
		
		sy.upDate(use, money);
	}
}
