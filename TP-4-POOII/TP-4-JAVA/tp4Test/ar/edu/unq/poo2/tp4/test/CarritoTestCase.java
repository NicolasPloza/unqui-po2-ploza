package ar.edu.unq.poo2.tp4.test;


import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.unq.poo2.tp4.*;


class CarritoTestCase {
	Carrito unCarrito;
	Stock unStock = new Stock();
	
	@BeforeEach
	void setUp() throws Exception {
		unCarrito = new Carrito(unStock);
	}

	@Test
	void unCarritoSeCreaYEstaVacio() {
		
		assertTrue(unCarrito.getCompra().isEmpty());
	}
	
	@Test
	void seAgregaUnProductoAlCarritoSiHayDisponibilidadEnStock() {
		Producto unProducto = new ProductoTradicional(1234, 500);
		unStock.agregarProducto(unProducto, 100);
		
		unCarrito.agregarAlCarrito(unProducto);
		
		assertTrue(unCarrito.contiene(unProducto));
		
	}
	
	@Test
	void siIntentoAgregarUnProductoSinCantidadDisponibleEnStockSeLanzaUnaExcepcion(){
		
		Producto unProducto = new ProductoTradicional(1234, 500);
		unStock.agregarProducto(unProducto, 0); // la cantidad del producto es cero.
		
		IllegalArgumentException excepcion = assertThrows(IllegalArgumentException.class , 
												() -> unCarrito.agregarAlCarrito(unProducto));
		
		assertEquals("No se puede agregar un producto sin disponiblidad en Stock", excepcion.getMessage());
		
	}
	
	@Test
	void siIntentoAgregarUnProductoQueNuncaSeAgregoAlStockSeLanzaUnaExcepcion(){
		
		Producto unProducto = new ProductoTradicional(1234, 500);
		//el producto se instancia pero nunca se agrega a ningun stock.
		
		
		IllegalArgumentException excepcion = assertThrows(IllegalArgumentException.class , 
												() -> unCarrito.agregarAlCarrito(unProducto));
		
		assertEquals("No se puede agregar un producto sin disponiblidad en Stock", excepcion.getMessage());
		
	}
	
	
/*
	@Test
	void seAgregaUnaFacturaAlCarrito() {
		
	}
	*/
}
