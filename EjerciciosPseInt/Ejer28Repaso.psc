Algoritmo Ejer27Repaso
	Escribir sumarImpares(4)
FinAlgoritmo

Funcion suma <- sumarImpares (num)
	Definir suma,contadorImpares, contador Como Entero
	Definir numeroImpar Como Entero
	
	suma = 0
	
	contador = 1
	contadorImpares = 0
	
	Mientras contadorImpares < num
		Si contador es impar
			contadorImpares = contadorImpares + 1
			suma = suma + contador
		FinSi
		contador = contador + 1
		
	FinMientras
	
//	Para contador = 1 hasta num
//		
//		numeroImpar = (2*contador) - 1
//		suma = suma + numeroImpar
//	FinPara
	
FinFuncion
	