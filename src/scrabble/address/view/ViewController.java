package scrabble.address.view;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

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
	private int compteurCoup = 0;
	private int compteurCoupDebut = 0;

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
	
	private String restriction = "";
	
	private int compteur = 0; 
	private int cpt2 = 0;
	
	private Piece P1;
	@FXML
	private Label lettre4;
	
	@FXML
	private Label lettre5;
	
	@FXML
	private Label lettre6;
	
	@FXML
	private Label score;
	
	@FXML
	private Label pseudo;
	
	private int joueurActuel = 0;
	
	private MainApp mainApp;
	
	private Node node;
	
	private List<Label> listeCoups = new ArrayList<Label>();
	
	public ViewController(){
		
	}
	
	
	@FXML
	private void Initialize(){
	}
	
	
	
	
	public void setMainApp(MainApp mainApp){
		this.mainApp = mainApp;
		this.listeCoups = new ArrayList<Label>();
		//Assigner la main Generée à la main affichée
		try{
			pseudo.setText(mainApp.getPartie().getParticipants().get(0).getPseudo());
			score.setText(String.valueOf(mainApp.getPartie().getParticipants().get(compteur).getScore()));
			String stck = Character.toString(mainApp.getPartie().getParticipants().get(compteur).getMain().get(0).getLettre());
			lettre0.setText(stck);
			 stck = Character.toString(mainApp.getPartie().getParticipants().get(compteur).getMain().get(1).getLettre());
			lettre1.setText(stck);
			stck = Character.toString(mainApp.getPartie().getParticipants().get(compteur).getMain().get(2).getLettre());
			lettre2.setText(stck);
			 stck = Character.toString(mainApp.getPartie().getParticipants().get(compteur).getMain().get(3).getLettre());
			lettre3.setText(stck);
			 stck = Character.toString(mainApp.getPartie().getParticipants().get(compteur).getMain().get(4).getLettre());
			lettre4.setText(stck);
			 stck = Character.toString(mainApp.getPartie().getParticipants().get(compteur).getMain().get(5).getLettre());
			lettre5.setText(stck);
			 stck = Character.toString(mainApp.getPartie().getParticipants().get(compteur).getMain().get(6).getLettre());
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
			//On parcours notre gridPane afin d'assigner l'evenement a tout les labels
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
	                //EVENEMENT DROP
	                label.addEventHandler(DragEvent.DRAG_DROPPED, (DragEvent event) -> {
	                    //Get the dragboard back
	                    Dragboard db = event.getDragboard();
	                    boolean success = false;
	                    Node noeud = this.node;
	    				
	                   
	                    if (db.hasString()) {
	                    	//La case doit etre jouable et vide pour pouvoir y inserer une valeur
	                    	if(mainApp.getPartie().getPlateau().getMatrice()[l][k].isJouable() && !mainApp.getPartie().getPlateau().getMatrice()[l][k].isPleine()){	
	                    		//En dessous de  2 coup , aucune autres conditions pour le drop;
	                    		if(cpt2<2){
	                    				this.cpt2++;
		                    			char temp = noeud.toString().charAt(11); 	//On récupère la lettre dans le noeud
		                    			//On definit une case que l'on va ajouter aussi sur le terrain matrice[][]
					                    Case C1 = new Case();		
					                    compteurCoup++;	
					                    C1.setPleine(true);
					                    C1.setHasChanged(true);
					    				Piece P1 = new Piece(temp);
					    				C1.setContenu(P1);
					    				mainApp.getPartie().getPlateau().setCase(C1,l,k); //On ajoute au plateau la case				                   
			                    		listeCoups.add(label);
			                    		//On ecrit dans le gridPane la lettre correspondante
					    				label.setText(Character.toString(mainApp.getPartie().getPlateau().getCase(l, k).getContenu().getLettre()));
					    				restriction = mainApp.getPartie().coupJoue(l,k,this.cpt2); // On ajoute a restriction la ligne ou la colonne et son index sur lequel on est restreint
					    				supprimerTexteLabel(this.labelNameStock);
					                    success = true;

	                    		}
	                    		//On autorise le drop sur une seule ligne et sur les cases autorisées (après 2 coups)
	                    		if(cpt2>=2){	
	                    			  String ligne = ""+l;
	                    			  String colonne = ""+k;
	                    			if(restriction.charAt(0) == 'l' && restriction.contains(ligne) ){
	                    				this.cpt2++;

		                    			char temp = noeud.toString().charAt(11); 	//On récupère la lettre dans le noeud
					                    Case C1 = new Case();		
					                    C1.setPleine(true);	
					                    C1.setHasChanged(true);
					    				Piece P1 = new Piece(temp);
					    				C1.setContenu(P1);
					    				mainApp.getPartie().getPlateau().setCase(C1,l,k);
			                    		listeCoups.add(label);
					                    compteurCoup++;
					    				label.setText(Character.toString(mainApp.getPartie().getPlateau().getCase(l, k).getContenu().getLettre()));
					    				restriction = mainApp.getPartie().coupJoue(l,k,this.cpt2);
					    				supprimerTexteLabel(this.labelNameStock);
					                    success = true;

	                    			} 
	                    			// On autorise le drop sur une seule colonne et sur les cases autorisées (après 2 coups pendant le même tour)
	                    			if(restriction.charAt(0) == 'c' && restriction.contains(colonne)){		
	                    				this.cpt2++;
	                    				char temp = noeud.toString().charAt(11); 	//On récupère la lettre dans le noeud
					                    Case C1 = new Case();		
					                    C1.setPleine(true);
					                    C1.setHasChanged(true);
					    				Piece P1 = new Piece(temp);
					    				C1.setContenu(P1);
					    				mainApp.getPartie().getPlateau().setCase(C1,l,k);
			                    		listeCoups.add(label);
					                    compteurCoup++;
					    				label.setText(Character.toString(mainApp.getPartie().getPlateau().getCase(l, k).getContenu().getLettre()));
					    				restriction = mainApp.getPartie().coupJoue(l,k,this.cpt2);
					    				supprimerTexteLabel(this.labelNameStock);
					                    success = true;
					                    
	                    			}

	                    		}
		              
			                    
	                    	}
	                    }
	                    //Complete and consume the event.
	                    event.setDropCompleted(success);
	                    event.consume();

	                });
	               
	                    }
	            }
		 
	        }
	
	// Action drag sur la main du joueur
	public void OnDragDetected(MouseEvent event){
		try{
			this.node = (Text)event.getPickResult().getIntersectedNode(); //On recupere le texte du label	
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
			System.out.println("Cliquez sur une lettre");

		}
	}
	
	//On supprime le texte du label(de la main) lorsqu'une lettre a été joué.
	public void supprimerTexteLabel(String label){
		String a = "";
		for(int i=9;i<16;i++){
			a = a + label.charAt(i);
			
		}
 		if(compteur+1 == mainApp.getPartie().getParticipants().size())
		if(a.contains("lettre0")){
			
			mainApp.getPartie().getParticipants().get(compteur).getMain().get(0).setLettre('\0');

		}
		if(a.contains("lettre1")){
			mainApp.getPartie().getParticipants().get(compteur).getMain().get(1).setLettre('\0');

		}
		if(a.contains("lettre2")){
			mainApp.getPartie().getParticipants().get(compteur).getMain().get(2).setLettre('\0');


		}
		if(a.contains("lettre3")){
			mainApp.getPartie().getParticipants().get(compteur).getMain().get(3).setLettre('\0');


		}
		if(a.contains("lettre4")){
			mainApp.getPartie().getParticipants().get(compteur).getMain().get(4).setLettre('\0');

		}
		if(a.contains("lettre5")){
			mainApp.getPartie().getParticipants().get(compteur).getMain().get(5).setLettre('\0');


		}
		if(a.contains("lettre6")){
			mainApp.getPartie().getParticipants().get(compteur).getMain().get(6).setLettre('\0');


		}
		
		
	}
	//Option over du drag and drop , definit la zone dans laquel on pourra drop  , ici le gridpane
	public void OVER(DragEvent event){
	    if (event.getGestureSource() != mainApp.getGP()
	            && event.getDragboard().hasString()) {
	        	event.acceptTransferModes(TransferMode.COPY_OR_MOVE);
	    }
	    event.consume();
	}
		
		//Boutton passer le tour.
	public void ButtonClicked2(ActionEvent e) {
		
		int i,j;
		int nombreJoueur = mainApp.getPartie().getParticipants().size();
		int i_premier = 0 , i_dernier = 0 , j_premier = 0 , j_dernier = 0;
		int compteurLettre = 0;
		int temp_score = 0;
		boolean premiereLettre = true;
		boolean verif = false;
		boolean motCorrecte = false;
		String mot = "";
		
		System.out.println("Il y a : "+nombreJoueur);
		
		if(e.getSource()==btnNewPlayer)
		{
			mot = mainApp.getPartie().rechercheMot();				// On cherche le mot qui a été joué
			System.out.println("Le mot est1 : " + mot + "\n");
			if(mot != ""){
				mainApp.getPartie().verifMot(mot);					//On verifie si le mot est correcte ou non
				verif = true;
			}
			if(verif == true){
				System.out.println("Le mot est "+mot+"\n");		
				motCorrecte= mainApp.getPartie().verifMot(mot);		
				System.out.println("Le mot est "+motCorrecte);
				if(motCorrecte==false){
			//		mainApp.getPartie().getPlateau().setMatrice(this.backup);
					mainApp.getPartie().motFaux();
					System.out.println(mainApp.getPartie().getPlateau().getCase(7, 7).isJouable());
					
							for(int k = compteurCoupDebut;k<listeCoups.size();k++){
								listeCoups.get(k).setText("");							//Le mot est incorrecte , on le supprime du terrain
							}
						//	mainApp.getPartie().actualiseCaseJouable();				//On actualise les cases jouable (non fonctionnel)
								
						}
						
					}					
				
			
			compteurCoupDebut = compteurCoup;
			for( i = 0; i<=14; i++){
				for( j = 0 ; j<=14; j++){
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
			System.out.println("Coordonnées de la premiere lettre : i = " + i_premier + "    j = " + j_premier);
			System.out.println("Coordonnées de la derniere lettre : i = " + i_dernier + "    j = " + j_dernier);
			//Actualisation du score du joueur
			if(motCorrecte == true){
				if(i_dernier != 0 && j_dernier != 0)
					mainApp.getPartie().getParticipants().get(compteur).setScore(mainApp.getPartie().getParticipants().get(compteur).getScore() + mainApp.getPartie().getPlateau().score(i_premier, j_premier, i_dernier, j_dernier));
				else
					mainApp.getPartie().getParticipants().get(compteur).setScore(mainApp.getPartie().getParticipants().get(compteur).getScore() + mainApp.getPartie().getPlateau().score(i_premier,j_premier));
				System.out.print("Score = " + mainApp.getPartie().getParticipants().get(compteur).getScore());
				score.setText(String.valueOf(mainApp.getPartie().getParticipants().get(compteur).getScore()));
			}
			
			//On remet toutes les cases à faux pour le prochain tour
			for(i = 0; i<=14; i++){
				for(j = 0 ; j<=14; j++)
					mainApp.getPartie().getPlateau().getCase(i, j).setHasChanged(false);
			}
			this.cpt2 = 0;
			//On remplit la main

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
			//On essaye d'afficher la main du joueur suivant
		
				score.setText(String.valueOf(mainApp.getPartie().getParticipants().get(compteur).getScore()));
				pseudo.setText(mainApp.getPartie().getParticipants().get(compteur).getPseudo());
				
				lettre0.setText(Character.toString(mainApp.getPartie().getParticipants().get(compteur).getMain().get(0).getLettre()));
				lettre1.setText(Character.toString(mainApp.getPartie().getParticipants().get(compteur).getMain().get(1).getLettre()));
				lettre2.setText(Character.toString(mainApp.getPartie().getParticipants().get(compteur).getMain().get(2).getLettre()));
				lettre3.setText(Character.toString(mainApp.getPartie().getParticipants().get(compteur).getMain().get(3).getLettre()));
				lettre4.setText(Character.toString(mainApp.getPartie().getParticipants().get(compteur).getMain().get(4).getLettre()));
				lettre5.setText(Character.toString(mainApp.getPartie().getParticipants().get(compteur).getMain().get(5).getLettre()));
				lettre6.setText(Character.toString(mainApp.getPartie().getParticipants().get(compteur).getMain().get(6).getLettre()));
				
			
			//Sinon cela signifie qu'un tour complet des joueurs à été réalisé et qu'il faut revenir au premier joueur
		

			}
		compteur++;
		if(compteur == mainApp.getPartie().getParticipants().size())
			compteur = 0;

		}
	

	
	public static int[] getIntegers(String str) {
		 
	    ArrayList<Integer> list = new ArrayList<Integer>();
	     
	    //découper la phrase en mots
	    String[] splited = str.split(" ");
	     
	    //parcourir les mots
	    for (String current : splited) {
	        try {
	            //tenter de convertir le mot en int
	            int parsedInt = Integer.parseInt (current);
	            //ajouter l Integer à la list
	            list.add(parsedInt);                    //un "auto boxing", une instance de Integer est créée à partir d'un int
	        } catch (NumberFormatException e) {
	            //c est pas un int
	        }
	    }
	     
	    //construire le résultat
	    int[] result = new int[list.size()];
	    for (int i = 0 ; i < list.size() ; i++) {
	        //parcourir la list de Integer créée
	        result[i] = list.get(i);
	    }
	    return result;
	}
	
	

}