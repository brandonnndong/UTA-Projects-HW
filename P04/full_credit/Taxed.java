public class Taxed extends Product{
    public Taxed(double cost, String name, int num){
        super();
        this.cost = cost;
        this.name = name;
        this.num = num;
    }
    
    /*public static double salesTaxRate = 0;
    public static double setTaxRate(double salesTax){
        return setTaxRate(salesTax);
    }*/
    
    @Override
    public double price(){
        return cost /*(1 + salesTaxRate)*/;
    }
    //private ArrayList<Product> products = new ArrayList<>();
 }