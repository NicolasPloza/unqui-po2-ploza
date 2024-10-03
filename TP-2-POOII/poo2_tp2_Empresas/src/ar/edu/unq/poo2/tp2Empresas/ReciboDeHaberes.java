package ar.edu.unq.poo2.tp2Empresas;
import java.time.*;



public class ReciboDeHaberes {
	
	private String nombreDeEmpleado;
	private String direccionDeEmpleado;
	private LocalDate fechaDeEmision;
	private float sueldoBrutoDelEmpleado;
	private float sueldoNetoDelEmpleado;
	private String desgloceDeConceptos;
	
	

	public ReciboDeHaberes(Empleado unEmpleado, 
						   LocalDate fechaDeEmision) {
		this.nombreDeEmpleado = unEmpleado.getNombre();
		this.direccionDeEmpleado = unEmpleado.getDireccion();
		this.fechaDeEmision = fechaDeEmision;
		this.sueldoBrutoDelEmpleado = unEmpleado.getSueldoBruto();
		this.sueldoNetoDelEmpleado = unEmpleado.getSueldoNeto();
		this.desgloceDeConceptos = unEmpleado.getConceptos();
	}
		
	public String getReciboDeEmpleado() {
		return "-----------Recibo de haberes ----------\n"
			 + "Nombre: " + nombreDeEmpleado + 
				"\nDireccion: " + direccionDeEmpleado +
				"\nFecha: " +  fechaDeEmision.toString() +
				"\nSueldo bruto: " + sueldoBrutoDelEmpleado +
				"\nSueldo neto: " + sueldoNetoDelEmpleado +
				"\n\nDesgloce de conceptos: \n" + desgloceDeConceptos;
				
				
	}

}
