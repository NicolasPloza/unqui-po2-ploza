package ar.edu.unq.poo2.tp6;
import java.util.*;

public class Empresa {
	
	private List<Empleado> empleados = new ArrayList<Empleado>();
	private Double presupuesto;
	
	public void cargarEmpleado(Empleado unEmpleado) {
		
		empleados.add(unEmpleado);	
	}
	
	public List<Empleado> getEmpleados(){
		
		return empleados;
	}

	public void setPresupuesto(Double p) {
		
		this.presupuesto= p;
	}

	public Double getPresupuesto() {
		
		return this.presupuesto;
	}

	public void pagarUnSueldo(Empleado unEmpleado) {
		
		unEmpleado.recibeSueldo(unEmpleado.sueldo());
		setPresupuesto(presupuesto - unEmpleado.sueldo());
	}

	private Double getTotalAPagar() {
		
		Double total = empleados.stream().mapToDouble(e -> e.sueldo()).sum();
		
		return total;
	}

	
	public void pagarSueldos() {
		if (this.getTotalAPagar() > this.getPresupuesto()) {
			throw new RuntimeException("El presupuesto no alcanza");
		}
		else{
		empleados.stream().forEach(e -> pagarUnSueldo(e));
		}		
	}

}
