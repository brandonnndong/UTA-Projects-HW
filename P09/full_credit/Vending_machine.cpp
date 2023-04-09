#include "vending_machine.h"
#include <iostream>

void Vending_machine::add(std::string name, int price) {
    Item item(name, price);
    _items.push_back(item);
}

void Vending_machine::buy(int index) const {
    std::cout << "\n#### Buying " << _items[index].to_string() << std::endl;
}

std::string Vending_machine::menu() const {
    std::string result = "\n======================\nWelcome to UTA Vending\n======================\n";
    for (unsigned int i = 0; i < _items.size(); i++) {
        result += std::to_string(i) + ". " + _items[i].to_string() + "\n";
    }
    return result;
}
