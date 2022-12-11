        ##ascii-console mejorado para dar visibilidad, se tabula 4 veces y luego salto de línea
        .globl __start
        .text 0x00400000

__start:
        li $s0,32
        li $s1,127
        li $s2, 4
loop:
        addi $s2, $s2, -1
        li $v0,1
        move $a0,$s1
        syscall
        li $v0,11
        li $a0,9
        syscall
        li $v0,11
        move $a0,$s1
        syscall
        beq $s2, $0, lf
        li $v0,11
        li $a0,9
        syscall
        
        addi $s1,$s1,-1
        blt $s0,$s1,loop
lf:     li $v0,11
        li $a0,10
        syscall
        li $s2, 4
        addi $s1,$s1,-1
        blt $s0,$s1,loop

        li $v0,10
        syscall
