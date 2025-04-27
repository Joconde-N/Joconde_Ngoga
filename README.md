# Joconde_Ngoga

# 📚 OOP  Case study Projects

Welcome to my collection of Object-Oriented Programming (OOP) practice projects! 🚀  
Each project demonstrates real-world application of abstract classes, inheritance, polymorphism, encapsulation, and input validations.

---

# 🏗️ Project 1: Site Construction Management System (REAL CONSTRUCTOR)

### 📋 Project Description
This system simulates material handling and cost tracking on a construction site using abstract classes and inheritance.

### 🛠️ Features
- Accept and validate material deliveries (1–10 tons).
- Allow material usage ensuring minimum stock (≥ 2 tons).
- Estimate costs based on material quantity.
  - 5–15 tons → 200,000 RWF/ton
  - Above 15 tons → 180,000 RWF/ton (bulk discount).

### 📦 Classes
- **Abstract Class: ConstructionMaterial**

  Serves as a blueprint for managing building materials, their usage, and cost estimations.
  
  - Abstract Methods:
    
    - receiveMaterial() – For processing delivered materials.
    - useMaterial() – For handling consumption of materials.
    - estimateCost() – For calculating cost based on usage.
   
  - Shared Fields: class is named as Constructor
    
    - contractorId (String) – Unique identifier for the contractor.
    - contractorName (String) – Full name of the contractor.
    - materialQuantity (double) – Quantity of material (in tons).
    - materialBalance (double) – Current available quantity in stock 

---

  ```java
  package Assignment_one.Question1;

  public abstract class ConstructionMaterial {
    protected String contractorId;
    protected String contractorName;
    protected double materialQuantity;
    protected double materialBalance;
     
    public ConstructionMaterial(String contractorId,String contractorName, double materialQuantity){
        this.contractorId = contractorId;
        this.contractorName = contractorName;
        this.materialQuantity = materialQuantity;
        this.materialBalance = 0;

    }

    public abstract void receiveMaterial();
    public abstract void useMaterial();
    public abstract void estimateCost();
   
    public String getContractorId() {
        return contractorId;
    }
    
    public void setContractorId(String contractorId) {
        this.contractorId = contractorId;
    }
    
    public String getContractorName() {
        return contractorName;
    }
    
    public void setContractorName(String contractorName) {
        this.contractorName = contractorName;
    }
    
    public double getMaterialQuantity() {
        return materialQuantity;
    }
    
    public void setMaterialQuantity(double materialQuantity) {
        this.materialQuantity = materialQuantity;
    }
    
    public double getMaterialBalance() {
        return materialBalance;
    }
    
    public void setMaterialBalance(double materialBalance) {
        this.materialBalance = materialBalance;
    }
  }

  ```

