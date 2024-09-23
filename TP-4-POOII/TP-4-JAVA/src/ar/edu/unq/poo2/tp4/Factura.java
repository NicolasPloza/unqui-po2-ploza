package ar.edu.unq.poo2.tp4;

public abstract class Factura implements Registrable {
	
	protected Agencia agencia; 
	
	
	protected Factura(){
		
	}
	
	
	public abstract double getMonto();
	
	public void realizarRegistro() {
		//agencia.registrarPago(this);
	}
	
	
	public void agregarseACarrito(Carrito carrito) {
		
		carrito.agregarFactura(this);
	}

}
