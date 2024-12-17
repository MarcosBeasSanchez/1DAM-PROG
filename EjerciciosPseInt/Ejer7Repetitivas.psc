Algoritmo Ejer7Repetitivas
	Definir num, acumulador, contador Como Entero
	Definir NVECES Como Entero
	
	NVECES = 10
	acumulador = 0
	contador = 0
	
	Mientras contador < NVECES
		Escribir "valor " contador + 1
		Leer num
		
		Si contador >= NVECES - 5
			acumulador = acumulador + num
		FinSi
		
		// incrementar el contador
		contador = contador + 1
	FinMientras
	
	Escribir "total acumulado = " acumulador	
FinAlgoritmo