- **Concrete Classes:**
  
  - *MaterialDelivery*:
    
   Handles material deliveries to the site.
   Accepts material delivery only if quantity is between 1 and 10 tons.
   On successful delivery, updates materialBalance.
   If invalid, shows an error message with reason.
    
    ```java
    package Assignment_one.Question1;

    public class MaterialDelivery extends ConstructionMaterial {
    public MaterialDelivery(String contractorId, String contractorName, double materialQuantity) {
        super(contractorId, contractorName, materialQuantity);
    }
    @Override
    public void receiveMaterial(){
        if(materialQuantity>1&&materialQuantity<10){
            materialBalance+=materialQuantity;
            System.out.println("the current balance "+materialBalance);
        }
        else{
            System.out.println("Error:material not delivered as the quantity is not in range of 1-10 tons");
        }
    }
    @Override
    public void useMaterial(){

    }
    @Override
    public void estimateCost(){

    }
    
    }

    ```
    
  - *MaterialUsage*:
 
  Handles the use of materials during construction.
  Allows material to be used only if the resulting materialBalance remains ≥ 2 tons.
  Subtracts the used quantity from materialBalance.
  If insufficient material is available, an appropriate message is displayed.
    
    ```java
    package Assignment_one.Question1;

    public class MaterialUsage extends ConstructionMaterial {
    public MaterialUsage(String contractorId, String contractorName, double materialQuantity, double materialBalance) {
        super(contractorId, contractorName, materialQuantity);
        this.materialBalance = materialBalance;
    }
    @Override
    public void receiveMaterial(){
        
    }
    @Override
    public void useMaterial(){
        if((materialBalance-materialQuantity)>=2){
            materialBalance-=materialQuantity;
            System.out.println("material usage successfully recorded");
            System.out.println("the current balance "+materialBalance);
        }
        else{
            System.out.println("Error:material usage not successful recorded as remaining materialBalance is not >=2");
        }

    }
    @Override
    public void estimateCost(){

    }
    
    }

    ```
  - *CostEstimation*:
 
  Handles payment and cost tracking of used materials.
  
  Determines the cost per ton:
  
   If materialQuantity is between 5 and 15 tons → cost = 200,000 per ton.
  
   If materialQuantity > 15 tons → cost = 180,000 per ton (bulk discount).

    ```java
    package Assignment_one.Question1;

    public class CostEstimation extends ConstructionMaterial{
    public CostEstimation(String contractorId, String contractorName, double materialQuantity) {
        super(contractorId, contractorName, materialQuantity);
    }
    @Override
    public void receiveMaterial(){
        
    }
    @Override
    public void useMaterial(){

    }
    @Override
    public void estimateCost(){
        double costperton;
        double totalCost;
        if(materialQuantity>5&&materialQuantity<15){
            costperton=200000;

        }else if(materialQuantity>15){
            costperton=180000;
        }else{
            costperton=200000;
        }
        totalCost=materialQuantity*costperton;
        
        System.out.println("the total cost of the material is "+totalCost);
        System.out.println("the contractor id is: "+contractorId);
        System.out.println("the contractor name is: "+contractorName);
        System.out.println("the quantity used: "+materialQuantity);
        System.out.println("the cost per ton is: "+String.format("%,.0f",costperton));
        System.out.println("total cost of materials used: "+String.format("%,.0f",totalCost));

    }
    
    }

    ```

- **Main Class**:

  This main class accepts user inputs (e.g., contractor name, material quantity) and
  Perform validations for quantity ranges as described

 ```java
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
 

 ```

### 🧠 Project Conclusion
This project showcases the fundamental usage of abstract classes and real-world validation techniques. Material handling and financial estimations are modeled effectively, ensuring a smooth construction management flow.

---

# 🏨 Project 2: Hotel Management System (LEMIGO HOTEL)

### 📋 Project Description
This system manages guest reservations, checkouts, and billing for a hotel(LEMIGO HOTEL).

### 🛠️ Features
-Book rooms if stayDays are between 1 and 30.
-Ensure room is available before booking.
-Checkout guests and free up rooms.
-Calculate billing:
  - STANDARD → 50,000 RWF/night
  - DELUXE → 80,000 RWF/night
  - SUITE → 120,000 RWF/night.

### 📦 Classes
- **Abstract Class: HotelService**

  This class serves as a blueprint for handling guest-related services.

  - Abstract Methods:

    - bookRoom()
    - checkoutGuest()
    - generateBill()

  - Common Attributes:

    - guestId (String) – Unique ID of the guest.
    - guestName (String) – Full name of the guest.
    - roomType (String) – Can be either "STANDARD", "DELUXE", or "SUITE".
    - stayDays (int) – Number of days the guest plans to stay.
    - roomStatus (String) – Either "AVAILABLE" or "OCCUPIED".

