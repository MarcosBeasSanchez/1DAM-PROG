Algoritmo probarMes
	Definir mes Como Entero
	Definir nombre Como Caracter
	
	leer mes
	
	nombre = calcularNombreMes(mes)
	
	Escribir nombre
	
FinAlgoritmo

Funcion nombreMes <- calcularNombreMes (numeroMes)
	Definir NOMBRES,nombreMes,letra, ESPACIO Como Caracter
	Definir inicio, final, espacios, contador Como Entero
	
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
