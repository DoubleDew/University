#include <iostream>
#include <stdlib.h>
#include "hash.h"
#include <iostream>
#define VMAX 17
#define P 13

using namespace std;

int hfunc(string key)
{
    int hkey = 0;
    string num;
    for(int i = key.length() - 4; i < key.length; i++)
        num += key[i];
    
    hkey = stoi(num);
    hkey = (hkey - 400) * 1.6694;
    
    return hkey;
}

Hashtable<string, double> hid(VMAX, hfunc);

int main()
{
    hid.put("5000910019990", 10);
    cout<<"Value of a certain key (5000910019990): " << hid.get("5000910019990");

    return 0;
}