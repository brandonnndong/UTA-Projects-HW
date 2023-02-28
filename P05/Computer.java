import java.util.ArrayList;

public class Computer extends Store{
    public Computer(String name, String model){
        super(name);
        this.model = model;
        Computer.options = new ArrayList<>();
    }

    public void addOption(Option option){
        options.add(option);
    }

    public static long cost(){
        long cost = 0;
        for(Option o: options){
           cost += o.cost();
        }
        return cost;
    }
    
    public String toString(){
        return name + model + "\n" + "\tMainboard" + " (" + Computer.cost() / 100.0 + ") " +
            "\n" + "\tRAM" + " (" + Computer.cost() / 100.0 + ") " +
            "\n" + "\tSSD" + " (" + Computer.cost() / 100.0 + ") " +
            "\n" + "\tCse" + " (" + Computer.cost() / 100.0 + ") ";
    }

    public boolean equals(Object o){
        if(this == o) return true;
        if(o == null || toString() != o.toString()) return false;
        return equals(o);
    }
    
    private String name;
    private String model;
    private static ArrayList<Option> options;
}