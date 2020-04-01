package Game;

import UI.*;

public class Game {
	private AppWindow appWindow;
	private Player player;
	
	public Game () {
		appWindow = new AppWindow(this);
	}
	
	public void startGame(String name) {
		player = new Player(name);
	}
	
	public void endGame() {
		
	}
	
	public Player getPlayer() {
		return player;
	}
}
