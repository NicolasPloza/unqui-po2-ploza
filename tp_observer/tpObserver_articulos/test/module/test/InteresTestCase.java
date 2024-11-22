package module.test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import module.*;

class InteresTestCase {

	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	void test_interesDeArticuloConUnTituloEspecifico() {
		
		Interes titulo = Interes.TITULO;
		titulo.setValor("Smalltalk");
		Articulo articulo = mock(Articulo.class);
		
		when(articulo.getTitulo()).thenReturn("Smalltalk");
		
		assertTrue(titulo.esDeInteres(articulo));
	}
	
	@Test
	void test_interesDeArticuloConAutoresEspecifico() {
		
		Interes autores = Interes.AUTORES;
		autores.setValor("Oscar Wide");
		Articulo articulo = mock(Articulo.class);
		List<String> listaDeAutores = new ArrayList<String>();
		listaDeAutores.add("Oscar Wide");
		listaDeAutores.add("Osho");
		
		when(articulo.getAutores()).thenReturn(listaDeAutores);
		
		assertTrue(autores.esDeInteres(articulo));
	}
	
	@Test
	void test_interesDeArticuloConFiliacionesEspecificas() {
		
		Interes filiaciones = Interes.FILIACIONES;
		filiaciones.setValor("Universidad de Quilmes");
		Articulo articulo = mock(Articulo.class);
		List<String> listaDeFiliaciones = new ArrayList<String>();
		listaDeFiliaciones.add("Universidad de Quilmes");
		listaDeFiliaciones.add("Lanus");
		
		when(articulo.getFiliaciones()).thenReturn(listaDeFiliaciones);
		
		assertTrue(filiaciones.esDeInteres(articulo));
	}
	

}
