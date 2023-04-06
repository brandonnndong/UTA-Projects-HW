#include "Vending_machine.h"
#include <iostream>

void Vending_machine::add(std::string name, double price, int quantity) {
Item item(name, price, quantity);
items.push_back(item);
}

void Vending_machine::buy(int index) {
std::cout << "#### Buying " << items[index].get_name() << std::endl;
items[index].set_quantity(items[index].get_quantity() - 1);
}

std::string Vending_machine::menu() {
std::string result;
for (int i = 0; i < items.size(); i++) {
result += std::to_string(i) + ": " + items[i].get_name() + " ($" + std::to_string(items[i].get_price()) + ")\n";
}
return result;
}