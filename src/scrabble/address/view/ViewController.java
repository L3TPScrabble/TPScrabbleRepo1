package scrabble.address.view;

import java.lang.reflect.InvocationTargetException;

import javax.swing.GroupLayout.Alignment;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.DragEvent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.TransferMode;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Region;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import scrabble.address.mainapp.MainApp;
import scrabble.address.model.Case;
import scrabble.address.model.Partie;
import scrabble.address.model.Piece;
import scrabble.address.model.Plateau;

public class ViewController {

		
	@FXML
	private BorderPane bp;
	
	@FXML
	private Button btnNewPlayer;
	
	private String labelNameStock;
	@FXML
	private Label lettre0;
		
	@FXML
	private Label lettre1;

	@FXML
	private Label lettre2;
	@FXML
	private Pane pane1;
	@FXML 
	private Pane pane2;
	@FXML
	private Label lettre3;
	
	private Piece P1;
	@FXML
	private Label lettre4;
	
	@FXML
	private Label lettre5;
	
	@FXML
	private Label lettre6;
	
	private int joueurActuel = 0;
	
	private MainApp mainApp;
	
	private Node node;
	
	public ViewController(){
		
	}
	
	@FXML
	private void Initialize(){
		
	
	}
	
	public void setMainApp(MainApp mainApp){
		this.mainApp = mainApp;
		
		//Assigner la main Generé à la main affiché
		try{
			String stck = Character.toString(mainApp.getPartie().getParticipants().get(0).getMain().get(0).getLettre());
			lettre0.setText(stck);
			 stck = Character.toString(mainApp.getPartie().getParticipants().get(0).getMain().get(1).getLettre());
			lettre1.setText(stck);
			stck = Character.toString(mainApp.getPartie().getParticipants().get(0).getMain().get(2).getLettre());
			lettre2.setText(stck);
			 stck = Character.toString(mainApp.getPartie().getParticipants().get(0).getMain().get(3).getLettre());
			lettre3.setText(stck);
			 stck = Character.toString(mainApp.getPartie().getParticipants().get(0).getMain().get(4).getLettre());
			lettre4.setText(stck);
			 stck = Character.toString(mainApp.getPartie().getParticipants().get(0).getMain().get(5).getLettre());
			lettre5.setText(stck);
			 stck = Character.toString(mainApp.getPartie().getParticipants().get(0).getMain().get(6).getLettre());
			lettre6.setText(stck);
			}
			catch(Exception e){
				e.printStackTrace();
			}
		mainApp.getGP().addEventHandler(DragEvent.DRAG_OVER, (DragEvent event) -> {
		    if (event.getGestureSource() != mainApp.getGP()
		            && event.getDragboard().hasString()) {
		        event.acceptTransferModes(TransferMode.COPY_OR_MOVE);
		    }
		    event.consume();
		});
		
		 for (int i = 0; i < 15; i++) {
	            for (int j = 0; j < 15; j++) {

	                Label label = new Label();
	                GridPane.setColumnIndex(label, i);
	                GridPane.setRowIndex(label, j);
	                mainApp.getGP().getChildren().add(label);
	                label.setPrefSize(50, 50);
	               

	                int k = i;
	                int l = j;
	                label.addEventHandler(DragEvent.DRAG_DROPPED, (DragEvent event) -> {
	                    //Get the dragboard back
	                    Dragboard db = event.getDragboard();
	                    boolean success = false;
	                    Node noeud = this.node;
	                   
	                    //Could have some more thorough checks of course.
	                    if (db.hasString()) {
	                    	
		                        //Get the textarea and place it into flowPane2 instead
		                    	if(mainApp.getPartie().getPlateau().getMatrice()[l][k].isJouable()){
		                    	mainApp.getGP().add(noeud, k, l);
			                    char temp = noeud.toString().charAt(11);
			                    Case C1 = new Case();
			    				Piece P1 = new Piece(temp);
			    				C1.setContenu(P1);
			    				mainApp.getPartie().getPlateau().setCase(C1,l,k);
			    				System.out.println("La lettre joué est :"+mainApp.getPartie().getPlateau().getCase(l,k).getContenu().getLettre());
			    				mainApp.getPartie().coupJoue(l,k);
			                    success = true;


	                    	}
	                    }
	                    //Complete and consume the event.
	                    event.setDropCompleted(success);
	                    event.consume();
	    				supprimerTexteLabel(this.labelNameStock);

	                });
	               
	                    }
	            }
		 
		 
	        }

