package HighScore;

import java.io.Serializable;

public class Score implements Comparable<Score>, Serializable {

	private int score;
	private String name;
	
	public Score (int score, String name) {
		this.score = score;
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public int getScore() {
		return score;
	}

	@Override
	public int compareTo(Score s) {
		// retourne > 0 si plus quand que s, sinon plus petit
		return score - s.score;
	}
}
