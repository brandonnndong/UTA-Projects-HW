public class Taxfree extends Product{
    public Taxfree(double cost, String name){
        super();
        this.cost = cost;
        this.name = name;
    }

    @Override
    public double price(){
        return cost;
    }
}
