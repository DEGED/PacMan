package model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;

public class FileManager {
	private ArrayList<PacMan> retu;
	
	public FileManager() {
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
				long timee = Long.parseLong(parts[3]);
				int  dire = Integer.parseInt(parts[4]); 
				PacMan s = new PacMan(radio, posx, posy, dire, timee);
				retu.add(s);
			}
			line = br.readLine();
			
		}
		
		br.close();
		fr.close();
		return retu;
	}
	public HighScores loadScores(String name){
		HighScores highs = new HighScores();
		File resourse = new File(name);
		if(resourse.exists()) {
			try {
				ObjectInputStream ois = new ObjectInputStream(new FileInputStream(resourse));
				 highs = (HighScores)ois.readObject();
				ois.close();
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		return highs;
	}
	public ArrayList<PacMan> loadlvls(String name){
		ArrayList<PacMan> pacs = new ArrayList<PacMan>();
		File resourse = new File(name);
		if(resourse.exists()) {
			try {
				ObjectInputStream ois = new ObjectInputStream(new FileInputStream(resourse));
				 pacs = (ArrayList)ois.readObject();
				ois.close();
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		return pacs;
	}
	public void savePacmas(String name, ArrayList<PacMan> pacs) throws FileNotFoundException, IOException{
		ObjectOutputStream lop = new ObjectOutputStream(new FileOutputStream(name));
		lop.writeObject(pacs);
		lop.close();
	}
	public void saveScores(String name, HighScores high) throws FileNotFoundException, IOException{
		ObjectOutputStream lop = new ObjectOutputStream(new FileOutputStream(name));
		lop.writeObject(high);
		lop.close();
	}
	public ArrayList<PacMan> getRetu() {
		return retu;
	}

	public void setRetu(ArrayList<PacMan> retu) {
		this.retu = retu;
	}
	

	
}
