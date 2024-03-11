#include <iostream>
using namespace std;
#include "C:\Users\mdeac\Desktop\Programming\C & C++\Lab_4\queue.h"

int main()
{
    QueueCirc<int> qC;
    qC.enqueue(5);
    cout << qC.peek() << endl;
    qC.enqueue(4);
    qC.enqueue(8);
    qC.dequeue();
    cout << qC.peek();
    return 0;
}