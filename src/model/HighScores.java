package model;

import java.io.Serializable;

public class HighScores implements Serializable{

	public static int HIGHSCORESMAX = 10;
	
	private int[] scoreTable;
	private String[] nameTable;
	
	public HighScores(){
		scoreTable = new int[HIGHSCORESMAX];
		nameTable = new String[HIGHSCORESMAX];
	}
	
	public void refresh() {
		for(int j = 0; j<scoreTable.length-1; j++){
			if(scoreTable[j] > scoreTable[j+1]) {
				int actualPos = scoreTable[j];
				int sigPos = scoreTable[j+1];
				scoreTable[j] = sigPos;
				scoreTable[j+1] = actualPos;
				String actualName = nameTable[j];
				String sigName = nameTable[j+1];
				nameTable[j] = sigName;
				nameTable[j+1] = actualName;
			}
		}
	}
	public void highScore(String name, int score) {
		refresh();
		scoreTable[1] = score;
		nameTable[1] = name;
		
	}

	public int[] getScoreTable() {
		return scoreTable;
	}

	public void setScoreTable(int[] scoreTable) {
		this.scoreTable = scoreTable;
	}

	public String[] getNameTable() {
		return nameTable;
	}

	public void setNameTable(String[] nameTable) {
		this.nameTable = nameTable;
	}
	
}
