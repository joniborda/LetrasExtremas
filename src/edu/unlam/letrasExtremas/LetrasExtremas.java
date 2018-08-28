package edu.unlam.letrasExtremas;

import java.util.ArrayList;

public class LetrasExtremas {

	private Integer n = 0;
	private ArrayList<String> palabras;
	private static final int CANTIDAD_LETRAS = 26;
	private int matLetras[][] = new int[2][CANTIDAD_LETRAS];
	private ArrayList<Character> letrasGanadoras;
	private ArrayList<String> palabrasGanadoras;

	private Archivo archivo;

	public LetrasExtremas(String path) {
		this.archivo = new Archivo(path, "EXTREMAS.IN");
		this.palabras = new ArrayList<String>();
		this.iniciar();
		this.contarLetrasExtremas();
	}

	public void iniciar() {
		this.n = Integer.parseInt(this.archivo.leerSiguienteLinea());

		for (int i = 0; i < this.n; i++) {
			this.palabras.add(this.archivo.leerSiguienteLinea());
		}
	}

	public void contarLetrasExtremas() {
		String palabra = null;

		for (int i = 0; i < this.n; i++) { // for que recorre el arrayList de
											// palabras
			palabra = this.palabras.get(i); // me traigo la palabra

			// Guardo todas las letras en la posici�n ASCII - 'a' (97) para que
			// me queden
			// ordenadas en mi matriz
			// en la segunda fila (fila 1) guardo la cantidad de apariciones de
			// todas las
			// letras

			// primer letra de la palabra leida
			int primera_letra = (int) palabra.charAt(0) - 97;

			if (this.matLetras[0][primera_letra] == 0) {
				// si a�n no hay una letra cargada guardo la primera
				this.matLetras[0][(int) palabra.charAt(0) - 97] = (int) palabra.charAt(0);
				this.matLetras[0][primera_letra] = (int) palabra.charAt(0);
			} // la
				// primera
			this.matLetras[1][primera_letra]++;

			// ultima letra de la palabra leida
			int ultima_letra = (int) palabra.charAt(palabra.length() - 1) - 97;
			if (this.matLetras[0][ultima_letra] == 0) {
				this.matLetras[0][ultima_letra] = (int) palabra.charAt(palabra.length() - 1);
			}

			this.matLetras[1][ultima_letra]++;

		}

		this.letrasGanadoras = new ArrayList<Character>();
		this.palabrasGanadoras = new ArrayList<String>();
		// Debo buscar la o las letras ganadoras. Recorro la matriz de letras
		this.letrasGanadoras.add((char) this.matLetras[0][0]);
		int cantRepeLetra = this.matLetras[1][0]; // guardo la primer letra y la
													// cantidad de repeticiones

		for (int i = 1; i < 25; i++) {
			if (this.matLetras[1][i] > cantRepeLetra) {
				this.letrasGanadoras.clear();
				this.letrasGanadoras.add((char) this.matLetras[0][i]);
				cantRepeLetra = this.matLetras[1][i];
			} else if (this.matLetras[1][i] == cantRepeLetra)
				this.letrasGanadoras.add((char) this.matLetras[0][i]);

		}

		// Debo buscar la o las palabras ganadoras. Recorro el arrayList de
		// palabras
		for (int i = 0; i < this.palabras.size(); i++) {
			palabra = this.palabras.get(i);

			for (int j = 0; j < this.letrasGanadoras.size(); j++) {

				if (palabra.charAt(0) == this.letrasGanadoras.get(j)
						|| palabra.charAt(palabra.length() - 1) == this.letrasGanadoras.get(j)) {

					// busco si la palabra est� repetida este while busca la
					// palabra analizada dentro de las ganadoras, si ya est�
					// sale del while, caso contrario la busca hasta el final.
					// Como tiene el operador &&, con solo verificar una
					// condicion ya es suficiente para relizar el corte.

					int k = 0;
					while (k < this.palabrasGanadoras.size() && this.palabrasGanadoras.get(k) != palabra) {
						k++;
					}

					// si el K sale con la cantidad de elementos del
					// arraylist es porque no encontr� la palabra
					if (k == this.palabras.size()) {
						this.palabrasGanadoras.add(palabra);
					}
				}
			}
		}

	}
}
