package ar.edu.unq.poo2.tp2Empresas;

import java.time.LocalDate;

public class Permanente extends Empleado {
	
	private String nombre;
	private String direccion;
	private String estadoCivil;
	private LocalDate fechaDeNacimiento;
	private float sueldoBasico;
	private int antiguedad;
	private int cantHijos;
	private boolean tieneConyugue;
	
	
	public Permanente() {
		
	}
	

	public Permanente(String nombre, String direccion, String estadoCivil,
			LocalDate fechaDeNacimiento,float sueldoBasico,int antiguedad, int cantHijos, boolean tieneConyugue){
		this.nombre= nombre;
		this.direccion = direccion;
		this.estadoCivil = estadoCivil;
		this.fechaDeNacimiento = fechaDeNacimiento;
		this.antiguedad = antiguedad;
		this.cantHijos = cantHijos;
		this.tieneConyugue = tieneConyugue;
	}
	
	
	public float getSueldoBruto() {
		return ( sueldoBasico + getSalarioFamiliar());
		
	}
	
	private float getSalarioFamiliar() {
		return asignacionPorConyugue() + asignacionPorHijo() + extraPorAntiguedad(); 
	}
	
	public float getRetenciones() {
		return obraSocial() + aportesJubilatorios();  
	}

	public float obraSocial() {
		return (float)(getSueldoBruto() / 10 + cantHijos*20);
	}
	
	public float aportesJubilatorios() {
		return (float) (getSueldoBruto() * 0.15) ;
	}
	
	
	private float asignacionPorConyugue() {
		
		float asignacion;
		
		if (tieneConyugue) {
			asignacion = 100;
		}else {
			asignacion = 0;
		}
		
		return asignacion;
	}
	
	
	private float asignacionPorHijo() {
		
		return cantHijos * 150;
	}
	
	private float extraPorAntiguedad() {
		return antiguedad * 50;
	}
	
	
	public String getConceptos() {
		return "\nSueldo básico: $" + sueldoBasico +
			"\nAsginación por hijo:  $" + asignacionPorHijo() +
			"\nAsignacion por conyugue: $" + asignacionPorConyugue() + 
			"\n \nRetenciones; \n"
			+  " ObraSocial: $" + this.obraSocial() + 
			 "\n Aportes Jubilatorios: $" + aportesJubilatorios()+"\n\n\n";
	}
	


}
