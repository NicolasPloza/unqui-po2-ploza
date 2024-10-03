package ar.edu.unq.poo2.tp2EmpresasTest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
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
	
	private Empleado empleadoContratado = new Contratado("Jorge",
			 "Alicia Moreau 875",
			 "casado",
			 LocalDate.of(1985, 10, 27),														
			 600,
			 788955,
			 "Banco Nacion");
	
	public Empresa empresa1 = new Empresa(30456789, "POO2 SRL" );
	
	private void setUp(){
		empresa1.agregarEmpleado(empleadoPermanente);
		empresa1.agregarEmpleado(empleadoTemporal);	
		empresa1.agregarEmpleado(empleadoContratado);
	}
	
	@Test
	void testListadeEmpleados() {
		setUp();
		empresa1.realizarLiquidacionDeSueldos();
		System.out.print(empresa1.getRecibo(empleadoPermanente, LocalDate.now() ));
	}
	
	

	
	@Test
	void test_calcularTotalDeSueldosNetos(){
		setUp();
		empresa1.getTotalSueldosNetos();
	}
	
	@Test
	void test_calcularTotalDeSueldosBrutos() {
		setUp();
		empresa1.getTotalSueldosBrutos();
	}
	
	@Test 
	void test_calcularTotalDeRetenciones() {
		setUp();
		empresa1.getTotalDeRetenciones();
	}
	
	

	
	
	
}
