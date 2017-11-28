package scrabble.address.view;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.EventObject;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
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
import javafx.util.Duration;
import scrabble.address.mainapp.MainApp;
import scrabble.address.model.Partie;


public class ViewController {

		
	@FXML
	private BorderPane bp;
	
	@FXML
	private Label lettre0;
	
	@FXML
	private Label lettre1;

	@FXML
	private Label lettre2;
	@FXML
	private Pane pane1;
	@FXML
	private Label lettre3;
	
	
	@FXML
	private Button btnNewPlayer;
	
	
	
	@FXML
	private Label lettre4;
	
	@FXML
	private Label lettre5;
	
	@FXML
	private Label lettre6;
	

	
	private MainApp mainApp;
	
	private Node node;
	
	private int compteur;
	
	
	public ViewController(){
		
	}
	
	@FXML
	private void Initialize(){
		
	
	}
	
	public void setMainApp(MainApp mainApp){
		
		this.mainApp = mainApp;
		try{
		compteur = 0;
		lettre0.setText(mainApp.getPartie().getParticipants().get(compteur).getMain().get(0).getLettre());
		lettre1.setText(mainApp.getPartie().getParticipants().get(compteur).getMain().get(1).getLettre());
		lettre2.setText(mainApp.getPartie().getParticipants().get(compteur).getMain().get(2).getLettre());
		lettre3.setText(mainApp.getPartie().getParticipants().get(compteur).getMain().get(3).getLettre());
		lettre4.setText(mainApp.getPartie().getParticipants().get(compteur).getMain().get(4).getLettre());
		lettre5.setText(mainApp.getPartie().getParticipants().get(compteur).getMain().get(5).getLettre());
		lettre6.setText(mainApp.getPartie().getParticipants().get(compteur).getMain().get(6).getLettre());
		
		
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
	                   
	                    //Could have some more thorough checks of course.
	                    if (db.hasString()) {
	                        //Get the textarea and place it into flowPane2 instead
	                    	mainApp.getGP().add(this.node, l, k);
	                    	success = true;
	                    	System.out.println(event.getDragboard());
	                    	System.out.println(this.node.toString());
	                    	System.out.println(event.getSource().toString());
	                    	System.out.println(event.getPickResult().getIntersectedNode().getId());
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
			i.printStackTrace();
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
	
	public void ButtonClicked2(ActionEvent e) {
		
		if(e.getSource()==btnNewPlayer)
		{
			System.out.println(lettre0.getText());
			
			if(lettre0.getText().equals(" ")){
				mainApp.getPartie().getParticipants().get(compteur).getMain().get(0).setLettre(mainApp.getPartie().getSac().piocher().getLettre());
				lettre0.setText(mainApp.getPartie().getParticipants().get(compteur).getMain().get(0).getLettre());
			}
			if(lettre1.getText().equals("")){
				mainApp.getPartie().getParticipants().get(compteur).getMain().get(1).setLettre(mainApp.getPartie().getSac().piocher().getLettre());
				lettre1.setText(mainApp.getPartie().getParticipants().get(compteur).getMain().get(1).getLettre());
			}
			if(lettre2.getText().equals("")){
				mainApp.getPartie().getParticipants().get(compteur).getMain().get(2).setLettre(mainApp.getPartie().getSac().piocher().getLettre());
				lettre2.setText(mainApp.getPartie().getParticipants().get(compteur).getMain().get(2).getLettre());
			}
			if(lettre3.getText().equals("")){
				mainApp.getPartie().getParticipants().get(compteur).getMain().get(3).setLettre(mainApp.getPartie().getSac().piocher().getLettre());
				lettre3.setText(mainApp.getPartie().getParticipants().get(compteur).getMain().get(3).getLettre());
			}
			if(lettre4.getText().equals(" ")){
				mainApp.getPartie().getParticipants().get(compteur).getMain().get(4).setLettre(mainApp.getPartie().getSac().piocher().getLettre());
				lettre4.setText(mainApp.getPartie().getParticipants().get(compteur).getMain().get(4).getLettre());
			}
			if(lettre5.getText().equals(" ")){
				mainApp.getPartie().getParticipants().get(compteur).getMain().get(5).setLettre(mainApp.getPartie().getSac().piocher().getLettre());
				lettre5.setText(mainApp.getPartie().getParticipants().get(compteur).getMain().get(5).getLettre());
			}
			if(lettre6.getText().equals(" ")){
				mainApp.getPartie().getParticipants().get(compteur).getMain().get(6).setLettre(mainApp.getPartie().getSac().piocher().getLettre());
				lettre6.setText(mainApp.getPartie().getParticipants().get(compteur).getMain().get(6).getLettre());
			}
			compteur++;
			try{
			lettre0.setText(mainApp.getPartie().getParticipants().get(compteur).getMain().get(0).getLettre());
			lettre1.setText(mainApp.getPartie().getParticipants().get(compteur).getMain().get(1).getLettre());
			lettre2.setText(mainApp.getPartie().getParticipants().get(compteur).getMain().get(2).getLettre());
			lettre3.setText(mainApp.getPartie().getParticipants().get(compteur).getMain().get(3).getLettre());
			lettre4.setText(mainApp.getPartie().getParticipants().get(compteur).getMain().get(4).getLettre());
			lettre5.setText(mainApp.getPartie().getParticipants().get(compteur).getMain().get(5).getLettre());
			lettre6.setText(mainApp.getPartie().getParticipants().get(compteur).getMain().get(6).getLettre());
			
			}catch(Exception i){
				compteur = 0;
				lettre0.setText(mainApp.getPartie().getParticipants().get(compteur).getMain().get(0).getLettre());
				lettre1.setText(mainApp.getPartie().getParticipants().get(compteur).getMain().get(1).getLettre());
				lettre2.setText(mainApp.getPartie().getParticipants().get(compteur).getMain().get(2).getLettre());
				lettre3.setText(mainApp.getPartie().getParticipants().get(compteur).getMain().get(3).getLettre());
				lettre4.setText(mainApp.getPartie().getParticipants().get(compteur).getMain().get(4).getLettre());
				lettre5.setText(mainApp.getPartie().getParticipants().get(compteur).getMain().get(5).getLettre());
				lettre6.setText(mainApp.getPartie().getParticipants().get(compteur).getMain().get(6).getLettre());
			}
			
		}
	}
	
/*	private void bindToTime() {
		  Timeline timeline = new Timeline(
		    new KeyFrame(Duration.seconds(0),
		      new EventHandler<ActionEvent>() {
		        @Override public void handle(ActionEvent actionEvent) {
		          Calendar time = Calendar.getInstance();
		          SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm:ss");
		          lettre1.setText("azra");
		        }
		      }
		    ),
		    new KeyFrame(Duration.seconds(1))
		  );
		  timeline.setCycleCount(Animation.INDEFINITE);
		  timeline.play();
	}*/

}