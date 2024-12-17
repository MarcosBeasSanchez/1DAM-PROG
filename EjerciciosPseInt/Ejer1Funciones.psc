Algoritmo Ejer1Funciones
	Definir base, altura Como Entero
	Definir area, perimetro Como Entero
	Definir respuesta Como Caracter
	Definir sigo Como Logico
	
	Repetir
		// leer los datos
		base = leerEnteroPositivo ("dame la base del rectángulo")
		altura = leerEnteroPositivo ("dame la altura del rectángulo")
		
		// calcular el área y el perímetro
		area = calcularArea (base, altura)
		perimetro = calcularPerimetro (base, altura)
		
		// mostrar los resultados
		mostrarResultados(area, perimetro)
		
		sigo = evaluarContinuar("desea continuar?(s/n)", "s", "n")
		
	Mientras Que sigo

	
FinAlgoritmo

Funcion mostrarResultados (a, p)
	Escribir "área = " a
	Escribir "perímetro = " p

FinFuncion

Funcion area <- calcularArea (b, h)
	Definir area Como Entero
	
	area = b * h
	
FinFuncion

Funcion p <- calcularPerimetro (b, h)
	Definir p Como Entero
	
	p = 2 * (b + h)
FinFuncion

Funcion continuar <- evaluarContinuar (mensaje, opcionAfirmativa, opcionNegativa)
	Definir continuar Como Logico
	Definir respuesta Como Caracter
	
	//continuar = Verdadero
	
	Repetir
		Escribir mensaje
		leer respuesta
		respuesta = Minusculas(respuesta)
	Mientras Que respuesta <> opcionAfirmativa y respuesta <> opcionNegativa
	
	
//	Si respuesta == opcionNegativa
//		continuar = Falso
//	FinSi
	
	continuar = respuesta == opcionAfirmativa
	
FinFuncion


Funcion n <- leerEnteroPositivo (mensaje)
	Definir n Como Entero
	
	Repetir 
		Escribir mensaje
		Leer n
	Mientras Que n  < 1
	
	
FinFuncion