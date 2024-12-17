Algoritmo ejer5MasEjer
	Definir jugadaUsuario, jugadaMaquina Como Entero
	Definir puntosUsuario, puntosMaquina Como Entero
	
	puntosUsuario = 0
	puntosMaquina = 0
	
	Mientras  puntosUsuario < 3 y puntosMaquina < 3
		// pedir elección al usuario
		jugadaUsuario = pedirEleccionUsuario()
		
		// pedir elección a la máquina
		jugadaMaquina = pedirEleccionMaquina()
		
		// Mostrar jugada de la máquina
		Escribir "judada de la máquina : " convertirEleccionATexto(jugadaMaquina)
		
		// evaluar ganador
		evaluarGanador(jugadaUsuario, jugadaMaquina, puntosUsuario, puntosMaquina)
		
		// Mostrar marcador al finalizar la jugada
		mostrarMarcador(puntosUsuario, puntosMaquina)
	FinMientras
	
	// mostrar ganador
	mostrarGanador(puntosUsuario, puntosMaquina)
	
FinAlgoritmo

Funcion eleccion <- pedirEleccionMaquina()
	Definir eleccion Como Entero
	
	eleccion = azar(2) + 1 // Aleatorio(1,3)
FinFuncion


Funcion  evaluarGanador (usuario, maquina, puntosU Por Referencia, puntosM Por Referencia)
	
	Si usuario <> maquina
		
		Segun usuario
			caso 1: // PIEDRA
				Si maquina == 2 // PAPEL
					puntosM = puntosM + 1
				SiNo
					puntosU = puntosU + 1
				FinSi
				
			caso 2: // PAPEL
				Si maquina == 1 // PIEDRA
					puntosU = puntosU + 1
				SiNo
					puntosM = puntosM + 1
				FinSi
				
			caso 3: // TIJERA
				Si maquina == 1 // PIEDRA 
					puntosM = puntosM + 1
				SiNo
					puntosU = puntosU + 1
				FinSi
				
		FinSegun
		
	FinSi
	
	
FinFuncion


Funcion mostrarGanador (usuario, maquina)
	Si usuario == 3
		Escribir  "el ganador es usuario"
	SiNo
		Si maquina == 3
			Escribir "el ganador es la máquina"
		SiNo
			Escribir "No hay ganador"
		FinSi
	FinSi
FinFuncion

Funcion mostrarMarcador (usuario, maquina)
	Escribir "puntos usuario: " usuario
	Escribir "puntos máquina: " maquina
	
FinFuncion


Funcion eleccion <- pedirEleccionUsuario()
	Definir eleccion Como Entero
	Definir peticion Como Caracter
	
	Repetir
		Escribir "Introduzca piedra, papel o tijera"
		leer peticion
		peticion = Mayusculas(peticion)
	Mientras Que peticion <> "PIEDRA" y peticion <> "PAPEL" y peticion <> "TIJERA"
	
	eleccion = convertirEleccionANumero (peticion)
FinFuncion

Funcion valorTexto <- convertirEleccionATexto (valorNumerico)
	Definir valorTexto Como Caracter
	
	Segun valorNumerico
		caso 1:
			valorTexto = "PIEDRA"
		caso 2:
			valorTexto = "PAPEL"
		caso 3:
			valorTexto = "TIJERA"
	FinSegun
FinFuncion

Funcion valorNumerico <- convertirEleccionANumero (valorTexto)
	Definir  valorNumerico Como Entero
	
	valorNumerico = 1
	
	Si valorTexto == "PAPEL"
		valorNumerico = 2
	SiNo
		Si valorTexto == "TIJERA"
			valorNumerico = 3
		FinSi
	FinSi
	
FinFuncion
