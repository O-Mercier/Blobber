package Blob;

import java.util.ArrayList;
import java.util.Random;

import Game.Game;
import Popper.MouseEnteredPopper;
import Popper.SingleClickPopper;

public class BlobFactory {
	protected  ArrayList<Integer> intUsedToCreateBlobs = new ArrayList<Integer>();
	protected  int currentHP = 2;
	protected  final int MAX_DAMAGE = 19, MIN_TICKS = 20, MAX_TICKS = 20, BLOB_WIDTH = 20, BLOB_HEIGHT = 20;
	protected  final int MIN_WIDTH = 20, MIN_HEIGHT = 20, MIN_DAMAGE = 1, POISON_HP = 1;
	protected  int max_w = 700, max_h = 600;
	protected  Random rand = new Random();

	public BlobFactory() {

	}

	protected  int w() {
		return MIN_WIDTH + rand.nextInt(BLOB_WIDTH);
	}

	protected  int h() {
		return MIN_HEIGHT + rand.nextInt(BLOB_HEIGHT);
	}

	protected  int x(int w) {
		return rand.nextInt(max_w - w);
	}

	protected  int y(int h) {
		return rand.nextInt(max_h - h);
	}

	protected  int ticks() {
		return MIN_TICKS + rand.nextInt(MAX_TICKS);
	}
	protected  int damage() {
		return MIN_DAMAGE + rand.nextInt(MAX_DAMAGE);
	}

	protected  void fillIntArray() {
		for (int i =0; i< 10; i++) {
			intUsedToCreateBlobs.add(i);
		}
		shuffleBlobs();
	}

	protected  void shuffleBlobs() {
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
			currentHP+=2;
		}
		
		int blobCaseValue = intUsedToCreateBlobs.remove(0);
		
		switch(blobCaseValue) {
			case 0:
				return bonusBlob(game);
			case 1:
				return poisonBlob(game);
			case 3:
				return movingBlob(game);
			default:
				return blob(game);
		}
	}

	protected  Blob blob(Game game) {
		int w = w();
		int h = h();
		Blob b = new Blob(ticks(),damage(),currentHP,currentHP,x(w),y(h),h,w,game);
		b.addMouseListener(new SingleClickPopper(b));
		return b;
	}
	protected  BonusBlob bonusBlob(Game game) {
		int w = w();
		int h = h();
		BonusBlob b = new BonusBlob(ticks(),damage(),currentHP,currentHP,x(w),y(h),w,h,game);
		b.addMouseListener(new SingleClickPopper(b));
		return b;	
	}
	protected  PoisonBlob poisonBlob(Game game) {
		int w = w();
		int h = h();
		PoisonBlob b = new PoisonBlob(ticks(),damage(), POISON_HP, 0,x(w),y(h),w,h,game);
		b.addMouseListener(new MouseEnteredPopper(b));
		return b;
	}

	protected  MovingBlob movingBlob(Game game){
		int w = w();
		int h = h();
		MovingBlob b = new MovingBlob(ticks(),damage(), POISON_HP, 0,x(w),y(h),w,h,game,rand);
		b.addMouseListener(new SingleClickPopper(b));
		return b;
	}
}
