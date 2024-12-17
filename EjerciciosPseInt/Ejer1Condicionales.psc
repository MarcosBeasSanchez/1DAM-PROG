Algoritmo Ejer1Condicionales
	Definir num, TOPE Como Entero
	Definir mensaje Como Caracter
	
	TOPE = 300
	mensaje = "mayor que " + ConvertirATexto(TOPE)
	
	Escribir "dime un numero"
	leer num
	
	Si num <= TOPE
		mensaje = " no es " + mensaje
	FinSi
	
	Escribir mensaje
	
FinAlgoritmo
