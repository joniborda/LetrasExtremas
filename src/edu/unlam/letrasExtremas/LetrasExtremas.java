package edu.unlam.letrasExtremas;

import java.util.ArrayList;

public class LetrasExtremas {

	private Integer n = 0;
	private ArrayList<String> palabras;

	private ArrayList<Letra> letras;

	private Archivo archivo;

	public LetrasExtremas(String ruta_archivo) {
		this.archivo = new Archivo(ruta_archivo);
		this.palabras = new ArrayList<String>();
		this.iniciar();
	}
	public void iniciar() {
		this.n = Integer.parseInt(this.archivo.leerSiguienteLinea());

		for (int i = 0; i < this.n; i++) {
			this.palabras.add(this.archivo.leerSiguienteLinea());
		}
	}

	public void contarLetrasExtremas() {
		String palabra = null;
		for (int i = 0; i < this.n; i++) {
			palabra = this.palabras.get(i);
			// TODO: tengo que hacer que agregar una letra y si ya exitia tiene
			// que incrementar el contador
			this.letras.add(new Letra(palabra.charAt(palabra.length())));
		}
	}
}
