package cls;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import dao.AccountDao;
import db.DBClose;
import db.DBConnection;

public class deleteClass {
	public void DeleteData() {
		Scanner sc = new Scanner(System.in);
		
		AccountDao ss =  new AccountDao();
		
		System.out.println("삭제할 TITLE을 입력하세요");
		String use = sc.next();
		
		ss.delete(use);
		
	}
}

