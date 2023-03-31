#include <iostream>
#include <vector>

int main(){
    std::vector<int> num;
    int input;
    while (std::cin >> input){
        num.push_back(input);
    }

    std::cout << "Number of elements: " << num.size() << std::endl;

    std::cout << "Elements: ";
    for (int n : num){
        std::cout << n << " ";
    }
    std::cout << std::endl;

    std::cout << "Even indices: ";
    for (int n : num){
        if (n % 2 == 0){
            std::cout << n << " ";
        }
    }
    std::cout << std::endl;

    std::cout << "Odd indices: ";
    for (int n : num){
        if (n % 2 != 0){
            std::cout << n << " ";
        }
    }
    std::cout << std::endl;

    return 0;
}
