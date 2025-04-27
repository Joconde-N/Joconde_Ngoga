package Assignment_one.Question3;

public class FinePayment extends TrafficRecord {
    public FinePayment(String driverId,String driverName,String vehiclePlate, String violationType,double fineAmount,String paymentStatus){
        super(driverId,driverName,vehiclePlate, violationType,fineAmount,paymentStatus);
    }
    @Override
    public void recordViolation(){
        
    }
    @Override
    public void assessFine(){
       
    }
    @Override
    public void  processPayment(){
        if(paymentStatus.equalsIgnoreCase("PAID")){
            System.out.println("Error!: the payment is already made");
            return;
        }else{
            paymentStatus="PAID";
            System.out.println("Fine payment recorded successfully");
            System.out.println("Driver Name: "+driverName);
            System.out.println("Vehicle Plate: "+vehiclePlate);
            System.out.println("The amount paid: "+fineAmount);
            System.out.println("Payment Status: "+paymentStatus);
        }


    }
    
}
