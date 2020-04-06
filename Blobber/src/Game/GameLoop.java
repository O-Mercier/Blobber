package Game;

import java.util.ArrayList;

public class GameLoop implements Runnable{
	
	private ArrayList<LoopObserver> observers;
	private static GameLoop gameLoop = null;
	private boolean isOver = false;
	
	private GameLoop () {
		observers = new ArrayList<LoopObserver>();
	}
	
	public static GameLoop getInstance() {
		if (gameLoop == null) {
			gameLoop = new GameLoop();
		}
		return gameLoop;
	}
	
	public void unregisterObserver(LoopObserver obs) {
		observers.remove(obs);
	}

	private void unregisterAllObservers() {
		observers.clear();
	}
	
	public void registerObserver(LoopObserver obs) {
		observers.add(obs);
	}
	
	public void notifyObservers() {
		for (int i = 0; i < observers.size(); i++) {
			observers.get(i).tick();
		}
	}
	
	@Override
	public void run() {
		isOver = false;
		try {
			while (!isOver) {			
				notifyObservers();
				Thread.sleep(200);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void endGame() {
		isOver = true;
		unregisterAllObservers();
	}
}
