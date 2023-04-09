#include "vending_machine.h"
#include <iostream>
#include <sstream>

void Vending_machine::add(const std::string& name, int price) {
    items_.emplace_back(name, price);
}

void Vending_machine::buy(int index) const {
    std::cout << "\n#### Buying " << items_[index].to_string() << std::endl;
}

std::string Vending_machine::menu() const {
    std::ostringstream out;
    out << "\n======================\nWelcome to UTA Vending\n======================\n";
    for (int i = 0; i < items_.size(); ++i) {
        out << i << ": " << items_[i].to_string() << "\n";
    }
    return out.str();
}
