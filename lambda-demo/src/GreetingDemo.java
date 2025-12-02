
public class GreetingDemo {

	public static void main(String[] args) {
		Greeting g1 = () -> "Happy Monsoon";
		System.out.println(g1.sayHello());
		
		Greeting g2 = () -> {
			String greet = "Happy Holidays";
			return greet;
		};
		System.out.println(g2.sayHello());
		
		g1.greet();
		Greeting.sayBye();
		
	}
}
