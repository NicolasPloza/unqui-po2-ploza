package module.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import module.FiltroDeNotificacion;
import module.Interesado;
import module.Partido;
import java.util.*;

import static org.mockito.Mockito.*;

class FiltroDeNotificacionTestCase {
	
	private Interesado servidor;
	private FiltroDeNotificacion filtro;
	
	@BeforeEach
	void setUp() throws Exception {
		servidor = mock(Interesado.class);
		filtro = new FiltroDeNotificacion(servidor);
	}

	@Test
	void test_seCreaUnFiltoDeNotificacion() {
		//setup
		Interesado servidor = mock(Interesado.class);
		
		//exercise
		FiltroDeNotificacion filtro = new FiltroDeNotificacion(servidor);
		
		//verify
		assertEquals(filtro.getInteresado(), servidor);
	}
	
	@Test
	void test_agregaUnDeporteASuListaDeDeportesDeInteres() {
		//setup
		
		
		//exercise
		filtro.agregarDeporte("futbol");
		
		//verify
		assertTrue(filtro.getDeportesDeInteres().contains("futbol"));

	}
	
	@Test
	void test_agregaUnContrincanteASuListaDeContrincantesDeInteres() {
		//setup
		
		
		//exercise
		filtro.agregarContrincante("boca");
		
		//verify
		assertTrue(filtro.getContrincantesDeInteres().contains("boca"));
	}
	
	@Test
	void test_remueveUnContrincanteDeSuListaDeContrincantesDeInteres() {
		//setup
		filtro.agregarContrincante("boca");
		
		//exercise
		filtro.removerContrincante("boca");
		
		//verify
		assertFalse(filtro.getContrincantesDeInteres().contains("boca"));
	}
	
	@Test
	void test_remueveUnDeporteDeSuListaDeDeportesDeInteres() {
		//setup
		filtro.agregarDeporte("futbol");
		
		//exercise
		filtro.removerDeporte("futbol");
		
		//verify
		assertFalse(filtro.getDeportesDeInteres().contains("futbol"));
	}
	
	@Test
	void test_actualizaUnPartido_soloSiEstaSuscriptoSuInteresado() {
		//setup
		Partido partidoDeInteres = mock(Partido.class);
		Partido partidoFueraDeInteres = mock(Partido.class);
		Set<String> contrincantesDeInteres = new HashSet<>();
		Set<String> contrincantesFueraDeInteres = new HashSet<>();
		
		contrincantesDeInteres.add("boca");
		contrincantesDeInteres.add("racing");
		contrincantesFueraDeInteres.add("independiente");
		contrincantesFueraDeInteres.add("lanus");
		
		when(partidoDeInteres.getDeporte()).thenReturn("futbol");
		when(partidoDeInteres.getContrincantes()).thenReturn(contrincantesDeInteres);
		
		when(partidoFueraDeInteres.getDeporte()).thenReturn("tennis");
		when(partidoFueraDeInteres.getContrincantes()).thenReturn(contrincantesFueraDeInteres);
		
		filtro.agregarDeporte("futbol");
		filtro.agregarDeporte("bascket");
		filtro.agregarContrincante("racing");
		
		//exercise
		filtro.update(partidoDeInteres);
		filtro.update(partidoFueraDeInteres);
		
		//verify
		verify(filtro.getInteresado()).update(partidoDeInteres);
		verify(filtro.getInteresado(),never()).update(partidoFueraDeInteres);
		
	}

	

	
	@Test
	void test_seConoceSiUnInteresadoPerteneceAlFiltroDeNOtificacion() {
		//setup
		Interesado app = mock(Interesado.class);
		
		//exercise
		filtro.tieneInteresado(servidor);
		
		//verify
		assertFalse(filtro.tieneInteresado(app));
		assertTrue(filtro.tieneInteresado(servidor));
	}
	
	
	
	
	
	
}
