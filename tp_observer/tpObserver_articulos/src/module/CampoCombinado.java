package module;

public class CampoCombinado extends Campo {
	
	private Campo campoIzq;
	private Campo campoDer;
	
	public CampoCombinado(Campo campoIzq, Campo campoDer) {
		super("combinado");
		this.campoIzq = campoIzq;
		this.campoDer = campoDer;
	}
	
	@Override
	public boolean esDeInteres(Articulo articulo) {
		return campoIzq.esDeInteres(articulo) || campoDer.esDeInteres(articulo);
	}

}
