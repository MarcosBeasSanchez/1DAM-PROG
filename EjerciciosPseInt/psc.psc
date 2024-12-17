Algoritmo Ejer23Repaso
	Definir fila, columna Como Entero
	Definir lado Como Entero
	Definir linea Como Caracter
	
	lado = leerEnteroPositivo ("lado?")
	
	Para fila = 1 Hasta lado
		linea = ""
		Para columna = 1 Hasta lado
			linea = linea + "*"
		FinPara
		Escribir linea
	FinPara
	
	
FinAlgoritmo

Funcion n <- leerEnteroPositivo (mensaje)
	Definir n Como Entero
	
	Repetir 
		Escribir mensaje
		Leer n
	Mientras Que n  < 1
	
FinFuncion
