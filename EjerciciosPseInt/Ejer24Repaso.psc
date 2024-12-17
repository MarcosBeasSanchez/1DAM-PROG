Algoritmo Ejer24Repaso
	Definir u,d,c,m,dm Como Entero
	
	Para dm = 0 Hasta 9
		Para m = 0 hasta 9
			Para c = 0 Hasta 9
				Para d = 0 Hasta 9
					Para u = 0 Hasta 9
						escribirCuentaNumeros(dm,m,c,d,u)
					FinPara
				FinPara
			FinPara
		FinPara
	FinPara
	
FinAlgoritmo

Funcion escribirCuentaNumeros (c5,c4,c3,c2,c1)
	Definir linea Como Caracter
	
	linea = ""
	
	linea = linea + cambiar3PorE(c5)
	linea = linea +"-"
	
	linea = linea + cambiar3PorE(c4)
	linea = linea +"-"
	
	linea = linea + cambiar3PorE(c3)
	linea = linea +"-"
	
	linea = linea + cambiar3PorE(c2)
	linea = linea +"-"
	
	linea = linea + cambiar3PorE(c1)
	
	Escribir linea
	
FinFuncion

Funcion val <- cambiar3PorE(digito)
	Definir val Como Caracter
	Si digito == 3
		val = "E"
	SiNo
		val = ConvertirATexto(digito) 
	FinSi
FinFuncion





