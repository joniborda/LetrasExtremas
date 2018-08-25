package edu.unlam.letrasExtremas;

import java.util.ArrayList;

public class LetrasExtremas {

	private int n = 0;
	private ArrayList<String> palabras;
	
	private String ruta_archivo;
	private Archivo archivo;
	
	public LetrasExtremas(int n, ArrayList<String> palabras, String ruta_archivo) {
		this.n = n;
		this.palabras = palabras;
		this.ruta_archivo = ruta_archivo;
		this.archivo = new Archivo("empate.in");
	}
	

}
