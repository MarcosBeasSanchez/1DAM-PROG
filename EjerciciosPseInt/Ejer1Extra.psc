Algoritmo Ejer1Extra
	Definir numeroNotas, contador Como Entero
	Definir primeraNota, melodia, nota Como Caracter

	
	numeroNotas = Aleatorio(1,7) * 4
	
	// Excepcion primera nota
	primeraNota = generarNota()
	melodia  = primeraNota + " "
	
	// resto de las notas menos la última
	Para contador = 2 Hasta numeroNotas - 1
		nota = generarNota ()
		melodia = melodia + nota + " "
		// escrobir fin de compás
		Si contador % 4 == 0
			melodia = melodia + "|" + " "
		FinSi
	FinPara
	
	// excepción última nota
	melodia = melodia + primeraNota + " ||"
	
	
	Escribir melodia
	
FinAlgoritmo


Funcion pintarCompas ()
	Definir contadorNotas Como Entero
	Definir nota, compas Como Caracter
	
	compas = ""
	
	Para contadorNotas = 1 Hasta 4
		nota = generarNota()
		compas = compas + nota + " "
	FinPara
	compas = compas + "|"
	Escribir Sin Saltar compas
	
FinFuncion

Funcion nota <- generarNota ()
	Definir nota Como Caracter
	Definir numeroNota Como Entero
	
	numeroNota = Aleatorio(1,7)
	
	Segun numeroNota
		caso 1:
			nota = "do"
		caso 2:
			nota = "re"
		caso 3:
			nota = "mi"
		caso 4:
			nota = "fa"
		caso 5:
			nota = "sol"
		caso 6:
			nota = "la"
		caso 7:
			nota = "si"
	FinSegun
FinFuncion
