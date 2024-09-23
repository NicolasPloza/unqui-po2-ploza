package ar.edu.unq.poo2.tp4;


public class ProductoTradicional extends Producto {
	

	
	public ProductoTradicional(int codigo, double precio){
		
		super(codigo, precio);
	}
	

	@Override
	public double getMonto() {
		
		return precio;
	}

	

}
