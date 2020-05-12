package Blob;

import java.awt.Color;
import java.awt.Graphics;

import Game.Game;

public class Blob extends ABlob{

	public Blob(int ticksCounter, int damage, int hp, int score,  int x, int y, int w, int h, Game game) {
		super(ticksCounter, damage, hp, score, x, y, w, h, game);
		this.color = Color.MAGENTA;
	}

	@Override
	protected void drawBlob(Graphics g) {
		super.drawBlob(g);
		g.setColor(color);
		g.fillOval(0, 0, w, h);
	}

}
