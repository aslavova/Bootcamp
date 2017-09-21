package Solution;
import Solution.Room;

public class SuperDeluxRoom extends Room{
	
	SuperDeluxRoom() {
		super();
		this.wifi = true;
		this.type = "Super Delux";
	}
	
	SuperDeluxRoom(int defaultRoomRate) {
		super(defaultRoomRate);
		this.wifi = true;
		this.type = "Super Delux";
	}
	
	public void DisplayRoom() {
		super.DisplayRoom();
		System.out.println("Room Type: " + this.type + "\n");
	}
}
