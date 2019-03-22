package threads;

import ui.GameController;

public class GUIUpdateRunnable implements Runnable{
	private GameController game;
	public GUIUpdateRunnable(GameController newone) {
		game = newone;
	
	}
	@Override
	public void run() {
		game.updatePacMan();
	}

	
}
