package model;

import java.util.ArrayList;
import java.util.List;

public class PacManPool {
private List<PacMan> pacs;
private FileManager one;

	
	public PacManPool(){
		pacs = new ArrayList<PacMan>();
	}
	
	public int addPac(double radio, double posx, double posy, int dire, long time){
		pacs.add(new PacMan(radio, posx, posy, dire, time));
		return pacs.size()-1;
	}
	
	public PacMan getPac(int id){
		return pacs.get(id);
	}
	
	public void colicion() {
		for(int i = 0;i<pacs.size() ;i++) {
			for(int j = 0; j<pacs.size();j++) {
			double distancia = Math.sqrt( (pacs.get(i).getPosX() - pacs.get(j).getPosX())*(pacs.get(i).getPosX() - pacs.get(j).getPosX()) + (pacs.get(i).getPosY() - pacs.get(j).getPosY())*(pacs.get(i).getPosY() - pacs.get(j).getPosY()));
			
			if ( distancia < pacs.get(i).getRadio() + pacs.get(j).getRadio()) {
					if(pacs.get(i).getDirection() == 1) {
						pacs.get(i).setDirection(2);
					}
					if(pacs.get(i).getDirection() == 2) {
						pacs.get(i).setDirection(1);
					}
					if(pacs.get(i).getDirection() == 3) {
						pacs.get(i).setDirection(4);
					}
					if(pacs.get(i).getDirection() == 4) {
						pacs.get(i).setDirection(3);
					}

				}
			}
		}
	}

}
