package ar.edu.unq.poo2.tp3;



public class Rectangulo {
	
	private Point esquinaSupIzq;
	private Point esquinaInfIzq;
	private Point esquinaSupDer;
	private Point esquinaInfDer;
	private int ancho;
	private int alto;
	
	public Rectangulo() {
		
	}

	public Rectangulo(Point esquinaSupIzq, int ancho, int alto) {
		super();
		
		this.esquinaSupIzq = esquinaSupIzq;
		this.esquinaSupDer = esquinaSupIzq.sumarCon(new Point(ancho,0));
		this.esquinaInfDer = esquinaSupIzq.sumarCon(new Point(ancho , (alto*-1)));
		this.esquinaInfIzq = esquinaSupIzq.sumarCon(new Point(0,(alto*-1)));
		this.ancho = ancho;
		this.alto = alto;
	}
	
	public void setEsquinaSupIzq(Point esquinaSupIzq) {
		this.esquinaSupIzq = esquinaSupIzq;
	}
	
	public void setAncho(int ancho) {
		this.ancho = ancho;
	}
	
	public void setAlto(int alto) {
		this.alto = alto;
	}
	
  	public int getAlto() {
	
		return alto;
	}
	
	public int getAncho() {

		return ancho;
	}
	
	public Point getEsquinaSupIzq() {
		return esquinaSupIzq;
	}
	
	public Point getEsquinaSupDer() {
		return  esquinaSupDer;
	}

	public Point getEsquinaInfIzq() {
		return esquinaInfIzq;
	}

	public Point getEsquinaInfDer() {
		return esquinaInfDer;
	}

	public int getArea() {
		int area = ancho * alto;
		
		return area;
	}

	public int getPerimetro() {
		int perimetro = (2*ancho) + (2*alto); 
		
		return perimetro;
	}

	public Boolean esHorizontal() {
		
		return ancho > alto ;
	}

	public Boolean esVertical() {
		
		return ancho < alto ;
	}


	
}
