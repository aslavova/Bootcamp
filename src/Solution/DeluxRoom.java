package Solution;
import Solution.LuxuryRoom;

public class DeluxRoom extends LuxuryRoom{
	DeluxRoom() {
		super();
		this.wifi = true;
		this.type = "Delux";
	}
	
	DeluxRoom(int defaultRoomRate) {
		super(defaultRoomRate);
		this.wifi = true;
		this.type = "Delux";
	}
	
	DeluxRoom(int defaultRoomRate, boolean occupancy) {
		super (defaultRoomRate, occupancy);
		this.type = "Delux";
	}
	
}
