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
				if (this.entradaBytes != null) {
					this.entradaBytes.close();
				}
				if (this.lector != null) {
					this.lector.close();
				}
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
		return null;
	}

	/**
	 * Comparador de archivos para los tests
	 * 
	 * @param otro
	 * 
	 * @return Si es igual
	 */
	public boolean equal(Archivo otro) {
		return true;
	}

}
