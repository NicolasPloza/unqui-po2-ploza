package ar.edu.unq.poo2.tp6.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.unq.poo2.tp6.Empleado;
import ar.edu.unq.poo2.tp6.Empresa;

import static org.mockito.Mockito.*;

class EmpresaTest {
	
	private Empresa empresa;
	private Empleado unEmpleado;
	
	@BeforeEach
	void setUp() throws Exception {
		empresa = new Empresa();
		unEmpleado = mock(Empleado.class);
	}

	@Test
	void laEmpresaCargaUnEmpleadoASuListaDeEmpleados() {
		//setup
		
		//excercise
		empresa.cargarEmpleado(unEmpleado);
		
		//verify
		assertTrue(empresa.getEmpleados().contains(unEmpleado));
		
	}
	
	@Test
	void laEmpresaPagaElSueldoDeUnEmpleado() {
		//setup
		empresa.setPresupuesto(100000.000);
		Double presupuestoInicial = empresa.getPresupuesto();
		
	
		when(unEmpleado.sueldo()).thenReturn(50000.000);
		
		//excercise
		empresa.pagarUnSueldo(unEmpleado);
		
		//verify
		verify(unEmpleado).recibeSueldo(50000.000);
		assertEquals(empresa.getPresupuesto(), presupuestoInicial-unEmpleado.sueldo());
	}
	
	
	@Test 
	void laEmpresaPagaElSueldoATodosSusEmpleados() {
		//setup
		empresa.setPresupuesto(100000.000);
		Double presupuestoInicial = empresa.getPresupuesto();
		Empleado e1 = mock(Empleado.class);
		Empleado e2 = mock(Empleado.class);
		Empleado e3 = mock(Empleado.class);
		Empleado e4 = mock(Empleado.class);
		Empleado e5 = mock(Empleado.class);
		empresa.cargarEmpleado(e1);
		empresa.cargarEmpleado(e2);
		empresa.cargarEmpleado(e3);
		empresa.cargarEmpleado(e4);
		empresa.cargarEmpleado(e5);
		
		when(e1.sueldo()).thenReturn(10000.00);
		when(e2.sueldo()).thenReturn(20000.00);
		when(e3.sueldo()).thenReturn(10000.00);
		when(e4.sueldo()).thenReturn(20000.00);
		when(e5.sueldo()).thenReturn(10000.00);
		//excercise
		empresa.pagarSueldos();
		
		//verify
		assertEquals(empresa.getPresupuesto(), presupuestoInicial-70000);
		
	}
	
	@Test 
	void laEmpresaIntentaPagarSueldosSinPresupuestoYSeLanzaUnError() {
		//setup
		empresa.setPresupuesto(5000.000);
		Double presupuestoInicial = empresa.getPresupuesto();
		Empleado e1 = mock(Empleado.class);
		Empleado e2 = mock(Empleado.class);
		Empleado e3 = mock(Empleado.class);
		Empleado e4 = mock(Empleado.class);
		Empleado e5 = mock(Empleado.class);
		empresa.cargarEmpleado(e1);
		empresa.cargarEmpleado(e2);
		empresa.cargarEmpleado(e3);
		empresa.cargarEmpleado(e4);
		empresa.cargarEmpleado(e5);
		
		when(e1.sueldo()).thenReturn(10000.00);
		when(e2.sueldo()).thenReturn(20000.00);
		when(e3.sueldo()).thenReturn(10000.00);
		when(e4.sueldo()).thenReturn(20000.00);
		when(e5.sueldo()).thenReturn(10000.00);

		//excercise
		Exception errorPorFaltaDePresupuesto = 
		assertThrows(RuntimeException.class, () -> empresa.pagarSueldos());
		
		//verify
		assertEquals("El presupuesto no alcanza", errorPorFaltaDePresupuesto.getMessage());
		//postcondition
		assertEquals(empresa.getPresupuesto(), presupuestoInicial );
	}
	
	
	
	
	
	
	
	
	
	
	

}
