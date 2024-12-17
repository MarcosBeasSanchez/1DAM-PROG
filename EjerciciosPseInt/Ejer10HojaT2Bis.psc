Algoritmo Ejer10HojaT2Bis
	Definir num, contador, numInverso Como Entero
	Definir numTexto, inversoTexto Como Caracter
	
	inversoTexto = ""
	
	Repetir 
		Escribir "dame un entero positivo"
		Leer num
	Mientras Que num  < 1
	
	numTexto = ConvertirATexto(num)
	
	Para contador = Longitud(numTexto) - 1 Hasta 0
		inversoTexto = inversoTexto + Subcadena(numTexto, contador, contador)
	FinPara
	
	numInverso = ConvertirANumero(inversoTexto)
	
	Escribir numInverso
	
FinAlgoritmo
