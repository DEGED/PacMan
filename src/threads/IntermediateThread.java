package threads;

import javafx.application.Platform;
import ui.GameController;

public class IntermediateThread extends Thread{
	private final static long SLEEP_TIME = 5;
	private GameController conto;
	
	public IntermediateThread(GameController update) {
		conto = update;
	}
	
	public void run() {
		while (true) {
			GUIUpdateRunnable gur = new GUIUpdateRunnable(conto);
			Platform.runLater(gur);
			try{
				sleep(SLEEP_TIME);
			}catch(InterruptedException e){
				e.printStackTrace();
			}
		}
	}
}
