Algoritmo Ejer25Repaso
	Definir num1, num2 Como Entero
	
	Leer num1
	Leer num2
	
	mostrarIntervalo(num1, num2)
	
FinAlgoritmo

Funcion mostrarIntervalo (n1,n2)
	Definir temp, contador Como Entero
	
	Si n2 < n1
		temp = n1
		n1 = n2
		n2 = temp
	FinSi
	
	Para contador = n1 Hasta n2
		Escribir contador
	FinPara
	
	
FinFuncion
	