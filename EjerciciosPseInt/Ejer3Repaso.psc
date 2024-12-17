Algoritmo Ejer3Repaso
	Definir n, suma, contador,n1,n2,n3 Como Entero
	Definir letrero Como Caracter
	
	suma = 0
	
	letrero = "dame un número"
	
	
	n = leerEnteroPositivo(letrero)

	
	Para contador = 1 Hasta n
		suma = suma + contador
	FinPara
	
	Escribir "la suma es " suma
	
	n1 =leerEnteroPositivo("dame el primero")
	n2 =leerEnteroPositivo("ahora el segundo")
	n3 =leerEnteroPositivo("y por último el tercero")
	
FinAlgoritmo

Funcion n <- leerEnteroPositivo (mensaje)
	Definir n Como Entero
	
	Repetir 
		Escribir mensaje
		Leer n
	Mientras Que n  < 1
	
	
FinFuncion









	