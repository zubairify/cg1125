
public class StringSearchDemo {
	private String[] data = {"Alfa","Romeo","Charlie","Beta","Frank","Indigo","Sean","Ben"};
	
	public void search(String query) {
		
	}
	
	public static void main(String[] args) {
		StringSearchDemo demo = new StringSearchDemo();
		demo.search("an");	// Frank, Sean
		demo.search("be");	// Beta, Ben
		demo.search("lie");	// Charlie
		
	}
}
