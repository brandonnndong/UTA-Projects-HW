 public class Taxed extends Product{
    public void taxed(String name, double cost){
        super(name, cost);
    }

    @Override
    public double price(){
        return cost * (1 + salesTaxRate);
    }

    private static tax = 0;
    public static double setTaxRate(double salesTax);
 }