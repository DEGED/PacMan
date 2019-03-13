package model;

public class PacMan {
	
	public static int IZQUIERDA = 1;
	public static int DERECHA = 2;
	public static int ARRIBA = 3;
	public static int ABAJO = 4;
	
	
	private double radio;
	private double posX;
	private double posY;
	private int direction;
	private boolean catchStatus;
	
	public PacMan(double radioo, double posx, double posy, int dire) {
		radio = radioo;
		posX = posx;
		posY = posy;
		direction = dire;
		catchStatus = true;
	}

	public void changeStatus() {
		catchStatus = false;
	}
	
	public double getRadio() {
		return radio;
	}

	public void setRadio(double radio) {
		this.radio = radio;
	}
	
	public double getPosX() {
		return posX;
	}
	public void setPosX(double posX) {
		this.posX = posX;
	}
	public double getPosY() {
		return posY;
	}
	public void setPosY(double posY) {
		this.posY = posY;
	}
	public boolean isCatchStatus() {
		return catchStatus;
	}
	public void setCatchStatus(boolean catchStatus) {
		this.catchStatus = catchStatus;
	}

	public int getDirection() {
		return direction;
	}

	public void setDirection(int direction) {
		this.direction = direction;
	}
	
}
