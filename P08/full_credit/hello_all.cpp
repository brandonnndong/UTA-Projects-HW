#include <iostream>

using namespace std;

int main(){
    string name;
    cout << "What is your name?";   //ask for name
    getline (cin, name);    //grab name
    cout << "Hello there, " << name << "!" << endl;     //prints name
    return 0;
}