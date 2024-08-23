package pruebaPrimerCommit;

//import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import ar.edu.poo2.pruebaPrimerCommit.Punto;

class PuntoTestCase {
	
	@Test
	void test() {
		Punto coordenada = new Punto(50, 23);
		Assertions.assertEquals( 23, coordenada.getY() );
	}

}
