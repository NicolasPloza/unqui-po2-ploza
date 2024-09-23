package ar.edu.unq.poo2.tp4.test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ar.edu.unq.poo2.tp4.*;
import java.util.*;

class CajaTestCase {
	Stock unStock;
	Caja unaCaja;
	Carrito unCarrito;
	Producto producto;
	Producto productoCoop;
	List<Registrable> unaCompra;
	Registrable factura;
	Registrable impuesto;
	Factura unServicio;
	Factura unImpuesto;
	
	
	@BeforeEach
	void setUp() throws Exception {
		
		producto = new ProductoTradicional(2856, 200.5);
		productoCoop = new ProductoDeCooperativa(3698, 500);
		unServicio = new Servicio(200.6 , 30 );
		unImpuesto = new Impuesto(3000);
		
		unStock = new Stock();
		unStock.agregarProducto(producto, 300);
		unStock.agregarProducto(productoCoop, 5);
		
		unaCaja = new Caja();
		unCarrito = new Carrito(unStock);
		
	}

	@Test
	void unaCajaProcesaUnaCompraVaciaYElMontoEsCero() {
		
		unaCompra = unCarrito.getCompra();
		
		assertEquals(0 , unaCaja.procesarCompra(unaCompra));
		
	}
	
	@Test 
	void seProcesaUnaCompraConUnSoloProductoYElResultadoEsSuMonto() {
		unCarrito.agregarAlCarrito(producto);
		unaCompra = unCarrito.getCompra();
		
		assertEquals(200.5, unaCaja.procesarCompra(unaCompra));
		
	}
	
	@Test
	void seProcesaUnaCompraConVariosproductosYElResultadoEsLaSumaDeSusMontos() {
		unCarrito.agregarAlCarrito(producto);
		unCarrito.agregarAlCarrito(productoCoop);
		unaCompra = unCarrito.getCompra();
		
		double montoBuscado = producto.getMonto() + productoCoop.getMonto(); 
		
		assertEquals(montoBuscado, unaCaja.procesarCompra(unaCompra));
	
	}
	
	@Test
	void seProcesaUnaCompraConUnServicoYUnImpuesto() {
		unCarrito.agregarAlCarrito(unServicio);
		unCarrito.agregarAlCarrito(unImpuesto);
	
		unaCompra = unCarrito.getCompra();
		double montoBuscado = unServicio.getMonto() + unImpuesto.getMonto();
		
		assertEquals(montoBuscado, unaCaja.procesarCompra(unaCompra));
	
	}
	
	
	
	
	

}
