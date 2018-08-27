package edu.unlam.letrasExtremas;

import java.util.ArrayList;

public class LetrasExtremas {

	private Integer n = 0;
	private ArrayList<String> palabras;
	private int matLetras[][] = new int[2][25];

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

			/**
			 * Guardo todas las letras en la posición ASCII - 'a' (97) para que
			 * me queden ordenadas en mi matriz en la segunda fila (fila 1)
			 * guardo la cantidad de apariciones de todas las letras
			 */
			// TODO: ver que pasa con la ñ
			// primer letra de la palabra leida
			if (this.matLetras[0][(int) palabra.charAt(0) - 97] != 0) {
				// si aún no hay una letra cargada guardo la primera
				this.matLetras[0][(int) palabra.charAt(0) - 97] = (int) palabra.charAt(0);
			}

			this.matLetras[1][(int) palabra.charAt(0) - 97]++;

			// ultima letra de la palabra leida
			if (this.matLetras[0][(int) palabra.charAt(palabra.length()) - 97] != 0) {
				this.matLetras[0][(int) palabra.charAt(palabra.length()) - 97] = (int) palabra.charAt(palabra.length());
			}

			this.matLetras[1][(int) palabra.charAt(palabra.length()) - 97]++;

		}

		for (int i = 0; i < this.n; i++) {

		}
	}
}
