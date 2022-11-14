        .globl __start
        .text 0x00400000

__start:
        li $s0,32
        #li $s0,0
        li $s1,127
        #li $s1,255
loop:
        li $v0,1
        move $a0,$s0
        syscall #printea el contenido de $s0
        li $v0,11
        li $a0,9
        syscall #printea un tabuladorazo
        li $v0,11
        move $a0,$s0 
        syscall #Printea el contenido de $s0
        li $v0,11
        li $a0,10
        syscall ##Printea un salto de línea

        addi $s0,$s0, 1 # "Salta" a la siguiente línea del código ASCII
        blt $s0,$s1,loop #si rs < rt salta a la etiqueta loop ($s0 < $s1)

        li $v0,10
        syscall #finaliza el programa
