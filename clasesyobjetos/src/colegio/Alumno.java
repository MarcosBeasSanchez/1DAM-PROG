package colegio;

import java.time.LocalDate;
import clasesyobjetos.Libreria;
import daw.com.Pantalla;
import daw.com.Teclado;

public class Alumno {
	// constantes de la clase
		private static final int NNOTAS = 6;
		//Estado de la clase
		private String nombre;
		private String nia;
		private LocalDate fecha;
		private Asignatura[] asignaturas;
		
		
		public Alumno(String nombre, String nia, LocalDate fecha, Asignatura[] asignaturas) 
		{
			this.nombre = nombre;
			this.nia = nia;
			
			setFecha (fecha);
							
			if (asignaturas != null)
			{
				this.asignaturas = new Asignatura [asignaturas.length];
				
				for (int i = 0; i < asignaturas.length; i++)
				{
					this.asignaturas[i] = new Asignatura ();
					if (asignaturas[i]!= null)
						setAsignatura (i, asignaturas[i]);
				}
			}
			else
			{
				this.asignaturas = new Asignatura [NNOTAS];
				for (int i = 0; i < this.asignaturas.length; i++)
					this.asignaturas[i] = new Asignatura ();
			}
			
		}
		
		public Alumno (String nombre, String nia, LocalDate fecha)
		{
			this (nombre,nia,fecha,NNOTAS);
		}
		
		public Alumno (String nombre, String nia, LocalDate fecha, int cuantas)
		{
			this.nombre = nombre;
			this.nia = nia;
			
			setFecha (fecha);
			this.asignaturas = new Asignatura[cuantas];
			
			for (int i = 0; i < this.asignaturas.length; i++)
				asignaturas[i] = new Asignatura ();
			
		}
		
		public Alumno ()
		{
			this("", "", LocalDate.now().minusYears(18),NNOTAS);
			
		}
		
		public Alumno (Alumno original)
		{
			
			this (original.nombre, original.nia, original.fecha, original.asignaturas);
		}
		
		public Alumno (String nia)
		{
			this ("", nia, LocalDate.now().minusYears(18));
		}
		
		public String getNombre()
		{
			return nombre;
		}
		
		public void setNombre (String nuevoNombre)
		{
			nombre = nuevoNombre;
		}
	
		public String getNia() {
			return nia;
		}

		public void setNia(String nia) {
			this.nia = nia;
		}

		public LocalDate getFecha() {
			return fecha;
		}

		public void setFecha(LocalDate fecha) {
			if (fecha.plusYears(18).isAfter(LocalDate.now()))
				fecha = LocalDate.now().minusYears(18);
			
			this.fecha = fecha;
		}

		public void setAsignatura (int cual, Asignatura valor)
		{
			int pos;
			if (valor != null)
			{

				if (cual < 0)
					cual = 0;
				else if (cual >= asignaturas.length)
					cual = asignaturas.length - 1;
				pos = buscarAsignatura (valor.getNombre());
				if (pos == -1  ) // evitar repetidas
					this.asignaturas[cual] = new Asignatura(valor);
			}

		}
		
		public void setAsignatura (String nombre, int nota, int convocatoria)
		{
	
			int pos = buscarAsignatura(nombre);
			
			if (pos != -1)
			{
				asignaturas[pos].setNombre (nombre);
				asignaturas[pos].setNota (nota);
				asignaturas[pos].setConvocatoria (convocatoria);
			}
			
		}
		
		public int buscarAsignatura (String nombre)
		{
			int pos = -1;
			
			for (int i = 0; i < asignaturas.length && pos != -1; i++)
				if (nombre.equals(asignaturas[i].getNombre()))
					pos = i;
			
			return pos;
		}
		
		public boolean addAsignatura (Asignatura asignatura)
		{
			boolean exito = false;
			int pos;
			
			if (buscarAsignatura (asignatura.getNombre()) != -1)
			{
				pos = buscarAsignatura ("");
				if (pos != 1)
				{
					asignaturas[pos] = new Asignatura (asignatura);
					exito = true;
				}
			}

			return exito;
		}
		
		
		public Asignatura getAsignatura (int cual)
		{
			if (cual < 0)
				cual = 0;
			else if (cual >= asignaturas.length)
				cual = asignaturas.length - 1;

			return new Asignatura(asignaturas[cual]);
		}
		
		public int getCuantasAsignaturas ()
		{
			return asignaturas.length;
		}
		
		public void leerDatos ()
		{
			leerDatosNia();
			leerOtrosDatos();
		}
		
		public void leerDatosNia ()
		{
			nia = Teclado.leerString("Nia");
		}
		
		public void leerOtrosDatos ()
		{
			String fechaString;
			int cuantas;
			Asignatura temp;
			
			nombre = Teclado.leerString("Nombre Alumno:");
			fechaString = Teclado.leerString("\nFecha nacimiento (yyyy-mm-dd)");
			setFecha (LocalDate.parse(fechaString));
			
			// leer asignaturas
			cuantas = Libreria.leerEntreLimites(1, NNOTAS, "\nCuantas notas?");
			asignaturas = new Asignatura[cuantas];
			
			for (int i = 0; i < asignaturas.length; i++)
			{
				temp = new Asignatura ();
				do
				{
					temp.leerNombre();
				}while (buscarAsignatura (temp.getNombre())!= -1);
				
				temp.leerOtrosDatos();
				addAsignatura (temp);
			}
			
		}
		
		public void mostrarDatos ()
		{
			Pantalla.escribirString("\nNia " + nia);
			Pantalla.escribirString("\nNombre " + nombre);
			Pantalla.escribirString("\nFecha nacimiento " + fecha);
			
			for (int i = 0; i < asignaturas.length; i++)
				if (!asignaturas[i].getNombre().equals(""))
					asignaturas[i].mostrarDatos();
		}

		public boolean estaAprobado()
		{
			boolean aprobado = true;
			
			for (int i = 0; i < asignaturas.length && aprobado; i++)
				if (!asignaturas[i].getNombre().equals("") &&  !asignaturas[i].estaAprobada())
					aprobado = false;
		
			return aprobado;
		}
		
		public float getMedia ()
		{
			float media = 0;
			int cuantas = 0;

			for (int i = 0; i < asignaturas.length; i++)
				if (!asignaturas[i].getNombre().equals(""))
				{
					media += asignaturas[i].getNota();
					cuantas++;
				}

			if (cuantas > 0)
				media /=  cuantas;
			
			return media;
		}
		
		boolean equals (Alumno otro)
		{
			return otro != null && otro.nia.equals(nia);
		}
}