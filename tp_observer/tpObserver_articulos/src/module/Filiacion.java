package module;

public class Filiacion extends Campo {
	
	public Filiacion(String valor) {
		super(valor);
	}
	
	@Override
	public boolean esDeInteres(Articulo articulo) {
		
		return  articulo.getFiliaciones().stream()
						.anyMatch(f -> f.equals(this.getValor()));
	}

}
