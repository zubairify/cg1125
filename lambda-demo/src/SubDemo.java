
public class SubDemo<T, S> extends Demo<T> {
	private S info;

	public SubDemo(T data, S info) {
		super(data);
		this.info = info;
	}

	public S getInfo() {
		return info;
	}

	public void setInfo(S info) {
		this.info = info;
	}
	
	public static void main(String[] args) {
		SubDemo<String, Integer> s1 = new SubDemo<String, Integer>("Polo", 21);
		System.out.println(s1.getData() + " = " + s1.getInfo());
	}
}
