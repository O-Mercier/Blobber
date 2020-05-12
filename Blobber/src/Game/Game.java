package Game;

import java.util.Random;

import Blob.ABlob;
import Blob.Blob;
import Blob.BlobFactory;
import Blob.ExtremeBlobFactory;
import Cursor.ACursorDecorator;
import Cursor.BaseCursor;
import Cursor.ICursor;
import HighScore.HighScoresManager;
import HighScore.Score;
import Popper.SingleClickPopper;
import UI.*;

public class Game implements LoopObserver {
	private int ticksBeforeNewBlob, ticksBeforeNewBlobCounter;
	private ICursor c;
	private AppWindow appWindow;
	private Player player;
	private GameFrame gameFrame;
	private InfoFrame infoFrame;
	private BlobFactory blobFactory; 
	private HighScoresManager hsm;
	
	public Game () {
		hsm = new HighScoresManager();
		appWindow = new AppWindow(this);
		appWindow.showScore(hsm.getScores());
		gameFrame = new GameFrame();
	}

	public void startGameExtreme(String name) {
		blobFactory = new ExtremeBlobFactory();
		c = new BaseCursor();
		player = new Player(name);
		GameLoop.getInstance().registerObserver(this);
		gameFrame.setVisible(true);
		infoFrame = new InfoFrame(this);
		infoFrame.setVisible(true);
		Thread t = new Thread(GameLoop.getInstance());
		t.start();
		ticksBeforeNewBlobCounter = 5;
		ticksBeforeNewBlob = 0;
	}

	public void startGame(String name) {
		blobFactory = new BlobFactory();
		c = new BaseCursor();
		player = new Player(name);
		GameLoop.getInstance().registerObserver(this);
		gameFrame.setVisible(true);
		infoFrame = new InfoFrame(this);
		infoFrame.setVisible(true);
		Thread t = new Thread(GameLoop.getInstance());
		t.start();
		ticksBeforeNewBlobCounter = 20;
		ticksBeforeNewBlob = 0;
	}
	
	public void endGame() {
		hsm.addScore(new Score(player.getScore(), player.getName()));
		appWindow.showScore(hsm.getScores());
		gameFrame.setVisible(false);
		infoFrame.setVisible(false);
		GameLoop.getInstance().endGame();
		gameFrame.removeAllBlobs();
	}
	
	public Player getPlayer() {
		return player;
	}

	@Override
	public void tick() {
		if (player.getHP() <=0) {
			endGame();
		}
		if (ticksBeforeNewBlob > 0) {
			ticksBeforeNewBlob--;
		} else {	
			System.out.println("Creation dun blob");
			System.out.println("Score: " + player.getScore());
			System.out.println("Damage: " + getCursorDamage());
			System.out.println("HP: " + player.getHP());
			ABlob b = blobFactory.createBlob(this);
			gameFrame.addBlob(b);
			if(!(blobFactory instanceof ExtremeBlobFactory))
				ticksBeforeNewBlobCounter -= 1;
			ticksBeforeNewBlob = ticksBeforeNewBlobCounter;
		}
	}

	public void removeBlobFromGame(ABlob b) {
		gameFrame.removeBlob(b);
	}
	
	public void decorateCursor(ACursorDecorator cd) {
		cd.decorate(c);
		c = cd;
	}

	public int getCursorDamage() {
		return c.getDamage();
	}
}
