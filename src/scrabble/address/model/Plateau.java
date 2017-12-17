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
		for(int i=0; i<=14 ; i++)
			for(int j=0; j<=14; j++)
				if(matrice[i][j].estVide())
					return false;			
		return true;
	}
	
	
	//Calcul du score à partir des coordonnées de la première lettre (i1,j1) et de la derniere lettre (i2,j2)
	public int score(int i1, int j1, int i2, int j2){
		int total = 0;
		boolean motDouble = false;
		boolean motTriple = false;
		//mot de haut en bas
		if(i1 == i2){ 
			for(int j = j1; j<=j2; j++){
				if(matrice[i1][j].isPink()){
					motDouble = true;
					total = total + matrice[i1][j].getContenu().getPoints() ;
				}
				if(matrice[i1][j].isRed()){
					motTriple = true;
					total = total + matrice[i1][j].getContenu().getPoints();
				}
				if(matrice[i1][j].isBlue())
					total = total + matrice[i1][j].getContenu().getPoints() * 3;
				if(matrice[i1][j].isCyan())
					total = total + matrice[i1][j].getContenu().getPoints() * 2;
			}
		}
		else if(j1 == j2){
			for(int i = i1; i<=i2; i++){
				if(matrice[i][j1].isPink()){
					motDouble = true;
					total = total + matrice[i][j1].getContenu().getPoints() ;
				}
				if(matrice[i][j1].isRed()){
					motTriple = true;
					total = total + matrice[i][j1].getContenu().getPoints();
				}
				if(matrice[i][j1].isBlue())
					total = total + matrice[i][j1].getContenu().getPoints() * 3;
				if(matrice[i][j1].isCyan())
					total = total + matrice[i][j1].getContenu().getPoints() * 2;
			}
		}
		if(motDouble)
			total = total * 2;
		if(motTriple)
			total = total * 3;
		return total;
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
	
	public Case getCase(int i , int j ){
		return this.matrice[i][j];
	}
	public Case[][] getMatrice() {
		return matrice;
	}

	public void setMatrice(Case[][] matrice) {
		this.matrice = matrice;
	}

	public int getTaille() {
		return taille;
	}

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
/*	public void plateauRemp(char[][] tableau){
		for(int i=0;i<15;i++){
			for(int j=0;j<15;j++){
				Case C1 = new Case();
				Piece P1 = new Piece(tableau[i][j]);
				C1.setContenu(P1);
				this.matrice[i][j] = C1;
			}
		}
	}*/

	public void setCase(Case C , int i , int j){
		this.matrice[i][j] = C;
	}

	@Override
	public void addMot(String mot, int i, int j, String d) {
		// TODO Auto-generated method stub
		
	}



}