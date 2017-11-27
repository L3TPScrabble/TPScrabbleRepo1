package scrabble.address.view;

import java.lang.reflect.InvocationTargetException;

import javax.swing.GroupLayout.Alignment;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.Node;
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
	private Label lettre0;
	
	private Plateau t;
	
	@FXML
	private Label lettre1;

	@FXML
	private Label lettre2;
	@FXML
	private Pane pane1;
	@FXML
	private Label lettre3;
	
	private Piece P1;
	@FXML
	private Label lettre4;
	
	@FXML
	private Label lettre5;
	
	@FXML
	private Label lettre6;
	
	private MainApp mainApp;
	
	private Node node;
	
	public ViewController(){
		
	}
	
	@FXML
	private void Initialize(){
		
	
	}
	
	public void setMainApp(MainApp mainApp){
		this.mainApp = mainApp;
		char tableJeu[][] = new char[15][15];
		 this.t = new Plateau();

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
	                GridPane.setRowIndex(label, i);
	                GridPane.setColumnIndex(label, j);
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
	                    	mainApp.getGP().add(noeud, l, k);
		                    char temp = noeud.toString().charAt(11);
		                    tableJeu[l][k] = temp;
		                    System.out.println(tableJeu[l][k]);
		                    success = true;
		                    

	                    }
	                    //Complete and consume the event.
	                    event.setDropCompleted(success);
	                    event.consume();
	                });
	               
	                    }
	            }
		 
		 
	        }

	public void up(char[][] P){
		for(int i = 0;i<this.t.getTaille();i++)
			for(int j=0;j<this.t.getTaille();j++){
				String s = "" + P[i][j];
				System.out.println("a");
				this.t.getMatrice()[i][j].getContenu().setLettre('a');
			}
	}
	public void OnDragDetected(MouseEvent event){
		try{
		  this.node = (Text)event.getPickResult().getIntersectedNode();;
		  Dragboard db = lettre0.startDragAndDrop(TransferMode.MOVE);

		    // Put a string on a dragboard as an identifier
		    ClipboardContent content = new ClipboardContent();
		    content.putString(this.node.toString());
		    db.setContent(content);
		    //Consume the event
		    event.consume();
		}
		catch(ClassCastException i){
			System.out.println("Glissez la lettre sur le terrain");
		}
	}
	public void DRAG_DROPPED(DragEvent event){
		
		    //Get the dragboard back
			Dragboard db = event.getDragboard();
			
		    boolean success = false;
		    for( Node node: mainApp.getGP().getChildren()) {

                if( node instanceof Label) {
                    if( node.getBoundsInParent().contains(event.getSceneX(),  event.getSceneY())) {
                    
                        System.out.println( "Node: " + node + " at " + GridPane.getRowIndex( node) + "/" + GridPane.getColumnIndex( node));
                    }
                }
		    }
		    //Could have some more thorough checks of course.
		    if (db.hasString()) {
		        //Get the textarea and place it into flowPane2 instead
		    	int i = (int) event.getSceneX();
            	int j = (int) event.getSceneY();
            	mainApp.getGP().add(this.node, i, j);
		        success = true;
		    }
		    //Complete and consume the event.
		    event.setDropCompleted(success);
		    event.consume();
	}
		public void OVER(DragEvent event){
	    if (event.getGestureSource() != mainApp.getGP()
	            && event.getDragboard().hasString()) {
	        event.acceptTransferModes(TransferMode.COPY_OR_MOVE);
	    }
	    event.consume();
	}
		
		
	
}