package HighScore;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;

public class HighScoresManager {
	private ArrayList<Score> scores;
	private final String FILE_NAME = "scores.ser";
	
	public HighScoresManager() {
		loadScores();
	}
	
	public ArrayList<Score> getScores() {
		return scores;
	}
	
	public void loadScores() {
		try {
			FileInputStream fis = new FileInputStream(FILE_NAME);
			ObjectInputStream ois = new ObjectInputStream(fis);
			scores = (ArrayList<Score>)ois.readObject();
			ois.close();
			fis.close();
		} catch (Exception e) {
			System.out.println("Nouveaux scores vides");
			scores = new ArrayList <Score>();
		}
		
	}
	
	/**
	 * Sauvegarde le score dans un fichier
	 * @param s Le score a ajouter
	 */
	public void addScore(Score s) {
		scores.add(s);
		Collections.sort(scores);
		try {
			FileOutputStream fos = new FileOutputStream(FILE_NAME);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(scores);
			oos.close();
			fos.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
