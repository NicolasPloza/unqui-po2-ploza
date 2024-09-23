package ar.edu.unq.poo2.tp4;

import java.util.List;

public class Caja {
	
	
	
	public double procesarCompra(List<Registrable> registrables) {
	
		double montoACobrar = 0;
		
		for (Registrable registrable : registrables  ) {
			
			montoACobrar += registrable.getMonto();
			registrable.realizarRegistro();
		}
		
		return montoACobrar;
		
	}
	
	
}
