package model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class FileManager {
	private ArrayList<PacMan> retu;
	
	public FileManager() {
//		retu = new ArrayList<PacMan>();
	}

	public ArrayList<PacMan> loadPacman(String path, String sep) throws IOException{
		ArrayList<PacMan> retu = new ArrayList<PacMan>();
		File f = new File(path);
		FileReader fr = new FileReader(f);
		BufferedReader br = new BufferedReader(fr);
		
		String line = br.readLine();
		String le = br.readLine();
		while(line != null ){
			char k = line.charAt(0);
			if(k != '#'){
				String[] parts = line.split(sep);
				
				double radio = Double.parseDouble(parts[0]);
				double posx = Double.parseDouble(parts[1]);
				double posy = Double.parseDouble(parts[2]);
				int  dire = Integer.parseInt(parts[4]);
			
			
				PacMan s = new PacMan(radio, posx, posy, dire);
				retu.add(s);
				
			}
			line = br.readLine();
			
		}
		
		br.close();
		fr.close();
		return retu;
	}
	public void loadScores(){}
	public void savePacmnas() {}
	public void saveScores() {}
	public ArrayList<PacMan> getRetu() {
		return retu;
	}

	public void setRetu(ArrayList<PacMan> retu) {
		this.retu = retu;
	}
	
}
