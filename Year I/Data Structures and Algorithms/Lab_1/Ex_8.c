#include <stdio.h>

int relativelyPrime(int a, int b)
{
    int gcd;
    for(int i = 1; i < a; i++)
        if(a%i==0 && b%i==0)
            gcd = i;
    if(gcd == 1)
        printf("%i and %i are relatively prime", a, b);
    else
        printf("%i and %i are not relatively prime", a, b);
    return 1;
}

int main()
{
    int a, b;
    scanf("%i%i", &a, &b);
    relativelyPrime(a, b);
    return 0;
}