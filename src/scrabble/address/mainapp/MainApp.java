package scrabble.address.mainapp;

import java.io.IOException;


import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.DragEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import scrabble.address.model.Joueur;
import scrabble.address.model.Partie;
import scrabble.address.model.Piece;
import scrabble.address.model.Plateau;
import scrabble.address.model.Sac;
import scrabble.address.view.ViewController;


public class MainApp extends Application {
	
    private Stage primaryStage;
    private BorderPane rootLayout;
    private GridPane  GP;
    private Scene scene1, scene2;
    private Button btnscene1;
    private Label lblscene1;
    private BorderPane pane1;
    private FlowPane pane2, pane3;
    private ObservableList<String> options ;
    private ComboBox comboBox;
    private TextField champ1,champ2,champ3,champ4;
    private Alert alert;
    private Joueur j1,j2,j3,j4;
	private Partie partie;
    private Sac sac;
   // private JOptionPane jop1;	    
    
    public MainApp(){

    }
    


  

	@Override
    public void start(Stage primaryStage) {
    	this.primaryStage = primaryStage;
        this.primaryStage.setTitle("Scrabble");
        
        
        initScene1();
        initRootLayout();
        
        showHandOverview();
        primaryStage.setScene(scene1);
        primaryStage.show();
        
        
         
    }
	
	
	
	public void initScene1(){
	
		
		//pane1 => panel principale de la page permettant la disposition des différents composant de celle-ci
		//pane2 => panel permettant la mise en place du label et du ComboBox l'un à coté de l'autre
		//pane3 => panel disposant les champs de texte 
		pane1 = new BorderPane();
        pane2 = new FlowPane();
        pane3 = new FlowPane();
		
        
        //Bouton permettant d'acceder à la 2e scene
		btnscene1=new Button(" Jouer ");
		btnscene1.setMaxSize(200, 200);
        btnscene1.setOnAction(e-> ButtonClicked(e));
        btnscene1.setTranslateX(1000);
        btnscene1.setStyle("-fx-backgroung-color: linear-gradient(#FF0000, #190707);");
        
        
        //Texte d'indication 
        lblscene1 = new Label("Saisir le nombre de joueur : ");
        lblscene1.setTextFill(Color.RED);
        lblscene1.setFont(new Font("Arial", 30));
        lblscene1.setTranslateX(150);
        
        
        //Champ de text
        champ1 = new TextField();
        champ1.setEditable(false);
        champ2 = new TextField();
        champ2.setEditable(false);
        champ3 = new TextField();
        champ3.setEditable(false);
        champ4 = new TextField();
        champ4.setEditable(false);
        
        
        //ComboBox listant les choix possible pour l'utilisateur
        options = FXCollections.observableArrayList(
	            "2 Joueurs",
	            "3 Joueurs",
	            "4 Joueurs"
	        );
	    comboBox = new ComboBox(options);
	    comboBox.setTranslateX(200);
	    comboBox.setPromptText("Saisir le nombre de joueurs : ");
	    //Différents comportement selon le choix sélectionné dans le combo box
	    comboBox.valueProperty().addListener(new ChangeListener<String>() {
	        @Override public void changed(ObservableValue ov, String t, String t1) {
	        		if(t1.equals("2 Joueurs")){
	        			champ1.setEditable(true);
	        			champ2.setEditable(true);
	        		}
	        		else if(t1.equals("3 Joueurs")){
	        			champ1.setEditable(true);
	        			champ2.setEditable(true);
	        			champ3.setEditable(true);
	        		}
	        		else if(t1.equals("4 Joueurs")){
	        			champ1.setEditable(true);
	        			champ2.setEditable(true);
	        			champ3.setEditable(true);
	        			champ4.setEditable(true);
	        		}
	        			

	        }    
	    });
	    
	    
        
        //Disposition du label suivi du bouton
        pane2.getChildren().add(lblscene1);
        pane2.getChildren().add(comboBox);
        
        //Disposition des champs de texte
        pane3.getChildren().add(champ1);
        pane3.getChildren().add(champ2);
        pane3.getChildren().add(champ3);
        pane3.getChildren().add(champ4);
        
        //Ajout des éléments sur le Pane principal
        pane1.setStyle("-fx-background-color: linear-gradient(#2EFEF7, #FFFF00);");
        pane1.setBottom(btnscene1);
        pane1.setTop(pane2);
        pane1.setCenter(pane3);

        scene1 = new Scene(pane1,800,800);
	}
	
	
	
