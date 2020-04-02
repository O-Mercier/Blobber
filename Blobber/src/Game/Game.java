package Game;

import UI.*;

public class Game implements LoopObserver {
	private AppWindow appWindow;
	private Player player;
	private GameFrame gameFrame;
	
	public Game () {
		appWindow = new AppWindow(this);
		gameFrame = new GameFrame();
		gameFrame.setVisible(true);
	}
	
	public void startGame(String name) {
		player = new Player(name);
		GameLoop.getInstance().registerObserver(this);
		gameFrame.setVisible(true);
	}
	
	public void endGame() {
		gameFrame.setVisible(false);
		GameLoop.getInstance().endGame();
	}
	
	public Player getPlayer() {
		return player;
	}

	@Override
	public void tick() {
		
	}
}
