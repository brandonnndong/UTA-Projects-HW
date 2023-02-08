public class Taxfree extends Product{
    public void Taxfree(String name, double cost){
        super(name, cost);
    }

    @Override
    public double price(){
        return cost;
    }

