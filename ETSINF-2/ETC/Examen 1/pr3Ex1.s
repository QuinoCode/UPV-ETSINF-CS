          .globl __start
          .text 0x00400000
__start:  
          li $a0,'M'
          jal Input
          move $s0, $v0
          ##Guarda el resultado en la variable del main $s0
          li $a0, 'Q'
          jal Input
          bgtz $v0 pos
          sub $v0, $0, $v0
          sub $s0, $0, $s0
pos:      move $a1,$v0 ## Guarda el resultado en la variable de transición $a1
          move $a0, $s0
          jal Mult ##Llama a la función "mult"
          move $a1,$v0 ##Mueve a la variable de transición $a0 el resultado $v0 de la funcion mult
          li $a0, 'R'
          jal Output
          li $v0,10
          syscall   ## Acaba el programa, exit
Mult:     li $v0, 0 ## Pone la variable de retorno a 0
          beqz $a1, MultRet  ## si el multiplicador es 0 salta a la instrucción de retorno pues 0 es el resultado
MultFor:  add $v0, $v0, $a0 
          addi $a1, $a1, -1
          bne $a1, $zero, MultFor 
          ##Suma el multiplicando el número de veces que marca el multiplicador (definición de multiplicación)
          ##Mientras que no haya llegado al número de veces vuelve a hacerlo
MultRet:  jr $ra ##retorna $v0 al programa principal a la siguiente instrucción de la llamada jal
Input:    ##Da formato a la operación leer un entero de teclado y lo devuelve por $v0 a al "main", pide un char para printear
          li $v0, 11 
          syscall
          li $v0, 11
          li $a0, '='
          syscall
          li $v0, 5
          syscall
          jr $ra
Output:   ## Da formato al resultado de la operación, pide un char para printear y el resultado de la operación por $a1
          li $v0, 11
          syscall
          li $v0, 11
          li $a0, '='
          syscall
          li $v0, 1
          move $a0, $a1
          syscall
          li $v0, 11
          li $a0, '\n'
          syscall
          jr $ra
