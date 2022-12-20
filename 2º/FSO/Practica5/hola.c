/**
* Programa de ejemplo: "Hola mundo" con pthreads.
* Para compilar teclea: gcc hola.c -lpthread -o hola
**/
#include <stdio.h>
#include <pthread.h>
#include <string.h>
void *Imprime( void *ptr)
{
  char *men;
  men = (char*)ptr;
  //Ejercicio 1.b
  usleep(200000);
  write(1,men,strlen(men));
}
int main()
{
  pthread_attr_t atrib;
  pthread_t hilo1, hilo2;

  pthread_attr_init( &atrib);
  pthread_create(&hilo1, &atrib, Imprime, "Hola \n");
  pthread_create(&hilo2, &atrib, Imprime, "mundo \n");

  //Ejercicio1.a
  // pthread_join(hilo1, NULL);
  // pthread_join(hilo2, NULL);
  // pthread_exit(0);
  usleep(100000);
}

