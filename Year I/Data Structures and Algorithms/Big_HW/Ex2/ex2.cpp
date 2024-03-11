DoubleDew
#4381
memento mori

Tanner_90 — Today at 11:37 AM
odata
Tanner_90 — Today at 2:54 PM
#include <iostream>
#include "queuecirc.h"
using namespace std;
float arrf[50], arrd[50];

void canGo(int index, int n, int fc)
Expand
exercitiu2.cpp
2 KB
You missed a call from 
Tanner_90
 that lasted a few seconds.
 — Today at 8:15 PM
DoubleDew — Today at 8:16 PM
incearca sa faci 2-ul
ca pe 3
ma ajuta un fost coleg
Tanner_90 — Today at 8:17 PM
pai da mi ce ai
modificat
DoubleDew — Today at 8:17 PM
intr-o ora asa
Tanner_90 — Today at 8:17 PM
ca poate ai facut mai bine
DoubleDew — Today at 8:17 PM
îți dau dar :))))
sa nu ai incredere
double triple check
Tanner_90 — Today at 8:17 PM
da-l aici sa fie
drq
DoubleDew — Today at 8:19 PM
#include <iostream>
#include "queuecirc.h"
using namespace std;

int main()
{
Expand
ex2.cpp
2 KB
asta am facut cu adi
nu prea m-a lamurit tbh
Tanner_90 — Today at 9:09 PM
vezi ca
am facut 3
muie
DoubleDew — Today at 9:09 PM
de ce 3
cand
il faceam oricum eu
coaie
ojdasjdioasjd
heavy of head
Tanner_90 — Today at 9:13 PM
danut
fa read me ul
fmm
ca lasam asa
3 e facut bine verificat
si 2 spunem cum l am gandit sa luam partial
punctaj
#include <iostream>
#include "list.h"
using namespace std;

string findRoadIntersection(LinkedList<string> l1, LinkedList<string> l2){
    int y = 0;
Expand
exercitiu3v2.cpp
2 KB
DoubleDew — Today at 9:28 PM
pai ce facem cu 3-ul?
ti-l dau pe al meu
Tanner_90 — Today at 9:28 PM
nu
DoubleDew — Today at 9:28 PM
sau pe al tau
Tanner_90 — Today at 9:28 PM
il folosim pe al meu
DoubleDew — Today at 9:29 PM
hmmm
DoubleDew — Today at 9:39 PM
fine
yours sa fie
si
pui tu
?
Tanner_90 — Today at 9:48 PM
ce
sa pun
vino pe server
Tanner_90 — Today at 10:33 PM
#include <iostream>
#include "queuecirc.h"
using namespace std;

int main()
{
Expand
exercitiu2.cpp
2 KB
﻿
#include <iostream>
#include "queuecirc.h"
using namespace std;

int main()
{
    QueueCirc<float> f;
    QueueCirc<float> d;
    int index = 0;
    int n;
    float fu;
    float dp;
    int z;
    cout<<"Enter number of petrol stations: "<<endl;
    cin>>n;
    int y = 0;
    int fc;
    cout<<"Enter fuel consumption: "<<endl;
    cin>>fc;

    cout<<"Enter fuel at station and distance to next station:"<<endl;
    int fuel, dist;
    for(int i = 0; i < n; i++)
    {
        cin>>fuel;
        f.enqueue(fuel);
        cin>>dist;
        d.enqueue(dist);
    }

    for(int i = 0; i < n; i++)
    {
     y=1;
    fu = f.peek();
    z = 0;
    while(z < n)
    {
       
        dp = (float) (fu * 100 ) / fc;
        if( dp >= d.peek())
        {
                fu = fu - (fc * dp) / 100;
                f.enqueue(f.dequeue());
                fu += f.peek();
                d.enqueue(d.dequeue());
                
                y++;
        }
        if(y == n)
        {    index=i;
            cout<<index;}
       z++;
       f.enqueue(f.dequeue());
       d.enqueue(d.dequeue());
    }
    
    }
    cout<<index;
    return 0;
}