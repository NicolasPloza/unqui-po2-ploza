package module;

public class Titulo extends Campo {

	public Titulo(String valor) {
		super(valor);
		
	}

	@Override
	public boolean esDeInteres(Articulo articulo) {
		
		return articulo.getTitulo().equals(this.getValor());
	}

}
