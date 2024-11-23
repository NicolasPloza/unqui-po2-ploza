package module;

public class PalabraClave extends Campo {
	
	public PalabraClave(String valor) {
		super(valor);
	}
	
	@Override
	public boolean esDeInteres(Articulo articulo) {
		
		return	articulo.getPalabrasClave().stream()
						.anyMatch( p -> p.equals(this.getValor()) );
	}

}
