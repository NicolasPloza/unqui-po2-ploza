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
	private float sueldoBruto ;
	
	
	public Temporal() {
		super();
	}
	
	public Temporal(String nombre, String direccion, String estadoCivil,
				LocalDate fechaDeNacimiento, float sueldoBasico, LocalDate fechaFinDeDesignacion, 
				int cantHorasExtra){
		
		this.nombre = nombre;
		this.direccion = direccion;
		this.estadoCivil=estadoCivil;
		this.fechaDeNacimiento = fechaDeNacimiento;
		this.sueldoBasico = sueldoBasico;
		this.fechaFinDeDesignacion = fechaFinDeDesignacion;
		this.cantHorasExtra = cantHorasExtra;
	}
	
	
	public float getSueldoBruto() {
		sueldoBruto = sueldoBasico + (cantHorasExtra*40);
		return sueldoBruto;
	}
	
	public float getSueldoNeto() {
	
		return (sueldoBruto - this.getRetenciones());
	}
	
	public float getRetenciones() {
		return (float)((sueldoBruto*0.1) + this.extraDeObraSocialPorEdad() + this.aportesJubilatorios());  
	}
	
	private float extraDeObraSocialPorEdad() {
		float extraPorEdad;
		if (this.edad(fechaDeNacimiento) > 50) {
			extraPorEdad = 25;
		}
		else {
			extraPorEdad = 0;
		}
		
		return extraPorEdad;
	}
	
	private float aportesJubilatorios() {
		return (float)(sueldoBruto * 0.1 + cantHorasExtra*5); 
	}
	

	
	
}
