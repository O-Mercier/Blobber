package Blob;

import java.awt.Color;
import java.awt.Graphics;

import Cursor.CursorBonus;
import Game.Game;

public class BonusBlob extends ABlob {
	public BonusBlob(int ticksCounter, int damage, int currentHP, int score, int x, int y, int w, int h, Game game) {
		super(ticksCounter, damage, currentHP, score, x, y, w, h, game);
		this.color = Color.GREEN;
	}
	
	@Override
	public void pop() {
		super.pop();
		game.decorateCursor(new CursorBonus());
	}

	@Override
	protected void drawBlob(Graphics g) {
		super.drawBlob(g);
		g.setColor(color);
		g.fillOval(0, 0, w, h);
	}
}
