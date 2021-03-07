package cls;

import java.util.List;

import dao.AccountDao;
import dto.AccountDto;


public class allPrint {
	public void userAllPrint() {
		
		AccountDao dao = AccountDao.getInstance();
		
		List<AccountDto> list = dao.getUserList();
		
		for (int i = 0; i < list.size(); i++) {
			AccountDto u = list.get(i);
			System.out.println(u.toString());
			
		}
		
		
	}
}
