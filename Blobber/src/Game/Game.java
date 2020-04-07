package Game;

import java.util.Random;

import Blob.ABlob;
import Blob.Blob;
import Cursor.ACursorDecorator;
import Cursor.BaseCursor;
import Cursor.ICursor;
import Popper.SingleClickPopper;
import UI.*;

public class Game implements LoopObserver {
	private int currentHP = 1;
	private final int MAX_DAMAGE = 19, MIN_TICKS = 20, MAX_TICKS = 20, BLOB_WIDTH = 20;
	private int max_w = 800, max_h = 600;
	private Random rand = new Random();
	private int ticksBeforeNewBlob, ticksBeforeNewBlobCounter;
	
	private ICursor c;
	private AppWindow appWindow;
	private Player player;
	private GameFrame gameFrame;
	
	public Game () {
		appWindow = new AppWindow(this);
		gameFrame = new GameFrame();
	}
	
	public void startGame(String name) {
		c = new BaseCursor();
		player = new Player(name);
		GameLoop.getInstance().registerObserver(this);
		gameFrame.setVisible(true);
		Thread t = new Thread(GameLoop.getInstance());
		t.start();
		ticksBeforeNewBlobCounter = 20;
		ticksBeforeNewBlob = 0;
	}
	
	public void endGame() {
		gameFrame.setVisible(false);
		GameLoop.getInstance().endGame();
		gameFrame.removeAllBlobs();
	}
	
	public Player getPlayer() {
		return player;
	}

	@Override
	public void tick() {
		if (player.getHP() <0) {
			endGame();
		}
		if (ticksBeforeNewBlob > 0) {
			ticksBeforeNewBlob--;
		} else {	
			System.out.println("Creation dun blob");
			int d = w();
			Blob b = new Blob(ticks(),damage(),currentHP,currentHP,x(d),y(d),d,this);
			b.addMouseListener(new SingleClickPopper(b));
			gameFrame.addBlob(b);
			
			// logique de creation des blobs
			ticksBeforeNewBlobCounter -= 1;
			ticksBeforeNewBlob = ticksBeforeNewBlobCounter;
		}
	}

	public void removeBlobFromGame(ABlob b) {
		gameFrame.removeBlob(b);
	}
	
	
	/**/
	private int w() {
		return 5+rand.nextInt(BLOB_WIDTH);
	}

	private int x(int w) {
		return rand.nextInt(max_w-w);
	}

	private int y(int h) {
		return rand.nextInt(max_h-h);
	}
	
	private int ticks() {
		return MIN_TICKS+rand.nextInt(MAX_TICKS);
	}
	private int damage() {
		return 1+rand.nextInt(MAX_DAMAGE);
	}
	
	public void decorateCursor(ACursorDecorator cd) {
		cd.decorate(c);
		c = cd;
	}

	public int getCursorDamage() {
		return c.getDamage();
	}
}
