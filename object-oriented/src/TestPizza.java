import com.zs.bank.AccountsFactory;
import com.zs.bank.Banking;
import com.zs.shop.Pizza;

public class TestPizza {

	public static void main(String[] args) {
		Pizza p1 = new Pizza("M", 3, true, true);
		
		Banking s1 = AccountsFactory.openSavings("Frank");
		s1.deposit(2000);
		
		p1.orderSummary();
		p1.placeOrder(s1);
		
		s1.statement();
	}
}
