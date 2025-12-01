
public class Car {
	private String model;
	private String[] features;
	
	public Car(String model, String...features) { // Var-args
		this.model = model;
		this.features = features;
	}
	
	public void specs() {
		System.out.println("Features of " + model);
		for (String f : features) {
			System.out.println(f);
		}
	}
	
	public static void main(String[] args) {
		Car swift = new Car("Suzuki Swift", "ABS","Keyless","Power Windows");
		
		Car bmw = new Car("BMW X6", "Adas", "Pano Roof", "Automatic", "Traction", "Cruise", "ABS");
		
		swift.specs();
		bmw.specs();
	}
}
