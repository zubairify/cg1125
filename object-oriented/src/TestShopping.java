import com.zs.bank.AccountsFactory;
import com.zs.bank.Banking;
import com.zs.shop.Product;
import com.zs.shop.ShoppingCart;
import com.zs.shop.ShoppingException;

public class TestShopping {

	public static void main(String[] args) {
		
		Product p1 = new Product("iPhone", 80000, 5);
		Product p2 = new Product("MacBook", 90000, 3);
		Product p3 = new Product("iPad", 50000, 2);
		Product p4 = new Product("Marker", 25, 10);
		Product p5 = new Product("Duster", 20, 10);
		
		ShoppingCart mycart = new ShoppingCart();
		try {
			mycart.addToCart(p1);
			mycart.addToCart(p2);
			mycart.addToCart(p3);
			mycart.addToCart(p4);
			mycart.addToCart(p5);
		} catch (ShoppingException e) {
			System.out.println(e.getMessage());
		}
		
		Banking s1 = AccountsFactory.openSavings("Frank");
		s1.deposit(200000);
		try {
			mycart.checkout(s1);
		} catch (ShoppingException e) {
			System.out.println(e.getMessage());
		}
		try {
			mycart.addToCart(new Product("Abc", 10, 0));
		} catch (ShoppingException e) {
			System.out.println(e.getMessage());
		}
	}
}
