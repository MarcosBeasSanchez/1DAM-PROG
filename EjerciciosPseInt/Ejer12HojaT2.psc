Algoritmo Ejer12HojaT2
	Definir b500, b200,b100,b50,b20,b10,b5,b2,b1 Como Entero
	Definir cantidad Como Entero
	
	// inicializador de contadores
	b500 = 0 
	b200 = 0
	b100 = 0
	b50 = 0
	b20 = 0
	b10 = 0
	b5 = 0
	b2 = 0
	b1 = 0	
	
	// Leer cantidad
	Repetir
		Escribir "dame una cantidad"
		Leer cantidad
	Mientras Que cantidad < 1
	
	
	// Calcular los billetes
	Si cantidad >= 500
		b500 = trunc (cantidad / 500)
		cantidad = cantidad % 500
	FinSi
	
	Si cantidad >= 200
		b200 = trunc (cantidad / 200)
		cantidad = cantidad % 200
	FinSi
	
	Si cantidad >= 100
		b100 = trunc (cantidad / 100)
		cantidad = cantidad % 100
	FinSi
	
	Si cantidad >= 50
		b50 = trunc (cantidad / 50)
		cantidad = cantidad % 50
	FinSi
	
	Si cantidad >= 20
		b20 = trunc (cantidad / 20)
		cantidad = cantidad % 20
	FinSi
	
	Si cantidad >= 10
		b10 = trunc (cantidad / 10)
		cantidad = cantidad % 10
	FinSi
	
	Si cantidad >= 5
		b5 = trunc (cantidad / 5)
		cantidad = cantidad % 5
	FinSi
	
	Si cantidad >= 2
		b2 = trunc (cantidad / 2)
		cantidad = cantidad % 2
	FinSi
	
	Si cantidad >= 1
		b1 = trunc (cantidad / 1)
		cantidad = cantidad % 1
	FinSi
	
	// Mostrar billetes
	Si b500 > 0
		Escribir "billetes de 500 " b500
	FinSi
	
	Si b200 > 0
		Escribir "billetes de 200 " b200
	FinSi
	
	Si b100 > 0
		Escribir "billetes de 100 " b100
	FinSi
	
	Si b50 > 0
		Escribir "billetes de 50 " b50
	FinSi
	
	Si b20 > 0
		Escribir "billetes de 20 " b20
	FinSi
	
	Si b10 > 0
		Escribir "billetes de 10 " b10
	FinSi
	
	Si b5 > 0
		Escribir "billetes de 5 " b5
	FinSi
	
	Si b2 > 0
		Escribir "billetes de 2 " b2
	FinSi
	
	Si b1 > 0
		Escribir "billetes de 1 " b1
	FinSi
	
FinAlgoritmo
