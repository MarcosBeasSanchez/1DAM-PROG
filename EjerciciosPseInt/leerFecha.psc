Algoritmo leerFecha
	Definir dia, mes, anio Como Entero
	
	anio = leerEntreLimites (2000, 2099, "dame un año de este siglo")
	mes = leerEntreLimites (1, 12, "dime un número de mes")
	
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
	
	dia = leerEntreLimites (1,dia,"día del mes")
	
	mostrarFecha(dia, mes, anio)
	
FinAlgoritmo

Funcion esBisiesto <- comprobarBisiesto (year)
	Definir esBisiesto Como Logico
	
	esBisiesto = Falso
	
	Si year % 4 == 0 y no (year % 100 == 0 y year % 400 <> 0)
		esBisiesto = Verdadero
	FinSi
	
FinFuncion


Funcion mostrarFecha (d, m, a)

	
	Escribir d " de " calcularNombreMes(m) " de " a
	
FinFuncion


Funcion nombreMes <- calcularNombreMes (numeroMes)
	Definir NOMBRES,nombreMes,letra, ESPACIO Como Caracter
	Definir espacios, contador Como Entero
	
	ESPACIO = " "
	NOMBRES = "Enero Febrero Marzo Abril Mayo Junio Julio Agosto Septiembre Octubre Noviembre Diciembre"
	contador = 0
	espacios = 0
	nombreMes = ""
	
	Mientras contador < Longitud(NOMBRES) y espacios <numeroMes
		letra = Subcadena(NOMBRES,contador, contador)
		nombreMes = nombreMes + letra
		Si letra == ESPACIO
			espacios = espacios + 1
			Si espacios <> numeroMes
				nombreMes = ""
			FinSi
		FinSi
		contador = contador + 1
	FinMientras
	
	
FinFuncion







Funcion valorLeido <- leerEntreLimites (limiteInferior, limiteSuperior, mensaje)
	Definir valorLeido Como Entero
	
	Repetir
		Escribir mensaje
		leer valorLeido
	Mientras Que valorLeido < limiteInferior o valorLeido > limiteSuperior
	
	
FinFuncion
	