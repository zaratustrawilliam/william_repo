package com.hbt.semillero.servicios;

import org.testng.Assert;
import org.testng.annotations.Test;

public class AppTest {

	public void shouldAnswerWithTrue() {

	}

	private String invertirCadena(String cadena) {
        String cadenaInvertida = "";
        for (int x = cadena.length() - 1; x >= 0; x--) {
                      cadenaInvertida = cadenaInvertida + cadena.charAt(x);
        }
        return cadenaInvertida;
	}
	
	@Test(description = "Caso inversion de la cadena")
	public void invertirCadenaPU() {
		String cadenaInvertir = "codigo";
		String cadenaEsperada = "ogidoc";
		Assert.assertEquals(invertirCadena(cadenaInvertir), cadenaEsperada);
	}
	
	@Test(description = "Caso donde el parametro es vacio")
	public void invertirCadenaPU2() {
		Assert.assertEquals(invertirCadena(""),"");
	}
	
	@Test(description = "Caso de inversion que la cadena")
	public void invertirCadenaPU3() {
		Assert.assertNotEquals(invertirCadena("abac"),"abac");
	}
	
	@Test(description = "Caso de verificacion del tamaño de la cadena invertida")
	public void invertirCadenaPU4() {
		Assert.assertEquals(invertirCadena("suma").length(),4);
	}
	
	@Test(description = "Caso de verificacion de cadenas con espacios")
	public void invertirCadenaPU5() {
		Assert.assertEquals(invertirCadena("a la ")," al a");
	}
	
	@Test(description = "Caso de verificacion de cadenas con caracteres   especiales")
	public void invertirCadenaPU6() {
		Assert.assertEquals(invertirCadena("hol$_op"),"po_$loh");
	}

}




