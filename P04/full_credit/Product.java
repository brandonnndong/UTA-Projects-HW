abstract class Product{
    protected double cost;
    protected String name;
    private int iNum;
    private static int inumber = 1;

    public void product(double cost, String name){
        this.iNum = inumber++;

        this.cost = cost;
        this.name = name;
    }
    public abstract double price();

    @Override
    public String toString(){
        return "\n" + this.iNum + ") " + name + " (" + cost + ")\t\t" + price();
    }
}