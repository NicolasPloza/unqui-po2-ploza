package ar.edu.unq.poo2.tp3;

public class Point {
	
	private int x;
	private int y;
	
	public Point() {
		
	}
	
	public Point(int x, int y) {
		super();
		
		this.x = x;
		this.y = y;
		
	}
	
	public int getX(){
		return this.x;
	}
	
	public int getY() {
		return this.y;
	}
	
	public void setX(int x) {
		this.x = x;
	}
	
	public void setY(int y) {
		this.y = y; 
	}
	
	public void moverAPosicion(int x, int y) {
		setX(x);
		setY(y);
	}

	public Point sumarCon(Point punto) {
		
		int x = getX() + punto.getX();
		
		int y = getY() + punto.getY();
		
		return ( new Point(x,y) );
	}
}




