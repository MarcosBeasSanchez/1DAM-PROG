Algoritmo ContarVocales
	Definir frase, letra Como Caracter
	Definir contadorVocales, contador Como Entero
	
	contadorVocales = 0
	
	Repetir
		Escribir "dime una frase"
		Leer frase
	Mientras Que frase == ""
	
	frase = Minusculas(frase)
	
	Para contador = 0 Hasta Longitud(frase) -1
		// obtener la letra
		letra = Subcadena(frase, contador, contador)
		
		Segun letra
			caso "a", "e", "i", "o","u":
				contadorVocales = contadorVocales + 1
			caso "�", "�", "�", "�","�":
				contadorVocales = contadorVocales + 1
		FinSegun
		
	FinPara
	
	Escribir "n� de vocales encontradas " contadorVocales
	
FinAlgoritmo






