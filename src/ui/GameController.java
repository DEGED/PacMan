package ui;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
import javafx.stage.StageStyle;
import model.FileManager;
import model.HighScores;
import model.PacMan;
import model.PacManPool;
import threads.*;

public class GameController{

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Pane pane;

    @FXML
    private MenuItem save;

    @FXML
    private Menu load;

    @FXML
    private MenuItem lvl0;

    @FXML
    private MenuItem out;

    @FXML
    private MenuItem scores;

    @FXML
    private MenuItem know;

    
    private ArrayList<PacMan> pacs;
    private List<Arc> skins;
    private FileManager manager;
    private PacManPool pool;
    private int bounces;
    private boolean flag;
    private HighScores high;
    
    @FXML
    void gameSave(ActionEvent event) throws FileNotFoundException, IOException{
    	manager.savePacmas("data/lol.txt", pacs);
    }

    @FXML
    void getOut(ActionEvent event){
    	
    }

    @FXML
    void knowGame(ActionEvent event){
    	Alert k = new Alert(AlertType.INFORMATION);
		k.setTitle("Catch the pacman");
		k.setHeaderText(null);
		k.initStyle(StageStyle.UTILITY);
		k.setContentText("in this game you have to catch all the packmans with clicks, you win when you catch all the pacmans");
		k.show();
    }

    @FXML
    void level0(ActionEvent event) throws IOException{
    	createPac("data/lvl.txt.txt");
 
    }

    @FXML
    void level1(ActionEvent event) throws IOException{
    	createPac("data/lvl1.txt");
    }

    @FXML
    void level2(ActionEvent event) throws IOException{
    	createPac("data/lvl2.txt");
    }

    @FXML
    void showScores(ActionEvent event){
    }
    
    
    public void createPac(String name) throws IOException {
    	pacs.clear();
    	pacs = manager.loadPacman(name, ";");
    	for(int i = 0; i<pacs.size(); i++) {
    		PacMan zero = pacs.get(i);
    		int id = pool.addPac(zero.getRadio(), zero.getPosX(), zero.getPosY(), zero.getDirection(), zero.getTime());
    		Arc pac1 = new Arc(pool.getPac(id).getPosX(), pool.getPac(id).getPosY(), pool.getPac(id).getRadio(), pool.getPac(id).getRadio(), 50, 270);
    		pac1.setType(ArcType.ROUND);
    		pac1.setCenterX(pool.getPac(id).getPosX());
    		pac1.setCenterY(pool.getPac(id).getPosY());
    		System.out.println(pool.getPac(id).getPosX());
    		pane.getChildren().add(pac1);
    		skins.add(pac1);
    		if(zero.getDirection() == 1 || zero.getDirection() == 2) {
    			PacMansXThreads x = new PacMansXThreads(flag, this, zero);
//    	    	x.setDaemon(true);
    			x.start();
    		}
    		if(zero.getDirection() == 3 || zero.getDirection() == 4) {
    			PacMansYThreads y = new PacMansYThreads(flag,this,zero);
    			y.start();
    		}
    		
    	}
    } 
    public boolean finish() {
    	boolean flag = false;
    	int cont = 0;
    	for(int i = 0; i<pacs.size();i++) {
    		if(pacs.get(i).getCatchStatus() == true){
    			cont++;
    		}
    	}
    	if(cont == pacs.size()){
    		flag = true;
    	}
    	return flag;
    	}
    public void updatePacMan(){
    	for (int id = 0; id < skins.size(); id++) {
			skins.get(id).setCenterX(pacs.get(id).getPosX());
			skins.get(id).setCenterY(pacs.get(id).getPosY());
			System.out.println(skins.get(id).getCenterX());
			System.out.println(skins.get(id).getCenterY());
			pool.colicion();
//			System.out.println(x);
		}
    	if(finish() == true){
    		flag = !flag;
    	}
    }

	public double getWidth(){
		double width = pane.getWidth();
		return width;
	}
	public double getHeigth() {
		double heigth = pane.getHeight();
		return heigth;
	}
	public void updateBounces(int x) {
		bounces += x;
	}
    @FXML
    void initialize() {
    	skins = new ArrayList<Arc>();
    	pacs = new ArrayList<PacMan>();
    	flag = true;
    	manager = new FileManager();
    	bounces = 0;
    	pool = new PacManPool();
    	high = new HighScores();
    	IntermediateThread gut = new IntermediateThread(this);
    	gut.start();
        assert pane != null : "fx:id=\"pane\" was not injected: check your FXML file 'PacMansGUI.fxml'.";
        assert save != null : "fx:id=\"save\" was not injected: check your FXML file 'PacMansGUI.fxml'.";
        assert load != null : "fx:id=\"load\" was not injected: check your FXML file 'PacMansGUI.fxml'.";
        assert lvl0 != null : "fx:id=\"lvl0\" was not injected: check your FXML file 'PacMansGUI.fxml'.";
        assert out != null : "fx:id=\"out\" was not injected: check your FXML file 'PacMansGUI.fxml'.";
        assert scores != null : "fx:id=\"scores\" was not injected: check your FXML file 'PacMansGUI.fxml'.";
        assert know != null : "fx:id=\"know\" was not injected: check your FXML file 'PacMansGUI.fxml'.";

    }
}

