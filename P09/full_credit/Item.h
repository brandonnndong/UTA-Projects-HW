#ifndef ITEM_H
#define ITEM_H

#include <string>
#include <stdexcept>

class Item {
public:
    Item(const std::string& name, int price);

    std::string to_string() const;

private:
    std::string name_;
    int price_;
};

#endif
