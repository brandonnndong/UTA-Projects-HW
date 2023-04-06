CXXFLAGS = --std=c++17

info:
	@echo
	@printf 'Type e.g., "make auto"  to create program "auto" from auto.cpp\n'
	@printf 'Type       "make all"   to create every program\n'
	@printf 'Type       "make clean" to delete every program\n\n'

read: Item.cpp
	-$(CXX) $(CXXFLAGS) -o Item Item.cpp
	@printf "Now type ./Item to execute the result\n\n"

stringstreams: Vending_machine.cpp
	-$(CXX) $(CXXFLAGS) -o Vending_machine Vending_machine.cpp
	@printf "Now type ./Vending_machine to execute the result\n\n"

write: write.cpp
	-$(CXX) $(CXXFLAGS) -o Vend Vend.cpp
	@printf "Now type ./Vend to execute the result\n\n"

all:  Item Vending_machine Vend

clean:
	rm -f *.o *.gch a.out  Item Vending_machine Vend test.txt
