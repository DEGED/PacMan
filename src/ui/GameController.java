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

    private boolean flag;
    @FXML
    void gameSave(ActionEvent event) {
    	
    }

    @FXML
    void getOut(ActionEvent event) {

    }

    @FXML
    void knowGame(ActionEvent event) {

    }

    @FXML
    void level0(ActionEvent event) throws IOException{
    	createPac();
    	leftToRigth(skins.get(0), pacs.get(0));
    	PacMansXThreads x = new PacMansXThreads(true, this, pacs.get(0), skins.get(0));
    	x.start();
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
    public void leftToRigth(Arc pac, PacMan gen) {
    	while(gen.getDirection() == 2){
    		pac.setLayoutX(pac.getLayoutX()+5);
    		gen.setPosX(pac.getLayoutX());
    	}
    	if(pac.getLayoutX()>pane.getWidth()){
    		gen.setDirection(1);
    	}
    }
    
    public void  rigthToLeft(Arc pac, PacMan gen){
    	while(gen.getDirection() == 1) {
    		pac.setLayoutX(pac.getLayoutX()-5);
    		gen.setPosX(pac.getLayoutX());
    	}
    	if(pac.getLayoutX()>pane.getWidth()){
    		gen.setDirection(2);
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
    		Arc pac1 = new Arc(zero.getPosX(), zero.getPosY(), zero.getRadio(), zero.getRadio(), 50, 270);
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
		while(line != null ) {
			char k = line.charAt(0);
			if(k != '#'){
				String[] parts = line.split(sep);
				
				double radio = Double.parseDouble(parts[0]);
				double posx = Double.parseDouble(parts[1]);
				double posy = Double.parseDouble(parts[2]);
				int  dire = Integer.parseInt(parts[3]);
			
			
				PacMan s = new PacMan(radio, posx, posy, dire);
				pacs.add(s);
				
			}
			line = br.readLine();
			
		}
		
		br.close();
		fr.close();
	}

    @FXML
    void initialize() {
    	skins = new ArrayList<Arc>();
    	pacs = new ArrayList<PacMan>();
    	flag = true;
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

