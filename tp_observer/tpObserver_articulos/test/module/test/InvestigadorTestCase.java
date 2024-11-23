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
		Campo interes = mock(Campo.class);
		
		//exercise
		investigador.agregarInteres(interes);
		
		//verify
		assertTrue(investigador.getIntereses().contains(interes));
		
	}
	
	@Test
	void test_unInvestigadorActualizaArticuloSoloSiCumpleSusIntereses(){
		//setup
		Campo interes1 = mock(Campo.class);
		Campo interes2 = mock(Campo.class);
		Articulo articulo = mock(Articulo.class);
		
		investigador.agregarInteres(interes1);
		investigador.agregarInteres(interes2);	
		
		//exercise
		investigador.update(articulo);
		
		//verify 
		verify(interes1).esDeInteres(articulo);
		verify(interes2).esDeInteres(articulo);
	
	}
	

}