---

  ```java
 package Assignment_one.Question2;

public abstract class HotelService {
    protected String guestId;
    protected String guestName;
    protected String roomType;
    protected int stayDays;
    protected String roomStatus;

    public HotelService(String guestId, String guestName, String roomType, int stayDays, String roomStatus) {
        this.guestId = guestId;
        this.guestName = guestName;
        this.roomType = roomType;
        this.stayDays = stayDays;
        this.roomStatus = roomStatus;
    }   

    public abstract void bookRoom();
    public abstract void checkoutGuest();
    public abstract void generateBill();

    public String getGuestId() {
        return guestId;
    }
    
    public void setGuestId(String guestId) {
        this.guestId = guestId;
    }
    
    public String getGuestName() {
        return guestName;
    }
    
    public void setGuestName(String guestName) {
        this.guestName = guestName;
    }
    
    public String getRoomType() {
        return roomType;
    }
    
    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }
    
    public int getStayDays() {
        return stayDays;
    }
    
    public void setStayDays(int stayDays) {
        this.stayDays = stayDays;
    }
    
    public String getRoomStatus() {
        return roomStatus;
    }
    
    public void setRoomStatus(String roomStatus) {
        this.roomStatus = roomStatus;
    }


    
}

 ```

- **Concrete Classes:**
  
  - *RoomBooking*:

    Handles room bookings.
    
    Allows booking only if stayDays is between 1 and 30.
    
    Verifies roomStatus == "AVAILABLE" before confirming a booking.

    On successful booking:

       roomStatus is set to "OCCUPIED".

       Confirmation message is printed.

    Displays an error message if booking fails.

    ```java
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

    ```
     
  - *GuestCheckout*:
 
    Handles guest checkout and room release.
    Processes guest checkout only if the room is currently "OCCUPIED".

    Changes roomStatus to "AVAILABLE" after checkout.

    Displays confirmation message for a successful checkout.

    Displays error if room is already available.
 
    ```java
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

    ```
    
  - *Billing*:
 
     -Calculates cost based on roomType and stayDays:

       - "STANDARD" → 50,000 per night

       - "DELUXE" → 80,000 per night

       - "SUITE" → 120,000 per night

     -Displays:

       - Guest Name and ID

       - Room Type and Days Stayed

       - Total Cost in readable format
 
    ```java
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

    ```
 
- **Main Class**:

  Takes guest details and room type via input and
  Performs validations on room status and stay duration.    

 ```java
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


 ```

### 🧠 Project Conclusion
The Hotel Management System reinforces the principles of encapsulation, validation, and real-world logic implementation. It ensures data consistency and a seamless experience for hotel operations.

---

# 🚓 Project 3: Traffic Fine Management System (Rwanda National Police)

### 📋 Project Description
This project helps Rwanda National Police manage traffic violations, assess fines, and handle fine payments effectively.

### 🛠️ Features
-Record new traffic violations.

-Validate violation types (Speeding, Red Light, No Helmet, DUI).

-Process fine payments and update statuses.

-Assess fines:
  - SPEEDING → 50,000 RWF
  - RED_LIGHT → 80,000 RWF
  - NO_HELMET → 30,000 RWF
  - DUI → 150,000 RWF


### 📦 Classes
- **Abstract Class: TrafficRecord**

  Serves as a blueprint for handling traffic-related operations.

  - Abstract Methods:

    - recordViolation()
    - assessFine()
    - processPayment()

  - Common Attributes:

    - driverId (String) – National ID or driving license number.
    - driverName (String)
    - vehiclePlate (String) – Vehicle registration plate.
    - violationType (String) – e.g., "SPEEDING", "RED_LIGHT", "NO_HELMET", etc.
    - fineAmount (double)
    - paymentStatus (String) – "UNPAID" or "PAID"

---

 ```java
 package Assignment_one.Question3;

public abstract class TrafficRecord {
    protected String driverId;
    protected String driverName;
    protected String vehiclePlate;
    protected String violationType;
    protected double fineAmount;
    protected String paymentStatus;

    public TrafficRecord(String driverId,String driverName,String vehiclePlate, String violationType,double fineAmount,String paymentStatus){
        this.driverId=driverId;
        this.driverName=driverName;
        this.vehiclePlate=vehiclePlate;
        this.violationType=violationType;
        this.fineAmount=fineAmount;
        this.paymentStatus=paymentStatus;

    }

    public abstract void recordViolation();
    public abstract void assessFine();
    public abstract void  processPayment();

    public String getDriverId() {
        return driverId;
    }
    
    public void setDriverId(String driverId) {
        this.driverId = driverId;
    }
    
    public String getDriverName() {
        return driverName;
    }
    
    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }
    
    public String getVehiclePlate() {
        return vehiclePlate;
    }
    
    public void setVehiclePlate(String vehiclePlate) {
        this.vehiclePlate = vehiclePlate;
    }
    
    public String getViolationType() {
        return violationType;
    }
    
    public void setViolationType(String violationType) {
        this.violationType = violationType;
    }
    
    public double getFineAmount() {
        return fineAmount;
    }
    
    public void setFineAmount(double fineAmount) {
        this.fineAmount = fineAmount;
    }
    
    public String getPaymentStatus() {
        return paymentStatus;
    }
    
    public void setPaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus;
    }
}
    


 ```

