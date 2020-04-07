package Blob;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JLabel;

import Game.*;

public abstract class ABlob extends JLabel implements LoopObserver {

	protected int ticksCounter;
	protected int damage;
	protected int hp;
	protected int score;
	protected Game game;
	protected Color color;
	
	public ABlob(int ticksCounter, int damage, int hp, int score, Game game) {
		super();
		this.ticksCounter = ticksCounter;
		this.damage = damage;
		this.hp = hp;
		this.score = score;
		this.game = game;
		GameLoop.getInstance().registerObserver(this);
	}
	
	public void tick() {
		ticksCounter--;
		if (ticksCounter <= 0)
			pop();
	}
	
	
	public void paintComponent(Graphics g){
		drawHealthBar(g);
		drawBlob(g);
	}

	protected abstract void drawBlob(Graphics g);

	protected void drawHealthBar(Graphics g) {
		// TRAVAIL ETU
	};

	public void pop() {
		game.removeBlobFromGame(this);
		GameLoop.getInstance().unregisterObserver(this);
		if(hp <= 0) 
			game.getPlayer().addScore(score);
		else
			game.getPlayer().removeHp(damage);
	}
	
	public void hit() {
		hp -= 1;
		if (hp <= 0)
			pop();
		// redessine la barre de vie
		repaint();
	}
}