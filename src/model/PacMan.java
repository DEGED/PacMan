package model;

import java.io.Serializable;


public class PacMan implements Serializable{
	private static final long serialVersionUID = 1L;
	public static int IZQUIERDA = 1;
	public static int DERECHA = 2;
	public static int ARRIBA = 3;
	public static int ABAJO = 4;
	
	
	private double radio;
	private double posX;
	private double posY;
	private int direction;
	private long time;
	private boolean catchStatus;
	private int bounce;
	
	
	public int getBounce() {
		return bounce;
	}
	public void setBounce(int bounce) {
		this.bounce = bounce;
	}
	public PacMan(double radioo, double posx, double posy, int dire, long timee) {
		radio = radioo;
		posX = posx;
		posY = posy;
		direction = dire;
		catchStatus = false;
		bounce = 0;
		setTime(timee);
	}
	public void rigthAndLeft(double max) {
		switch(direction) {
		case 1:
			if(posX < 0) {
				direction = DERECHA;
				bounce++;
			}else {
				posX = posX-5;
			}
		break;
		case 2:
			if(posX >= max){
				direction = IZQUIERDA;
				bounce++;
			}else {
				posX = posX+5;
			}
		break;
		}
		
	}
	public void upAndDown(double max ) {
		switch(direction) {
			case 3:
				if(posY < 0) {
					direction = ABAJO;
				}else {
					posY = posY-5;
				}
			break;
			case 4:
				if(posY >= max) {
					direction = ARRIBA;
				}else{
					posY = posY+5;
				}
			break;	 
		}
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
	public boolean getCatchStatus() {
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

	public long getTime() {
		return time;
	}
	public void setTime(long time) {
		this.time = time;
	}
	
}
