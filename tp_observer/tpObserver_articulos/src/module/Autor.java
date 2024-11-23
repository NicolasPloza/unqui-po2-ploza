package module;

public class Autor extends Campo {
	
	public Autor(String valor) {
		super(valor);
	}
	
	@Override
	public boolean esDeInteres(Articulo articulo) {

		return 	articulo.getAutores().stream()
						.anyMatch(a -> a.equals(this.getValor()) );
	}

}
