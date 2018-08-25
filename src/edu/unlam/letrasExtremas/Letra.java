package edu.unlam.letrasExtremas;


public class Letra {

	private char letra;
	private Integer cantidad;
	public Letra(char letra) {
		this.letra = letra;
		this.cantidad = 0;
	}

	public char getLetra() {
		return letra;
	}
	public void setLetra(char letra) {
		this.letra = letra;
	}
	public Integer getCantidad() {
		return cantidad;
	}
	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}

	public void incrementar() {
		this.cantidad++;
	}
}
