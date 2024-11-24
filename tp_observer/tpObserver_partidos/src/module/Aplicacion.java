package module;
import java.util.*;



public class Aplicacion {
	
	private Set<FiltroDeNotificacion> filtroDeinteresados;
	private List<Partido> partidos;
	
	public Aplicacion() {
		this.filtroDeinteresados = new HashSet<>();
		this.partidos = new ArrayList<>();
	}
	
	public Set<FiltroDeNotificacion> getFiltrosDeInteresados(){
		return this.filtroDeinteresados;
	}
	
	public List<Partido> getPartidos(){
		return this.partidos;
	}

	public void suscribirInteresadoEnDeporte(Interesado interesado, String deporte) {
		
		FiltroDeNotificacion filtroNotificacion = 
				this.getFiltrosDeInteresados().stream()
					.filter( fn -> fn.getInteresado().equals(interesado))
					.findFirst().orElse(new FiltroDeNotificacion(interesado));
		
		filtroNotificacion.agregarDeporte(deporte);
		this.getFiltrosDeInteresados().add(filtroNotificacion);
			
	}

	public int cantidadDeFiltros() {
		
		return this.getFiltrosDeInteresados().size();
	}

	public boolean tieneInteresadoEnDeporte(Interesado interesado, String deporte) {
		
		return 	this.getFiltrosDeInteresados()
				.stream()
				.anyMatch(f -> f.getInteresado().equals(interesado) && f.tieneInteresEnDeporte(deporte));
	}

	public void removerInteresadoEnDeporte(Interesado interesado, String deporte) {
		
		FiltroDeNotificacion filtro = this.getFiltroParaInteresado(interesado);
		
		filtro.removerDeporte(deporte);
		
		if(!filtro.tieneIntereses()){
			this.removerFiltro(filtro);
		}
		
		
	}

	public void removerFiltro(FiltroDeNotificacion filtro) {
		
		this.getFiltrosDeInteresados().remove(filtro);
	}

	public FiltroDeNotificacion getFiltroParaInteresado(Interesado interesado) {
		
		return 	this.getFiltrosDeInteresados()
					.stream()
					.filter(f -> f.getInteresado().equals(interesado))
					.findFirst()
					.get();
	}

	public void suscribirInteresadoEnContrincante(Interesado interesado, String contrincante) {
		
		FiltroDeNotificacion filtroNotificacion = 
				this.getFiltrosDeInteresados().stream()
					.filter(f -> f.getInteresado().equals(interesado) )
					.findFirst().orElse(new FiltroDeNotificacion(interesado));
		
		filtroNotificacion.agregarContrincante(contrincante);
		this.getFiltrosDeInteresados().add(filtroNotificacion);
		
	}

	public boolean tieneInteresadoEnContrincante(Interesado interesado, String contrincante) {
		
		return 	this.getFiltrosDeInteresados()
				.stream()
				.anyMatch(f -> f.getInteresado().equals(interesado) && f.tieneInteresEnContrincante(contrincante));
	}

	public void removerInteresadoEnContrincante(Interesado interesado, String contrincante) {
		
		FiltroDeNotificacion filtro = this.getFiltroParaInteresado(interesado);
		
		filtro.removerContrincante(contrincante);
		
		if(!filtro.tieneIntereses()) {
			this.getFiltrosDeInteresados().remove(filtro);
		}
		
	}

	
	public void notificar(Partido partido) {
		
		this.getFiltrosDeInteresados().stream().forEach(f -> f.update(partido));
		
	}


	
	
}
