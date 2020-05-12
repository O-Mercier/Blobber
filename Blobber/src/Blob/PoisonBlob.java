package Blob;

import Game.Game;
import Cursor.CursorMalus;

import java.awt.*;


public class PoisonBlob extends ABlob {

    public PoisonBlob(int ticksCounter, int damage, int currentHP, int score, int x, int y, int w, int h, Game game) {
        super(ticksCounter, damage, currentHP, score, x, y, w, h, game);
        this.color = Color.RED;
    }

    @Override
    public void pop() {
        super.pop();
        game.decorateCursor(new CursorMalus());
        game.getPlayer().removeHp(damage);
    }

    @Override
    protected void drawBlob(Graphics g) {
        super.drawBlob(g);
        g.setColor(color);
        g.fillOval(0, 0, w, h);
    }

    @Override
    protected void drawHealthBar(Graphics g) {
    }
}
