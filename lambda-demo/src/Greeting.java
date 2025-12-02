
@FunctionalInterface
public interface Greeting {
	String sayHello();
	
	default void greet() {
		String m = msg();
		System.out.println(m);
	}
	
	static void sayBye() {
		System.out.println("Good bye");
	}
	
	private String msg() {
		return "Whatsup?";
	}
}
