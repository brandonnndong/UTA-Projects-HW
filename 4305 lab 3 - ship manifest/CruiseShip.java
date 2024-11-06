/*
    Quang Minh Dong
    INSY - 4305 - 004
    10/17/2024
*/   

// CruiseShip class that extends Ship
public class CruiseShip extends Ship{
    
    // integer field for max passengers
    private int maxPass;

    // Constructor that implements fields from Ship
    public CruiseShip(String name, String year, int maxPass){
        super(name, year);
        this.maxPass = maxPass;
    }
    // Copy Constructor that calls the superclass (Ship)
    public CruiseShip(CruiseShip cruiseShip) {
        super(cruiseShip.getName(), cruiseShip.getYear());
        this.maxPass = cruiseShip.maxPass;
    }

    //Mutator
    public void setMax(int maxPass){
        this.maxPass = maxPass;
    }
    
    // Accessor
    public int getMax(){
        return maxPass;
    }

    // Override the toString method to display the ship name, year, and max passengers
    @Override
    public String toString(){
        return "Cruise Ship name: " + getName() + 
                        " | Year: " + getYear() + 
                        " | Max Passengers: " + maxPass;
    }

    // Implemented from Displayable to display ship name and year
    @Override
    public void display(){
        System.out.println(toString());
    }
}
