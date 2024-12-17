Algoritmo Ejer10Condicionales
	Definir SUELDO, anios como Entero
	Definir sueldoTotal Como Real
	
	SUELDO = 40000
	
	sueldoTotal = SUELDO * 1.03
	
	Escribir "antiguedad en la empresa "
	leer anios
	
	Si anios >= 10
		sueldoTotal = SUELDO * 1.1
	SiNo
		Si anios >= 5
			sueldoTotal = SUELDO * 1.07
		SiNo
			Si anios >= 3
				sueldoTotal = SUELDO * 1.05
			FinSi
		FinSi
	FinSi
	
	Escribir "total a cobrar " sueldoTotal
	
FinAlgoritmo
