package Blob;

import java.awt.Color;
import java.awt.Graphics;

import Game.Game;

public class Blob extends ABlob{
	private int x, y, diameter;

	public Blob(int ticksCounter, int damage, int hp, int score, int x, int y, int diameter, Game game) {
		super(ticksCounter, damage, hp, score, game);
		this.color = Color.MAGENTA;
		this.x = x;
		this.y = y;
		this.diameter = diameter;
	}

	@Override
	protected void drawBlob(Graphics g) {
		setBounds(x, y, diameter, diameter);
		g.setColor(color);
		g.fillOval(0, 0, diameter, diameter);
	}
	
	
	
}
