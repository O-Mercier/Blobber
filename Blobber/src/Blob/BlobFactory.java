package Blob;

import java.util.ArrayList;
import java.util.Random;

import Game.Game;
import Popper.SingleClickPopper;

public class BlobFactory {
	private ArrayList<Integer> intUsedToCreateBlobs = new ArrayList<Integer>();
	private int currentHP = 1;
	private final int MAX_DAMAGE = 19, MIN_TICKS = 20, MAX_TICKS = 20, BLOB_WIDTH = 20, BLOB_HEIGHT = 20;
	private final int MIN_WIDTH = 20, MIN_HEIGHT = 20, MIN_DAMAGE = 1;
	private int max_w = 800, max_h = 600;
	private Random rand = new Random();

	public BlobFactory(int width, int heigth) {
		max_w = width;
		max_h = heigth;
	}

	private int w() {
		return MIN_WIDTH + rand.nextInt(BLOB_WIDTH);
	}

	private int h() {
		return MIN_HEIGHT + rand.nextInt(BLOB_HEIGHT);
	}

	private int x(int w) {
		return rand.nextInt(max_w - w);
	}

	private int y(int h) {
		return rand.nextInt(max_h - h);
	}
	
	private int ticks() {
		return MIN_TICKS + rand.nextInt(MAX_TICKS);
	}
	private int damage() {
		return MIN_DAMAGE + rand.nextInt(MAX_DAMAGE);
	}
	
	private void fillIntArray() {
		for (int i =0; i< 10; i++) {
			intUsedToCreateBlobs.add(i);
		}
		shuffleBlobs();
	}

	private void shuffleBlobs() {
		for (int i = 0; i < intUsedToCreateBlobs.size(); i++) {
			int randomIndexToSwap = rand.nextInt(intUsedToCreateBlobs.size());
			int temp = intUsedToCreateBlobs.get(randomIndexToSwap);
			intUsedToCreateBlobs.set(randomIndexToSwap, intUsedToCreateBlobs.get(i));
			intUsedToCreateBlobs.set(i, temp);
		}
	}
	
	public ABlob createBlob(Game game) {
		if(intUsedToCreateBlobs.isEmpty()) {
			fillIntArray();
			currentHP*=2;
		}
		
		int blobCaseValue = intUsedToCreateBlobs.remove(0);
		
		switch(blobCaseValue) {
		case 0:
			return bonusBlob(game);
		default:
			return blob(game);
		}
	}
	
	private Blob blob(Game game) {
		int d = w();
		Blob b = new Blob(ticks(),damage(),currentHP,currentHP,x(d),y(d),d,game);
		b.addMouseListener(new SingleClickPopper(b));
		return b;
	}
	private BonusBlob bonusBlob(Game game) {
		int w = w();
		int h = h();
		BonusBlob b = new BonusBlob(ticks(),damage(),currentHP,currentHP,x(w),y(h),w,h,game);
		b.addMouseListener(new SingleClickPopper(b));
		return b;	
	}
	
}
