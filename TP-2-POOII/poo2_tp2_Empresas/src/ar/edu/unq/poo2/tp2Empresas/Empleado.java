package ar.edu.unq.poo2.tp2Empresas;
import java.time.*;

public abstract class Empleado {
	 
	private String nombre;
	private String direccion;
	private String estadoCivil;
	private LocalDate fechaDeNacimiento;
	private float sueldoBasico;
	
	public Empleado() {
		
	}
	
	public Empleado(String nombre, String direccion, String estadoCivil,
								LocalDate fechaDeNacimiento, float sueldoBasico){
		this.nombre= nombre;
		this.direccion = direccion;
		this.estadoCivil = estadoCivil;
		this.fechaDeNacimiento = fechaDeNacimiento;
		this.sueldoBasico = sueldoBasico;
				
	}
	
	public abstract float getSueldoBruto();
	public abstract float getRetenciones(); 
	public abstract String getConceptos();
	
	
	public int edad(LocalDate fechaNacimiento) {
		return Period.between(fechaNacimiento, LocalDate.now()).getYears();
	}


	public LocalDate getFechaNacimiento() {
		return fechaDeNacimiento;
	}


	public void setFechaNacimiento(LocalDate fechaNacimiento) {
		this.fechaDeNacimiento = fechaNacimiento;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getEstadoCivil() {
		return estadoCivil;
	}

	public void setEstadoCivil(String estadoCivil) {
		this.estadoCivil = estadoCivil;
	}
		                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                  
	public float getSueldoNeto(){
		return (getSueldoBruto() - getRetenciones());
	}
	

	
	
	
	
}
