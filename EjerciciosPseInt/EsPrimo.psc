Algoritmo EsPrimo
	Definir num, contador Como Entero
	Definir soyPrimo Como Logico
	
	soyPrimo = Verdadero
	
	Repetir
		Escribir "dame un entero positivo"
		leer num
	Mientras Que num < 1 
	
	 contador = 2
	 
	 Mientras soyPrimo y contador < num 
		 Si num % contador == 0
			 soyPrimo = Falso
		 FinSi
		 contador = contador + 1
	 FinMientras
	 
	 Si soyPrimo
		 Escribir num " es primo"
	 SiNo
		Escribir num " no es primo" 
	 FinSi
	
FinAlgoritmo





