#include <iostream>
#include <string>

int main(int args, char* argv[]) {
    std::string prev;
    for (int i = 1; i < args; i++) {    //for loop that compares the string of words
        std::string arg(argv[i]);       //from the current to the previous string
        if (arg != prev) {              //where if they aren't the same they don't print
            std::cout << arg << " ";    //vice versa
            prev = arg;
        }
    }
    std::cout << std::endl;
    return 0;
}
