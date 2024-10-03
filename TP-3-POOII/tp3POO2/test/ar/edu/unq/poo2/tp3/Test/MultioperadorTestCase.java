package ar.edu.unq.poo2.tp3.Test;

import static org.junit.jupiter.api.Assertions.*;
import ar.edu.unq.poo2.tp3.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.unq.poo2.tp3.Multioperador;
import java.util.*;

class MultioperadorTestCase {
	
	private Multioperador multioperador;
	private List<Integer> listaDeEnteros = new ArrayList<Integer>();
	
	
	
	@BeforeEach
	void setUp() throws Exception {
		multioperador = new Multioperador();
		
		listaDeEnteros.add(5);
		listaDeEnteros.add(8);
		listaDeEnteros.add(10);
		listaDeEnteros.add(15);
		listaDeEnteros.add(-2);
		listaDeEnteros.add(6);
		listaDeEnteros.add(7);
		listaDeEnteros.add(9);
		listaDeEnteros.add(-10);
		
	}

	@Test
	void testSuma() {
		int result = multioperador.sumaDeEnteros(listaDeEnteros);
		assertEquals(48, result);
	}
	
	@Test
	void testResta(){
		int result = multioperador.restaDeEnteros(listaDeEnteros);
		assertEquals(-38, result);
	}
	
	@Test
	void testMult(){
		int result = multioperador.multiplicacionDeEnteros(listaDeEnteros);
		assertEquals(45360000, result);
	}
}
