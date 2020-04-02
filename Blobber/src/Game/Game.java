package Game;

import UI.*;

public class Game implements LoopObserver {
	private AppWindow appWindow;
	private Player player;
	
	public Game () {
		appWindow = new AppWindow(this);
	}
	
	public void startGame(String name) {
		player = new Player(name);
		GameLoop.getInstance().registerObserver(this);
	}
	
	public void endGame() {
		
	}
	
	public Player getPlayer() {
		return player;
	}

	@Override
	public void tick() {
		
	}
}
