          .globl __start
          .text 0x00400000
__start: 
		 li $a0, 'M'
		 jal Input
         move $s0, $v0 #guarda el multiplicando de la función mult
         li $a0, 'Q'
         jal Input
         bgez $v0, Positivo
         sub $v0, $zero, $v0
         sub $s0, $zero, $s0
Positivo:move $s1,$v0 #guarda el multiplicador de la función mult
         move $a0, $s0 #prepara el multiplicando de la funcion mult
         move $a1, $s1 #prepara el multiplicador de la función mult
         jal Mult #jump and link (salta a la etiqueta mult y linkea el ra)
         move $s0, $v0
         li $a0, 'R'
         jal Output


         #Output
Output:  li $v0, 11
         syscall
         li $v0 11
         li $a0, '='
         syscall
         li $v0,1
         move $a0,$s0
         syscall #printea el contenido de a0
         li $v0,10
         syscall #acaba el programa


Input:   li $v0, 11
		 syscall  #Creo que imprime el char que haya en $a0
		 li $v0,11
		 li $a0, '='
	     syscall #printea el char '='
		 li $v0, 5
		 syscall #pide un int al user
		 jr $ra
		  

Mult:    li $v0, 0 #pone el registro v0 a 0 (es el registro que se va a retornar como resultado)
         beqz $a1, MultRet #si el multiplicador es 0 retorna 0 como resultado
MultFor: add $v0, $v0, $a0 #suma al retorno el multiplicando (multiplica con la definición de la multiplicación)
         addi $a1, $a1, -1 #descuenta 1 al multiplicador para acabar el programa cuando llegue a 0 (3*2 => 0+3+3)
         bne $a1, $zero, MultFor# cuando el multiplicador no es 0 vuelve a comenzar el ciclo
MultRet: jr $ra
