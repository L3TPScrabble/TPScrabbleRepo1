package interfaces;

public interface SacInterface {
	
	public void retirerPieces(int nombre);
	public void newSac();
	public int getPiecesRestantes();
	public void setPiecesRestantes(int piecesRestantes);
	public boolean isSacVide();
	public void setSacVide(boolean sacVide);

}