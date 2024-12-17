Algoritmo Ejer4Repetitivas
	Definir nAlturas, contador Como Entero
	Definir altura, alturaMaxima, suma, media Como Real
	
	suma = 0
	alturaMaxima = 0
	
	Repetir
		Escribir "nº de alturas"
		Leer nAlturas
	Mientras Que nAlturas < 1
	
	Para contador = 0 Hasta nAlturas - 1
		Repetir
			Escribir "altura ?"
			Leer altura
		Mientras Que altura <= 0
		
		suma = suma + altura
		
		Si altura > alturaMaxima
			alturaMaxima = altura
		FinSi
		
	FinPara
	
	media = suma / nAlturas
	
	Escribir "la media es " media
	Escribir "la altura máxima es " alturaMaxima
	
	
FinAlgoritmo
