package edu.unlam.letrasExtremas;

import java.io.FileNotFoundException;
import java.util.ArrayList;

public class LetrasExtremas {

	private Integer n = 0;
	private String name;
	private ArrayList<String> palabras;
	private static final int CANTIDAD_LETRAS = 26;
	private static final int ASCII_INICIAL = 97;
	private int vecLetras[] = new int[CANTIDAD_LETRAS];
	private ArrayList<Character> letrasGanadoras;
	private ArrayList<String> palabrasGanadoras;

	private Archivo archivo;

	public LetrasExtremas(String name) throws FileNotFoundException {
		this.name = name;
		this.archivo = new Archivo(LetrasExtremasTests.CARPETA_ENTRADA, this.name + ".in");
		this.archivo.prepararParaLeer();
		this.palabras = new ArrayList<String>();
		this.iniciar();
	}

	public void iniciar() {
		this.n = Integer.parseInt(this.archivo.leerSiguienteLinea());	//cantidad de letras a leer

		for (int i = 0; i < this.n; i++) {
			this.palabras.add(this.archivo.leerSiguienteLinea());
		}
	}

	public Archivo contarLetrasExtremas() {
		String palabra = null;

		for (int i = 0; i < this.n; i++) {
			palabra = this.palabras.get(i);

			// Guardo todas las letras en la posici�n ASCII - 'a' (97) para que
			// me queden ordenadas

			// primer letra de la palabra leida
			this.vecLetras[(int) palabra.charAt(0) - ASCII_INICIAL]++;

			// ultima letra de la palabra leida
			this.vecLetras[(int) palabra.charAt(palabra.length() - 1) - ASCII_INICIAL]++;

		}

		this.letrasGanadoras = new ArrayList<Character>();
		this.palabrasGanadoras = new ArrayList<String>();

		// Busco las letras con mas repeticiones
		int maximaCantidadRepetida = 0;
		for (int i = 0; i < CANTIDAD_LETRAS; i++) {
			if (this.vecLetras[i] > maximaCantidadRepetida) {
				this.letrasGanadoras.clear();
				this.letrasGanadoras.add((char) ((char) i + ASCII_INICIAL));
				maximaCantidadRepetida = this.vecLetras[i];
			} else if (maximaCantidadRepetida != 0 && this.vecLetras[i] == maximaCantidadRepetida) {
				this.letrasGanadoras.add((char) ((char) i + ASCII_INICIAL));
			}
		}

		
		// A partir de las letras, guardar las palabras ganadoras
		boolean esPalabraGanadora;
		for (int i = 0; i < this.palabras.size(); i++) {
			palabra = this.palabras.get(i);
			int j = 0;
			while (j < this.letrasGanadoras.size()) {
				
				//Primero tengo que verificar que esa palabra no se encuentre ya cargada
				//Luego la agrego
				if (palabra.charAt(0) == this.letrasGanadoras.get(j)
						|| palabra.charAt(palabra.length() - 1) == this.letrasGanadoras.get(j)) {
					
					int k = 0;
					while(k < this.palabrasGanadoras.size() && !palabra.equals(this.palabrasGanadoras.get(k)))
						k++;
					
					if(k == this.palabrasGanadoras.size() || this.palabrasGanadoras.isEmpty())	//si K lleg� al size es porque no est� repetida
						this.palabrasGanadoras.add(palabra);
				}
				
				j++;
			}
		}

		/*for (int i = 0; i < this.letrasGanadoras.size(); i++) {
			System.out.println(this.letrasGanadoras.get(i));
		}

		for (int i = 0; i < this.palabrasGanadoras.size(); i++) {
			System.out.println(this.palabrasGanadoras.get(i));
		}*/
		
		Archivo archivoOut = new Archivo(LetrasExtremasTests.CARPETA_OBTENIDA, this.name + ".out");
		archivoOut.imprimirOutput(letrasGanadoras, palabrasGanadoras);
		return archivoOut;
	}
}
