#include <iostream>
#include "list.h"
using namespace std;

string findRoadIntersection(LinkedList<string> l1, LinkedList<string> l2){
    int y = 0;
    int z;
    Node<string>* pfirst1 = l1.pfirst;
    Node<string>* pfirst2 = l2.pfirst;
    while(y < l1.getSize()){
        z=0;
        
        while(z < l2.getSize()){
            if(pfirst1->info == pfirst2->info )
            {    
                return pfirst1->info;
            }
            else pfirst2 = pfirst2->next;
            z++;
        }
        pfirst1 = pfirst1->next;
        pfirst2 = l2.pfirst;
        y++;
    }
    
}

int main(){
    LinkedList<string> l1;
    LinkedList<string> l2;
    l1.addLast("Alexandria");
    l1.addLast("Athens");
    l1.addLast("Tomis");
    l1.addLast("Sarmizegetusa");
    l1.addLast("Aquilea");
    l1.addLast("Rome");

    l2.addLast("Napoca");
    l2.addLast("Sarmizegetusa");
    l2.addLast("Aquilea");
    l2.addLast("Rome");

    cout<<findRoadIntersection(l1, l2);
}