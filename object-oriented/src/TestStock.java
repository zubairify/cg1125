import com.zs.stock.Broker;
import com.zs.stock.Exchange;
import com.zs.stock.Holder;
import com.zs.stock.StockSingleton;

public class TestStock {
	public static void main(String[] args) {

		Holder h = StockSingleton.getStock();
		h.viewQuote();
		
		Broker b = StockSingleton.getStock();
		b.getQuote();
		b.viewQuote();
		
		Exchange x = StockSingleton.getStock();
		x.setQuote();
		x.getQuote();
		x.viewQuote();
		
		System.out.println(h == b);
		System.out.println(h == x);
	}
}
