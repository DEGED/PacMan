package threads;

import java.util.ArrayList;

import javafx.scene.shape.Arc;
import model.PacMan;
import ui.GameController;

public class PacMansXThreads extends Thread{
	private boolean flag;
	private GameController x;
	private PacMan thePac;
	private boolean r;
	private ArrayList<Arc> pac;
	private int id;
	
	public PacMansXThreads(boolean flag, GameController x, PacMan thePac,ArrayList<Arc> ofThread, int id) {
		this.flag = flag;
		this.x = x;
		this.thePac = thePac;
		pac = ofThread;
		this.id = id;
		
	}


	public void run() {
		while(flag) {
			x.setPacman1and2(pac.get(id));
			
			thePac.setDirection(x.rigthToLeft(thePac));
			thePac.setDirection(x.leftToRigth(thePac));
			
//			System.out.println(pacForm.getCenterX());
//			x.leftToRigth(thePac);
//			System.out.println(x.getPacman1and2().getCenterX());
			try{
				sleep(500);
			}catch(InterruptedException e){
				e.printStackTrace();
			} 
		}
	}
}
