Algoritmo Ejer2Propuestos
	Definir cuantosTrabajadores, horas Como Entero
	Definir contador, total Como Entero
	Definir sueldoBruto, sueldoNeto Como Entero
	Definir impuestos, tarifa Como Entero
	
	total = 0
	
	cuantosTrabajadores = leerEnteroPositivo ("cuántos trabajadores?")
	tarifa = leerEnteroPositivo ("precio tarifa ordinaria")
	
	Para contador = 1 Hasta cuantosTrabajadores
		horas = leerEnteroPositivo ("horas trabajadas")
		
		// calcular el salario bruto
		sueldoBruto = calcularBruto (horas, tarifa)
		
		// calcular los impuestos
		impuestos = calcularImpuestos (sueldoBruto)
		
		// calcular el salario neto
		sueldoNeto = sueldoBruto - impuestos
		
		// mostrar salario del trabajador
		Escribir "salario neto= " sueldoNeto
		
		// acumular total
		total = total + sueldoNeto
		
	FinPara
	
	Escribir "total a pagar por todos " total
	
FinAlgoritmo

Funcion bruto <- calcularBruto (h, t)
	Definir bruto, extra Como Entero
	
	bruto = h * t
	extra  = 0	
	Si h > 38
		extra = (h -38) * (1,5 * t)
		bruto = (38 * t ) + extra
	FinSi
	
	
FinFuncion

Funcion impuestos <- calcularImpuestos (sueldo)
	Definir impuestos Como Entero
	
	Si sueldo > 90000
		impuestos = trunc((sueldo - 90000) * 0,45)
		impuestos = impuestos + (40000 * 0,25)
	SiNo
		Si sueldo > 50000
			impuestos = trunc((sueldo -50000) * 0,25)
			
		SiNo
			impuestos = 0
		FinSi
		
	FinSi
	
FinFuncion

Funcion n <- leerEnteroPositivo (mensaje)
	Definir n Como Entero
	
	Repetir 
		Escribir mensaje
		Leer n
	Mientras Que n  < 1
	
FinFuncion
