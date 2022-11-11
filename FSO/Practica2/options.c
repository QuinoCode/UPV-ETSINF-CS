#include <stdio.h>
#include <string.h>

int main(int argc, char *argv[]) {   
     int j, cmpC, cmpE, cmpI;
     char c[] = "-c";
     char E[] = "-E";
     char i[] = "-i";
     

     for(j = 1; j < argc; j++) {
         
         cmpC = strcmp(argv[j], c);
         cmpI = strcmp(argv[j], i);
         cmpE = strcmp(argv[j], E);
        printf("Argumento %d es ", j);
        if (cmpC == 0) {
            printf("Compilar\n");
        } else {
            if (cmpE == 0) {
            printf("Preprocesar\n");
            }
            else {
                if (cmpI == 0) {
                printf("Incluir %s\n", argv[0]);
                }
            }
            
        }
         
    }
    
}

