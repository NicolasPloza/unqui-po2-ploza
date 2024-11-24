package module;
import java.util.*;


public class FiltroDeNotificacion implements Interesado {
	
	private Interesado interesado;
	
	Set<String> deportes;
	Set<String> contrincantes;
	
	public FiltroDeNotificacion(Interesado interesado) {
		this.interesado = interesado;
		this.deportes = new HashSet<>();
		this.contrincantes = new HashSet<>();
	}
	
	public Interesado getInteresado() {
		return this.interesado;
	}

	public void agregarDeporte(String deporte) {
		
		this.getDeportesDeInteres().add(deporte);
	}
	
	public Set<String> getDeportesDeInteres(){
		return this.deportes;
	}

	public Set<String> getContrincantesDeInteres() {
		
		return this.contrincantes;
	}

	public void agregarContrincante(String contrincante) {
		
		this.getContrincantesDeInteres().add(contrincante);
	}

	public void removerContrincante(String contrincante) {
		
		this.getContrincantesDeInteres().remove(contrincante);
	}

	public void removerDeporte(String deporte) {
		
		this.getDeportesDeInteres().remove(deporte);
	}
	
	public void update(Partido partido) {
		if(tieneDeporteDeInteres(partido) || tieneContrincanteDeInteres(partido) ) {
			this.getInteresado().update(partido);
		}
	}
	
	
	public boolean tieneDeporteDeInteres(Partido partido) {
		return getDeportesDeInteres().contains(partido.getDeporte());
	}
	
	

	public boolean tieneContrincanteDeInteres(Partido partido) {
		
		return this.getContrincantesDeInteres().stream().anyMatch( c -> partido.tieneContrincante(c) );
	}

	public boolean tieneInteresado(Interesado interesado) {
		
		return this.getInteresado().equals(interesado);
	}

	public boolean tieneInteresEnDeporte(String deporte) {
		
		return this.getDeportesDeInteres().contains(deporte);
	}

	public boolean tieneIntereses() {
		
		return !( this.getDeportesDeInteres().isEmpty() 
				&& this.getContrincantesDeInteres().isEmpty() ) ;
	}

	public boolean tieneInteresEnContrincante(String contrincante) {
		
		return this.getContrincantesDeInteres().contains(contrincante);
	}
	
}
