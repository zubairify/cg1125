
public class StringRegEx {

	public static void main(String[] args) {
		String name = "Zubair";
		String nameExp = "[A-Z][a-z]{3,}";	
		System.out.println(name.matches(nameExp));
		
		String mobile = "6438323499";
		String mobileExp = "[6-9][0-9]{9}";
		System.out.println(mobile.matches(mobileExp));
		
		String email = "zubair@gmail.com";
		String emailExp = "";
		System.out.println(email.matches(emailExp));
	}
}
