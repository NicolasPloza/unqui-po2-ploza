package module;

public abstract class Campo {
	
	private String valor;
	
	public Campo(String valor) {
		this.valor = valor;
	}
	
	public String getValor() {
		return this.valor;
	}
	
	public abstract boolean esDeInteres(Articulo articulo);

}
