
public class Person {
	private String name;
	private int age;

	public Person() {
		this("Anonymous", -1);	// Constructor chaining
	}
	
	public Person(String name, int age) {
		this.name = name;
		this.age = age;
	}
	
	public void print() {
		System.out.println("Name: " + name + "\tAge: " + age);
	}
	
	@Override
	public String toString() {
		return "Name: " + name + "\tAge: " + age;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Person) {
			Person p = (Person) obj;
			if(this.age == p.age && name.equals(p.name))
				return true;
		}
		return false;
	}

	public static void main(String[] args) {
		Person p1 = new Person("Polo", 21);
		System.out.println(p1.hashCode());
		System.out.println(p1);	// implicitly calls toString()
		
		Person p2 = new Person("Polo", 21);
		System.out.println(p2);
		
		System.out.println(p1.equals(p2));
	}
}


