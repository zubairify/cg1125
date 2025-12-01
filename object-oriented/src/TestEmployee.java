import com.zs.hr.Clerk;
import com.zs.hr.Employee;
import com.zs.hr.Manager;

public class TestEmployee {

	public static void main(String[] args) {
		Manager m1 = new Manager("Mili", 3000, 1200);
		
		Clerk c1 = new Clerk("Lili", 2500, 900);
		
		showSalary(m1);
		showSalary(c1);
	}

	private static void showSalary(Employee e) {
		if(e instanceof Clerk)
			System.out.println("Clerk Salary: " + e.getSalary());
		else
			System.out.println("Manager Salary: " + e.getSalary());
	}

//	private static void showSalary(Clerk c1) {
//		System.out.println("Clerk Salary: " + c1.getSalary());
//	}
//
//	private static void showSalary(Manager m1) {
//		System.out.println("Manager Salary: " + m1.getSalary());
//	}
}
