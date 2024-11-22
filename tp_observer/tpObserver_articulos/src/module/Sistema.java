package module;
import java.util.*;

public class Sistema {
	
	private List<Articulo> articulos;
	private List<Investigador> interesados;
	
	public Sistema() {
		this.articulos = new ArrayList<>();
		this.interesados = new ArrayList<>();
	}
	
	public void agregarArticulo(Articulo articulo) {
		
		this.getArticulos().add(articulo);
	}

	public List<Articulo> getArticulos() {

		return this.articulos;
	}
	
	public List<Investigador> getInteresados() {

		return this.interesados;
	}

	public void suscribir(Investigador investigador, Interes interes) {
		
		investigador.agregarInteres(interes);
		this.getInteresados().add(investigador);
		
	}

	public void remover(Investigador investigador) {
		
		this.getInteresados().remove(investigador);
	}

	public void notificar(Articulo articulo) {
		
		this.getInteresados().stream()
			.forEach(i -> i.update(articulo));
		
	}
	
}
