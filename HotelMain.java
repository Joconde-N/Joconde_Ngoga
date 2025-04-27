package Assignment_one.Question2;
import java.util.Scanner;
public class HotelMain {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        System.out.println("Welcome to the LEMIGO HOTEL management system");

        String guestId="";
        while (true) {
            System.out.print("Enter guest ID: ");
            guestId = in.nextLine();
            if (guestId.matches("\\d+")) {
                break;
            } else {
                System.out.println("Error: Guest ID must contain digits only.");
            }
        }
        
        String guestName="";
        while (true) {
            System.out.print("Enter guest Name: ");
            guestName = in.nextLine();
            if (guestName.matches("[a-zA-Z ]+")) {
                break;
            } else {
                System.out.println("Error: Guest name must contain only letters.Try again");
                
            }
        }
        System.out.println("Enter room type (STANDARD, DELUXE or SUITE): ");
        String roomType=in.nextLine();
        if(!roomType.equals("STANDARD")&&!roomType.equals("DELUXE")&&!roomType.equals("SUITE")){
            System.out.println("Error: invalid room type! Please enter STANDARD, DELUXE or SUITE");
            roomType=in.nextLine();
        }
        int stayDays = 0; 
        while (true) {
            try{
        System.out.println("Enter number of days you want to stay between 1 and 30: ");
        stayDays=in.nextInt(); 
        if(stayDays<1||stayDays>30){
            System.out.println("Error: invalid number of days! Please enter a number between 1 and 30");
        } else {
            break; 
        }
        }catch(Exception e){
            System.out.println("Error: invalid input! please enter a numeric value");
            in.nextLine(); 
        }
        }

        in.nextLine();
        String roomStatus="AVAILABLE";

        RoomBooking room=new RoomBooking(guestId, guestName, roomType, stayDays, roomStatus);
        room.bookRoom();
        roomStatus = "OCCUPIED";

        System.out.println("Do you want to checkout?(yes/no): ");
        String choice=in.nextLine();
        if(choice.equalsIgnoreCase("yes")){
            GuestCheckout gue=new GuestCheckout(guestId, guestName, roomType, stayDays, roomStatus);
            gue.checkoutGuest();

            Billing bi=new Billing(guestId, guestName, roomType, stayDays, roomStatus);
            bi.generateBill();
        }else{
            System.out.println(" Enjoy your stay :| ");
        }
        in.close();
    }
    
}
