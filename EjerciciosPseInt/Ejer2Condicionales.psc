Algoritmo Ejer2Condicionales
	Definir letra, mensaje Como Caracter
	
	mensaje = "La letra leida no es una vocal"
	
	//Introducción de datos
	Escribir "dime una letra"
	Leer letra
	

	// Proceso 
	letra = Minusculas(letra)
	Si letra == "a" o letra == "e" o letra == "i" o letra == "o" o letra == "u"
		mensaje = "La letra leida es una vocal"
	FinSi

	// Salida de datos
	Escribir mensaje
		
	
FinAlgoritmo
