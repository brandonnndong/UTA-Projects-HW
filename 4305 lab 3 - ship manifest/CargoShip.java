/*
    Quang Minh Dong
    INSY - 4305 - 004
    10/17/2024
*/ 

// CargoShip class that extends Ship 
public class CargoShip extends Ship{
    
    // integer field for cargo capacity (tons) on the ship
    private int cargoCap;

    // Constructor that implements fields from Ship
    public CargoShip(String name, String year, int cargoCap){
        super(name, year);
        this.cargoCap = cargoCap;
    }
    // Copy Constructor that calls the superclass (Ship)
    public CargoShip(CargoShip cargoShip) {
        super(cargoShip.getName(), cargoShip.getYear());
        this.cargoCap = cargoShip.cargoCap;
    }

    // Mutator
    public void setMax(int cargoCap){
        this.cargoCap = cargoCap;
    }

    // Accessor
    public int getMax(){
        return cargoCap;
    }

    // Override the toString method to display the ship name, year, and cargo capacity
    @Override
    public String toString(){
        return "Cargo Ship name: " + getName() + 
                        " | Year: " + getYear() + 
                        " | Cargo Capacity: " + cargoCap + " tons";
    }

    // Implemented from Displayable to display ship name and year
    @Override
    public void display(){
        System.out.println(toString());
    }
}
