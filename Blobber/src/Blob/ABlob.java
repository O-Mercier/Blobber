package Blob;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JLabel;

import Game.*;

import static java.lang.Math.round;

public abstract class ABlob extends JLabel implements LoopObserver {
	protected final int HP_BAR_MARGIN = 10, HP_BAR_HEIGHT = 5;
	protected int ticksCounter;
	protected int damage;
	protected int hp, initialHp;
	protected int score;
	protected int x, y, w, h, damageW;
	protected Game game;
	protected Color color;


	
	public ABlob(int ticksCounter, int damage, int hp, int score, int x, int y, int w, int h, Game game) {
		super();
		this.ticksCounter = ticksCounter;
		this.damage = damage;
		this.hp = hp;
		this.initialHp = hp;
		this.score = score;
		this.game = game;
		this.x = x;
		this.y = y;
		this.w = w;
		this.h = h;
		this.damageW = 0;
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

	protected void drawBlob(Graphics g) {
		setBounds(x, y, w, h + HP_BAR_MARGIN);
	}

	protected void drawHealthBar(Graphics g) {
		if (initialHp > hp){
			damageW = w - round(w * ((float)hp/(float)initialHp));
			g.setColor(Color.RED);
			g.fillRect(w - damageW, h + HP_BAR_HEIGHT, damageW, HP_BAR_HEIGHT);}
		g.setColor(Color.GREEN);
		g.fillRect(0, h + HP_BAR_HEIGHT, w - damageW, HP_BAR_HEIGHT);
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
		revalidate();
		repaint();
	}
}