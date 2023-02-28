import java.util.ArrayList;

public class Order extends Store{
    public Order(Customer customer){
        super(name);
        this.orderNumber = nextOrderNumber++;
        this.customer = customer;
    }
    
    public void addComputer(Computer computer){
        customer.add(computer);
    }

    public String toString(){
        return "Order " + orderNumber + " for " + name + " (" + Customer.email + ")"; 
    }

    public boolean equals(Object o){
        if(this == o) return true;
        if(o == null || computer != o.computer || customer != o.customer) return false;
        return equals(o);

    }
    
    private Customer customer;
    private ArrayList<Computer> computer = new ArrayList<>();//fix

    private static long nextOrderNumber = 0;
    private long orderNumber;
}