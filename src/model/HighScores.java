package model;

public class HighScores {

	public static int HIGHSCORESMAX = 10;
	
	private int[] scoreTable;
	private String[] nameTable;
	
	public HighScores(){
		scoreTable = new int[HIGHSCORESMAX];
		nameTable = new String[HIGHSCORESMAX];
	}
	
	public void refresh() {
		
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
