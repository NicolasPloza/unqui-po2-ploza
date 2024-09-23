package ar.edu.unq.poo2.tp4;

public class Servicio extends Factura {

	private double costoPorUnidad;
	private int cantUnidades;
	
	public Servicio(double costoPorUnidad , int cantUnidades ) {
		super();
		
		this.costoPorUnidad = costoPorUnidad;
		this.cantUnidades = cantUnidades;
	}
	
	@Override
	public double getMonto() {
		
		return costoPorUnidad * cantUnidades;
	}

}
