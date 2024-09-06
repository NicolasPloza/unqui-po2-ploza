package ar.edu.unq.poo2.tp2Empresas;
import java.util.*;

public class Empresa {
	private int cuit;
	private String nombre;
	private List<Empleado> listaDeEmpleados = new ArrayList<Empleado>();
	
	public Empresa() {
		super();
	}
	
	public Empresa(int cuit, String nombre) {
		this.cuit = cuit;
		this.nombre = nombre;
	}

	
	public void agregarEmpleado(Empleado unEmpleado) {
		listaDeEmpleados.add(unEmpleado); 
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public void setCuit(int cuit) {
		this.cuit = cuit;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	
	public float getTotalSueldosNetos() {
		float montoTotal = 0;
		
		for (Empleado empleado : listaDeEmpleados) {
			montoTotal = montoTotal + empleado.getSueldoNeto();
		}
		
		return montoTotal;
	}
	
	
	
	
	
	
	
}
