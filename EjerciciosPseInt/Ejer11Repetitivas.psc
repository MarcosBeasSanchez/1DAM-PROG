Algoritmo Ejer11Repetitivas
	Definir productoOferta, producto, respuesta Como Caracter
	Definir precioUnidad, subtotal, descuento, total Como Real
	Definir unidades, unidadesGratis Como Entero
	
	descuento = 0
	total = 0
	
	Repetir
		Escribir "Producto en oferta "
		Leer productoOferta
	Mientras que Longitud(productoOferta) == 0
	
	Repetir
		unidadesGratis = 0
		
		Escribir "Producto "
		Leer producto
		
		Repetir
			Escribir "unidades compradas"
			leer unidades
		Mientras Que unidades < 1
		
		Repetir
			Escribir "precio unidad"
			leer precioUnidad
		Mientras Que precioUnidad <= 0 
		
		Si producto == productoOferta
			unidadesGratis = trunc (unidades / 3)
			descuento = descuento + (unidadesGratis * precioUnidad)
		FinSi
		
		
		subtotal = (unidades - unidadesGratis) * precioUnidad
		total = total + subtotal
		Repetir
			Escribir "hay más productos?(s/n)"
			Leer respuesta
		Mientras Que respuesta <> "s" y respuesta <> "n"
		
	Mientras Que respuesta == "s"
	
	Escribir "total a pagar " total
	Si descuento > 0
		Escribir "te ahorras " descuento
	FinSi
	
FinAlgoritmo












