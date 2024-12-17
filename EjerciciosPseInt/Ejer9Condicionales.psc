Algoritmo Ejer9Condicionales
	Definir hh, mm,ss Como Entero
	
	Escribir "horas"
	leer hh
	Escribir "minutos"
	leer mm
	Escribir "segundos"
	leer ss
	
	ss = ss + 1
	
	Si ss > 59
		ss = 0
		mm = mm + 1
		Si mm > 59
			mm = 0
			hh = hh +1
			Si hh > 23
				hh = 0
			FinSi
		FinSi
	FinSi
	
	Escribir hh " : " mm " : " ss
FinAlgoritmo





