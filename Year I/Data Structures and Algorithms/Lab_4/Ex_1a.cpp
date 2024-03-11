#include <iostream>
using namespace std;
#include "C:\Users\mdeac\Desktop\Programming\C & C++\Lab_4\queue.h"

int main()
{
    Queue<int> q;
    q.enqueue(3);
    cout << q.peek() << endl;
    q.enqueue(4);
    q.enqueue(7);
    cout << q.peek() << endl;
    q.dequeue();
    cout << q.peek() << endl;
    q.enqueue(8);
    cout << q.peek();
    return 0;
}