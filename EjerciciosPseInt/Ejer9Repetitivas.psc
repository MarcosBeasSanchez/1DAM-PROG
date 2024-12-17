Algoritmo Ejer9Repetitivas
	Definir cx, cy, cantidadPuntos, contador Como Entero
	Definir cuadrante1, cuadrante2, cuadrante3, cuadrante4 Como Entero
	
	
	contador = 0
	cuadrante1 = 0
	cuadrante2 = 0
	cuadrante3 = 0
	cuadrante4 = 0
	
	
	Repetir
		Escribir "cuántos puntos tienes?" 
		leer cantidadPuntos
	Mientras  Que cantidadPuntos < 1 
	
		
		Mientras contador < cantidadPuntos	
			Escribir "x ="
			Leer cx
			
			Escribir "y ="
			Leer cy
		
			
			Si cx <> 0 y cy <> 0
				Si cx > 0
					Si cy > 0
						cuadrante1 = cuadrante1 + 1
					SiNo
						cuadrante4 = cuadrante4 + 1
					FinSi
				SiNo
					Si cy > 0
						cuadrante2 = cuadrante2 + 1
					SiNo
						cuadrante3 = cuadrante3 + 1
					FinSi
				FinSi
			FinSi
			contador = contador + 1
		FinMientras

	
		Escribir "en el cuadrante 1 hay " cuadrante1 " puntos"
		Escribir "en el cuadrante 2 hay " cuadrante2 " puntos"
		Escribir "en el cuadrante 3 hay " cuadrante3 " puntos"
		Escribir "en el cuadrante 4 hay " cuadrante4 " puntos"
	
FinAlgoritmo
