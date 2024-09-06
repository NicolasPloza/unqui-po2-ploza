package ar.edu.unq.poo2.tp2Empresas;
import java.time.LocalDate;
import java.util.*;

public class Empresa {
	private int cuit;
	private String nombre;
	public List<Empleado> listaDeEmpleados = new ArrayList<Empleado>();
	public List<String> listaDeRecibos = new ArrayList <String>();
	
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
	

	public float getTotalSueldosNetos() {
		float montoTotal = 0;
		
		for (Empleado empleado : listaDeEmpleados) {
			montoTotal = montoTotal + empleado.getSueldoNeto();
		}
		
		return montoTotal;
	}
	
	public float getTotalSueldosBrutos() {
		float montoTotal = 0;
		
		for (Empleado empleado : listaDeEmpleados) {
			montoTotal = montoTotal + empleado.getSueldoBruto();
		}
		
		return montoTotal;
		
	}
	
	public float getTotalDeRetenciones() {
		float montoTotal = 0;
		
		for (Empleado empleado : listaDeEmpleados) {
			montoTotal = montoTotal + empleado.getRetenciones();
		}
		
		return montoTotal ;
				
	}
	
	public void realizarLiquidacionDeSueldos() {
		
		for (Empleado empleado : listaDeEmpleados) {
			listaDeRecibos.add(getRecibo(empleado , LocalDate.now()));
		}
		
	}
	
	
	public String getRecibo(Empleado unEmpleado, LocalDate fechaDeEmision) {
		
		return 
		new ReciboDeHaberes(unEmpleado, fechaDeEmision).getReciboDeEmpleado();
	}
	

	
	
	
	
	
	
}
