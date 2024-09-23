package ar.edu.unq.poo2.tp4.test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ar.edu.unq.poo2.tp4.*;

class ProductoTestCase {

	Stock stock = new Stock();
	Producto unProducto = new ProductoTradicional(1234,500);
	
	@BeforeEach
	void setUp() throws Exception {
		stock.agregarProducto(unProducto, 1000);
	}

	@Test
	void unProductoEnStockRealizaSuRegistroYSuCantidadDecrementa(){
		
		int cantidadDeUnidades = stock.cantUnidadesProducto(unProducto);
		
		unProducto.realizarRegistro();
		
		assertEquals(cantidadDeUnidades - 1, stock.cantUnidadesProducto(unProducto));
	}
	


}
