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
