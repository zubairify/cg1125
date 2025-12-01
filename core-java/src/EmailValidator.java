
public class EmailValidator {

	// Rules for validations
	// 1. Regex uses not allowed
	// 2. Min 4 chars before @
	// 3. Min 3 chars between @ and .
	// 4. Min 2 chars after .
	// 5. Only 1 @ and . is allowed
	public static void main(String[] args) {
		String email = "zuba@ema.co";

		int iat = email.indexOf('@');
		int idot = email.indexOf('.');

		System.out.println(iat == email.lastIndexOf('@') && idot == email.lastIndexOf('.') && iat >= 4
				&& idot > (iat + 3) && email.length() > idot + 2 ? "Valid email" : "Invalid email");
	}
}
