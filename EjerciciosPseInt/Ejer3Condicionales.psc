Algoritmo Ejer3Condicionales
	Definir num1,num2,num3 Como Entero
	Definir mensaje Como Caracter
	
	mensaje = "No son crecientes"
	
	//leer datos
	Escribir "dime n�mero 1"
	leer num1
	Escribir "dime n�mero 2"
	leer num2	
	Escribir "dime n�mero 3"
	leer num3
	
	// Proceso 
	Si num1 < num2 y num2 < num3
		mensaje = "son crecientes"
	FinSi
	
	// salida de datos
	Escribir mensaje
	
FinAlgoritmo
