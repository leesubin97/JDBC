package main;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.Scanner;

import cls.InsertClass;
import cls.SelectClass;
import cls.UpdateClass;
import cls.allPrint;
import cls.deleteClass;
import dao.AccountDao;
import dto.AccountDto;


public class MainClass {
	
	Scanner sc = new Scanner(System.in);
	

	public static void main(String[] args) {

		
		Scanner sc = new Scanner(System.in);
		
		// menu
	
		
		
		boolean t = true;
	    while(t) {
	        // 메뉴
	        System.out.println("-------가계부menu---------");
	        System.out.println("1.가계부추가");
	        System.out.println("2.가계부삭제(타이틀을 입력하세용~)");
	        System.out.println("3.가계부검색(타이틀을 입력하세용~)");
	        System.out.println("4.가계부UPDATE");
	        System.out.println("5.모든 데이터 출력");
	        System.out.println("6.종료");
	        System.out.println("--------------------");
	        // 입력 1 ~ 6
	        System.out.print("원하는 메뉴번호를 입력하세요 : ");
	        int worknum = sc.nextInt();

	        switch( worknum ) {
	            case 1:
	            	InsertClass ss = new InsertClass();
	        		ss.insertData();
	                break;    

	            case 2:    
	            	deleteClass sd = new deleteClass();
	            	sd.DeleteData();
	                
	                break;

	            case 3:
	            	SelectClass st = new SelectClass();
	            	st.SelectData();
	                
	                break;

	            case 4:    
	            	UpdateClass up = new UpdateClass();
	            	up.UpdateData();
	                 
	                break;
	            case 5:
	            	
	            	//allPrint ap = new allPrint();
	            	//ap.userAllPrint();
	            	
	            	AccountDao dao = AccountDao.getInstance();
	        		
	        		List<AccountDto> list = dao.getUserList();
	        		
	        		for (int i = 0; i < list.size(); i++) {
	        			AccountDto u = list.get(i);
	        			System.out.println(u.toString());
	        			
	        		}
	            	
	                break;
	            case 6:
	                
	        }            
	    }
	}
	/*	
		dao.allprint();
		
		dao.delete();
		
		dao.allprint();
		
		dao.update();
		
		dao.allprint();
	*/	
		
		
		
		
		
		
		
		
		
		
		

	}







