package edu.unlam.letrasExtremas;

import java.util.ArrayList;

public class LetrasExtremas {

	private Integer n = 0;
	private ArrayList<String> palabras;
	private static final int CANTIDAD_LETRAS = 25;
	private static final int ASCII_INICIAL = 97;
	private int matLetras[] = new int[CANTIDAD_LETRAS];
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

		for (int i = 0; i < this.n; i++) {
			palabra = this.palabras.get(i);

			// Guardo todas las letras en la posición ASCII - 'a' (97) para que
			// me queden ordenadas

			// primer letra de la palabra leida
			this.matLetras[(int) palabra.charAt(0) - ASCII_INICIAL]++;

			// ultima letra de la palabra leida
			this.matLetras[(int) palabra.charAt(palabra.length() - 1) - ASCII_INICIAL]++;

		}

		this.letrasGanadoras = new ArrayList<Character>();
		this.palabrasGanadoras = new ArrayList<String>();

		// Busco las letras con mas repeticiones
		int maximaCantidadRepetida = 0;
		for (int i = 0; i < CANTIDAD_LETRAS; i++) {
			if (this.matLetras[i] > maximaCantidadRepetida) {
				this.letrasGanadoras.clear();
				this.letrasGanadoras.add((char) ((char) i + ASCII_INICIAL));
				maximaCantidadRepetida = this.matLetras[i];
			} else if (maximaCantidadRepetida != 0 && this.matLetras[i] == maximaCantidadRepetida) {
				this.letrasGanadoras.add((char) ((char) i + ASCII_INICIAL));
			}
		}

		// A partir de las letras guardar las palabras ganadoras
		boolean esPalabraGanadora;
		for (int i = 0; i < this.palabras.size(); i++) {
			palabra = this.palabras.get(i);

			int j = 0;
			esPalabraGanadora = false;
			while (!esPalabraGanadora && j < this.letrasGanadoras.size()) {

				if (palabra.charAt(0) == this.letrasGanadoras.get(j)
						|| palabra.charAt(palabra.length() - 1) == this.letrasGanadoras.get(j)) {
					this.palabrasGanadoras.add(palabra);
					esPalabraGanadora = true;
				}
				j++;
			}
		}

		for (int i = 0; i < this.letrasGanadoras.size(); i++) {
			System.out.println(this.letrasGanadoras.get(i));
		}

		for (int i = 0; i < this.palabrasGanadoras.size(); i++) {
			System.out.println(this.palabrasGanadoras.get(i));
		}

	}
}
