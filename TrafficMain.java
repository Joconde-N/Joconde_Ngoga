package Assignment_one.Question3;
import java.util.Scanner;
import java.util.regex.Pattern;

public class TrafficMain {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        System.out.println("--Welcome to the Rwanda National Police Traffic Management System--");

        String driverId="";
        while(true){
        System.out.println("Enter the driver ID (must be 16 digits): ");
        driverId=in.nextLine();
        if (driverId.matches("\\d{16}")) {
            break; 
        } else {
            System.out.println("Error: The ID must contain 16 digits and only numbers. Please try again.");
        }
    }


        String driverName="";
        while (true) {
        System.out.println("Enter the driver's name: ");
        driverName=in.nextLine();
        if (driverName.matches("[a-zA-Z ]+")) {
            break;
        } else {
            System.out.println("Error: driver's name must contain only letters.Try again");
            
        }
    }

        System.out.println("Enter the vehicle plate (e.g., RAB123D): ");
        String vehiclePlate=in.nextLine();
        while (!Pattern.matches("[R][A-Z]{2}\\d{3}[A-Z]", vehiclePlate)) {
            System.out.print("Invalid plate format. Try again (e.g., RAB123D): ");
            vehiclePlate = in.nextLine();
        }
        System.out.println("Enter Violation Type (SPEEDING, RED_LIGHT, NO_HELMET or DUI): ");
        String violationType = in.nextLine();
        if(!violationType.equals("SPEEDING")&&!violationType.equals("RED_LIGHT")&&!violationType.equals("NO_HELMET")&&!violationType.equals("DUI")){
            System.out.println("Error: invalid violation type! Please enter SPEEDING, RED_LIGHT, NO_HELMET or DUI ");
            violationType=in.nextLine();
        }

        ViolationEntry vio=new ViolationEntry(driverId, driverName, vehiclePlate, violationType, 0, violationType);
        vio.recordViolation();
        System.out.println("");
        FineAssessment fine=new FineAssessment(driverId, driverName, vehiclePlate, violationType, 0, violationType);
        fine.assessFine();
        System.out.println("Do you want to pay the fine now (yes/no)?: ");
        String choice=in.nextLine();
        if(choice.equalsIgnoreCase("yes")){
            FinePayment pay=new FinePayment(driverId, driverName, vehiclePlate, violationType, 0, choice);
            pay.processPayment();
        
        }else{
            System.out.println("Fine is not yet paid. Please pay it sooner!");

        }
        in.close();

        
    }

    
}
