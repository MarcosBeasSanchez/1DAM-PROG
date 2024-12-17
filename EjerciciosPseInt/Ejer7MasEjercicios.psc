Algoritmo Ejer7MasEjercicios
	Definir listaReyes, reyNuevo Como Caracter
	Definir cuantosReyes, lugar Como Entero
	
	// leer cuántos reyes
	cuantosReyes = leerEnteroPositivo ("cantidad de reyes a leer")
	
	// leer listaReyes
	listaReyes = leerListaReyes (cuantosReyes)
	
	// leer rey nuevo
	Escribir "dime el nuevo rey"
	leer reyNuevo
	
	// calcular el lugar que ocupa
	lugar = calcularLugar (reyNuevo, listaReyes)
	
	// Mostrar resultado
	Escribir reyNuevo " ocupa el lugar " lugar
	
FinAlgoritmo

Funcion posicion <- calcularLugar (rey, lista)
	Definir posicion, contador Como Entero
	Definir palabra, letra Como Caracter
	
	posicion = 1
	palabra = ""
	

	
	Para contador = 0 Hasta Longitud(lista) - 1
		letra = Subcadena(lista,contador,contador)
		Si letra == " "
			Si palabra == rey
				posicion = posicion + 1
			FinSi
			palabra = "" // resetear palabra
		SiNo
			palabra = palabra + letra // acumular letra
		FinSi
	FinPara
	
	Si palabra == rey
		posicion = posicion + 1
	FinSi

	
	
FinFuncion

Funcion n <- leerEnteroPositivo (mensaje)
	Definir n Como Entero
	
	Repetir 
		Escribir mensaje
		Leer n
	Mientras Que n  < 1
	
FinFuncion

Funcion lista <- leerListaReyes (cuantos)
	Definir lista Como Caracter
	
	Repetir
		Escribir "dame lista de reyes, separados por espacios"
		leer lista
	Mientras Que cuantos <> contarPalabras(lista) 
	
	
	
FinFuncion

Funcion cantidad <- contarPalabras (frase)
	Definir cantidad, contador Como Entero
	Definir ESPACIO, letra Como Caracter
	
	ESPACIO = " "
	
	cantidad = 0
	
	Para contador = 0 Hasta Longitud(frase) - 1
		letra = Subcadena(frase, contador, contador)
		Si letra == ESPACIO
			cantidad = cantidad + 1
		FinSi
	FinPara
	
	cantidad = cantidad + 1
	
FinFuncion


















