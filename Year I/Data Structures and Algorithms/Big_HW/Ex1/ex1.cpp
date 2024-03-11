#include <iostream>
#include "../Ex1/brackets.h"
using namespace std;

int main()
{
    Stack<char> s;
    int ok = 0;
    int n = 0;
    char x;
    cout<<"Enter total number of brackets: "<<endl;
    cin>> n;
    char arr[n];
    cout<<"Enter bracket sequence:"<<endl;
   
    for(int i = 0; i < n;i++)
        cin>>arr[i];
    if(n%2==1)
        ok=1;
    else
    {
        for(int i = 0; i < n;i++)
        {
            if(arr[i] == '{' || arr[i] == '[' || arr[i] == '(')
                s.push(arr[i]);
            if(s.isEmpty())
                ok=1;
            switch (arr[i])
            {
                case ')':
                    x=s.peek();
                    s.pop();
                    if(x=='{' || x=='[')
                        ok=1;
                    break;

                case ']':
                    x=s.peek();
                    s.pop();
                    if(x=='{' || x=='(')
                        ok=1;
                    break;

                case '}':
                    x=s.peek();
                    s.pop();
                    if(x=='(' || x=='[')
                        ok=1;
                    break;

                default:
                    break;
            }          
        }    
    }
    if(ok==0)
        cout<<"TRUE";
    else cout<<"FALSE";
}