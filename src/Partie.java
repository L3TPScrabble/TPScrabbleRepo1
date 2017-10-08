import java.util.List;

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
		
	
	}

}
