#include "Item.h"
#include <stdexcept>

Item::Item(std::string name, double price) : name(name), price(price) {
if (price < 0) {
throw std::runtime_error("Item price cannot be negative!");
}
}

std::string Item::get_name() const {
return name;
}

double Item::get_price() const {
return price;
}

std::string Item::to_string() const {
std::string result = name + " ($" + std::to_string(price / 100) + ".";

int cents = static_cast<int>(price) % 100;
if (cents < 10) {
    result += "0";
}

result += std::to_string(cents) + ")";
return result;
