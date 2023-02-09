 public class Taxed extends Product{
    public Taxed(double cost, String name){
        super();
        this.cost = cost;
        this.name = name;
    }

    @Override
    public double price(){
        return cost; //* (1 + salesTaxRate);
    }

    //private static int tax = 0;
    //public static double setTaxRate(double salesTax);
 }