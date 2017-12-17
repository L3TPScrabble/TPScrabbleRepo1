package scrabble.address.view;

import java.lang.reflect.InvocationTargetException;

import javax.swing.GroupLayout.Alignment;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
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
import javafx.scene.control.Labeled;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.DragEvent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.TransferMode;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Region;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.util.Duration;
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
	
	@FXML
	private Label score;
	
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
		//Assigner la main Generée à la main affichée
		try{
			score.setText(String.valueOf(mainApp.getPartie().getParticipants().get(0).getScore()));
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
		
		 for (int i = 0; i <= 14; i++) {
	            for (int j = 0; j <= 14; j++) {

	                Label label = new Label();
	                GridPane.setColumnIndex(label, i);
	                GridPane.setRowIndex(label, j);
	                mainApp.getGP().getChildren().add(label);
	                label.setPrefSize(50, 50);
	                Font font = new Font(20);
	                label.setFont(font);
	               

	                int k = i;
	                int l = j;
	                label.addEventHandler(DragEvent.DRAG_DROPPED, (DragEvent event) -> {
	                    //Get the dragboard back
	                    Dragboard db = event.getDragboard();
	                    boolean success = false;
	                    Node noeud = this.node;
	                    Node noeud2;
	    				
	                   
	                    //Could have some more thorough checks of course.
	                    if (db.hasString()) {
	                    	
		                        //Get the textarea and place it into flowPane2 instead
		                    	if(mainApp.getPartie().getPlateau().getMatrice()[l][k].isJouable() ){
			                    mainApp.getPartie().getPlateau().getCase(l,k).setPleine(true);
			                    mainApp.getPartie().getPlateau().getCase(l,k).setHasChanged(true);
		                    	char temp = noeud.toString().charAt(11);
			                    Case C1 = new Case();
			    				Piece P1 = new Piece(temp);
			    				C1.setContenu(P1);
			    				C1.setJouable(false);
			    				mainApp.getPartie().getPlateau().setCase(C1,l,k);
		                    	mainApp.getGP().add(noeud, k, l);
			    				label.setText(Character.toString(mainApp.getPartie().getPlateau().getCase(l, k).getContenu().getLettre()));

			    				System.out.println("La lettre jaoué est :"+mainApp.getPartie().getPlateau().getCase(l,k).getContenu().getLettre());
			    				mainApp.getPartie().coupJoue(l,k);
			    				supprimerTexteLabel(this.labelNameStock);
			                    success = true;
			                    

	                    	}
	                    }
	                    //Complete and consume the event.
	                    event.setDropCompleted(success);
	                    event.consume();

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
		    System.out.println("voici le contenu  : \n" + content );
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
			
			mainApp.getPartie().getParticipants().get(0).getMain().get(0).setLettre('\0');

		}
		if(a.contains("lettre1")){
			mainApp.getPartie().getParticipants().get(0).getMain().get(1).setLettre('\0');

		}
		if(a.contains("lettre2")){
			mainApp.getPartie().getParticipants().get(0).getMain().get(2).setLettre('\0');


		}
		if(a.contains("lettre3")){
			mainApp.getPartie().getParticipants().get(0).getMain().get(3).setLettre('\0');


		}
		if(a.contains("lettre4")){
			mainApp.getPartie().getParticipants().get(0).getMain().get(4).setLettre('\0');

		}
		if(a.contains("lettre5")){
			mainApp.getPartie().getParticipants().get(0).getMain().get(5).setLettre('\0');


		}
		if(a.contains("lettre6")){
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
		int i_premier = 0 , i_dernier = 0 , j_premier = 0 , j_dernier = 0;
		int compteurLettre = 0;
		boolean premiereLettre = true;
		System.out.println("Il y a : "+nombreJoueur);

		if(e.getSource()==btnNewPlayer)
		{
			//Recuperation des coordonnées de la premiere lettre et de la dernière lettre du mot
			for (int i = 0; i <= 14; i++) {
	            for (int j = 0; j <= 14; j++) {
	            	if(mainApp.getPartie().getPlateau().getCase(i,j).HasChanged() && premiereLettre){
	            		
	            		i_premier = i;
	            		j_premier = j;
	            		premiereLettre = false;
	            	}
	            	else if(mainApp.getPartie().getPlateau().getCase(i,j).HasChanged()){
	            		i_dernier = i;
	            		j_dernier = j;
	            	}
	            }
			}
			//Actualisation du score du joueur
			mainApp.getPartie().getParticipants().get(compteur).setScore(mainApp.getPartie().getPlateau().score(i_premier, j_premier, i_dernier, j_dernier));			
			
			
			score.setText(String.valueOf(mainApp.getPartie().getParticipants().get(compteur).getScore()));
			System.out.println(lettre0.getText());
			
			if(mainApp.getPartie().getParticipants().get(compteur).getMain().get(0).getLettre() == '\0'){
				mainApp.getPartie().getParticipants().get(compteur).getMain().get(0).setLettre(mainApp.getPartie().getSac().piocher().getLettre());
				lettre0.setText(Character.toString(mainApp.getPartie().getParticipants().get(compteur).getMain().get(0).getLettre()));
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
			if(mainApp.getPartie().getParticipants().get(compteur).getMain().get(5).getLettre() == '\0'){
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