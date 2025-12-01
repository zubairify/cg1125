import com.zs.lib.Book;
import com.zs.lib.Library;
import com.zs.lib.LibraryException;
import com.zs.lib.Member;

public class TestLibrary {

	public static void main(String[] args) {
		Library lib = new Library();
		
		Book b1 = new Book("The Alchemist");
		b1.status();
		
		Member m1 = new Member("John");
		m1.status();
		
		try {
			lib.issueBook(b1, m1);
		} catch (LibraryException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		b1.status();
		m1.status();
		
		Member m2 = new Member("Jack");
		try {
			lib.issueBook(b1, m2);
		} catch (LibraryException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			lib.returnBook(b1, m1);
		} catch (LibraryException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		b1.status();
		m1.status();
		
		try {
			lib.returnBook(b1, m2);
		} catch (LibraryException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
