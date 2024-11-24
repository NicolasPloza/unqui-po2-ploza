package module.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;
import java.util.*;
import module.*;

class AplicacionTestCase {
	
	Aplicacion aplicacion;
	Interesado servidor;
	Interesado appMovil;
	
	@BeforeEach
	void setUp() throws Exception {	
		aplicacion = new Aplicacion();
		servidor = mock(Interesado.class);
		appMovil = mock(Interesado.class);
	}
	
	
	@Test
	void test_seCreaUnaAplicacion_conUnaListadePartidos_YUnaListaDeInteresadosEnPartidos() {
		//exercise
		Aplicacion aplicacionPrueba = new Aplicacion();
		
		//verify
		assertTrue(aplicacionPrueba.getFiltrosDeInteresados().isEmpty());
		assertTrue(aplicacionPrueba.getPartidos().isEmpty());
		
	}
	
	
	@Test
	void test_seSuscribeInteresadoEnDeporte() {
		//setup
		
		//exercise
		aplicacion.suscribirInteresadoEnDeporte(servidor, "tennis" );
		
		//verify
		assertFalse(aplicacion.getFiltrosDeInteresados().isEmpty());
		
	}
	
	@Test
	void test_seSuscribeInteresadoEnDeporte_SiYaTieneUnFiltroCreadoSoloSeAgregaSuNuevoInteres() {
		//setup
		aplicacion.suscribirInteresadoEnDeporte(servidor, "tennis" );
		int cantidadInicial = aplicacion.cantidadDeFiltros(); 
		
		//exercise
		aplicacion.suscribirInteresadoEnDeporte(servidor, "fulbol" );
		
		//verify
		assertEquals(aplicacion.cantidadDeFiltros(), cantidadInicial);
		
	}
	
	@Test
	void test_seRemueveInteresadoEnDeporte() {
		//setup
		aplicacion.suscribirInteresadoEnDeporte(servidor, "futbol" );
		aplicacion.suscribirInteresadoEnDeporte(servidor, "tennis" );
		
		//exercise
		aplicacion.removerInteresadoEnDeporte(servidor, "tennis" );
		
		//verify
		assertTrue(aplicacion.tieneInteresadoEnDeporte(servidor, "futbol"));
		assertFalse(aplicacion.tieneInteresadoEnDeporte(servidor,"tennis"));
		
	}
	
	@Test
	void test_seSuscribeInteresadoEnContrincante() {
		//setup
		
		//exercise
		aplicacion.suscribirInteresadoEnContrincante(servidor, "boca" );
		
		//verify
		assertFalse(aplicacion.getFiltrosDeInteresados().isEmpty());
		
	}
	
	@Test
	void test_seSuscribeInteresadoEnContrincante_SiYaTieneUnFiltroCreadoSoloSeAgregaSuNuevoInteres() {
		//setup
		aplicacion.suscribirInteresadoEnContrincante(servidor, "boca" );
		int cantidadInicial = aplicacion.cantidadDeFiltros(); 
		
		//exercise
		aplicacion.suscribirInteresadoEnContrincante(servidor, "river" );
		
		//verify
		assertEquals(aplicacion.cantidadDeFiltros(), cantidadInicial);
		
	}
	
	@Test
	void test_seRemueveInteresadoEnContrincante() {
		//setup
		aplicacion.suscribirInteresadoEnContrincante(servidor, "boca" );
		aplicacion.suscribirInteresadoEnContrincante(servidor, "river" );
		
		//exercise
		aplicacion.removerInteresadoEnContrincante(servidor, "boca" );
		
		//verify
		assertTrue(aplicacion.tieneInteresadoEnContrincante(servidor,"river"));
		assertFalse(aplicacion.tieneInteresadoEnContrincante(servidor,"boca"));
		
	}
	
	@Test
	void test_seNotificaATodosLosInteresadosQueSeAgregoUnPartido() {
		//setup
		Interesado otroServidor = mock(Interesado.class);
		aplicacion.suscribirInteresadoEnDeporte(servidor, "tennis" );
		aplicacion.suscribirInteresadoEnDeporte(servidor, "futbol" );
		
		aplicacion.suscribirInteresadoEnDeporte(appMovil, "futbol");
		aplicacion.suscribirInteresadoEnContrincante(appMovil, "boca");
		
		aplicacion.suscribirInteresadoEnDeporte(otroServidor , "golf");
		
		Partido partido = mock(Partido.class);
		Set<String> contrincantes = new HashSet<>();
		contrincantes.add("racing");
		contrincantes.add("boca");
		when(partido.getDeporte()).thenReturn("futbol");
		when(partido.getContrincantes()).thenReturn(contrincantes);
		
		//exercise
		aplicacion.notificar(partido);
		
		//verify
		verify(servidor,times(1)).update(partido);
		verify(appMovil,times(1)).update(partido);
		verify(otroServidor,never()).update(partido);	
	}

}
