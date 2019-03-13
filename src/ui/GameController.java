package ui;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
import model.PacMan;
import threads.*;

public class GameController {

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

    @FXML
    private Arc lol;
    
    private ArrayList<PacMan> pacs;
    private ArrayList<Arc> skins;

    private Arc pacman1and2;
    
    private boolean flag;
    @FXML
    void gameSave(ActionEvent event){
    	
    }

    @FXML
    void getOut(ActionEvent event){

    }

    @FXML
    void knowGame(ActionEvent event){

    }

    @FXML
    void level0(ActionEvent event) throws IOException{
    	createPac();
    	for(int i = 0; i<pacs.size();i++) {
    	PacMan exam = pacs.get(i);
    	/*
    	 * 
    	 
    	System.out.println(exam.getPosX());
    	System.out.println(exam.getPosY());
    	System.out.println(exam.getRadio());
    	System.out.println(exam.getDirection());
    	System.out.println("form:");
    	*/
    	Arc p = skins.get(i);
    	/*
    	 * 
    	 
    	System.out.println(p.getCenterX());
    	System.out.println(p.getCenterY());
    	System.out.println(p.getRadiusX());
    	*/
//    	PacMansXThreads x = new PacMansXThreads(true, this, pacs.get(i), skins, i);
    	
//    	x.start();
    	/*
    	System.out.println(pacman1and2.getRadiusX());
    	System.out.println(pacman1and2.getLayoutY());
    	System.out.println(pacman1and2.getLayoutX());
    	*/
    	}
    }

    @FXML
    void level1(ActionEvent event){

    }

    @FXML
    void level2(ActionEvent event){

    }

    @FXML
    void showScores(ActionEvent event){

    }
    public void leftToRigth(PacMan gen){
    	System.out.println(gen.getDirection());
    	while(gen.getDirection() == 2){
    		pacman1and2.setCenterX(pacman1and2.getCenterX()+5);
    		gen.setPosX(pacman1and2.getCenterX());
    		System.out.println("derecha");	
    		if(pacman1and2.getCenterX()>pane.getWidth()){
        		gen.setDirection(1);
        		
        	}
    	}
    
    }
    
    public void  rigthToLeft(PacMan gen){
    	while(gen.getDirection() == 1) {
    		pacman1and2.setLayoutX(pacman1and2.getLayoutX()-5);
    		gen.setPosX(pacman1and2.getLayoutX());
    		if(pacman1and2.getLayoutX()>pane.getWidth()){
        		gen.setDirection(2);
        		System.out.println("izquierda");
        	}
    	}
    }
    public void leftToRigth1(PacMan gen){
    	
    	while(gen.getDirection() == 1) {
    		pacman1and2.setCenterX(pacman1and2.getCenterX()-5);
    		gen.setPosX(pacman1and2.getCenterX());
    		if(pacman1and2.getCenterX()>pane.getWidth()){
        		gen.setDirection(2);
        		System.out.println("izquierda");
        	}
    	}
    }
    public void downToUp(Arc pac, PacMan gen){
    	while(gen.getDirection() == 3) {
    		pac.setLayoutY(pac.getLayoutY()-5);
    		gen.setPosY(pac.getLayoutY());
    	}
    	if(pac.getLayoutY()>pane.getHeight()){
    		gen.setDirection(4);;
    	}
    }
    public void upToDown(Arc pac, PacMan gen){
    	while(gen.getDirection() == 4) {
    		pac.setLayoutY(pac.getLayoutY()+5);
    		gen.setPosY(pac.getLayoutY());
    	}
    	if(pac.getLayoutY()>pane.getHeight()){
    		gen.setDirection(3);
    	}
    }
    
    public void createPac() throws IOException {
    	pacs.clear();
    	loadSPacManFile("data/lvl.txt.txt", ";");
    	for(int i = 0; i<pacs.size(); i++) {
    		PacMan zero = pacs.get(i);
    		/*
    		System.out.println(zero.getPosX());
        	System.out.println(zero.getPosY());
        	System.out.println(zero.getRadio());
        	System.out.println(zero.getDirection());
        
    		 * 
        	*/
    		Arc pac1 = new Arc(zero.getPosX(), zero.getPosY(), zero.getRadio(), zero.getRadio(), 50, 270);
    		
    		 
    		System.out.println(pac1.getCenterX());
        	System.out.println(pac1.getCenterY());
        	System.out.println(pac1.getRadiusX());
        	/*
    		 * 
        	*/
    		pac1.setType(ArcType.ROUND);
    		skins.add(pac1);
    		pane.getChildren().add(pac1);
    		
    	}
    }   
    public void loadSPacManFile(String path, String sep) throws IOException{
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
				pacs.add(s);
				
			}
			line = br.readLine();
			
		}
		
		br.close();
		fr.close();
	}
    public Arc getPacman1and2() {
		return pacman1and2;
	}
    public void setPacman1and2(Arc x) {
		pacman1and2 = x;
	}
    @FXML
    void initialize() {
    	skins = new ArrayList<Arc>();
    	pacs = new ArrayList<PacMan>();
    	flag = true;
    	pacman1and2 = new Arc();
        assert pane != null : "fx:id=\"pane\" was not injected: check your FXML file 'PacMansGUI.fxml'.";
        assert save != null : "fx:id=\"save\" was not injected: check your FXML file 'PacMansGUI.fxml'.";
        assert load != null : "fx:id=\"load\" was not injected: check your FXML file 'PacMansGUI.fxml'.";
        assert lvl0 != null : "fx:id=\"lvl0\" was not injected: check your FXML file 'PacMansGUI.fxml'.";
        assert out != null : "fx:id=\"out\" was not injected: check your FXML file 'PacMansGUI.fxml'.";
        assert scores != null : "fx:id=\"scores\" was not injected: check your FXML file 'PacMansGUI.fxml'.";
        assert know != null : "fx:id=\"know\" was not injected: check your FXML file 'PacMansGUI.fxml'.";
        assert lol != null : "fx:id=\"lol\" was not injected: check your FXML file 'PacMansGUI.fxml'.";

    }
}

