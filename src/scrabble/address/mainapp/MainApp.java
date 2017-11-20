package scrabble.address.mainapp;

import java.io.IOException;


import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import javafx.stage.Stage;
import scrabble.address.model.Piece;
import scrabble.address.view.ViewController;


public class MainApp extends Application {
	
	private ObservableList<Piece> mainJoueur = FXCollections.observableArrayList();
    private Stage primaryStage;
    private BorderPane rootLayout;
    
    public MainApp(){
    	mainJoueur.add(new Piece("B"));
    	mainJoueur.add(new Piece("O"));
    	mainJoueur.add(new Piece("N"));
    	mainJoueur.add(new Piece("J"));
    	mainJoueur.add(new Piece("O"));
    	mainJoueur.add(new Piece("U"));
    	mainJoueur.add(new Piece("R"));
    }
    
    public ObservableList<Piece> getMainJoueur() {
    	return mainJoueur;
    }

    @Override
    public void start(Stage primaryStage) {
    	this.primaryStage = primaryStage;
        this.primaryStage.setTitle("AddressApp");
        
        
        
        initRootLayout();
        

        showHandOverview();
        
      /*  GridPane grid = new GridPane();
         
        for(int row=0; row<15; row++) {
            for(int col=0; col<15; col++) {
                Rectangle rec = new Rectangle();
                rec.setWidth(50);
                rec.setHeight(50);
                if((row%2==0 && col%2==0) || (row%2 !=0 && col%2 !=0))
                    rec.setFill(Color.WHITE);
                else
                    rec.setFill(Color.BLACK);
                GridPane.setRowIndex(rec, row);
                GridPane.setColumnIndex(rec, col);
                grid.getChildren().addAll(rec);
                 
            }
        }
        rootLayout.getChildren().add(grid);*/
         
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
            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public void showHandOverview(){
    	try{
    	 FXMLLoader loader = new FXMLLoader();
         loader.setLocation(MainApp.class.getResource("../view/View.fxml"));
         AnchorPane view = (AnchorPane) loader.load();
         
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
                 grid.setGridLinesVisible(true);
                 GridPane.setRowIndex(rec, row);
                 GridPane.setColumnIndex(rec, col);
                 grid.getChildren().addAll(rec);
             }
         }
         
         rootLayout.setTop(view);
         rootLayout.getChildren().add(grid);
         
         ViewController controller = loader.getController();
         controller.setMainApp(this);
    	}
    	catch(IOException e){
    		e.printStackTrace();
    	}
    }
    
    public void showPlateau(){
    	
    	
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
