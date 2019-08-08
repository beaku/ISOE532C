#include <stdio.h>

void display()
{
    printf("Hello World");
}
int add(int x, int y)
{

    int a = x;
    int b = y;
    return a+b;
}

int main()
{
    int addition = add(1,2);

    if(addition == 10)
    {
        printf("Over limit");
    }

    switch(addition)
    {
    case 3:
        printf("Correct Answer");
        break;

    default:
        break;
    }

    for(int i = 0; i < 10; i++)
    {
        printf("Hello World");
    }
    printf("\n");
    int i = 10;
    while(i--)
    {
        printf("Hello World");
    }
    printf("\n");
    int j = 10;
    do
    {
        printf("Hello World");
    } while (j--);

    return 0;
}
