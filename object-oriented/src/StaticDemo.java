
public class StaticDemo {
	private int data;
	private static int count;
	
	static {	// Static initializer block - executes at the time of class loading..
		System.out.println("Class is loaded...");
		count = 1000;
	}
	
	{	// Instance block
		System.out.println("Object created...");
	}
	
	public StaticDemo(int data) {
		this.data = data;
		count ++;
	}
	
	public static void counter() {
		System.out.println("Count: " + count);
	}
	
	public void print() {
		System.out.println("Data: " + data + "\tCount: " + count);
	}
	
	public static void main(String[] args) {
		StaticDemo.counter();
		
		StaticDemo s1 = new StaticDemo(10);
		StaticDemo s2 = new StaticDemo(20);
		StaticDemo s3 = new StaticDemo(30);
		
		s1.print();
		s2.print();
		s3.print();
		
		StaticDemo.counter();
	}
}
