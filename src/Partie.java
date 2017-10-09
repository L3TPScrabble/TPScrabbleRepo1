import java.awt.GridLayout;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Partie {
	
	private List<Joueur> joueurs;
	private Sac sac;
	private Plateau plateau;
	
	

	public Partie() {
		super();
		this.joueurs = null;
		this.sac = new Sac(null);
		this.plateau = new Plateau();
	}



	public static void main(String[] args) {
		  Plateau plateau = new Plateau();
		    
		    JFrame frame = new JFrame();
		    frame.setContentPane(plateau.getTotal());
		    frame.pack();
		    frame.setVisible(true);
		  }       
	
	

}
