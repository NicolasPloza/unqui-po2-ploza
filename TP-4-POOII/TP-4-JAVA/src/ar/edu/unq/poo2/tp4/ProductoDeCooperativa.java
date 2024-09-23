package ar.edu.unq.poo2.tp4;

public class ProductoDeCooperativa extends Producto {
	
	public ProductoDeCooperativa (int codigo, double precio){
		
		super(codigo, precio);
	}
	

	@Override
	public double getMonto() {
		
		return precio - descuentoIVA() ;
	}

	private double descuentoIVA() {
		
		return precio * 0.1;
	}




}
