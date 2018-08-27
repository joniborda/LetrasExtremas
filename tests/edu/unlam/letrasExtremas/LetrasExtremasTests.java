package edu.unlam.letrasExtremas;

import junit.framework.Assert;

import org.junit.Test;

public class LetrasExtremasTests {

	@Test
	public void archivosIguales() {
		Archivo a1 = new Archivo("/prueba/entrada/empate.in");
		Archivo a2 = new Archivo("/prueba/entrada/empate.in");
		Assert.assertEquals(a2, a1);
	}

	@Test
	public void tresLetrasExtremasEmpatan() {
		LetrasExtremas le = new LetrasExtremas("/prueba/entrada/empate.in");
	}

	@Test
	public void verificacionDeFormato() {

	}

	@Test
	public void laPalabraNoDebeSuperarElMaximoPermitido() {

	}
}
