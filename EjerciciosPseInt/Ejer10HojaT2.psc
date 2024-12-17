Algoritmo Ejer10HojaT2
	Definir digito, num, numInverso Como Entero
	
	numInverso = 0
	
	Repetir 
		Escribir "dame un entero positivo"
		Leer num
	Mientras Que num  < 1
	
	
	Mientras num > 0
		digito = num % 10
		numInverso = (numInverso * 10 ) + digito
		num = trunc (num /10)
	FinMientras
	
	Escribir numInverso
FinAlgoritmo
