
#include <stdio.h>
#include <stdbool.h>

#define InitBalance 1000
float Balance;

int main()
{ int operation;
  float income, withdraw;
  
  printf("\nWelcome to the FSO ATM\n");
  Balance=InitBalance;
  operation=0;
  bool bEnquiry = true;
  while (operation != 6)
  {
    printf("\nIndicate operation to do:\n");
    printf(" 0.Show/not Show Balance Enquiry \n 1.Cash Income\n 2.Cash Withdrawal\n 3.Balance Enquiry\n");
    printf(" 4.Account Activity\n 5.Change PIN\n 6.Exit\n\n");
    printf(" Operation:");
    scanf("%d",&operation);
    
    switch(operation) {
        case 0:
            bEnquiry = !bEnquiry;
            printf("Ha cambiado la configuración correctamente\n");
            break;
        case 1:
    
            printf(" Cash Income\n");
            printf("\n Enter the amount to deposit:");   
            scanf("%f",&income);
            Balance=Balance+income;  
            printf(" Successful income\n");
            break;
    
        case 2:
            printf(" Cash Withdrawal\n");
            printf("\n Enter the amount to withdraw:");
            scanf("%f",&income);
            
            if(Balance>income){
            Balance=Balance-income;
            }else{
            printf(" Operation does not allowed\n");
            printf("   Not enough cash\n");
            }
            break;

        case 3:
            printf(" Balance Enquiry\n");
            printf("\n\n Current Balance: %.2f Euros\n\n", Balance);
            break;
    
        case 4:
        case 5:
            printf(" This operation is not implemented");
            break;
        case 6:
            printf(" EXIT\n"); 
            break;
    
        default:
            printf(" ERROR: This operation does not apply\n");
        
    }
  
  
  if(bEnquiry && operation != 0) 
  {
      printf("\n\n Current Balance: %.2f Euros\n\n", Balance);
  }
  }
  printf("\n\n Thanks \n\n");
   return(0);

}