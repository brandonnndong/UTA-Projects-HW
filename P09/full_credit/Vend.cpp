#include "vending_machine.h"
#include <iostream>

int main() {
    Vending_machine vm;

    vm.add("Puntini", 189);
    vm.add("Dr. Pepper", 249);

    std::cout << vm.menu();
    
    vm.buy(1);
    return 0;
}
