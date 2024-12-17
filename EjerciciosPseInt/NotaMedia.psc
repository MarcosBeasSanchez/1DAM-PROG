Algoritmo NotaMedia
	Definir  contador, cuantasNotas Como Entero
	Definir nota, acumulador,media Como Real
	
	Escribir "cuántas notas tienes?"
	Leer cuantasNotas
	
	contador = 0
	acumulador = 0
	
	Mientras contador < cuantasNotas
		
		Repetir
			Escribir "dame nota " 
			leer nota
		Mientras que nota < 0 o nota > 10
		
		acumulador = acumulador + nota // acumular
		contador = contador + 1 // incrementar el contador
	FinMientras
	
	media = acumulador / cuantasNotas
	
	Escribir "nota media = " media
	
	
FinAlgoritmo





