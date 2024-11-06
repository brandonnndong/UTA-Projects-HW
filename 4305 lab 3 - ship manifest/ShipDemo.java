/*
    Quang Minh Dong
    INSY - 4305 - 004
    10/17/2024
*/ 

import java.util.ArrayList;

// ShipDemo class to display the varying ships 
public class ShipDemo {
    public static void main(String[] args) {

        // Cruise and Cargo ship objects
        CruiseShip cruiseShip1 = new CruiseShip("Carnival", "2000", 3500);
        CruiseShip cruiseShip2 = new CruiseShip("Royal Caribbean", "2015", 5000);
        CruiseShip cruiseShip3 = new CruiseShip("Disney Dream", "2018", 5600);
        CargoShip cargoShip1 = new CargoShip("Maersk", "1995", 20000);
        CargoShip cargoShip2 = new CargoShip("MSC", "2010", 15000);
        CargoShip cargoShip3 = new CargoShip("CMC", "2020", 220000);

        // Array for Ship objects
        Ship[] shipsArray = new Ship[3];
        
        // Assigns ship objects to array
        shipsArray[0] = cruiseShip1;
        shipsArray[1] = cruiseShip2;
        shipsArray[2] = cargoShip1;
        
        System.out.println("\nShip information (array):");
        System.out.println("-----------------------------------------------------------------");
        // For loop to step through the array, calling each object's display() method
        for (Ship ship : shipsArray) {
            ship.display();  
        }
        
        // ArrayList for Ship objects
        ArrayList<Ship> shipsList = new ArrayList<>();
        
        // Adding ship objects to the ArrayList
        shipsList.add(cruiseShip3);
        shipsList.add(cargoShip2);
        shipsList.add(cargoShip3);
        
        System.out.println("\nShip information (ArrayList):");
        System.out.println("-----------------------------------------------------------------");
        // For loop to step through the arraylist, calling each object's toString() method
        for (Ship ship : shipsList) {
            System.out.println(ship);  
        }

        // Objects created from copy constructor
        CruiseShip cruiseShipCopy = new CruiseShip(cruiseShip1);
        CargoShip cargoShipCopy = new CargoShip(cargoShip1);

        // Copy constructor test prints
        System.out.println("\nCopy constructor test: ");
        System.out.println("-----------------------------------------------------------------");
        System.out.println(cruiseShipCopy);
        System.out.println(cargoShipCopy);
    
    }
}
