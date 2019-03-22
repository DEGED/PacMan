package threads;

import model.PacMan;
import ui.GameController;

public class PacMansYThreads extends Thread{
	private boolean flag;
	private GameController x;
	private PacMan thePac;
	private boolean r;

	
	public PacMansYThreads(boolean flag, GameController x, PacMan thePac) {
		this.flag = flag;
		this.x = x;
		this.thePac = thePac;
	}
	public void run(){
		while(flag){
			thePac.upAndDown(x.getWidth());
//			x.updateBounces(thePac.getBounce());
			try{
				sleep(thePac.getTime());
//				System.out.println("jaja salu2");
			}catch(InterruptedException e){
				e.printStackTrace();
			}
		}
	}
}
