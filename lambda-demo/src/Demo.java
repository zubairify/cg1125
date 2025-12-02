
public class Demo<T> {
	private T data;

	public Demo(T data) {
		this.data = data;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}
	
	public static void main(String[] args) {
		Demo<String> d1 = new Demo<String>("Hola");
		System.out.println(d1.getData());
		
		Demo<Integer> d2 = new Demo<Integer>(1234);
		System.out.println(d2.getData());
	}
}
