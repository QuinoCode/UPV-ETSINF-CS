### PROGRAMA BASE PRACTICAS DE ENTRADA/SALIDA MIPS R2000

#-------------------------------------------------#
#
#  PR�CTICA 12: SINCRONIZACI�N POR PRUEBA DE ESTADO
# 
#-------------------------------------------------#

# ACTIVIDAD 3:  Completar las funciones:
#    char getchar() - obtiene el car�cter del teclado
#    void putchar(char c) - imprime un car�cter por la consola

# Segmento de datos

	.data		
Teclado:	.word 0xffff0000
Consola:	.word 0xffff0008
#-------------------------------------------------#

# Segmento de c�digo ("text")
	.text
    	.globl __start	



__start:			


	li $a0, 'P'		# 
	jal putchar		# putchar('P')

	li $a0, '1'		# 
	jal putchar		# putchar('1')

	li $a0, '2'		# 
	jal putchar		# putchar('2')

	li $a0, 13		# car�cter de retorno ('\n')
	jal putchar		# putchar('\n')
	
bucle:

	jal getchar		# $v0 = getchar()
	move $a0, $v0		#

	li $t0, 0x1b      	# detecto ESC (0x1b = 27)
	beq $a0, $t0, fin
	jal putchar		# putchar($a0)
	b bucle
fin:	

	li $v0, 10
	syscall			# exit
	
	
	
getchar:			# $v0 = getchar()
### A COMPLETAR: c�digo de la funci�n
la $t6, 0xffff0000
espera:
lw $t3, 0 ($t6)
	andi $t3, $t3, 1
	beqz $t3, espera


lb $t6, 4($t6)
move $v0, $t6



###
	jr $ra


putchar:			# putchar($a0)
### A COMPLETAR: c�digo de la funci�n
la $t5, 0xffff0008

esperaPC:
 lw $t4,0 ($t5)

	andi $t4, $t4, 1
	beqz $t4, esperaPC


sb $a0, 4($t5)


###
	jr $ra
