          .globl __start
          .text 0x00400000
__start:  li $v0,5
          syscall #read int 
          move $a0,$v0
          li $v0,5
          syscall #read int
          move $a1,$v0
          jal Mult #jump and link (salta a la etiqueta mult y linkea el ra)
          move $a0,$v0
          li $v0,1
          syscall #printea el contenido de v0
          li $v0,10
          syscall #acaba el programa
Mult:     li $v0, 0 #pone el registro v0 a 0 (es el registro que se va a retornar como resultado)
          beqz $a1, MultRet #si el multiplicador es 0 retorna 0 como resultado
MultFor:  add $v0, $v0, $a0 #suma al retorno el multiplicando (multiplica con la definición de la multiplicación)
          addi $a1, $a1, -1 #descuenta 1 al multiplicador para acabar el programa cuando llegue a 0 (3*2 => 0+3+3)
          bne $a1, $zero, MultFor# cuando el multiplicador no es 0 vuelve a comenzar el ciclo
MultRet:  jr $ra
