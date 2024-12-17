Algoritmo Ejer5Condicionales
	Definir eleccion Como Entero
	Definir mensaje Como Caracter
	
	Escribir "1. Archrivo"
	Escribir "2. Buscar"
	Escribir "3. Salir"
	Escribir "Elija una opción"
	leer eleccion
	
	
//	Si eleccion == 1
//		mensaje = "Archivo"
//	SiNo
//		Si eleccion == 2
//			mensaje = "Buscar"
//		SiNo
//			Si eleccion == 3
//				mensaje = "Salir"
//			SiNo
//				mensaje = "Opción incorrecta"
//			FinSi
//		FinSi
//	FinSi
	
	
	Segun eleccion
			Caso 1:
				mensaje = "Archivo"
			Caso 2:
				mensaje = "Buscar"
			Caso 3:
				mensaje = "Salir"
			De Otro Modo:
				mensaje = "Opción incorrecta"
			
	FinSegun
	
	Escribir mensaje
	
FinAlgoritmo
