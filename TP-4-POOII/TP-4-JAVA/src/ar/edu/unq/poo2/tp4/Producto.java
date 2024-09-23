package ar.edu.unq.poo2.tp4;

public abstract class Producto implements Registrable{
	protected int codigo;
	protected double precio;
	protected Stock stock; 
	
	public Producto() {
		
	}
	
	
	public Producto(int codigo, double precio) {
		
		this.codigo = codigo;
		this.precio = precio;

	}

	
	public abstract double getMonto();


	public void setCodigo(int codigo) {
		
		this.codigo = codigo;
	}

	public void setPrecio(double precio) {
		
		this.precio = precio;
	}
	
	public void setStock(Stock unStock) {
		
		this.stock = unStock;
	}
	

	public Integer getCodigo() {
		return codigo;
	}
	
	
	public void realizarRegistro() {
		
		stock.registrarVenta(this);

	}
	
	public void agregarseACarrito(Carrito carrito) {
		
		carrito.agregarProducto(this);
	}


	
}
