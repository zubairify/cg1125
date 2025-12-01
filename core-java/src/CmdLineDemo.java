import static java.lang.Integer.*;

public class CmdLineDemo {

	public static void main(String[] args) {
		int total = 0;
		for (String s : args) {
//			total += parseInt(s);
			total = sum(total, parseInt(s));
			System.out.println(s);
		}
		System.out.println("Total: " + total);
		
		int o = 10;
		Integer iobj = o;	// Boxing
		Integer iobj2 = new Integer(o);
		int i = 5;
		int x = iobj;	// Unboxed
		System.out.println(i + iobj);	// Auto-boxing
		
	}
}
