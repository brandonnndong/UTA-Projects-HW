#ifndef ITEM_H
#define ITEM_H

#include <string>

class Item {
public:
Item(std::string name, double price);
std::string get_name() const;
double get_price() const;
std::string to_string() const;
private:
std::string name;
double price;
};

#endif // ITEM_H