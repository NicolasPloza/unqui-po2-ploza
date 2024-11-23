package module.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import module.Articulo;
import module.Campo;
import module.Investigador;
import module.Sistema;
import static org.mockito.Mockito.*;

class SistemaTestCase {
	
	private Sistema sistema;
	private Articulo articulo;
	private Investigador investigador;
	private Campo interes;
	private Investigador otroInvestigador;
	
	@BeforeEach
	void setUp() throws Exception {
		sistema = new Sistema();
		articulo = mock(Articulo.class);
		investigador = mock(Investigador.class);
		interes = mock(Campo.class);
		otroInvestigador =  mock(Investigador.class);

	}
	
	@Test
	void test_seSuscribeUnInvestigadorConSuInteresDeArticulo() {
		
		//exercise
		sistema.suscribir(investigador, interes);
		
		//verify
		assertTrue(sistema.getInteresados().contains(investigador));
		assertFalse(sistema.getInteresados().isEmpty());
		verify(investigador).agregarInteres(interes);
		
	}
	
	@Test
	void test_seRemueveUnInteresadoDeLaLista() {
	
		//exercise
		sistema.suscribir(investigador, interes);
		sistema.remover(investigador);
		
		//verify
		assertFalse(sistema.getInteresados().contains(investigador));
		
	}
	
	@Test
	void test_seRemueveUnInteresadoQueNoEstaEnLaLista() {
		//setup
		sistema.suscribir(investigador, interes);
		
		//exercise
		sistema.remover(otroInvestigador);
		
		//verify
		assertFalse(sistema.getInteresados().isEmpty());
		assertFalse(sistema.getInteresados().contains(otroInvestigador));
		
	}
	
	@Test
	void test_seAgregaUnArticuloAlSistemaYSeNotificaALosSuscriptores() {
		//setup
		sistema.suscribir(investigador, interes);
		sistema.suscribir(otroInvestigador, interes);
		
		//exercise
		sistema.agregarArticulo(articulo);
		
		//verify
		assertFalse(sistema.getArticulos().isEmpty());
		assertTrue(sistema.getArticulos().contains(articulo));
		verify(investigador).update(articulo);
		verify(otroInvestigador).update(articulo);
		
	}
	
	

}
