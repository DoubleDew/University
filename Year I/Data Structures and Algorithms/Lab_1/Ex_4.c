#include <stdio.h>

int digitSum(int x)
{
    int suma = 0;
    while(x)
    {
        suma += x%10;
        x/=10;
    }
    return suma;
}

int sum(int start, int finish)
{
    int suma = 0;
    for(int i = start; i <= finish; i++)
        suma += digitSum(i);
    printf("The sum is %i", suma);
    return 1;
}

int main()
{
    int start, finish;
    scanf("%i%i", &start, &finish);
    sum(start, finish);
    return 0;
}