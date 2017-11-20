package scrabble.address.view;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Region;
import scrabble.address.mainapp.MainApp;
import scrabble.address.model.Partie;

public class ViewController {

	@FXML
	private GridPane mainJoueurTable;
	
	@FXML
	private Label lettre0;
	
	@FXML
	private Label lettre1;

	@FXML
	private Label lettre2;
	
	@FXML
	private Label lettre3;
	
	@FXML
	private Label lettre4;
	
	@FXML
	private Label lettre5;
	
	@FXML
	private Label lettre6;
	
	private MainApp mainApp;
	
	
	public ViewController(){
		
	}
	
	@FXML
	private void Initialize(){
		
	
	}
	
	public void setMainApp(MainApp mainApp){
		this.mainApp = mainApp;
		lettre0.setText(mainApp.getMainJoueur().get(0).getLettre());
		lettre1.setText(mainApp.getMainJoueur().get(1).getLettre());
		lettre2.setText(mainApp.getMainJoueur().get(2).getLettre());
		lettre3.setText(mainApp.getMainJoueur().get(3).getLettre());
		lettre4.setText(mainApp.getMainJoueur().get(4).getLettre());
		lettre5.setText(mainApp.getMainJoueur().get(5).getLettre());
		lettre6.setText(mainApp.getMainJoueur().get(6).getLettre());
	}
	


}