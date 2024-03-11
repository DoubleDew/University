#include <stdio.h>

int palindrome(int x)
{
    int a, p=0, b;
    b = x;
    while(x)
    {
        a = x%10;
        p = p*10 + a;
        x /= 10;
    }
    if(p == b)
        printf("%i palindrome", b);
    else
        printf("not palindrome");
    return 1;
}

int main()
{
    int a;
    scanf("%i", &a);
    palindrome(a);
    return 0;
}