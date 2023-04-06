#include <iostream>
#include "Vending_machine.h" // assuming the Vending_machine class is defined in a separate header file

int main() {
    Vending_machine vending_machine;
    vending_machine.add("Oreos", 189); // $1.89
    vending_machine.add("Doritos", 199); // $1.99
    
    std::cout << vending_machine.menu() << std::endl;
    
    vending_machine.buy(1); // buy Doritos (index 1)
    
    std::cout << vending_machine.menu() << std::endl;
    
    return 0;
}
