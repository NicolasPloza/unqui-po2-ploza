package ar.edu.unq.poo2.tp3.Test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ar.edu.unq.poo2.tp3.*;

class CuadradoTestCase {

	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	void puedeCalcularElArea() {
		Point esquinaSupIzq = new Point(0,10);
		Cuadrado cuadrado = new Cuadrado(esquinaSupIzq, 10);
		
		
		assertEquals(100 , cuadrado.getArea());
		
	}
	
	@Test
	void puedeCalcularElPerimetro() {
		Point esquinaSupIzq = new Point(0,10);
		Cuadrado cuadrado = new Cuadrado(esquinaSupIzq, 10);
		
		
		assertEquals(40 , cuadrado.getPerimetro());
		
	}

	
}
