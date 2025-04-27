package Assignment_one.Question3;

public class ViolationEntry extends TrafficRecord{
    public ViolationEntry(String driverId,String driverName,String vehiclePlate, String violationType,double fineAmount,String paymentStatus){
        super(driverId,driverName,vehiclePlate, violationType,fineAmount,paymentStatus);
    }
    @Override
    public void recordViolation(){
        if(!violationType.equalsIgnoreCase("SPEEDING") &&
               !violationType.equalsIgnoreCase("RED_LIGHT") &&
               !violationType.equalsIgnoreCase("NO_HELMET") &&
               !violationType.equalsIgnoreCase("DUI")) {
            System.out.print("Error!:Invalid violation type. ");
            return;    
        }
        paymentStatus="UNPAID";
        System.out.println("violation recorded successfully");
        System.out.println("Driver ID: "+driverId);
        System.out.println("Driver Name: "+driverName);
        System.out.println("Vehicle Plate: "+vehiclePlate);
        System.out.println("Violation Type: "+violationType);
        System.out.println("Payment Status: "+paymentStatus);

    }
    @Override
    public void assessFine(){

    }
    @Override
    public void  processPayment(){

    }

    
}
