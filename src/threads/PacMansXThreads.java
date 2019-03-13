package threads;

import javafx.scene.shape.Arc;
import model.PacMan;
import ui.GameController;

public class PacMansXThreads extends Thread{
	private boolean flag;
	private GameController x;
	private PacMan thePac;
	private Arc pacForm;
	
	public PacMansXThreads(boolean flag, GameController x, PacMan thePac, Arc pacForm) {
		super();
		this.flag = flag;
		this.x = x;
		this.thePac = thePac;
		this.pacForm = pacForm;
	}



	public void run() {
		while(flag) {
			x.rigthToLeft(pacForm, thePac);
			x.leftToRigth(pacForm, thePac);
			try {
				sleep(30);
			}catch(InterruptedException e) {
				e.printStackTrace();
			} 
		}
	}
}
