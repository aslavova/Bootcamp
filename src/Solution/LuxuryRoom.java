package Solution;
import Solution.Room;

public class LuxuryRoom extends Room{
	boolean occupancy; // false = single, true = double
	
	LuxuryRoom() {
		super();
		this.occupancy = false;
		this.type = "Luxury";
	}

	LuxuryRoom(int defaultRoomRate) {
		super(defaultRoomRate);
		this.occupancy = false;
		this.type = "Luxury";
	}
	
	LuxuryRoom(int defaultRoomRate, boolean occupancy) {
		super (defaultRoomRate);
		this.occupancy = occupancy;
		this.type = "Luxury";
	}
	
	private String occupancyToString() {
		if (this.occupancy == true)
			return "Single room";
		else
			return "Double room";
	}
	
	public void DisplayRoom() {
		super.DisplayRoom();
		System.out.println("Room Type: " + this.type);
		System.out.println("Occupancy: " + this.occupancyToString() + "\n");
	}
}
