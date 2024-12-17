Algoritmo Ejer9Propuestos
	Definir limiteInf, limiteSup, num, temp Como Entero
	Definir cuantosDentro Como Entero
	Definir enElLimite Como Logico
	
	
	
	cuantosDentro = 0
	enElLimite = Falso
	// leer l�mites
	leerLimites(limiteInf, limiteSup)
	
	
	Repetir
		Escribir "dame un n�mero" 
		leer num
		
		Si num >= 0
			Si  !enElLimite  y comprobarEstaEnLimites(limiteInf, limiteSup, num) 				
				enElLimite = Verdadero
			SiNo
				Si !comprobarFueraIntervalo(limiteInf, limiteSup, num)
					cuantosDentro = cuantosDentro + 1
				FinSi
			FinSi
		FinSi
		
	Mientras Que num >= 0
	
	Si enElLimite
		Escribir "hay n�meros en los l�mites"
	FinSi
	
	Si cuantosDentro > 0
		Escribir "hay n�meros " cuantosDentro " dentro del intervalo"
	SiNo
		Escribir "No hay n�meros dentro del intervalo"
	FinSi
	
FinAlgoritmo

Funcion leerLimites (lInf Por Referencia, lSup Por Referencia)
	lInf = leerEnteroNoNegativo ("l�mite inferior = ")
	lSup = leerEnteroNoNegativo ("l�mite superior = ")
	
	Si lSup < lInf
		intercambiar(lSup, lInf)
	FinSi
	
FinFuncion

Funcion intercambiar (n1 Por Referencia, n2 Por Referencia)
	Definir temp Como Entero
	
	temp = n1
	n1 = n2
	n2 = temp
FinFuncion

Funcion estaFuera <- comprobarFueraIntervalo (lInf,lSup, n)
	Definir estaFuera Como Logico
	
	estaFuera = Falso
	
	Si n < lInf o n > lSup
		estaFuera = Verdadero
	FinSi
	
FinFuncion

Funcion estaLimites <- comprobarEstaEnLimites (lInf,lSup, n)
	Definir estaLimites Como Logico
	estaLimites = Falso
	
	Si n == lInf o n == lSup
		estaLimites = Verdadero
	FinSi
FinFuncion


Funcion n <- leerEnteroNoNegativo (mensaje)
	Definir n Como Entero
	
	Repetir 
		Escribir mensaje
		Leer n
	Mientras Que n  < 0
	
FinFuncion