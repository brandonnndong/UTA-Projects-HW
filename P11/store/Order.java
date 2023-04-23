package store;

import java.util.ArrayList;
import java.util.Objects;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;

public class Order {
    public Order(Customer customer) {
        this.customer = customer;
        this.orderNumber = nextOrderNumber++;
    }
    public Order(BufferedReader br) throws IOException {
        this.orderNumber = Long.parseLong(br.readLine());
        if(nextOrderNumber <= orderNumber) nextOrderNumber = orderNumber + 1;
        this.customer = new Customer(br);
        int numOptions = Integer.parseInt(br.readLine());
        while(numOptions-- > 0)
            computers.add(new Computer(br));
    }
    public void save(BufferedWriter bw) throws IOException {
        bw.write(Long.toString(orderNumber) + '\n');
        this.customer.save(bw);
        bw.write(computers.size() + '\n');
        for(Computer computer : computers)
            computer.save(bw);
    }
    
    public void addComputer(Computer computer) {
        computers.add(computer);
    }

    public double cost() {
        double totalCost = 0;
        for (Computer computer : computers) {
            totalCost += computer.cost();
        }
        return totalCost;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Order " + orderNumber + " for " + customer + "\n\n");
        for(Computer c : computers) {
            sb.append(c.toString() + "\n");
        }
        sb.append("\nTotal cost: $" + cost());
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        try {
            if(this == o) return true;
            if(this.getClass() != o.getClass()) return false;
            Order c = (Order) o;
            if(!this.customer.equals(c.customer)) return false;
            if(this.computers.size() != c.computers.size()) return false;
            for(int i=0; i<this.computers.size(); ++i)
                if(!this.computers.get(i).equals(c.computers.get(i))) return false;
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public int hashCode(){
        int hash = 17;
        hash = 31 * hash + Objects.hashCode(customer);
        hash = 31 * hash + Objects.hashCode(orderNumber);
        hash = 31 * hash + Objects.hashCode(computers);
        hash = 31 * hash + Objects.hashCode(nextOrderNumber);
        return hash;
    }

    private Customer customer;
    private long orderNumber;
    private ArrayList<Computer> computers = new ArrayList<>();
    
    private static long nextOrderNumber = 0;
}
