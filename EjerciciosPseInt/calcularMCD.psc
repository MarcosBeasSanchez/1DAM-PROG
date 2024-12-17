Algoritmo calcularMCD
	Definir m,n Como Entero
	
	Escribir mcd(24,6)

	
FinAlgoritmo

Funcion res <- mcd (m, n)
	Definir res Como Entero
	Definir resto Como Entero
	
	resto = m % n
	
	Si resto == 0
		res = n
	SiNo
		res = mcd (n,resto)
	FinSi
	
	
FinFuncion
	