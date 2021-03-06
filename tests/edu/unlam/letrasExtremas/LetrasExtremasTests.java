package edu.unlam.letrasExtremas;

import java.io.FileNotFoundException;

import org.junit.Assert;
import org.junit.Test;

public class LetrasExtremasTests {

	public static final String CARPETA_ENTRADA = "resource/prueba/entrada/";
	public static final String CARPETA_OBTENIDA = "resource/prueba/obtenida/";
	public static final String CARPETA_ESPERADA = "resource/prueba/esperada/";
	@Test
	public void archivosIguales() throws FileNotFoundException {
		Archivo a1 = new Archivo(CARPETA_ENTRADA, "EXTREMAS.in");
		Archivo a2 = new Archivo(CARPETA_ENTRADA, "EXTREMAS.in");
		Assert.assertEquals(a2, a1);
	}

	@Test
	public void tresLetrasExtremasEmpatan() throws FileNotFoundException {
		LetrasExtremas le = new LetrasExtremas("EXTREMAS");
		Archivo a1 = le.contarLetrasExtremas();
		Archivo a2 = new Archivo(CARPETA_ESPERADA, "EXTREMAS.out");
		Assert.assertEquals(a2, a1);
	}
	
	/*@Test
	public void verificacionDeFormato() {

	}*/


	@Test
	public void noDebeRepetirPalabras() throws FileNotFoundException {
		LetrasExtremas obtenidas = new LetrasExtremas("06_NoRepetirPalabras");
		Archivo obtenido = obtenidas.contarLetrasExtremas();
		Archivo esperado = new Archivo(CARPETA_ESPERADA, "06_NoRepetirPalabras.out");
		Assert.assertEquals(esperado, obtenido);
	}
	
	@Test
	public void casoFatiga() throws FileNotFoundException {
		LetrasExtremas obtenidas = new LetrasExtremas("09_CasoFatiga");
		Archivo obtenido = obtenidas.contarLetrasExtremas();
		Archivo esperado = new Archivo(CARPETA_ESPERADA, "09_CasoFatiga.out");
		Assert.assertEquals(esperado, obtenido);
	}
	
	@Test
	public void repeticionLetraExtrema() throws FileNotFoundException {
		LetrasExtremas obtenidas = new LetrasExtremas("04_RepeticionLetraExtrema");
		Archivo obtenido = obtenidas.contarLetrasExtremas();
		Archivo esperado = new Archivo(CARPETA_ESPERADA, "04_RepeticionLetraExtrema.out");
		Assert.assertEquals(esperado, obtenido);
	}
	
	@Test
	public void conteoLetraExtremaUnica() throws FileNotFoundException {
		LetrasExtremas obtenidas = new LetrasExtremas("05_ConteoLetraExtremaUnica");
		Archivo obtenido = obtenidas.contarLetrasExtremas();
		Archivo esperado = new Archivo(CARPETA_ESPERADA, "05_ConteoLetraExtremaUnica.out");
		Assert.assertEquals(esperado, obtenido);
	}
}
