package colegioProf;

import java.util.ArrayList;
import java.util.List;

public enum TipoEstudios {
	ESO(4), BACHILLERATO(2), FPGM(2), FPGS(2);

	private int cursos;

	private TipoEstudios(int cursos) {
		this.cursos = cursos;
	}

	public int getCursos() {
		return cursos;
	}

	public static TipoEstudios toTipoEstudios(String tipo) {

		TipoEstudios tipoEstudio;
		List<String> tipos = new ArrayList<>();

		tipo = tipo.toUpperCase();

		for (TipoEstudios t : TipoEstudios.values())
			tipos.add(t.toString());

		tipoEstudio = tipos.contains(tipo) ? TipoEstudios.valueOf(tipo) : TipoEstudios.ESO;
		return tipoEstudio;
	}
}
