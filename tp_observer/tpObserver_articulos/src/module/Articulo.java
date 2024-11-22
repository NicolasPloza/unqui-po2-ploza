package module;
import java.util.*;

public class Articulo {
	
	private String titulo;
	private List<String> autores; 
	private List<String> filiaciones;
	private String tipo;
	private String lugarDePublicacion;
	private List<String> palabrasClave;
	
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	
	public String getTitulo() {
		return titulo;
	}

	public List<String> getAutores() {
		return autores;
	}

	public void setAutores(List<String> autores) {
		this.autores = autores;
	}

	public List<String> getFiliaciones() {
		return filiaciones;
	}

	public void setFiliaciones(List<String> filiaciones) {
		this.filiaciones = filiaciones;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getLugarDePublicacion() {
		return lugarDePublicacion;
	}

	public void setLugarDePublicacion(String lugarDePublicacion) {
		this.lugarDePublicacion = lugarDePublicacion;
	}

	public List<String> getPalabrasClave() {
		return palabrasClave;
	}

	public void setPalabrasClave(List<String> palabrasClave) {
		this.palabrasClave = palabrasClave;
	}


	
}
