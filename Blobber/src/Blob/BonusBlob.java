package Blob;

import java.awt.Color;
import java.awt.Graphics;

import Cursor.CursorBonus;
import Game.Game;

public class BonusBlob extends ABlob {
	private int x, y, w, h;

	public BonusBlob(int ticksCounter, int damage, int currentHP, int score, int x, int y, int w, int h, Game game) {
		super(ticksCounter, damage, currentHP, score, game);
		this.x = x;
		this.y = y;
		this.w = w;
		this.h = h;
		this.color = Color.GREEN;
	}
	
	@Override
	public void pop() {
		super.pop();
		game.decorateCursor(new CursorBonus());
	}

	@Override
	protected void drawBlob(Graphics g) {
		setBounds(x, y, w, h);
		g.setColor(color);
		g.fillOval(0, 0, w, h);	
	}
}
