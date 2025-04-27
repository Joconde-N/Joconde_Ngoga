package Assignment_one.Question1;
import java.util.Scanner;
public class ConstructionMain {
    public static void main(String[] args) {

        Scanner in=new Scanner(System.in);
        System.out.println("===== REAL CONSTRUCTOR: Site Construction Management System =====");
        String contractorId="";
        while(true){
        System.out.println("Enter Contractor ID: ");
        contractorId = in.nextLine();
        if (contractorId.matches("\\d+")) {
            break; 
        } else {
            System.out.println("Error: The ID must contain only numbers. Please try again.");
        }
    }
        
        String contractorName="";
        while(true){
        System.out.println("Enter Contractor Name: ");
        contractorName =in.nextLine();
        if (contractorName.matches("[a-zA-Z ]+")) {
            break;
        } else {
            System.out.println("Error: contractor's name must contain only letters.Try again");
            
        }
    }
        
        double deliveryQuantity = 0;
        while (true) {
            try {
                System.out.println("\n--- Material Delivery ---");
                System.out.println("Enter material quantity to deliver (1-10 tons): ");
                deliveryQuantity = in.nextDouble();
                if (deliveryQuantity < 1 || deliveryQuantity > 10) {
                    System.out.println("Error: Quantity must be between 1 and 10 tons. Please try again.");
                } else {
                    break;
                }
            } catch (Exception e) {
                System.out.println("Invalid input. Please enter a numeric value.");
                in.next(); 
            }
        }
        
        
        MaterialDelivery delivery = new MaterialDelivery(contractorId, contractorName, deliveryQuantity);
        delivery.receiveMaterial();
        
       
        double currentBalance = delivery.getMaterialBalance();
        
        if (currentBalance > 0) {
            double usageQuantity = 0;
            while (true) {
                try {
                    System.out.println("\n--- Material Usage ---");
                    System.out.println("Enter material quantity to use: ");
                    usageQuantity = in.nextDouble();
                    if (usageQuantity > currentBalance || currentBalance - usageQuantity < 2) {
                        System.out.println("Error: Usage quantity cannot exceed the current balance or leave less than 2 tons in stock. Please try again.");
                    } else {
                        break;
                    }
                } catch (Exception e) {
                    System.out.println("Invalid input. Please enter a numeric value.");
                    in.next(); 
                }
            }
            MaterialUsage usage = new MaterialUsage(contractorId, contractorName, usageQuantity, currentBalance);
            usage.useMaterial();

            // Cost estimation based on usage
            System.out.println("\n--- Cost Estimation ---");
            CostEstimation costEstimation = new CostEstimation(contractorId, contractorName, usageQuantity);
            costEstimation.estimateCost();
        }
        
        in.close();
        System.out.println("\nThank you for using REAL CONSTRUCTOR Management System!");
    }
    
}
