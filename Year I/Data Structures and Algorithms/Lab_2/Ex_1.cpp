#include <iostream>
using namespace std;

void swap(double &a, double &b)
{
    int aux = a;
    a = b;
    b = aux;
}

void sort(double v[], double n)
{
    for(int i=0;i<n;i++)
        for(int j=0;j<n-i-1;j++)
            if(v[i] > v[j+1])
                swap(v[j], v[j+1]);
}

int main()
{
    double v[5];
    for(int i=0;i<5;i++)
        cin>>v[i];
    sort(v, 5);
    for(int i=0;i<5;i++)
        cout<<v[i]<<" ";
    return 1;
}