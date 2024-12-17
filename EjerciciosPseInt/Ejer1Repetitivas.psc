Algoritmo Ejer1Repetitivas
	Definir num, suma, contador Como Entero
	Definir mensaje Como Caracter
	
	mensaje = "El número no es perfecto"
	suma = 1
	
	
	Repetir
		Escribir "dame un entero positivo"
		leer num
	Mientras Que num  < 1
	
	
	Para contador = 2 Hasta num - 1 Con Paso 1
		Si num % contador == 0
			suma = suma + contador
		FinSi
	FinPara
	
	
	Si suma == num 
		mensaje = "el número es perfecto"
	FinSi
	
	Escribir mensaje
	
	
FinAlgoritmo



