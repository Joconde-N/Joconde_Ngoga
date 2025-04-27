package Assignment_one.Question2;

public class GuestCheckout extends HotelService{
    public GuestCheckout(String guestId, String guestName, String roomType, int stayDays, String roomStatus){
        super(guestId, guestName, roomType, stayDays, roomStatus);  
    }   
    @Override
    public void bookRoom(){

    }
    @Override
    public void checkoutGuest(){
       if(!roomStatus.equals("OCCUPIED")){
        System.out.println("Error: The room is not currently occupied");
       }
       roomStatus="AVAILABLE";
       System.out.println("Checkout successful .The room is now available for Booking");
    }
    @Override
    public void generateBill(){

    }
    
}
