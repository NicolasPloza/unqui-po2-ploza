package ar.edu.unq.poo2.tp4;

public class Impuesto extends Factura {

	private double costoFijo;
	
	public Impuesto(double costoFijo) {
		super();
		
		this.costoFijo = costoFijo;
	}
	
	@Override
	public double getMonto() {
		
		return costoFijo;
	}

}
