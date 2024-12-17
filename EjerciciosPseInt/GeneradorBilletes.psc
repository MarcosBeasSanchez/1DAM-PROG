Algoritmo GeneradorBilletes
	Definir contador1, contador2, cantidad, billetes,monedaActual Como Entero
	
//	contador1 = 5
//	
//	Mientras contador1 > 0
//		Escribir contador1
//		contador1 = trunc (contador1 /2)
//	FinMientras
//	
//	contador2 = 100
//	Mientras contador2 > 0
//		Escribir contador2
//		contador2 = trunc (contador2 / 10)
//	FinMientras
	
	
	Repetir
		Escribir "dame una cantidad"
		Leer cantidad
	Mientras Que cantidad < 1
	contador2 = 100
	
	Mientras contador2 > 0
		contador1 = 5
		Mientras contador1 > 0
			monedaActual = contador1 * contador2
			Si cantidad >= monedaActual
				billetes = trunc (cantidad / monedaActual)
				cantidad  = cantidad % monedaActual
				Escribir "billetes de " monedaActual " " billetes
			FinSi
			contador1 = trunc (contador1 /2)
		FinMientras
		contador2 = trunc (contador2 / 10)
		
	FinMientras
	
	
	
	
FinAlgoritmo
