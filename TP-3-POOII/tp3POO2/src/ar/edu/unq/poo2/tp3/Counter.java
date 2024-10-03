package ar.edu.unq.poo2.tp3;
import java.util.*;

public class Counter {
	
	private List<Integer> numberArrayList = new  ArrayList<Integer>();
	
	//--------------------------------------punto 1--------------------------------------------
	
	
	//cuenta los numero pares de la lista
	public Integer getEvenOcurrences() {

		return  getMultipleOf(2);
	}
	
	
	//agrega un numero a la lista 
	public void addNumber(Integer aNumber) {
		numberArrayList.add(aNumber);
	}
	
	public int getOddOcurrences() {
		
		return numberArrayList.size() - getEvenOcurrences(); 
	}
	
	// cuenta los numeros que son multiplos de otro en la lista
	public int getMultipleOf(int aNumber) {
		
		int amount= 0;
		
		for (Integer number : numberArrayList ) {
			amount += countIfAMultiple(number , aNumber);
		}
		
		return amount;
		
	}
	
	
	private int countIfAMultiple(int number, int divisor ) {
		int count;
		
		if ( number % divisor ==  0 ) {
			count = 1;
		}else {
			count = 0;
		}
		
		return count;
		
	}
	
	
	//-----------------------------------------punto 2. Desarmando numeros
	
	
	public int getEvenDigits(List<Integer> arregloDeEnteros) {
		
		int max = arregloDeEnteros.getFirst() ;
		
		for (Integer entero : arregloDeEnteros) {
			max = enteroConMasDigitosPares(max, entero); 
		}
		
		return max;
	}
	
	private int enteroConMasDigitosPares(int n1, int n2){
		
		int max;
		
		if ( cantDigitosParesDe(n1) >= cantDigitosParesDe(n2) ) {
			max= n1;
		}else {
			max= n2;
		}
		
		return max;
		
	}
	
	
	private int cantDigitosParesDe(int n ) {
		
		int amount= 0;
		int numero= n;
		
		while (numero != 0 ) {
			amount += contarSiEsDigitoPar(numero);
			numero = numero / 10;
		}
		
		return amount;
	}
	
	private int contarSiEsDigitoPar(int numero) {
		
		int count;
		if(numero % 2 == 0 ) {
			count = 1;
		}else {
			count = 0;
		}
		
		return count;
		
	}
	
	
	
	//------------------------------------------- punto 3 Multiplos-----------------------------------------
	/**
	 * Realice una función que reciba dos valores X e Y, y devuelva el número más alto entre 0 y 1000, que sea
	   múltiplo simultáneamente de X e Y. Si no existe, devolver -1. Por ejemplo si se ingresa 3 y 9, la función debe
	   devolver 999.
	 */
	
	public int getMultiploMasAltoEntreCeroYMilDe(int x, int y) {
		
		int numero = 1000;
		while ( numero > 0 && !(esMultiploSimultaneamenteDe(numero, x, y)) ) {
			numero -- ;
		}
		
		return numero;
	}
	
	
	private boolean esMultiploSimultaneamenteDe(int n, int x, int y) {
		
		return esMultiploDe(n, x) && esMultiploDe(n, y);
	}
	
	private boolean esMultiploDe(int n1, int n2 ) {
		
		return (n1 % n2 == 0 );
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
