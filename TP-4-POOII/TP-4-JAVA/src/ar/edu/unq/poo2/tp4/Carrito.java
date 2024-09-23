package ar.edu.unq.poo2.tp4;
import java.util.*;


public class Carrito {
	
	private Stock stock;
	private List<Registrable> compra = new ArrayList<Registrable>();

	public Carrito() {
		
	}
	
	public Carrito(Stock unStock) {
		this.stock = unStock;
	}
	
	public List<Registrable> getCompra() {
		
		return compra;
	}

	public void agregarAlCarrito(Registrable registrable) {
		
		registrable.agregarseACarrito(this);
	}


	public Boolean contiene(Registrable registrable) {
	
		return compra.contains(registrable);
	}


	public void agregarProducto(Producto producto) {
		
		if ( ! stock.hayStockDe(producto) ) {
			throw new IllegalArgumentException ("No se puede agregar un producto sin disponiblidad en Stock");
		}
		
		
		compra.add(producto);
	}

	public void agregarFactura(Factura factura) {
		
		compra.add(factura);
	}
	
	
	
	
}
