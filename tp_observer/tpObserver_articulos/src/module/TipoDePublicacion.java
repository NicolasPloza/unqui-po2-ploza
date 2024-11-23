package module;

public class TipoDePublicacion extends Campo {
	
	public TipoDePublicacion(String valor){
		super(valor);
	}
	
	@Override
	public boolean esDeInteres(Articulo articulo) {
		
		return articulo.getTipo().equals(this.getValor());
	}

}
