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
