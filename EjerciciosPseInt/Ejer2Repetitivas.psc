Algoritmo Ejer2Repetitivas
	Definir num, cifras Como Entero
	
	Repetir
		Escribir "dame un entero positivo"
		leer num
	Mientras  Que num < 1
		
	cifras = 0
		
	Mientras num > 0
		Escribir  num % 10
		num = trunc (num / 10)
		cifras = cifras + 1
	FinMientras
	
	Escribir "la cantidad de cifras es " cifras
	
FinAlgoritmo
