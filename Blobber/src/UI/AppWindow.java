package UI;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;

import Game.Game;
import HighScore.Score;

import javax.swing.JTextField;

public class AppWindow {

	private JFrame frmBlobber;
	private JButton bStart;
	private JLabel scoresList, scoreTitle;
	private Game game;
	private Listener l;
	private JTextField iName;
	
	/**
	 * Create the application.
	 */
	public AppWindow(Game game) {
		this.game = game;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmBlobber = new JFrame();
		frmBlobber.setTitle("Blobber");
		frmBlobber.setBounds(100, 100, 800, 600);
		frmBlobber.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmBlobber.getContentPane().setLayout(null);
		
		bStart = new JButton("Démarrer");
		bStart.setBounds(0, 413, 784, 148);
		bStart.setFont(new Font("Tahoma", Font.PLAIN, 55));
		frmBlobber.getContentPane().add(bStart);
		
		scoresList = new JLabel("Aucun Score");
		scoresList.setBounds(0, 59, 784, 290);
		scoresList.setHorizontalAlignment(SwingConstants.CENTER);
		scoresList.setFont(new Font("Tahoma", Font.PLAIN, 20));
		frmBlobber.getContentPane().add(scoresList);
		
		scoreTitle = new JLabel("Tableau des scores");
		scoreTitle.setBounds(0, 11, 784, 37);
		scoreTitle.setHorizontalAlignment(SwingConstants.CENTER);
		scoreTitle.setFont(new Font("Tahoma", Font.PLAIN, 30));
		frmBlobber.getContentPane().add(scoreTitle);
		
		iName = new JTextField();
		iName.setBounds(10, 358, 764, 53);
		iName.setHorizontalAlignment(SwingConstants.CENTER);
		iName.setFont(new Font("Tahoma", Font.PLAIN, 55));
		iName.setText("Antoine");
		iName.setToolTipText("Ton Nom");
		iName.setColumns(10);
		frmBlobber.getContentPane().add(iName);
		
		l = new Listener();
		bStart.addActionListener(l);
		
		frmBlobber.setVisible(true);
	}
	
	private class Listener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			game.startGame(iName.getText());
		}	
	}
	
	public void showScore(ArrayList<Score> scores) {
		String list = "<html>";
		for (Score s: scores) {
			list += s.getName();
			list += " : ";
			list += String.valueOf(s.getScore());
			list += "<br>";
		}
		list += "</html>";
		scoresList.setText(list);
	}
}
