package ar.edu.unq.poo2.tp3.Test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ar.edu.unq.poo2.tp3.*;
import java.util.*;

class CounterTestCase {
	
	private Counter counter;
	/**
	* Crea un escenario de test básico, que consiste en un contador
	* con 10 enteros
	*
	* @throws Exception
	*/
	
	private  List<Integer> arregloDeEnteros = new ArrayList<Integer>();  

	@BeforeEach
	void setUp() throws Exception {
		
		//Se crea el contador
		counter = new Counter();
		//Se agregan los numeros. Un solo par y nueve impares
		counter.addNumber(1);
		counter.addNumber(3);
		counter.addNumber(5);
		counter.addNumber(7);
		counter.addNumber(9);
		counter.addNumber(1);
		counter.addNumber(1);
		counter.addNumber(1);
		counter.addNumber(1);
		counter.addNumber(4);
		
	}

	
	/**
	* Verifica la cantidad de pares
	*/

	@Test
	void testCantidadPares() {
		
		// Getting the even occurrences
		int amount = counter.getEvenOcurrences();
		// I check the amount is the expected one
		assertEquals(amount, 1);
		
	}
	
	
	/**
	 * Verifica la cantidad de impares
	 */
	
	
	@Test
	void testCantidadImpares() {
		
		// Getting the odd occurrences
		int amount = counter.getOddOcurrences();
		// I check the amount is the expected one
		assertEquals(amount, 9);
		
	}
	
	
	/**
	 * Verifica que dado un arreglo de números enteros, devuelve el número que tiene la mayor cantidad de dígitos pares
	 */
	
	@Test 
	void testDigitosPares(){
		
		arregloDeEnteros.add(55);
		arregloDeEnteros.add(525);
		arregloDeEnteros.add(556);
		arregloDeEnteros.add(2265);
		arregloDeEnteros.add(2222);
		
		int enteroConMasDigitosPares = counter.getEvenDigits(arregloDeEnteros);
		
		assertEquals(enteroConMasDigitosPares, 2222 );

	}
	
	
	@Test
	void testMultiploMasAlto() {
		
		int numero = counter.getMultiploMasAltoEntreCeroYMilDe(3, 9);
		
		assertEquals(numero,999);
		
	}
	
	
}
























