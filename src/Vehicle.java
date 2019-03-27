
public class Vehicle {

	static String CAR = "CAR", TRUCK  = "TRUCK", VAN = "VAN";
	final String TYPE, VIN;
	String serializedForm;
	
	Vehicle(String vin, String type){
		this(new String[] {vin, type});
	}
	
	Vehicle(String representation){
		this(representation.split("#"));
	}
	
	private Vehicle(String ...values) {
		VIN = values[0].toUpperCase();
		TYPE = values[1];
		serializedForm = VIN + "#" + TYPE;
	}
	
	public boolean equals(Vehicle other) {
		if(null != other & other.VIN == VIN) {
			return true;
		}
		return false;
	}
		
	public String toString() {
		return serializedForm;
	}
}
