package Solution;
import java.util.Scanner;
import java.util.logging.Logger;

import Solution.Room;
import Solution.LuxuryRoom;
import Solution.SuperDeluxRoom;
import Solution.DeluxRoom;

public class MainClass {
	private static final Logger LOGGER = Logger.getLogger( MainClass.class.getName() );
	
	public static void main(String [ ] args){
		Room[] rooms = loadRooms();
		
		Scanner reader = new Scanner(System.in);
				
		while (true) {
			printFirstScreen();
			int roomType = reader.nextInt();
			boolean cancel = false;
			boolean available = false;
			boolean end = false;
			
			for (int i = 0; i < rooms.length; i++){
				if (roomType == 3) {
					if (rooms[i].type == "Luxury" & rooms[i].status == "Vacant") {
						rooms[i].DisplayRoom();
						available = true;
					}
					else continue;
				}
				else if (roomType == 2) {
					if (rooms[i].type == "Delux" & rooms[i].status == "Vacant") {
						rooms[i].DisplayRoom();
						available = true;
					}
					else continue;
				}
				else if (roomType == 1) {
					if (rooms[i].type == "Super Delux" & rooms[i].status == "Vacant") {
						rooms[i].DisplayRoom();
						available = true;
					}
					else continue;
				}
				else if (roomType == 4) {
					if (rooms[i].status == "Occupied") {
						rooms[i].DisplayRoom();
						cancel = true;
					}
					else continue;
				}
				else if (roomType == 0){
					end = true;
					break;
				}
				else {
					LOGGER.warning("User entered wrong symbol. Please try again!");
					System.out.println("Please try again!");
					printFirstScreen();
					roomType = reader.nextInt();
				}
					
			} 
			
			if (end == true) {
				LOGGER.info("Exiting the program");
				break;
			}
				
			if (cancel == true) {
				System.out.println("Please select room number to Cancel reservation");
				int roomID = reader.nextInt();
				
				for (int i = 0; i < rooms.length; i++){
					if (rooms[i].roomID == roomID) {
						rooms[i].CancelReservation();
						System.out.println("Reservation was canceled\n"
								+ "------------------------------\n");
					}
				}	
			}
			else if (available == false) {
				LOGGER.warning("No rooms available in selected category.");
				System.out.println("No rooms available from this category, please try again..."
						+ "\n------------------------------\n");
				continue;
			}
			else {
				System.out.println("Please select room number from above"
						+ "\n------------------------------\n");
				
				int roomID = reader.nextInt();
				
				System.out.println("Please enter number of days for the reservation"
						+ "\n------------------------------\n");
				
				int numberDays = reader.nextInt();
				
				for (int i = 0; i < rooms.length; i++){
					if (rooms[i].roomID == roomID) {
						int charge = rooms[i].Reserve(numberDays);
						System.out.println("The room was reserved. The charge for " + numberDays + "days is " + charge +
								"\n------------------------------\n");
					}
				}
				
				System.out.println("For exit press 0. To continue press any other key"
						+ "\n------------------------------\n");
				int exit = reader.nextInt();
				if (exit == 0) {
					break;
				}
				else {
					continue;
				}
			}
			
		}
				
		reader.close();
		
		System.out.println("Goodbye!");
	}
	
	public static Room[] loadRooms() {
		LOGGER.info("The rooms array is initiated");
		
		LuxuryRoom first = new LuxuryRoom (41, true);
		LuxuryRoom second = new LuxuryRoom (32, false);
		SuperDeluxRoom third = new SuperDeluxRoom(33);
		SuperDeluxRoom fourth = new SuperDeluxRoom(64);
		DeluxRoom fifth = new DeluxRoom(102, false);
		DeluxRoom sixth = new DeluxRoom(82, true);
		
		Room[] rooms = {first, second, third, fourth, fifth, sixth};
		
		return rooms;
	}
	
	public static void printFirstScreen() {
		LOGGER.info("The first screen of the application is displayed");
		
		System.out.println("Please select room type: "
				+ "\n1. Super Delux"
				+ "\n2. Delux"
				+ "\n3. Luxury"
				+ "\n\n4. Cancel reservation"
				+ "\n\n0. Exit");
	}
}
