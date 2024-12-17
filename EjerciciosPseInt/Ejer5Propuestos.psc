Algoritmo Ejer5Propuestos
	Definir dia, mes, anio, maximoDia Como Entero
	Definir numeroTarot Como Entero
	
	anio = leerEntreLimites (0,2023, "año de nacimiento?")
	mes = leerEntreLimites (1,12, "mes de nacimiento?")
	maximoDia = calcularMaximoDiasMes (anio, mes)
	dia = leerEntreLimites (1, maximoDia, "día de nacimiento?")
	
	numeroTarot = anio + mes + dia
	
	Mientras numeroTarot > 9
		numeroTarot = sumarDigitos (numeroTarot)
	FinMientras
	
	Escribir "tu número del tarot es " numeroTarot
	
FinAlgoritmo

Funcion suma <- sumarDigitos (num)
	Definir suma, digito Como Entero
	
	suma = 0
	
	Mientras num > 0
		digito = num % 10
		suma = suma + digito
		num = trunc (num / 10)
	FinMientras
	
FinFuncion


Funcion valorLeido <- leerEntreLimites (valorMinimo, valorMaximo, mensaje)
	Definir valorLeido Como Entero
	
	Repetir 
		Escribir mensaje
		leer valorLeido
	Mientras Que valorLeido < valorMinimo o valorLeido > valorMaximo
	
FinFuncion

Funcion dia <- calcularMaximoDiasMes (anio,mes)
	Definir dia Como Entero
	Segun mes
		caso 1,3,5,7,8,10,12:
			dia = 31
		caso 2:
			Si comprobarBisiesto(anio) == Verdadero
				dia = 29
			SiNo
				dia = 28
			FinSi
			
		De Otro Modo:
			dia = 30
	FinSegun
FinFuncion

Funcion esBisiesto <- comprobarBisiesto (year)
	Definir esBisiesto Como Logico
	
	esBisiesto = Falso
	
	Si year % 4 == 0 y no (year % 100 == 0 y year % 400 <> 0)
		esBisiesto = Verdadero
	FinSi
	
FinFuncion
