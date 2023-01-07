
factorial(0,1).
factorial(Numero,Resultado) :-
  Numero > 0, 

  % Esto evita que se introduzcan números negativos

  NumeroAnterior is Numero - 1, % Preparamos la ejecución concurrente

  factorial(NumeroAnterior,ResultadoAnterior), 

  % Llamamos a factorial para aplicar la concurrencia.

  Resultado is Numero * ResultadoAnterior. 

  % Habilita los resultados partiendo del caso base para desbloquear la ejecucion de la línea anterior.


% put_char('.'), pone un '.' en pantalla
tab(0) :- !. 

% si no se pone el corte (!) tab 0 al darle a redo entrará por tab(N) lo que desembocará en un bucle infinito.

tab(N) :- put_char('.'), N1 is N - 1, tab(N1).

