/*
    Quang Minh Dong
    INSY - 4305 - 004
    10/17/2024
*/    

// Abstract class called Ship that implements displayable
public abstract class Ship implements Displayable{

    // Fields
    private String name;
    private String year;

    // Constructor 
    public Ship(String name, String year){
        this.name = name;
        this.year = year;
    }

    // Mutators
    public void setName(String name){
        this.name = name;
    }
    public void setYear(String year){
        this.year = year;
    }

    // Accessors
    public String getName(){
        return name;
    }
    public String getYear(){
        return year;
    }

    // Override the toString method to display ship name and year
    @Override
    public String toString(){
        return "Ship name: " + name + 
                    "| Year: " + year;
    }

    // Implemented from Displayable to display ship name and year
    @Override
    public void display(){
        System.out.println(toString());
    }
}