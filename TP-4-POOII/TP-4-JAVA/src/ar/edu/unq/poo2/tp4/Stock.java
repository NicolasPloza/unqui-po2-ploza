package ar.edu.unq.poo2.tp4;
import java.util.*;


public class Stock {
	
	private Map<Integer,Integer> productos = new HashMap<>();

	public void agregarProducto(Producto unProducto, int unidades) {
		
		unProducto.setStock(this);
		productos.put(unProducto.getCodigo(), unidades);
		
	}

	public Integer cantUnidadesProducto(Producto unProducto) {
		
		return productos.get(unProducto.getCodigo()) ;
	}

	public Boolean hayStockDe(Producto unProducto) {
		
		return productos.containsKey(unProducto.getCodigo()) 
			   && cantUnidadesProducto(unProducto) > 0 ;    
	}

	public void registrarVenta(Producto unProducto) {
		
		int cantidadAntesDeLaVenta = cantUnidadesProducto(unProducto);	
		int nuevaCantidad = cantidadAntesDeLaVenta - 1 ;

		productos.put(unProducto.getCodigo(), nuevaCantidad);
	}
	
	
	
}
