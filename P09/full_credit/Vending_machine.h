// Vending_machine.h
#ifndef VENDING_MACHINE_H
#define VENDING_MACHINE_H

#include <string>
#include <vector>
#include "Item.h"

class Vending_machine {
public:
void add(std::string name, double price, int quantity);
void buy(int index);
std::string menu();
private:
std::vector<Item> items;
};

#endif // VENDING_MACHINE_H