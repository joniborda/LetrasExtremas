package edu.unlam.letrasExtremas;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Archivo {

	public String name;
	public String contenido;
	private BufferedReader entradaBytes;
	private BufferedReader lector;

	public Archivo(String name) {
		this.name = name;
		this.contenido = "";
		InputStream entradaBytes = ClassLoader.class.getResourceAsStream("/data/" + this.name);
		this.lector = new BufferedReader(new InputStreamReader(entradaBytes));

	}

	public String leerSiguienteLinea() {
		String linea = null;
		try {
			if ((linea = this.lector.readLine()) != null) {
				return linea;
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				// significa fin de archivo
				if (linea == null) {
					this.lector.close();
					this.entradaBytes.close();
				}
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
		return null;
	}

	public void comienzo() throws IOException {
		this.lector.mark(0);
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

			String cadena1 = this.lector.readLine();
			String cadena2 = otro.lector.readLine();
			boolean iguales = true;

			while ((cadena1 != null) && (cadena2 != null) && iguales) {

				if (!cadena1.equals(cadena2)) {
					iguales = false;
				}

				cadena1 = this.lector.readLine();
				cadena2 = otro.lector.readLine();
			}

			this.lector.close();
			otro.lector.close();

			if ((iguales) && (cadena1 == null) && (cadena2 == null)) {
				return true;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		return false;
	}
}
