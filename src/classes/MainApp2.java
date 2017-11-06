package classes;
import java.io.IOException;
import java.net.URL;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.application.Application;

public  final class MainApp2 extends Application {

	  @Override
	  public void start(final Stage primaryStage) {
	    try {
	      // Localisation du fichier FXML.
	      final URL url = getClass().getResource("test.fxml");
	      // Cr�ation du loader.
	      final FXMLLoader fxmlLoader = new FXMLLoader(url);
	      // Chargement du FXML.
	      final AnchorPane root = (AnchorPane) fxmlLoader.load();
	      // Cr�ation de la sc�ne.
	      final Scene scene = new Scene(root, 300, 250);
	      primaryStage.setScene(scene);
	    } catch (IOException ex) {
	      System.err.println("Erreur au chargement: " + ex);
	    }
	    primaryStage.setTitle("Test FXML");
	    primaryStage.show();
	  }

	  public static void main(String[] args) {
	    launch(args);
	  }
	}