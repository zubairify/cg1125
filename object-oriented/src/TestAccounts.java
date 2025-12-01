import com.zs.bank.BalanceException;
import com.zs.bank.Banking;
import com.zs.bank.Current;
import com.zs.bank.Savings;

public class TestAccounts {

	public static void main(String[] args) {
		Banking s1 = new Savings("Polo");
		try {
			s1.withdraw(500);
		} catch (BalanceException e) {
//			e.printStackTrace();	// Developers : To troubleshoot exceptions/errors
//			System.out.println(e);	// Logging : To audit system behavior
			System.out.println(e.getMessage());		// End users
		}
		
	}
}
