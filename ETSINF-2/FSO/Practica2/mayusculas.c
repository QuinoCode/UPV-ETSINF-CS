#include <stdio.h> 
#define TAM_CADENA 200

int main() {
    // Puntero a caracter para copiar las cadenas
    char * p1;
    char * p2;
  

    // A) Definir las variables cadena y cadena2 
    char cadena[TAM_CADENA];
    char cadena2[TAM_CADENA];
    // B) Leer cadena de consola 
    scanf("%[^\n]s", cadena);
        
    // C) Convertir a mayúsculas
    p1 = cadena;
    p2 = cadena2;

    while (*p1 != '\0') {
        //  Copiar p1 a p2 restando 32
        *p2 = *p1 - 32; //Es código ascii, lo que hace por lo que modificar el contenido de p2 con una indirección a la indirección de p1 (su contenido) - 32 lo pone en mayúsculas
         p1 = p1 + 1;
         p2 = p2 + 1;
    }
    //mio: no está filtrado a minusculas solo, pero solo funciona con ellas
    // Acordarse de poner el cero final en cadena2
    *p2 = '\0';
    // D) Sacar por consola la cadena2.
    printf("Cadena 1 en mayusculas: %s \n", cadena2);
}

