CXXFLAGS = --std=c++17

all: Vend

Vend: Vend.o Item.o Vending_machine.o
	g++ $(CXXFLAGS) -o Vend Vend.o Item.o Vending_machine.o
	@printf 'Now type ./vend to execute the vending_machine\n'

Vend.o: Vend.cpp item.h vending_machine.h
	g++ $(CXXFLAGS) -c Vend.cpp

Item.o: item.cpp item.h
	g++ $(CXXFLAGS) -c item.cpp

Vending_machine.o: vending_machine.cpp vending_machine.h item.h
	g++ $(CXXFLAGS) -c vending_machine.cpp

clean:
	rm -f *.o *.gch *~ a.out Vend
