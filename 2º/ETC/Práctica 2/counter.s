          .globl __start
          .text 0x00400000

__start:
          li $s0, 0
          li $s1, 0
loop:
          li $v0,5
          syscall #read_int
          beqz $v0, fin
          #beq $v0, $0, 9
          addu $s0,$s0,$v0
          li $v0,1
          addi $s1, $s1, 1
          move $a0, $s1
          syscall #Printea el registro $s1 que es donde se guarda el contador de operaciones
          li $v0,11
          li $a0, '>'
          syscall #Printea el caracter ">"
          li $v0,1
          move $a0, $s0
          syscall #printea un int introducido en el regitro %a0 (que es movido desde $s0)
          li $v0,11
          li $a0, '\n'
          syscall #print char, printea un salto de linea \n introducido en el registro $a0
          b loop
fin:
          li $v0, 11
          li $a0, '='
          syscall #printea el caracter "="
          li $v0, 1
          move $a0, $s0
          syscall #printea el resultado final
          li $v0, 11
          li $a0, 10
          syscall #printea el caracter "\n"
          li $v0, 11
          li $a0, 'n'
          syscall #printea el caracter "\n"
          li $v0, 11
          li $a0, '='
          syscall #printea el caracter "="
          li $v0, 1
          move $a0, $s1
          syscall #printea el número de operaciones que se han realizado

          li $v0,10 #acaba el proceso
          syscall
