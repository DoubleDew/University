#include <iostream>
using namespace std;
#define NMAX 50

template<typename T>
class Stack
{
    private: 
        int topLevel; 
                    
    public:
        T stackArray[NMAX];
        
        void push(T x){
            if (topLevel >= NMAX-1) {
                cout << "The stack is full: we have already NMAX elements!\n";
                return;
            }
            stackArray[++topLevel] = x;
        }

        int isEmpty()
        {
            return (topLevel < 0);
        }

        T pop()
        {
            if (isEmpty())
            {
                cout << "The stack is empty! \n";
                T x;
                return x;
            }
            return stackArray[topLevel--]; 	
        }

        T peek()
        {
            if (isEmpty())
            {
                cout << "The stack is empty! \n";
                T x;
                return x;
        	}
            return stackArray[topLevel];
        }

        int getTopLevel()
        {
            return topLevel;
        }

        void printStack()
        {
            for(int i = (topLevel); i >= 0; i--)
                cout << stackArray[i] << " ";
            cout << endl;
        }

        Stack()
        { 
            topLevel = -1;
        }

        ~Stack(){}
};