Algoritmo Ejer4MasEjer
	Definir dias, contador Como Entero
	Definir precioActual, precioAnterior Como Real
	Definir diferencia, diferenciaMaxima Como Real
	
	
	
	dias = leerEnteroPositivo ("cuántos días?")

	// Singularidad del primero, podría meterse en el bucle
	precioActual = leerRealPositivo ("dia 1")
	precioAnterior = precioActual
	diferenciaMaxima = 0
	
	Para contador = 2 Hasta dias
		precioActual = leerRealPositivo ("dia " + ConvertirATexto(contador))
		diferencia = abs(precioActual - precioAnterior)
		
		Si diferencia > diferenciaMaxima
			diferenciaMaxima = diferencia
		FinSi
		precioAnterior = precioActual
	FinPara
	
	Si diferenciaMaxima > 0
		Escribir "La mayor diferencia fue de " diferenciaMaxima
	SiNo
		Escribir "No hubo diferencias"
	FinSi
	
FinAlgoritmo

Funcion n <- leerEnteroPositivo (mensaje)
	Definir n Como Entero
	
	Repetir 
		Escribir mensaje
		Leer n
	Mientras Que n  < 1
	
FinFuncion

Funcion n <- leerRealPositivo (mensaje)
	Definir n Como Real
	
	Repetir 
		Escribir mensaje
		Leer n
	Mientras Que n  < 1
	
FinFuncion