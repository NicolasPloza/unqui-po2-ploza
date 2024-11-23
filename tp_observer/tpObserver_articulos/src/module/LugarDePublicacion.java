package module;

public class LugarDePublicacion extends Campo {
	
	public LugarDePublicacion(String valor) {
		super(valor);
	}
	
	@Override
	public boolean esDeInteres(Articulo articulo) {
		
		return articulo.getLugarDePublicacion().equals(this.getValor());
	}

}