	//Bouton scene1 vers scene 2
    private void ButtonClicked(ActionEvent e) {
    	
    	//Boite d'alerte 
    	alert = new Alert(AlertType.ERROR);
    	alert.setTitle("Field is empty");
    	alert.setHeaderText(null);
    	alert.setContentText("You must enter a Pseudo for your player ! ");
    	
    	//Verification des champs
    	if(e.getSource()==btnscene1){
    		//Si tous les champs ne sont pas remplis alors message d'alerte
			if(champ1.getText().isEmpty() || champ2.getText().isEmpty() ||
					(comboBox.getValue().equals("3 Joueurs") && champ3.getText().isEmpty())
					|| (comboBox.getValue().equals("4 Joueurs") && 
							(champ3.getText().isEmpty() || champ4.getText().isEmpty())))
			    		alert.show();
			//sinon on crée le nombre de joueur necessaire et on l'ajoute à la liste de participants
			else{
				if(comboBox.getValue().equals("2 Joueurs"))
				{
					partie = new Partie(); //Creation nouvelle partie
					
					j1 = new Joueur(champ1.getText());	//Creation joueurs avec leur pseudo
					j2 = new Joueur(champ2.getText());
					
					sac = new Sac();	//Nouveau sac
					partie.setSac(sac);
					
					partie.getParticipants().add(j1);	//Ajout des joueurs dans la partie
					partie.getParticipants().add(j2);
					partie.getParticipants().get(0).newMain(sac);	//Main des joueurs depuis le sac
					partie.getParticipants().get(1).newMain(sac);
				}
				else if(comboBox.getValue().equals("3 Joueurs"))
				{
					partie = new Partie();
					j1 = new Joueur(champ1.getText());
					j2 = new Joueur(champ2.getText());
					j3 = new Joueur(champ3.getText());
					
					sac = new Sac();
					partie.setSac(sac);
					
					partie.getParticipants().add(j1);
					partie.getParticipants().add(j2);
					partie.getParticipants().add(j3);
					
					partie.getParticipants().get(0).newMain(sac);
					partie.getParticipants().get(1).newMain(sac);
					partie.getParticipants().get(2).newMain(sac);
				}
				else if(comboBox.getValue().equals("4 Joueurs"))
				{
					partie = new Partie(); 
					
					j1 = new Joueur(champ1.getText());
					j2 = new Joueur(champ2.getText());
					j3 = new Joueur(champ3.getText());
					j4 = new Joueur(champ4.getText());
					
					sac = new Sac();
					partie.setSac(sac);
					
					partie.getParticipants().add(j1);
					partie.getParticipants().add(j2);
					partie.getParticipants().add(j3);
					partie.getParticipants().add(j4);
					
					partie.getParticipants().get(0).newMain(sac);
					partie.getParticipants().get(1).newMain(sac);
					partie.getParticipants().get(2).newMain(sac);
					partie.getParticipants().get(3).newMain(sac);
				}
				System.out.println("Test");
				initRootLayout();
				showHandOverview();
				primaryStage.setScene(scene2);		
			}

		}
	}


	
    /**
     * Initializes the root layout.
     */
    public void initRootLayout() {
        try {
            // Load root layout from fxml file.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("../view/RootLayout.fxml"));
            rootLayout = (BorderPane) loader.load();
            
            // Show the scene containing the root layout.
            scene2 = new Scene(rootLayout);
            primaryStage.setScene(scene2);
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public void showHandOverview(){
    	try{
    	 FXMLLoader loader = new FXMLLoader();
         loader.setLocation(MainApp.class.getResource("../view/View.fxml"));
         BorderPane view = (BorderPane) loader.load();
         ViewController controller = loader.getController();
         
         GridPane grid = new GridPane();
         for(int row=0; row<15; row++) {
             for(int col=0; col<15; col++) {
                 Rectangle rec = new Rectangle();
                 rec.setWidth(50);
                 rec.setHeight(50);
                // set color of each rectangle
                if((row == 0 && (col == 0 || col == 7 || col == 14)) 
                		 || (row == 7 && (col == 0 || col == 7 || col == 14))
                		 || (row == 14 && (col == 0 || col == 7 || col == 14)))
                	 rec.setFill(Color.RED);
                else if((row == 1 && (col == 1 || col == 13)) || (row == 2 && (col == 2 || col == 12)) 
                		|| (row == 3 && (col == 3 || col == 11)) || (row == 4 && (col == 4 || col == 10))
                		|| (row == 10 && (col == 4 || col == 10)) || (row == 11 && (col == 3 || col == 11))
                		|| (row == 12 && (col == 2 || col == 12)) || (row == 13 && (col == 1 || col == 13)))
                	rec.setFill(Color.PINK);
                else if((row == 1 && (col == 5 || col == 9)) 
                		|| (row == 5 && (col == 1 || col == 5 || col == 9 || col == 13))
                		|| (row == 9 && (col == 1 || col == 5 || col == 9 || col == 13))
                		|| (row == 13 && (col == 5 || col == 9)))
                	rec.setFill(Color.BLUE);
                else if(((row == 0 || row == 14) && (col == 3 || col == 11)) 
                		|| ((row == 2 || row == 12) && (col == 6 || col == 8))
                		|| ((row == 3 || row == 11) && (col == 0 || col == 7 || col == 14))
                		|| ((row == 6 || row == 8) && (col == 2 || col == 6 || col == 8 || col == 12))
                		|| (row == 7 && (col == 3 || col == 11)))
                	rec.setFill(Color.AQUAMARINE);
                 else
                	rec.setFill(Color.GREEN);
                
                 GridPane.setRowIndex(rec, row);
                 GridPane.setColumnIndex(rec, col);
                 grid.getChildren().addAll(rec);

                 
             }
         }
         
         grid.setPadding(new Insets(50, 10 , 10, 10));
         this.GP = grid;
         grid.setGridLinesVisible(true);		//Affiche les ligne de la grille
         rootLayout.setBottom(view);			//Ajout de view.Fxml en bas de la fenetre
         view.setCenter(grid);					//Ajout de grid au milieu de la fenetre

         controller.setMainApp(this);
    	}
    	catch(IOException e){
    		e.printStackTrace();
    	}
    }
    

    /**
	 * @return the gP
	 */
	public GridPane getGP() {
		return GP;
	}
    public Partie getPartie() {
		return partie;
	}


    
    /**
     * Returns the main stage.
     * @return
     */
    public Stage getPrimaryStage() {
        return primaryStage;
    }
    
    public static void main(String[] args) {
        launch(args);
        
    }
}
