          .globl __start
          .text 0x00400000

__start:
          li $s0, 0
loop:
          li $v0,5
          syscall #read_int
          addu $s0,$s0,$v0
          li $v0,1
          move $a0, $s0
          syscall #printea un int introducido en el regitro %a0 (que es movido desde $s0)
          li $v0,11
          li $a0, '\n'
          syscall #print char, printea un salto de linea \n introducido en el registro $a0
          b loop

          li $v0,10 #acaba el proceso
          syscall
