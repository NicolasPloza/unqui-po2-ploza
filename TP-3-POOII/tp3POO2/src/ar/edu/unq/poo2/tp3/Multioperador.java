package ar.edu.unq.poo2.tp3;
import java.util.*;

public class Multioperador {
	

	
	public int sumaDeEnteros(List<Integer> listaDeEnteros ) {
		
		int total = listaDeEnteros.getFirst() ;
		listaDeEnteros.removeFirst();
		for (Integer entero : listaDeEnteros ) {
			total += entero;
		}
		
		return total;
	}
	
	
	public int restaDeEnteros(List<Integer> listaDeEnteros ) {
		
		int total = listaDeEnteros.getFirst() ;
		listaDeEnteros.removeFirst();
		for (Integer entero : listaDeEnteros ) {
			total -= entero;
		}
		
		return total;
	}
	
	public int multiplicacionDeEnteros(List<Integer> listaDeEnteros) {
		int total = listaDeEnteros.getFirst() ;
		listaDeEnteros.removeFirst();
		for (Integer entero : listaDeEnteros ) {
			total = total * entero;
		}
		
		return total;
	}
	
}
