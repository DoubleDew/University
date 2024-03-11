#include <iostream>
#include "C:\Users\mdeac\Desktop\Programming\C & C++\Lab_3\Stack.h"
using namespace std;

int main(){
    Stack <int> s;
    s.isEmpty();
    s.push(3);
    s.push(5);
    s.push(8);
    s.pop();
    s.push(6);
    s.printStack();
    return 0;
}