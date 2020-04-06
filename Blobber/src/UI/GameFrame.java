package UI;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Blob.ABlob;

public class GameFrame extends JFrame {

	public GameFrame() {
		initialize();
	}
	
	private void initialize() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		setUndecorated(true);
	}
	
	public void addBlob (ABlob b) {
		getContentPane().add(b);
		revalidate();
	}
	
	public void removeBlob(ABlob b) {
		getContentPane().remove(b);
		revalidate();
		repaint();
	}
	
	public void removeAllBlobs() {
		Component[] c = getContentPane().getComponents();
		for (int i = 0; i < c.length; i++) {
			if (c[i] instanceof ABlob)
				this.remove(c[i]);
		}
	}
}
