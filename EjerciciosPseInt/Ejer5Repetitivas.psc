Algoritmo Ejer5Repetitivas
	Definir sueldo, totalSueldos Como Real
	Definir cuantosTrabajadores, contador, mayoresTope Como Entero
	Definir MINIMOSUELDO, MAXIMOSUELDO, TOPE Como Real
	
	MINIMOSUELDO = 100
	MAXIMOSUELDO = 1000
	TOPE = 500
	
	totalSueldos = 0
	mayoresTope = 0
	
	
	Repetir
		Escribir "cuántos trabajadores?"
		leer cuantosTrabajadores
	Mientras  Que cuantosTrabajadores < 1
		
		
	Para contador = 0 Hasta cuantosTrabajadores - 1
		// leer sueldo
		Repetir
			Escribir "sueldo ?"
			leer sueldo
		Mientras Que sueldo < MINIMOSUELDO o sueldo > MAXIMOSUELDO
		
		// procesar sueldo
		Si sueldo > TOPE
			mayoresTope = mayoresTope + 1
		FinSi
		
		// acumular
		totalSueldos = totalSueldos + sueldo
	FinPara
	
		
	Escribir "nº de trabajadores de más de 500 euros " mayoresTope
	Escribir "nº de trabajadores de menos o de 500 euros " cuantosTrabajadores - mayoresTope
	
	Escribir "total en sueldos " totalSueldos
FinAlgoritmo
