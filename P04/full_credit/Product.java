abstract class Product{
    protected double cost;
    protected String name;
    protected int num;

    public void product(double cost, String name, int num){
        this.cost = cost;
        this.name = name;
        this.num = num;

    }
    
    public abstract double price();

    @Override
    public String toString(){
        StringBuilder result = new StringBuilder("\n" + num + ") " + name + 
        " ($" + cost + ") "+ "\t\t\t" + "$" + price());
        return result.toString();
    }
    
}