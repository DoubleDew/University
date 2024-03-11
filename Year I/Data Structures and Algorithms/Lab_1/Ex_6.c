#include <stdio.h>

int primeNumbers(int number)
{
    int i=3, contor, c;

    if (number >= 1)
    {
        printf("The first %i prime numbers are: ", number);
        printf("2 ");
    }

    for (contor = 2; contor <= number; i++)
    {
        for (c=2;c<i;c++)
            if (i%c==0)
                break;
        if (c == i)
        {
            printf("%d ", i);
            contor++;
        }
    }
}

int main()
{
    int number;
    printf("number = ");
    scanf("%d", &number);
    printf(primeNumbers(number));
}