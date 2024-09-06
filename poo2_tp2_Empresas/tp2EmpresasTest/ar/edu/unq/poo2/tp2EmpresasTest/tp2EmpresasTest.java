package ar.edu.unq.poo2.tp2EmpresasTest;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import ar.edu.unq.poo2.tp2Empresas.*;

import java.time.LocalDate;


class tp2EmpresasTest {
	
	private Empleado empleadoTemporal = new Temporal("Nico", 
			 "calle 252 774, Sourigues", 
			 "casado", 
			 LocalDate.of(1997, 8, 24), 
			 500, 
			 LocalDate.of(2026, 5, 25), 
			 48
	);  

	private Empleado empleadoPermanente = new Permanente("Alan", 
				 "av.Alvear 478, CABA", 
				 "soltero", LocalDate.of(1999, 6, 19) , 
				 10000, 
				 15, 
				 2, 
				 true
	);
	
	
	public Empresa empresa1 = new Empresa(30456789, "POO2 SRL" );
	
	
	@Test
	void test_tieneNombre() {
		assertEquals(empresa1.getNombre(), "POO2 SRL");
	}
	
	
	@Test 
	void test_tieneUnaListaDeEmpleados() {
		empresa1.agregarEmpleado(empleadoPermanente);
		empresa1.agregarEmpleado(empleadoTemporal);	
	}
	
	@Test
	void test_calcularTotalDeSueldosNetos(){
		empresa1.getTotalSueldosNetos();
	}

}
