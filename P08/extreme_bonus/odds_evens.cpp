#include <iostream>
#include <vector>

int main(){
    std::vector<int> num;
    int input;

    while (std::cin >> input){
        num.push_back(input);
    }

    int n = num.size();

    //number of elements stored
    std::cout << "Number of elements: " << n << std::endl;

    //elements that are stored
    std::cout << "Elements: ";
    for (int i = 0; i < n; i++){
        std::cout << num[i] << " ";
    }
    std::cout << std::endl;

    //elements stored with an even index
    std::cout << "Elements with even index: ";
    for (int i = 0; i < n; i += 2) {
        std::cout << num[i] << " ";
    }
    std::cout << std::endl;
    
    //elements stored with an odd index
    std::cout << "Elements with odd index: ";
    for (int i = 1; i < n; i += 2) {
        std::cout << num[i] << " ";
    }
    std::cout << std::endl;

    return 0;
}
