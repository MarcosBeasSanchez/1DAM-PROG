Algoritmo Ejer27Repaso
	Definir numero1, numero2 Como Entero
	Definir amigos Como Logico
	Definir mensaje Como Caracter
	
	numero1 = leerEnteroPositivo ("dame el primer valor")
	numero2 = leerEnteroPositivo ("dame el segundo valor")
	
	mensaje = ConvertirATexto(numero1) + " y " + ConvertirATexto(numero2)
	Si comprobarNumerosAmigos(numero1, numero2) 
		mensaje =  mensaje + " son amigos"
	SiNo
		mensaje =  mensaje + " NO son amigos"
	FinSi
	
	Escribir mensaje
	
	
FinAlgoritmo

Funcion n <- leerEnteroPositivo (mensaje)
	Definir n Como Entero
	
	Repetir 
		Escribir mensaje
		Leer n
	Mientras Que n  < 1
	
FinFuncion

Funcion sonAmigos<- comprobarNumerosAmigos (n1,n2)
	Definir sonAmigos Como Logico
	Definir suma1, suma2 Como Entero
	
	suma1 = calcularSumaDivisores (n1)
	suma2 = calcularSumaDivisores (n2)
	
	Si suma1 == n2 y suma2 == n1
		sonAmigos = Verdadero
	SiNo
		sonAmigos = Falso
	FinSi
	
	//sonAmigos = (suma1 == n2) y (suma2 == n1)
	
FinFuncion

Funcion suma <- calcularSumaDivisores (num)
	Definir suma, contador Como Entero
	
	suma = 1
	
	Para contador = 2 Hasta num - 1
		Si num % contador == 0
			suma = suma + contador
		FinSi
	FinPara
	
FinFuncion






