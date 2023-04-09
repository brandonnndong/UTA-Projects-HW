#include "item.h"
#include <stdexcept>

Item::Item(std::string name, int price) {
    if (price < 0) {
        throw std::runtime_error("Price cannot be negative");
    }
    _name = name;
    _price = price;
}

std::string Item::to_string() const {
    return _name + " ($" + std::to_string(_price / 100) + "." + std::to_string(_price % 100) + ")";
}
