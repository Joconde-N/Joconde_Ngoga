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
