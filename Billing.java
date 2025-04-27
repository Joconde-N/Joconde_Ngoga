package Assignment_one.Question2;

public class Billing extends HotelService {
    public Billing(String guestId, String guestName, String roomType, int stayDays, String roomStatus){
        super(guestId, guestName, roomType, stayDays, roomStatus); 
    }
    @Override
    public void bookRoom(){
    }
    @Override
    public void checkoutGuest(){
       
    }
    @Override
    public void generateBill(){
    int costpernight=0;
    int totalCost = 0;
    switch (roomType) {
        case "STANDARD":
            costpernight = 50000;
            break;
        case "DELUXE":
            costpernight = 80000;
            break;
        case "SUITE":
            costpernight = 120000;
            break;
        default:
            System.out.println("Error: Invalid room type.");
            return;
    }
    
    
    
    totalCost = costpernight * stayDays;
    System.out.println(" ");
    System.out.println("----BILLING STATUS----");
    System.out.println("Guest ID : " + guestId);
    System.out.println("Guest Name : " +guestName);
    System.out.println("Room Type : " +roomType);
    System.out.println("Days Stayed: " +stayDays+" Days");
    System.out.println(String.format("Total Cost: %,d RWF", totalCost));
}
    
}
