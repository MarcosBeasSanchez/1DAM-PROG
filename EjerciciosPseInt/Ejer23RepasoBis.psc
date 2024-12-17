Algoritmo Ejer23RepasoBis
	Definir fila, columna Como Entero
	Definir lado Como Entero
	Definir linea Como Caracter
	
	lado = leerEnteroPositivo ("lado?")
	
	escribirRelleno(lado)
	Para fila = 2 Hasta lado -1
		escribirInterior(lado)
	FinPara
	escribirRelleno(lado)
	
FinAlgoritmo

Funcion escribirInterior (tamanio)
	Definir linea Como Caracter
	Definir columna Como Entero
	linea = "*"
	
	Para columna = 2 Hasta tamanio -1
		linea = linea + " "
	FinPara
	linea = linea + "*"
	
	Escribir linea
FinFuncion

Funcion escribirRelleno (tamanio)
	Definir linea Como Caracter
	Definir columna Como Entero
	linea = ""
	Para columna = 1 Hasta tamanio
		linea = linea + "*"
	FinPara
	Escribir linea
FinFuncion

Funcion n <- leerEnteroPositivo (mensaje)
	Definir n Como Entero
	
	Repetir 
		Escribir mensaje
		Leer n
	Mientras Que n  < 1
	
FinFuncion
