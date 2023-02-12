public class Taxed extends Product{
    public static double salesTaxRate = Double.NaN;
    
    public Taxed(double cost, String name, int num){
        super();
        this.cost = cost;
        this.name = name;
        this.num = num;
    }

    public static double setTaxRate(double salesTaxRate){
        return salesTaxRate;
    }

    @Override
    public double price(){
        return cost * (1 + salesTaxRate);
    }
 }