
class HelloImpl implements Hello {
	@Override
	public void sayHello() {
		System.out.println("Hello from simple class");
	}
}

public class HelloDemo {
	private class NestedImpl implements Hello {
		@Override
		public void sayHello() {
			System.out.println("Hello from Nested class");
		}
	}
	
	static class StaticInnerImpl implements Hello {
		@Override
		public void sayHello() {
			System.out.println("Hello from Static Inner class");
		}
	}
	
	public void nestedDemo() {
		class InnerImpl implements Hello {
			@Override
			public void sayHello() {
				System.out.println("Hello from Nested method class");
			}
		}
		new InnerImpl().sayHello();
	}
	
	public void anonymousDemo() {
		Hello h = new Hello () {
			@Override
			public void sayHello() {
				System.out.println("Hello from Anonymous inner class");
			}
		};
		h.sayHello();
	}
	
	public void lambdaDemo() {
		Hello h = () -> System.out.println("Hello from Lambda expression");
		h.sayHello();
	}
	
	public static void main(String[] args) {
		HelloImpl hi = new HelloImpl();
		hi.sayHello();
		
		HelloDemo demo = new HelloDemo();
		NestedImpl ni = demo.new NestedImpl();
		ni.sayHello();
		
		Hello stat = new HelloDemo.StaticInnerImpl();
		stat.sayHello();
		
		demo.nestedDemo();
		demo.anonymousDemo();
		demo.lambdaDemo();
	}
}
