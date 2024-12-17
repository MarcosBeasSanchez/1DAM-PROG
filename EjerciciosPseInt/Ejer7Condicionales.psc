Algoritmo Ejer7Condicionales
	Definir lado1,lado2,lado3,perimetro Como Entero
	Definir eleccion Como Entero
	Definir puedoCalcular Como Logico
	
	puedoCalcular = Verdadero
	
	Escribir "1. Equilatero"
	Escribir "2. Isóceles"
	Escribir "3. Escaleno"
	Escribir "Elija una opción"
	Leer eleccion
	
	
	Segun eleccion
		Caso 1:
			Escribir "Introduzca el lado"
			leer lado1
			lado2 = lado1
			lado3 = lado1
		Caso 2:
			Escribir "Introduzca el lado desigual"
			leer lado1
			Escribir "Introduzca el lado igual"
			leer lado2
			lado3 = lado2
		Caso 3:
			Escribir "Introduzca el lado 1"
			leer lado1
			Escribir "Introduzca el lado 2"
			leer lado2
			Escribir "Introduzca el lado 3"
			leer lado3
		De Otro Modo:
			puedoCalcular = Falso
	FinSegun
	
	Si puedoCalcular == Verdadero
		perimetro = lado1+lado2+lado3
		Escribir "el perímetro es " perimetro
	SiNo
		Escribir "no es posible calcular el perímetro"
	FinSi
	
	
FinAlgoritmo



