Algoritmo Ejer10Repetitivas
	Definir lado1, lado2, lado3 Como Entero
	Definir isosceles, equilateros, escalenos Como Entero
	Definir cuantos,contador Como Entero
	
	equilateros = 0
	isosceles = 0
	escalenos = 0
	
	Repetir
		Escribir "cuántos triángulos? "
		leer cuantos
	Mientras Que cuantos < 1
	
	
	Para contador = 0 Hasta cuantos - 1
		
		Repetir
			Escribir "lado 1 ?"
			leer lado1
		Mientras Que lado1 < 1
		
		Repetir
			Escribir "lado 2 ?"
			leer lado2
		Mientras Que lado2 < 1
		
		Repetir
			Escribir "lado 3 ?"
			leer lado3
		Mientras Que lado3 < 1
		
		Si lado1 == lado2
			Si lado1 == lado3
				Escribir "Equilatero"
				equilateros = equilateros + 1
			SiNo
				Escribir "Isóceles"
				isosceles = isosceles + 1
			FinSi
		SiNo
			Si lado1 == lado3 o lado2 == lado3
				Escribir "Isóceles"
				isosceles = isosceles + 1
			SiNo
				Escribir "Escaleno"
				escalenos = escalenos + 1
			FinSi
		FinSi
	FinPara
	
	Escribir "equilateros = " equilateros
	Escribir "isósceles = " isosceles
	Escribir "escalenos = " escalenos
	
FinAlgoritmo
