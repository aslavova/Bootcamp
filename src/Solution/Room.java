package Solution;

import java.lang.String;


public class Room {
	public static int totalNumberRooms = 0;
	
	public static void incrementRooms() {
		totalNumberRooms++;
	}
	
	int roomID;
	int defaultRoomRate;
	String status;
	boolean wifi;
	String type;
	
	Room() {
		this.roomID = totalNumberRooms + 1;
		this.defaultRoomRate = 10;
		this.status = "Vacant";
		this.wifi = false;
		this.type = "Room";
		
		incrementRooms();
	}
	
	Room(int defaultRoomRate) {
		this.roomID = totalNumberRooms + 1;
		this.defaultRoomRate = defaultRoomRate;
		this.status = "Vacant";
		this.wifi = false;
		this.type = "Room";
		
		incrementRooms();
	}
	
	public void CancelReservation() {
		this.status = "Vacant";
	}
	
	public int Reserve(int numberDays) {
		this.status = "Occupied";
		
		int charge = this.defaultRoomRate * numberDays;
		
		return charge;
	}
	
	public void DisplayRoom() {
		System.out.println("Room Number: " + this.roomID);
	}
	
	public boolean isOccupied() {
		if (this.status == "Occupied")
			return true;
		else
			return false;
	}
}
