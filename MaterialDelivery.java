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
