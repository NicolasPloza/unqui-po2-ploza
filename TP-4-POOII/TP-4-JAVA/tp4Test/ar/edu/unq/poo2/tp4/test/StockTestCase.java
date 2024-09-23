package ar.edu.unq.poo2.tp4.test;

import ar.edu.unq.poo2.tp4.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class StockTestCase {

	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	void seAgregaUnNuevoProducto() {
		int unidades = 1000;
		Producto unProducto = new ProductoDeCooperativa(1234, 600);
		Stock unStock = new Stock();
		
		unStock.agregarProducto(unProducto,unidades);
		
		assertTrue(unStock.hayStockDe(unProducto) );
		assertEquals(unidades , unStock.cantUnidadesProducto(unProducto) );
		
	}

}
