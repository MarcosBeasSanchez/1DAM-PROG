Funcion n <- leerEnteroPositivo (mensaje)
	Definir n Como Entero
	
	Repetir 
		Escribir mensaje
		Leer n
	Mientras Que n  < 1
	
FinFuncion


Funcion n <- leerRealPositivo (mensaje)
	Definir n Como Real
	
	Repetir 
		Escribir mensaje
		Leer n
	Mientras Que n  < 1
	
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

Funcion valorLeido leerEntreLimites (valorMinimo, valorMaximo, mensaje)
	Definir valorLeido Como Entero
	
	Repetir 
		Escribir mensaje
		leer valorLeido
	Mientras Que valorLeido < valorMinimo o valorLeido > valorMaximo
	
FinFuncion


Funcion intercambiar (n1 Por Referencia, n2 Por Referencia)
	Definir temp Como Entero
	
	temp = n1
	n1 = n2
	n2 = temp
FinFuncion

