package module.test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import module.*;


class InvestigadorTestCase {
	
	private Investigador investigador;
	
	@BeforeEach
	void setUp() throws Exception {
		investigador = new Investigador("email@mail.com");
	}
	
	@Test
	void test_unInvestigadorSeCreaConUnMail(){

		//verify
		assertEquals(investigador.getEmail(),"email@mail.com");
		
	}
	
	@Test
	void test_unInvestigadorAgregaUnInteresASuLista(){
		//setup
		Interes interes = mock(Interes.class);
		
		//exercise
		investigador.agregarInteres(interes);
		
		//verify
		assertTrue(investigador.getIntereses().contains(interes));
		
	}
	
	@Test
	void test_unInvestigadorRecibeMailSoloDeArticulosDeInteres(){
		//setup
		Interes interes1 = mock(Interes.class);
		Interes interes2 = mock(Interes.class);
		Articulo articuloDeInteres = mock(Articulo.class);
		Articulo articuloFueraDeInteres = mock(Articulo.class);
		investigador.agregarInteres(interes1);
		investigador.agregarInteres(interes2);	
		
		//exercise
		investigador.update(articuloDeInteres);
		investigador.update(articuloFueraDeInteres);
		

		//verify
		verify(interes1).esDeInteres(articuloDeInteres);
		verify(interes1).esDeInteres(articuloFueraDeInteres);
		verify(interes2).esDeInteres(articuloDeInteres);
		verify(interes2).esDeInteres(articuloFueraDeInteres);
		
	}
	

}
