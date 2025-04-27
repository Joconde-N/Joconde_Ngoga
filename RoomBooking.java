package Assignment_one.Question2;

public class RoomBooking extends HotelService {
    public RoomBooking(String guestId, String guestName, String roomType, int stayDays, String roomStatus){
        super(guestId, guestName, roomType, stayDays, roomStatus);  
    }
    @Override
    public void bookRoom(){
        if(stayDays>1&&stayDays<30){
            System.out.println("Error: Booking failed. Stay duration must be between 1 and 30 days.");
            return;
        }
        if(!roomStatus.equals("AVAILABLE")){
            System.out.println("Error: The room is currently occupied");
            return;
        }
        roomStatus="OCCUPIED";
        System.out.println("---ROOM BOOKING STATUS---");
        System.out.println("Guest ID: "+guestId);
        System.out.println("Guest Name: "+guestName);
        System.out.println("Room Type: "+roomType);
        System.out.println("Stay Days: "+stayDays+" Days");
        System.out.println("The room is successfully booked");

    }
    @Override
    public void checkoutGuest(){

    }
    @Override
    public void generateBill(){

    }
    
}
