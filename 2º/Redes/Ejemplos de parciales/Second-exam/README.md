# Disclaimer
Obviously I do not have the actual statement of the exam because it is not given to the student.
This is what I recall and it should be sufficient to understand the code.
## Statement
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
nc localhost 7777 \n
RESTA \n
12 \n
4  \n
[Respuesta del servidor:] El resultado de la operación 12 - 4 = 8
