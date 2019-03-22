package threads;

import model.PacMan;
import ui.GameController;

public class PacMansXThreads extends Thread{
	private boolean flag;
	private GameController x;
	private PacMan thePac;

	
	public PacMansXThreads(boolean flag, GameController x, PacMan thePac) {
		this.flag = flag;
		this.x = x;
		this.thePac = thePac;
	}
	public void run(){
		while(flag){
			thePac.rigthAndLeft(x.getWidth());
//			x.updateBounces(thePac.getBounce());
			try{
				sleep(thePac.getTime());
			}catch(InterruptedException e){
				e.printStackTrace();
			}
		}
	}
}
