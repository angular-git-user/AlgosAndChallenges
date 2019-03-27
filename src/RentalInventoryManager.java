import java.io.*;
import java.util.*;

public class RentalInventoryManager {

	public final int AVAILABLE = 1, IN_USE = 2, BEING_SERVED = 3;
	private int total_vehicle_count;
	private List<Vehicle> InUse, Available, InService = new Vector<Vehicle>();
	private File file = new File(System.getProperty("user.home"), "RentalInventory.txt");
	private List<Vehicle>[] MasterList = new List[] {Available, InUse, InService};
	private Properties archive = new Properties();
	
	public RentalInventoryManager() {
		
		try {
			archive.load(new FileInputStream(file));
		} catch (IOException e) {
			System.err.println(String.format(""	, e));
		}
		
		for(Object key : archive.keySet()) {
			Vehicle vehicle = new Vehicle((String)key);
			int state = Integer.parseInt((String)archive.get(key));
			addRentalToInventory(vehicle, state);
		}
	}


	public void saveState() throws IOException{
		
		for(int i = 0; i < MasterList.length; i ++) {
			
			for(Vehicle vehicle: MasterList[i]) {
				archive.setProperty(vehicle.toString(), String.valueOf(i + 1));
			}
		}
		archive.store(new FileOutputStream(file), "RentalInventory");
	}
	
	
	public void addRentalToInventory(Vehicle vehicle, int state) {
		switch(state) {
		case AVAILABLE:
			Available.add(vehicle);
		case IN_USE:
			InUse.add(vehicle);
		case BEING_SERVED:
			InService.add(vehicle);
		}
	}
	
	// ********************************************************
	public void removeRentalFromInventory(Vehicle vehicle) {
		
		for(int i = 0; i < MasterList.length; i++) {
			MasterList[i].remove(vehicle);
		}
	}
	
	public void changeState(Vehicle vehicle, int state) {
		removeRentalFromInventory(vehicle);
		addRentalToInventory(vehicle, state);
	}
	
	public List getAllAvailable() {
		return Available;
	}
	
	public List getAvailableByVehicleType(String type) {
		
		if(Available.isEmpty())
			return null;
		List<Vehicle> a = new ArrayList<>();
		type.toUpperCase();
		for(Vehicle vh: Available) {
			if(type.equals(vh.TYPE)) {
				a.add(vh);
			}
		}
		return a;
	}
	
	public boolean isAvailable(String vin) {
		return Available.contains(vin);
	}


	@Override
	public String toString() {
		double p = Available.size() / (Available.size() + InUse.size());
		String rate = String.format("%,.2f", p);
		String summary = new String("Rental Inventory (" + rate + "%utilization)\n");
		String[] labels = new String[] {"Available", "InUse", "InService"};
		for(int i = 0 ; i < MasterList.length; i ++) {
			summary += labels[i] + "\n";
			for(Vehicle vehicle: MasterList[i]) {
				summary += "\t" + vehicle + "\n";
			}
		}
		return summary;
	}
	
	
}
