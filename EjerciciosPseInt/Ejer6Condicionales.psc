Algoritmo Ejer6Condicionales
	Definir num1, num2 Como Entero
	Definir mensaje Como Caracter
	
	mensaje = "ambos n�meros no son pares o impares"
	
	Escribir "num1"
	leer num1
	
	Escribir "num2"
	leer num2
	
	
	Si num1 es par y num2 es par
		mensaje = "ambos n�meros son pares"
	SiNo
		Si num1 es impar y num2 es impar
			mensaje = "ambos n�meros son impares"
		FinSi
	FinSi
	
	
	Escribir mensaje
	
FinAlgoritmo
