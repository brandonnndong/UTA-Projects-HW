#include <iostream>
#include <string>

int main(int args, char* argv[]) {
    std::string prev_arg;
    for (int i = 1; i < args; i++) {
        std::string arg(argv[i]);
        if (arg != prev_arg) {
            std::cout << arg << " ";
            prev_arg = arg;
        }
    }
    std::cout << std::endl;
    return 0;
}
