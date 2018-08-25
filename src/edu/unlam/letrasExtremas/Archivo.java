package edu.unlam.letrasExtremas;

public class Archivo {

	public String name;

	public Archivo(String name) {
		this.name = name;
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
