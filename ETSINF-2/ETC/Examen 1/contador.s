          .globl __start
          .text 0x00400000

__start:
          li $s0, 0
          li $s1, 0
loop:
          li $v0,5
          syscall
          beq $0, $v0, exit
          addu $s0,$s0,$v0
          addi $s1, $s1, 1
          addi $s2, $v0, 0
          li $v0,1
          move $a0, $s1
          syscall ##Print s1 (nº operación)
          li $v0, 11 
          li $a0, '>'
          syscall ##print char
          li $v0, 1
          move $a0, $s2
          syscall
          li $v0,11
          li $a0, '\n'
          syscall
          b loop
exit:
          li $v0, 11
          li $a0, '='
          syscall
          li $v0, 1
          move $a0, $s0
          syscall
          li $v0, 11
          li $a0, '\n'
          syscall
          li $v0, 11
          li $a0, 'n'
          syscall
          li $v0, 11
          li $a0, '='
          syscall
          li $v0, 1
          move $a0, $s1
          syscall
          li $v0,10
          syscall
##código de forever.s modificado para limitar el bucle