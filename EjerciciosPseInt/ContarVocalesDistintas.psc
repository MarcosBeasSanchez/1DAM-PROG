Algoritmo ContarVocalesDistintas
	Definir frase, letra Como Caracter
	Definir contadorVocales, contador Como Entero
	Definir hayA, hayE, hayI, hayO, hayU  Como Logico
	
	contadorVocales = 0
	hayA = Falso
	hayE = Falso
	hayI = Falso
	hayO = Falso
	hayU = Falso
	
	Repetir
		Escribir "dime una frase"
		Leer frase
	Mientras Que frase == ""
	
	frase = Minusculas(frase)
	
	Para contador = 0 Hasta Longitud(frase) -1
		// obtener la letra
		letra = Subcadena(frase, contador, contador)
		
		Segun letra
			caso "a":
				Si  hayA == Falso
					contadorVocales = contadorVocales + 1
					hayA = Verdadero
				FinSi
			caso "e":
				Si  hayE == Falso
					contadorVocales = contadorVocales + 1
					hayE = Verdadero
				FinSi
			caso "i":
				Si  hayI == Falso
					contadorVocales = contadorVocales + 1
					hayI = Verdadero
				FinSi
			caso "o":
				Si  hayO == Falso
					contadorVocales = contadorVocales + 1
					hayO = Verdadero
				FinSi
			caso "u":
				Si  hayU == Falso
					contadorVocales = contadorVocales + 1
					hayU = Verdadero
				FinSi
				
			
		FinSegun
		
	FinPara
	
	Escribir "nº de vocales distintas encontradas " contadorVocales
	
FinAlgoritmo






