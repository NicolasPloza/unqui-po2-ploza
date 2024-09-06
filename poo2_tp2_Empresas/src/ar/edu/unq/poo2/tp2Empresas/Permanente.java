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
	private float salarioFamiliar = this.asignacionPorConyugue() + 
									this.asignacionPorHijo()+ this.extraPorAntiguedad(); 
	private float sueldoBruto ;
	
	public Permanente() {
		super();
	}
	
	public Permanente(String nombre, String direccion, String estadoCivil,
				LocalDate fechaDeNacimiento, float sueldoBasico, int antiguedad, 
				int cantHijos, boolean tieneConyugue){
		
		this.nombre = nombre;
		this.direccion = direccion;
		this.estadoCivil=estadoCivil;
		this.fechaDeNacimiento = fechaDeNacimiento;
		this.sueldoBasico = sueldoBasico;
		this.antiguedad = antiguedad;
		this.cantHijos = cantHijos;
		this.tieneConyugue = tieneConyugue;
	}
	
	public float getSueldoBruto() {
		sueldoBruto = sueldoBasico + salarioFamiliar;
		return sueldoBruto;
	}
	
	public float getSueldoNeto() {
		return sueldoBruto - this.getRetenciones();
	}
	
	public float getRetenciones() {
		return (float)(sueldoBruto*0.1 + cantHijos*20)+ this.aportesJubilatorios();
	}
	
	private float aportesJubilatorios() {
		return (float) (sueldoBruto * 0.1) ;
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
	
	
	/*
	 *Sueldo Basico 
	 *Salario Familiar, que se compone de:
 		 Asignación por hijo: $150 por cada hijo.
 		 Asignación por cónyuge: $100 si tiene cónyuge 
 		 Antigüedad: $50 por cada año de antigüedad.
 	 
 	 *Las retenciones que se realizan a este empleado son:
      	 Obra Social: 10% de su sueldo bruto + $20 por cada hijo. 
      	 Aportes Jubilatorios: 15% de su sueldo bruto
	 * */

}
