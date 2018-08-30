package edu.unlam.letrasExtremas;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Archivo {

	public String path;
	public String name;
	private Scanner sc;

	public Archivo(String path, String name) {
		this.path = path;
		this.name = name;
	}

	public void prepararParaLeer() throws FileNotFoundException {
		this.sc = new Scanner(new File(this.path + this.name));
	}

	public String leerSiguienteLinea() {
		if (this.sc.hasNext()) {
			return this.sc.next();
		}
		this.sc.close();
		return null;
	}

	public void comienzo() throws IOException {
		if (this.sc == null) {
			this.sc = new Scanner(new File(this.path + this.name));
		}
		this.sc.reset();
	}

	/**
	 * Comparador de archivos para los tests
	 * 
	 * @param otro
	 * 
	 * @return Si es igual
	 */
	public boolean equals(Object obj) {
		try {
			Archivo otro = (Archivo) obj;

			this.comienzo();
			otro.comienzo();

			String cadena1 = this.sc.next();
			String cadena2 = otro.sc.next();
			boolean iguales = true;

			while ((cadena1 != null) && (cadena2 != null) && iguales) {

				if (!cadena1.equals(cadena2)) {
					iguales = false;
				}

				cadena1 = null;
				cadena2 = null;
				if (this.sc.hasNext()) {
					cadena1 = this.sc.next();
					cadena2 = otro.sc.next();
				}
			}

			this.sc.close();
			otro.sc.close();

			if ((iguales) && (cadena1 == null) && (cadena2 == null)) {
				return true;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		return false;
	}

	public void imprimirOutput(ArrayList<Character> letrasGanadoras, ArrayList<String> palabrasGanadoras) {

		FileWriter fichero = null;
		PrintWriter pw = null;
		try {
			fichero = new FileWriter(this.path + this.name);
			pw = new PrintWriter(fichero);

			for (int i = 0; i < letrasGanadoras.size(); i++) {
				pw.print(letrasGanadoras.get(i) + "\t");
			}
			pw.println();
			
			for (int i = 0; i < palabrasGanadoras.size(); i++) {
				pw.println(palabrasGanadoras.get(i));
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				// Nuevamente aprovechamos el finally para
				// asegurarnos que se cierra el fichero.
				if (fichero != null) {
					fichero.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}
}
