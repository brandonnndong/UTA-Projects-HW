#ifndef VENDING_MACHINE_H
#define VENDING_MACHINE_H

#include <vector>
#include "item.h"

class Vending_machine {
    private:
        std::vector<Item> _items;

    public:
        void add(std::string name, int price);
        void buy(int index) const;
        std::string menu() const;
};

#endif
