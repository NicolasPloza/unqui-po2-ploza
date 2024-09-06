package ar.edu.unq.poo2.tp2Empresas;
import java.time.*;

public class Temporal extends Empleado {
	
	private String nombre;
	private String direccion;
	private String estadoCivil;
	private LocalDate fechaDeNacimiento;
	private float sueldoBasico;
	private LocalDate fechaFinDeDesignacion;
	private int cantHorasExtra;
	
	
	public Temporal() {
		
	}
	
	public Temporal(String nombre, String direccion, String estadoCivil,
			LocalDate fechaDeNacimiento,float sueldoBasico, LocalDate fechaFinDeDesignacion, 
				int cantHorasExtra){
		this.nombre= nombre;
		this.direccion = direccion;
		this.estadoCivil = estadoCivil;
		this.fechaDeNacimiento = fechaDeNacimiento;
		this.sueldoBasico = sueldoBasico;
		this.fechaFinDeDesignacion = fechaFinDeDesignacion;
		this.cantHorasExtra = cantHorasExtra;
	}
	
	
	public float getSueldoBruto() {
		return (sueldoBasico + (cantHorasExtra*40));
		
	}
	
	public float getRetenciones() {
		return obraSocial() + aportesJubilatorios();  
	}
	
	
	public float obraSocial() {
		return (float)(getSueldoBruto()*0.1 + extraDeObraSocialPorEdad());
	}
	
	private float extraDeObraSocialPorEdad() {
		float extraPorEdad;
		if (edad(fechaDeNacimiento) > 50) {
			extraPorEdad = 25;
		}
		else {
			extraPorEdad = 0;
		}
		
		return extraPorEdad;
	}
	
	public float aportesJubilatorios() {
		return (float)(getSueldoBruto() * 0.1 + cantHorasExtra*5); 
	}
	
	public String getConceptos() {
		return "\nSueldo Basico: $" + sueldoBasico +
			"\nHoras extra: $" + (cantHorasExtra*40) + 
			"\n\nRetenciones:\n "
			+ "Obra social: $" + obraSocial() +
		   "\n Aportes jubilatorios: $" + aportesJubilatorios()+ "\n\n\n";
	}
	

	
	
}
