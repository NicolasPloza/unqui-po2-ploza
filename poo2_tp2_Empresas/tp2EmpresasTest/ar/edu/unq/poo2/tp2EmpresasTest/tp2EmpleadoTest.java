package ar.edu.unq.poo2.tp2EmpresasTest;

import static org.junit.jupiter.api.Assertions.*;

import java.awt.SystemColor;
import java.time.*;

import org.junit.jupiter.api.Test;
import ar.edu.unq.poo2.tp2Empresas.*;

class tp2EmpleadoTest {
	
	private Empleado empleadoTemporal = new Temporal("Nico", 
													 "calle 252 774, Sourigues", 
													 "casado", 
													 LocalDate.of(1997, 8, 24), 
													 500, 
													 LocalDate.of(2026, 5, 25), 
													 48
	);  
	
	private Empleado empleadoPermanente = new Permanente("Alan", //nombre
			 "av.Alvear 478, CABA", //dir
			 "soltero", LocalDate.of(1999, 6, 19) , 
			 10000, //sueldo basico
			 15,   //años de antiguedad
			 2,    //cantidad de hijos
			 true  //tiene conyugue?
);  
  
	private Empleado empleadoContratado = new Contratado("Jorge",
														 "Alicia Moreau 875",
														 "casado",
														 LocalDate.of(1985, 10, 27),														
														 600,
														 788955,
														 "Banco Nacion");
			
	
	@Test
	void test_calcularEdad() {		
		empleadoTemporal.setFechaNacimiento(LocalDate.of(1997, 8, 24));
		assertEquals(empleadoTemporal.edad(empleadoTemporal.getFechaNacimiento()), 27);
	}
	
	@Test
	void test_TemporalCalculaSuSueldoBruto() {
		empleadoTemporal.getSueldoBruto();
	}
	
	@Test
	void test_PermanenteCalculaSuSueldoBruto() {
		empleadoPermanente.getSueldoBruto();
	}
	
	@Test
	void test_ContratadoCalculaSuSueldoBruto() {
		empleadoContratado.getSueldoBruto();
	}
	
	@Test
	void test_conceptos() {
		System.out.print(empleadoTemporal.getConceptos());
		System.out.print(empleadoPermanente.getConceptos());
		System.out.print(empleadoContratado.getConceptos());
	}
	

	
}
