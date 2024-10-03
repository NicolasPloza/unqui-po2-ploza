package ar.edu.unq.poo2.tp3.Test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ar.edu.unq.poo2.tp3.*;	

class RectanguloTestCase {
	
	private Rectangulo rectangulo;
	private Point esquinaSupIzq;
	private int ancho;
	private int alto;
	
	@BeforeEach
	void setUp() throws Exception {
		
	}

	@Test
	void seCreaUnRectangulo() {
		
		esquinaSupIzq = new Point(0,10);
		ancho = 10; 
		alto  = 5;
	
		rectangulo = new Rectangulo(esquinaSupIzq,ancho,alto);
		
		assertEquals(5, rectangulo.getAlto());
		assertEquals(10, rectangulo.getAncho());
		
		assertEquals( 10 , rectangulo.getEsquinaSupDer().getX());  
		assertEquals( 10 , rectangulo.getEsquinaSupDer().getY());
		assertEquals( 10 , rectangulo.getEsquinaInfDer().getX());
		assertEquals( 5 , rectangulo.getEsquinaInfDer().getY());
		assertEquals( 0 , rectangulo.getEsquinaInfIzq().getX());
		assertEquals( 5 , rectangulo.getEsquinaInfIzq().getY());
	}
	
	@Test 
	void seObtieneElArea() {
		ancho = 20;
		alto = 10;
		esquinaSupIzq = new Point(0,10);
		rectangulo = new Rectangulo(esquinaSupIzq, ancho, alto);
		
		assertEquals( 200 , rectangulo.getArea());
			
	}
	
	@Test 
	void seObtieneElPerimetro() {
		ancho = 20;
		alto = 10;
		esquinaSupIzq = new Point(0,10);
		rectangulo = new Rectangulo(esquinaSupIzq, ancho, alto);
		
		assertEquals( 60 , rectangulo.getPerimetro());
			
	}
	
	
	@Test 
	void determinaSiEsHorizontalOVertical(){
		
		ancho = 20;
		alto = 10;
		esquinaSupIzq = new Point(0,10);
		rectangulo = new Rectangulo(esquinaSupIzq, ancho, alto);
		
		assertTrue(rectangulo.esHorizontal() );
		assertFalse(rectangulo.esVertical() );
		
	}
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
