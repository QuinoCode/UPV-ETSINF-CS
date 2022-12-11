#include <stdio.h>

int Number;

int main()
{
    int i;
    scanf("%d", &Number);
    printf("The first %d natural numbers are: \n", Number);
    for(i=1; i <= Number; i++) 
    {
        printf("    %d \n", i);
    }
    printf("BYE \n");
    return(0);
}