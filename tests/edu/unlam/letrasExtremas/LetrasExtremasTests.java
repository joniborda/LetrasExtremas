package edu.unlam.letrasExtremas;

import org.junit.Assert;
import org.junit.Test;

public class LetrasExtremasTests {

	@Test
	public void archivosIguales() {
		Archivo a1 = new Archivo("/prueba/entrada/", "EXTREMAS.in");
		Archivo a2 = new Archivo("/prueba/entrada/", "EXTREMAS.in");
		Assert.assertEquals(a2, a1);
	}

	@Test
	public void tresLetrasExtremasEmpatan() {
		LetrasExtremas le = new LetrasExtremas("/prueba/entrada/");
	}

	@Test
	public void verificacionDeFormato() {

	}

	@Test
	public void laPalabraNoDebeSuperarElMaximoPermitido() {

	}
}