- **Concrete Classes:**
  
  - *ViolationEntry*:
 
    Handles recording of new traffic violations.
    
    Accepts a traffic violation report for a given driver.
    
    Validates that violationType is one of the allowed types.
    
    Sets paymentStatus = "UNPAID" initially.
    
    Prints a confirmation with violation details.

  ```java
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

  ```
  
  - *FineAssessment*:
 
    Calculates fines based on the severity and violation type.
    
    Determines the fine amount based on the violation type:

      - "SPEEDING" → 50,000 RWF

      -  "RED_LIGHT" → 80,000 RWF

      -  NO_HELMET" → 30,000 RWF

      -  "DUI" → 150,000 RWF

    if the violation is unrecognized, displays an error.
    
    Sets the fineAmount accordingly.

    Displays the fine to be paid with driver and violation details.
 
    ```java
    package Assignment_one.Question3;

    public class FineAssessment extends TrafficRecord {
    public FineAssessment(String driverId,String driverName,String vehiclePlate, String violationType,double fineAmount,String paymentStatus){
        super(driverId,driverName,vehiclePlate, violationType,fineAmount,paymentStatus);
    }
    @Override
    public void recordViolation(){
        
    }
    @Override
    public void assessFine(){
        switch (violationType.toUpperCase()) {
            case "SPEEDING":
                fineAmount = 50000;
                break;
            case "RED_LIGHT":
                fineAmount = 80000;
                break;
            case "NO_HELMET":
                fineAmount = 30000;
                break;
            case "DUI":
                fineAmount = 150000;
                break;
            default:
                System.out.println("Error: Invalid violation type.");
            return;
        }
        System.out.println("Fine assessment recorded successfully");
        System.out.println("Driver ID: "+driverId);
        System.out.println("Driver Name: "+driverName);
        System.out.println("Vehicle Plate: "+vehiclePlate);
        System.out.println("Violation Type: "+violationType);
        System.out.println("Fine amount to be paid: "+fineAmount);

    }
    @Override
    public void  processPayment(){

    }


    
    }

    ```
    
  - *FinePayment*:
 
    Handles payment processing and updates payment status.
    Allows payment only if paymentStatus == "UNPAID".

    On successful payment:

     - Updates paymentStatus = "PAID".

     - Displays receipt: Driver name, vehicle plate, paid amount, and payment status.

    Displays an error if payment is attempted on an already paid fine.
 
    ```java
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

    ```
- **Main Class**:

  It includes Sample Validations and Input Handling:

    - violationType must match allowed entries. Use equalsIgnoreCase().

    - National ID must be exactly 16 digits (if used as driverId).

    - Plate number should follow format (e.g., RAB123D).

    - Prevent payment if the fine is already marked as "PAID".

    - Accept and validate user input via Scanner

  ```java
  
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

  ```

### 🧠 Project Conclusion
This Traffic Fine Management System highlights the power of abstraction and input validation. It simulates real-world procedures in law enforcement and streamlines violation tracking and payment management.

---

### 🎯 Overall Conclusion
These three case studies demonstrate the flexibility and strength of Object-Oriented Programming in solving real-world problems.
Through abstract classes, inheritance, encapsulation, and proper input validation, we have designed structured, scalable, and maintainable systems.
Each project addresses specific challenges in different domains (Construction, Hospitality, and Law Enforcement), showcasing the versatility of Java and solid programming principles.

---
