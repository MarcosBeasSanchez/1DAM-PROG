Algoritmo Ejer3Repetitivas
	Definir nota Como Real
	Definir contador, aprobados, CUANTOSALUMNOS Como Entero
	
	CUANTOSALUMNOS = 3
	contador = 0
	aprobados = 0
	
	Mientras contador < CUANTOSALUMNOS
		// Leer la nota de cada alumno
		Repetir
			Escribir "nota = "
			leer nota
		Mientras Que nota < 1 o nota > 10
		
		// comprobar si la nota está aprobada
		Si nota > 4.5
			aprobados = aprobados + 1
		FinSi
		
		// incrementar el contador
		contador = contador + 1
		
		
	FinMientras
	
	Escribir "aprobados = " aprobados
	Escribir "suspensos = " CUANTOSALUMNOS - aprobados
	
	
FinAlgoritmo
