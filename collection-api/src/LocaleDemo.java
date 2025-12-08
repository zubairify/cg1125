import java.util.Locale;
import java.util.ResourceBundle;

public class LocaleDemo {

	public static void main(String[] args) {
		
		ResourceBundle bundle = ResourceBundle.getBundle("msgs", Locale.of("hi"));
		
		System.out.println(bundle.getString("greet"));
		System.out.println(bundle.getString("msg"));
	}
}
