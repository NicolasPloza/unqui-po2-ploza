package ar.edu.unq.poo2.tp2Empresas;

import java.time.LocalDate;

public class Contratado extends Empleado {
	
	private String nombre;
	private String direccion;
	private String estadoCivil;
	private LocalDate fechaDeNacimiento;
	private float sueldoBasico;
	private int numeroDeContrato;
	private String medioDePago;
	
	public Contratado() {
		
	}
	
	public Contratado (String nombre, String direccion, String estadoCivil,
			LocalDate fechaDeNacimiento, float sueldoBasico,int numeroDeContrato, String medioDePago) {
		this.nombre= nombre;
		this.direccion = direccion;
		this.estadoCivil = estadoCivil;
		this.fechaDeNacimiento = fechaDeNacimiento;
		this.sueldoBasico = sueldoBasico;
		this.numeroDeContrato = numeroDeContrato;
		this.medioDePago = medioDePago;
		
	}

	@Override
	public float getSueldoBruto() {
	
		return sueldoBasico;
	}

	

	@Override
	public float getRetenciones() {
	
		return 50;
	}

	@Override
	public String getConceptos() {
		
		return "\nSueldo basico: $" + sueldoBasico + 
			"\nRetenciones : \n Gastos Administrativos Contractuales $" + getRetenciones()+
			"\n\n\n";
	}

}
