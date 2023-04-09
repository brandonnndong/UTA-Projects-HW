#include "item.h"
#include <sstream>

Item::Item(const std::string& name, int price) : name_(name), price_(price) {
    if (price < 0) {
        throw std::runtime_error("Price cannot be negative.");
    }
}

std::string Item::to_string() const {
    std::ostringstream out;
    out << name_ << " ($" << price_ / 100 << "." << price_ % 100 << ")";
    return out.str();
}
