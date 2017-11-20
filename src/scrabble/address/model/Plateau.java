package scrabble.address.model;

import java.util.Random;

import interfaces.CaseInterface;
import interfaces.PlateauInterface;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Shape;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;


public class Plateau extends Application implements PlateauInterface{
	private Case[][] matrice;
	private int taille;
	
	
	public Plateau() {
		this.taille = 15;
		this.matrice = new Case[taille][taille];
	}
	
	public Boolean estPlein() {
		for(int i=0; i<15 ; i++)
			for(int j=0; j<15; j++)
				if(matrice[i][j].estVide())
					return false;			
		return true;
	}
	
	public int ScoreMot(String mot, int i, int j, String d) { //i et j sont les coordonnées de la premiere lettre de mot, d est la direction du mot(gauche à droite / haut en bas) 
		int temp,g;
		boolean motDouble = false, motTriple = false;
		char[] charArray = mot.toCharArray();
		int compteurPoints = 0;
		if(d.equals("droite"))
		{
			g = i;
			temp = i + charArray.length -1;
			while(g<temp)
			{
				for(char c : charArray)
				{
					if(matrice[g][j].getId() == 1) //case de couleur verte
						compteurPoints = compteurPoints + matrice[g][j].getContenu().getPoints();
					else if(matrice[g][j].getId() == 2) //case de couleur bleu clair
						compteurPoints = compteurPoints + matrice[g][j].getContenu().getPoints() * 2 ;
					else if(matrice[g][j].getId() == 3) //case de couleur bleu foncé
						compteurPoints = compteurPoints + matrice[g][j].getContenu().getPoints() * 3 ;
					else if(matrice[g][j].getId() == 4) //case de couleur rose
						motDouble = true;
					else if(matrice[g][j].getId() == 5) //case de couleur rouge
						motTriple = true;
					g++;
				}
			}
		}
		else if(d.equals("bas"))
		{
			g = j;
			temp = j + charArray.length -1;
			while(g<temp)
			{
				for(char c : charArray)
				{
					if(matrice[i][g].getId() == 1) //case de couleur verte
						compteurPoints = compteurPoints + matrice[i][g].getContenu().getPoints();
					else if(matrice[i][g].getId() == 2) //case de couleur bleu clair
						compteurPoints = compteurPoints + matrice[i][g].getContenu().getPoints() * 2 ;
					else if(matrice[i][g].getId() == 3) //case de couleur bleu foncé
						compteurPoints = compteurPoints + matrice[i][g].getContenu().getPoints() * 3 ;
					else if(matrice[i][g].getId() == 4) //case de couleur rose
						motDouble = true;
					else if(matrice[i][g].getId() == 5) //case de couleur rouge
						motTriple = true;
					g++;
				}
			}
		}
		if(motDouble == true)
			compteurPoints = compteurPoints * 2 ;
		if(motTriple == true)
			compteurPoints = compteurPoints * 3 ;
		return compteurPoints;
	}
	
	/*public void addMot(String mot, int i, int j, String d) { //i et j sont les coordonnées de la premiere lettre de mot, d est la direction du mot(gauche à droite / haut en bas)
		int temp,g;	
		char[] charArray = mot.toCharArray();
		if(d.equals("droite"))
		{
			g = i;
			temp = i + charArray.length - 1;
			while(g<temp)
			{
				for(String c: charArray)
				{
					matrice[g][j].getContenu().setLettre(c);
					g++;
				}
			}
		}
		else if(d.equals("bas"))
		{
			g = j;
			temp = j + charArray.length -1;
			while(g<temp)
			{
				for(char c: charArray)
				{
					matrice[i][g].getContenu().setLettre(c);
					g++;
				}
			}
		}
	}*/

	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		int SIZE = 10;
        int length = 15;
        int width = 15;
        
        
        
        GridPane root = new GridPane();    

        for(int y = 0; y < length; y++){
            for(int x = 0; x < width; x++){
            	
            	
            	if(y == 0)
            	{
            		if(x == 0 || x == 7 || x == 14)
            			root.setStyle("-fx-background-color: red; -fx-border-color: redrod;");
            		if(x == 3 || x == 11)
            			root.setStyle("-fx-background-color: blue; -fx-border-color: bluerod;");
            	}
            	if(y == 1)
            	{
            		if(x == 1 || x == 13)
            			root.setStyle("-fx-background-color: pink; -fx-border-color: pinkrod;");
            		else if(x == 5 || x == 9)
            			root.setStyle("-fx-background-color: blue; -fx-border-color: bluerod;");
            		else
            			root.setStyle("-fx-background-color: green; -fx-border-color: greenrod;");
            	}

            	Random rand = new Random();
                int rand1 = rand.nextInt(2);

                // Create a new TextField in each Iteration
                TextField tf = new TextField();
                tf.setPrefHeight(50);
                tf.setPrefWidth(50);
                tf.setAlignment(Pos.CENTER);
                tf.setEditable(false);
                tf.setText("(" + rand1 + ")");

                // Iterate the Index using the loops
                root.setRowIndex(tf,y);
                root.setColumnIndex(tf,x);    
                root.getChildren().add(tf);
            }
        }

        Scene scene = new Scene(root, 500, 500);    
        primaryStage.setTitle("Random Binary Matrix (JavaFX)");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {    
        launch(args);
    }

	@Override
	public void addMot(String mot, int i, int j, String d) {
		// TODO Auto-generated method stub
		
	}    

}