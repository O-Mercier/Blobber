package UI;

import Game.Game;
import Game.GameLoop;
import Game.LoopObserver;

import javax.swing.*;
import java.awt.*;

public class InfoFrame extends JFrame implements LoopObserver {
private JLabel damageLabel, hpLabel, scorelable;
private Game game;
    public InfoFrame(Game game){
        this.game = game;
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(900, 100, 100, 300);
        setUndecorated(true);
        GameLoop.getInstance().registerObserver(this);
        getContentPane().setLayout( new GridLayout(3,0));
        hpLabel = new JLabel("HP: ");
        getContentPane().add(hpLabel);
        damageLabel = new JLabel("Attaque: ");
        getContentPane().add(damageLabel);
        scorelable = new JLabel("Score: ");
        getContentPane().add(scorelable);
        getContentPane().setBackground(Color.GRAY);
    }

    @Override
    public void tick() {
       hpLabel.setText("HP: " + game.getPlayer().getHP() );
       damageLabel.setText("Attaque: " + game.getCursorDamage());
       scorelable.setText("Score: " + game.getPlayer().getScore() );
    }
}
