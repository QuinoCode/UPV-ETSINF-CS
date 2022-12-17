
# Disclaimer

Obviously I do not have the actual statement of the exam because it is not given to the student.
This is what I recall and it should be sufficient to understand the code.

## Statement
Make a TCP concurrent server on your machine that is capable of handling two distinct types of mathematical operations.

It should be able to do both additions and subtractions. To make sure it works you will have to use the terminal and the instruction "nc localhost 'port'" then select a type of mathematical operation, provide two numbers and finally receive the response with the answer from the server. It should look like this:

### Addition

nc localhost 7777

SUMA

4

4

[Response from the server:] The result of the operation: 4 + 4 = 8

### Substraction

nc localhost 7777

RESTA

12

4

[Response from the server:] The result of the operation: 12 + 4 = 8


# Spanish

## Enunciado
Crea un servidor TCP concurrente en local que sea capaz de hacer dos operaciones matemáticas. "SUMA" y "RESTA" 
Para comprobar su funcionamiento deberas usar el terminal con la orden "nc localhost 'puerto'", seleccionar una operación
y darle los dos números sobre los que tiene que hacer la operación, el servidor te devolerá el resultado. Debería verse así:

### Suma

nc localhost 7777

SUMA

4

4

[Respuesta del servidor:] El resultado de la operación 4 + 4 = 8

### Resta

nc localhost 7777 

RESTA 

12

4 

[Respuesta del servidor:] El resultado de la operación 12 - 4 = 8
