package module.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;
import module.*;
import java.util.*;

class CampoTestCase {
	
	private Articulo articuloDeInteres;
	private Articulo articuloSinInteres;
	
	@BeforeEach
	void setUp() throws Exception {
		articuloDeInteres = mock(Articulo.class);
		articuloSinInteres = mock(Articulo.class);
	}

	@Test
	void test_seCreaUnCampoDeInteres_Titulo_ConSuValorDeseado() {
		when(articuloDeInteres.getTitulo()).thenReturn("Smalltalk");
		when(articuloSinInteres.getTitulo()).thenReturn("Wollok");
		
		Campo titulo = new Titulo("Smalltalk");
		
		assertEquals(titulo.getValor(), "Smalltalk" );
		assertTrue(titulo.esDeInteres(articuloDeInteres));
		assertFalse(titulo.esDeInteres(articuloSinInteres));
	}
	
	@Test
	void test_seCreaUnCampoDeInteres_Autor_ConSuValorDeseado() {
		//setup
		List<String> autores_Art1 = new ArrayList<>();
		List<String> autores_Art2 = new ArrayList<>();
		autores_Art1.add("autor 1");
		autores_Art1.add("autor 2");
		autores_Art1.add("Shakespeare");
		autores_Art2.add("autor 1");
		autores_Art2.add("autor 2");
		when(articuloDeInteres.getAutores()).thenReturn(autores_Art1);
		when(articuloSinInteres.getAutores()).thenReturn(autores_Art2);
		
		//exercise
		Campo autor = new Autor("Shakespeare");
		
		//verify
		assertEquals(autor.getValor(), "Shakespeare" );
		assertTrue(autor.esDeInteres(articuloDeInteres));
		assertFalse(autor.esDeInteres(articuloSinInteres));
	}
	
	@Test
	void test_seCreaUnCampoDeInteres_Filiacion_ConSuValorDeseado() {
		//setup
		List<String> filiaciones_DeInteres = new ArrayList<>();
		List<String> filiaciones_SinInteres = new ArrayList<>();
		filiaciones_DeInteres.add("UNQ");
		filiaciones_DeInteres.add("EMBA");
		filiaciones_DeInteres.add("ITBA");
		filiaciones_SinInteres.add("Municipio");
		filiaciones_SinInteres.add("Ministerio de Educacion");
		when(articuloDeInteres.getFiliaciones()).thenReturn(filiaciones_DeInteres);
		when(articuloSinInteres.getFiliaciones()).thenReturn(filiaciones_SinInteres);
		
		//exercise
		Campo filiacion = new Filiacion("UNQ");
		
		//verify
		assertEquals(filiacion.getValor(), "UNQ" );
		assertTrue(filiacion.esDeInteres(articuloDeInteres));
		assertFalse(filiacion.esDeInteres(articuloSinInteres));
	}
	
	@Test
	void test_seCreaUnCampoDeInteres_TipoDePublicacion_ConSuValorDeseado() {
		when(articuloDeInteres.getTipo()).thenReturn("Investigacion");
		when(articuloSinInteres.getTipo()).thenReturn("Divulgacion");
		
		Campo tipoDePublicacion = new TipoDePublicacion("Investigacion");
		
		assertEquals(tipoDePublicacion.getValor(), "Investigacion" );
		assertTrue(tipoDePublicacion.esDeInteres(articuloDeInteres));
		assertFalse(tipoDePublicacion.esDeInteres(articuloSinInteres));
	}
	
	@Test
	void test_seCreaUnCampoDeInteres_LugarDePublicacion_ConSuValorDeseado() {
		when(articuloDeInteres.getLugarDePublicacion()).thenReturn("Bernal");
		when(articuloSinInteres.getLugarDePublicacion()).thenReturn("CABA");
		
		Campo lugarDePublicacion = new LugarDePublicacion("Bernal");
		
		assertEquals(lugarDePublicacion.getValor(), "Bernal" );
		assertTrue(lugarDePublicacion.esDeInteres(articuloDeInteres));
		assertFalse(lugarDePublicacion.esDeInteres(articuloSinInteres));
	}
	
	@Test
	void test_seCreaUnCampoDeInteres_PalabraClave_ConSuValorDeseado() {
		//setup
		List<String> palabrasClave_DeInteres = new ArrayList<>();
		List<String> palabrasClave_SinInteres = new ArrayList<>();
		palabrasClave_DeInteres.add("tecnologia");
		palabrasClave_DeInteres.add("celular");
		palabrasClave_DeInteres.add("usos");
		palabrasClave_SinInteres.add("cocina");
		palabrasClave_SinInteres.add("recetas");
		when(articuloDeInteres.getPalabrasClave()).thenReturn(palabrasClave_DeInteres);
		when(articuloSinInteres.getPalabrasClave()).thenReturn(palabrasClave_SinInteres);
		
		//exercise
		Campo palabraClave = new PalabraClave("tecnologia");
		
		//verify
		assertEquals(palabraClave.getValor(), "tecnologia" );
		assertTrue(palabraClave.esDeInteres(articuloDeInteres));
		assertFalse(palabraClave.esDeInteres(articuloSinInteres));
	}
	
	@Test
	void test_seCreaUnCampoDeInteres_Combinado_ConSusValoresDeseados() {
		//setup
		List<String> palabrasClave_DeInteres = new ArrayList<>();
		List<String> palabrasClave_SinInteres = new ArrayList<>();
		palabrasClave_DeInteres.add("tecnologia");
		palabrasClave_DeInteres.add("celular");
		palabrasClave_DeInteres.add("usos");
		palabrasClave_SinInteres.add("cocina");
		palabrasClave_SinInteres.add("recetas");
		
		when(articuloDeInteres.getPalabrasClave()).thenReturn(palabrasClave_DeInteres);
		when(articuloSinInteres.getPalabrasClave()).thenReturn(palabrasClave_SinInteres);
		when(articuloDeInteres.getTitulo()).thenReturn("Smalltalk");
		when(articuloSinInteres.getTitulo()).thenReturn("Wollok");
		
		//exercise
		Campo combinado = 
				new CampoCombinado(new Titulo("Smalltalk"), new PalabraClave("tecnologia"));
		
		//verify
		assertTrue(combinado.esDeInteres(articuloDeInteres));
		assertFalse(combinado.esDeInteres(articuloSinInteres));
	}
	
	
}
