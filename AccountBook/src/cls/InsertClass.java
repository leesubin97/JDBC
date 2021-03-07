package cls;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Scanner;

import dao.AccountDao;
import db.DBClose;
import db.DBConnection;
import dto.AccountDto;


public class InsertClass {
	

	public void insertData() {
			Scanner sc = new Scanner(System.in);
		
			
			
			
			System.out.print("지출(1)/수입(2) = ");
			int c = sc.nextInt();				
			String classify = (c == 1)?"지출":"수입";
			
			System.out.print("금액 = ");
			int money = sc.nextInt();
			
			System.out.print("사용처 = ");
			 String use = sc.next();
			
			System.out.print("memo = ");
			 String memo = sc.next();
			
			System.out.println("날짜 = ");
			 String dateTime = sc.next();
			
			AccountDao dao = AccountDao.getInstance();
			
			boolean b = dao.insert(dateTime, use, classify, money, memo);
			if(b) {
				System.out.println("정상적으로 추가 되었습니다");
				return;
			}else {
				System.out.println("추가되지 않았습니다");
			}
			
			
			
			
	
			
			
	
		
	}





}
