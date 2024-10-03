package ar.edu.unq.poo2.tp3.Test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ar.edu.unq.poo2.tp3.*;

class PointTestCase {

	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	void seCreaUnPunto() {

		Point punto = new Point(2,10);
		
		assertEquals(2, punto.getX());
		assertEquals(10, punto.getY());
	}
	
	@Test 
	void seCreaUnPuntoSinParametros(){
		
		Point puntoSinParametros = new Point();
		
		assertEquals(0, puntoSinParametros.getX());
		assertEquals(0, puntoSinParametros.getY());
	}
	
	@Test 
	void seMueveUnPuntoAOtraPosicion() {
		
		Point punto = new Point(10 , 12);
		punto.moverAPosicion(5,8);
		
		assertEquals(5,punto.getX());
		assertEquals(8,punto.getY());
		
	}
	
	@Test 
	void seSumanDosPuntos() {
		
		Point punto1 = new Point(10 , 12);
		Point punto2 = new Point(8 , 6);
		Point nuevoPunto = punto1.sumarCon(punto2);
		
		assertEquals(18,nuevoPunto.getX());
		assertEquals(18,nuevoPunto.getY());
		
	}
	
	
	
}
