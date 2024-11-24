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
	
	public void actualizarDeporte(Partido partido) {
		if( getDeportesDeInteres().contains(partido.getDeporte())) {
			this.getInteresado().actualizarDeporte(partido);
		}
	}

	public void actualizarContrincante(Partido partidoDeInteres) {
		
		if( this.tieneContrincanteDeInteres(partidoDeInteres.getContrincantes() )  ) {
			this.getInteresado().actualizarContrincante(partidoDeInteres);
		}
		
	}

	private boolean tieneContrincanteDeInteres(Set<String> contrincantes) {
		
		return this.getContrincantesDeInteres().stream().anyMatch( c -> contrincantes.contains(c) );
	}
	
}