	public void OnDragDetected(MouseEvent event){
		try{
		  this.node = (Text)event.getPickResult().getIntersectedNode(); 
		  Dragboard db = this.node.startDragAndDrop(TransferMode.MOVE);
		  	
		    // Put a string on a dragboard as an identifier
		  	ClipboardContent content = new ClipboardContent();
			this.labelNameStock = event.getSource().toString();

		    content.putString(this.node.toString());
		    db.setContent(content);
		    
		    //Consume the event
		    event.consume();
		    
		}
		catch(ClassCastException i){
			System.out.println("Glissez la lettre sur le terrain");
			System.out.println("Label text"+event.getSource().toString());
		}
	}
	
public void supprimerTexteLabel(String label){
		String a = "";
		for(int i=9;i<16;i++){
			a = a + label.charAt(i);
			
		}
 		
		if(a.contains("lettre0")){
			
			lettre0 = new Label();
			
			mainApp.getPartie().getParticipants().get(0).getMain().get(0).setLettre('\0');

		}
		if(a.contains("lettre1")){
	//		lettre1 = new Label();
			mainApp.getPartie().getParticipants().get(0).getMain().get(1).setLettre('\0');

		}
		if(a.contains("lettre2")){
	//		lettre2 = new Label();
			mainApp.getPartie().getParticipants().get(0).getMain().get(2).setLettre('\0');


		}
		if(a.contains("lettre3")){
	//		lettre3 = new Label();
			mainApp.getPartie().getParticipants().get(0).getMain().get(3).setLettre('\0');


		}
		if(a.contains("lettre4")){
	//		lettre4 = new Label();
			mainApp.getPartie().getParticipants().get(0).getMain().get(4).setLettre('\0');

		}
		if(a.contains("lettre5")){
	//		lettre5 = new Label();
			mainApp.getPartie().getParticipants().get(0).getMain().get(5).setLettre('\0');


		}
		if(a.contains("lettre6")){
	//		lettre6 = new Label();
			mainApp.getPartie().getParticipants().get(0).getMain().get(6).setLettre('\0');


		}
		
		
	}
	public void OVER(DragEvent event){
	    if (event.getGestureSource() != mainApp.getGP()
	            && event.getDragboard().hasString()) {
	        event.acceptTransferModes(TransferMode.COPY_OR_MOVE);
	    }
	    event.consume();
	}
		
		
public void ButtonClicked2(ActionEvent e) {
		int compteur=joueurActuel;
		int nombreJoueur = mainApp.getPartie().getParticipants().size();
		System.out.println("Il y a : "+nombreJoueur);

		if(e.getSource()==btnNewPlayer)
		{
			System.out.println(lettre0.getText());
			
			if(mainApp.getPartie().getParticipants().get(compteur).getMain().get(0).getLettre() == '\0'){
				mainApp.getPartie().getParticipants().get(compteur).getMain().get(0).setLettre(mainApp.getPartie().getSac().piocher().getLettre());
				lettre0.setText(Character.toString(mainApp.getPartie().getParticipants().get(compteur).getMain().get(0).getLettre()));
				System.out.println("bite");
			}
			if(mainApp.getPartie().getParticipants().get(compteur).getMain().get(1).getLettre() == '\0'){
				mainApp.getPartie().getParticipants().get(compteur).getMain().get(1).setLettre(mainApp.getPartie().getSac().piocher().getLettre());
				lettre1.setText(Character.toString(mainApp.getPartie().getParticipants().get(compteur).getMain().get(1).getLettre()));
			}
			if(mainApp.getPartie().getParticipants().get(compteur).getMain().get(2).getLettre() == '\0'){
				mainApp.getPartie().getParticipants().get(compteur).getMain().get(2).setLettre(mainApp.getPartie().getSac().piocher().getLettre());
				lettre2.setText(Character.toString(mainApp.getPartie().getParticipants().get(compteur).getMain().get(2).getLettre()));
			}
			if(mainApp.getPartie().getParticipants().get(compteur).getMain().get(3).getLettre() == '\0'){
				mainApp.getPartie().getParticipants().get(compteur).getMain().get(3).setLettre(mainApp.getPartie().getSac().piocher().getLettre());
				lettre3.setText(Character.toString(mainApp.getPartie().getParticipants().get(compteur).getMain().get(3).getLettre()));
			}
			if(mainApp.getPartie().getParticipants().get(compteur).getMain().get(4).getLettre() == '\0'){
				mainApp.getPartie().getParticipants().get(compteur).getMain().get(4).setLettre(mainApp.getPartie().getSac().piocher().getLettre());
				lettre4.setText(Character.toString(mainApp.getPartie().getParticipants().get(compteur).getMain().get(4).getLettre()));
			}
			if(mainApp.getPartie().getParticipants().get(compteur).getMain().get(5).getLettre() == '\0'){
				mainApp.getPartie().getParticipants().get(compteur).getMain().get(5).setLettre(mainApp.getPartie().getSac().piocher().getLettre());
				lettre5.setText(Character.toString(mainApp.getPartie().getParticipants().get(compteur).getMain().get(5).getLettre()));
			}
			if(mainApp.getPartie().getParticipants().get(compteur).getMain().get(0).getLettre() == '\0'){
				mainApp.getPartie().getParticipants().get(compteur).getMain().get(6).setLettre(mainApp.getPartie().getSac().piocher().getLettre());
				lettre6.setText(Character.toString(mainApp.getPartie().getParticipants().get(compteur).getMain().get(6).getLettre()));
			}
			try{
				joueurActuel = joueurActuel+1;
				compteur=joueurActuel;
				if(joueurActuel == nombreJoueur)
					joueurActuel = 0;
			lettre0.setText(Character.toString(mainApp.getPartie().getParticipants().get(compteur).getMain().get(0).getLettre()));
			lettre1.setText(Character.toString(mainApp.getPartie().getParticipants().get(compteur).getMain().get(1).getLettre()));
			lettre2.setText(Character.toString(mainApp.getPartie().getParticipants().get(compteur).getMain().get(2).getLettre()));
			lettre3.setText(Character.toString(mainApp.getPartie().getParticipants().get(compteur).getMain().get(3).getLettre()));
			lettre4.setText(Character.toString(mainApp.getPartie().getParticipants().get(compteur).getMain().get(4).getLettre()));
			lettre5.setText(Character.toString(mainApp.getPartie().getParticipants().get(compteur).getMain().get(5).getLettre()));
			lettre6.setText(Character.toString(mainApp.getPartie().getParticipants().get(compteur).getMain().get(6).getLettre()));
			
			}catch(Exception i){
				compteur = 0;
				lettre0.setText(Character.toString(mainApp.getPartie().getParticipants().get(compteur).getMain().get(0).getLettre()));
				lettre1.setText(Character.toString(mainApp.getPartie().getParticipants().get(compteur).getMain().get(1).getLettre()));
				lettre2.setText(Character.toString(mainApp.getPartie().getParticipants().get(compteur).getMain().get(2).getLettre()));
				lettre3.setText(Character.toString(mainApp.getPartie().getParticipants().get(compteur).getMain().get(3).getLettre()));
				lettre4.setText(Character.toString(mainApp.getPartie().getParticipants().get(compteur).getMain().get(4).getLettre()));
				lettre5.setText(Character.toString(mainApp.getPartie().getParticipants().get(compteur).getMain().get(5).getLettre()));
				lettre6.setText(Character.toString(mainApp.getPartie().getParticipants().get(compteur).getMain().get(6).getLettre()));
			}
			
		}
	}
}