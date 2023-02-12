public class Taxfree extends Product{
    public Taxfree(double cost, String name, int num){
        super();
        this.cost = cost;
        this.name = name;
        this.num = num;
    }

    @Override
    public double price(){
        return cost;
    }
    //private ArrayList<Product> products = new ArrayList<>();
}
