package Blob;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

import Game.Game;

public class MovingBlob extends ABlob{
    Random rand;

    public MovingBlob(int ticksCounter, int damage, int hp, int score, int x, int y, int w, int h, Game game, Random rand) {
        super(ticksCounter, damage, hp, score, x, y, w, h, game);
        this.color = Color.BLUE;
        this.rand = rand;
    }

    @Override
    protected void drawBlob(Graphics g) {
        super.drawBlob(g);
        g.setColor(color);
        g.fillOval(0, 0, w, h);
    }

    @Override
    public void tick() {
        super.tick();
        x = rand.nextInt(800);
        y = rand.nextInt(600);
        revalidate();
        repaint();
    }

}
