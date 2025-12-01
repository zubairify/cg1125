
public class StringDemo {

	public static void main(String[] args) {
		String s1 = "Hello";
		String s2 = new String("Hello");
		String s3 = "Hello";
		
		System.out.println(s1);
		
		System.out.println(s1 == s2);
		System.out.println(s1 == s3);
		
		System.out.println(s1.equals(s2));
		System.out.println(s1.equals(s3));
		
		s1 = s1 + "World";
		System.out.println(s1 == s3);
		
		System.out.println(s1);
		System.out.println(s1.length());
		System.out.println(s1.toUpperCase());
		System.out.println(s1.toLowerCase());
		
		System.out.println(s1.indexOf('o'));
		System.out.println(s1.lastIndexOf('o'));
		System.out.println(s1.charAt(7));
		
		System.out.println(s1.substring(3));
		System.out.println(s1.substring(3, 7));
		
		// Print index of all 3 'l's in the string s1
		int idx = -1;
		while(true) {
			idx = s1.indexOf('l', idx+1);
			if(idx == -1) break;
			System.out.println(idx);
		}
		
		String week = "Sun-Mon-Tue-Wed-Thu-Fri-Sat";
		String[] days = week.split("-");
		for (String day : days) 
			System.out.println(day);
		
	}
}

