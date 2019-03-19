import java.util.List;

/**
 * Modélisation de la grille de jeu
 */

/**
 * @author BERNARD Hugo 'Tenebrosful'
 *
 */
public class Grille {
	
	private int tailleX;
	private int tailleY;
	private List<Case> grille;

	/**
	 * Constructeur de Grille.java par défaut
	 */
	public Grille() {
		this.tailleX = 20;
		this.tailleY = 20;
	}

	/**
	 * Constructeur de Grille.java pour 
	 * @param tailleX
	 * @param tailleY
	 * @throws TailleException 
	 */
	public Grille(int tailleX, int tailleY) throws TailleException{
		
		if(tailleX <= 0)
			throw new TailleException("La taille en X ne peut pas être négative (" + tailleX + ")");
		if(tailleY <= 0)
			throw new TailleException("La taille en X ne peut pas être négative (" + tailleX + ")");
		
		this.tailleX = tailleX;
		this.tailleY = tailleY;
		for(int i = 0; i < tailleX; ++i) {
			for(int j = 0; j < tailleY; ++j) {
				grille.add(new Case(i,j));
			}
		}
	}
	
	/**
	 * Teste s'il reste un bateau non coulé dans la grille
	 * @return True s'il reste au moins une case avec un bateau non-coulé
	 */
	public boolean avoirBateauVivant() {
		for(int i = 0; i < grille.size(); ++i){
				if(grille.get(i).isImpact()) {
					return true;
				}
		}
		return false;
	}
	
	/**
	 *
	 * @param posX
	 * @param posY
	 * @return True si la position (x;y) est valide
	 */
	public boolean positionValide(int posX, int posY) {
		return (posX < 0 || posY < 0 || posX >= this.tailleX || posY >= this.tailleY);
	}
	
	/**
	 *
	 * @param posX
	 * @param posY
	 * @return Case correspondante aux coordonnées
	 * @throws CaseInexistanteException 
	 */
	public Case getCase(int posX, int posY) throws CaseInexistanteException {
		if(this.positionValide(posX, posY)) {
			for(int i = 0 ; i < this.grille.size() ; ++i) {
				Case tmp = this.grille.get(i);
				if(tmp.aPourCoordonnee(posX, posY)) {
					return tmp;
				}
			}
		} else {
			throw new CaseInexistanteException("La case (" + posX + ";" + posY + ") n'existe pas");
		}
		return null;
	}

	/**
	 *
	 * @param bateau
	 * @param posX
	 * @param posY
	 * @throws CaseInexistanteException 
	 * @throws CaseOccupeeException 
	 */
	public void setBateauCase(Bateau bateau, int posX, int posY) throws CaseInexistanteException, CaseOccupeeException {
		if(this.positionValide(posX, posY)) {
			Case tmp = this.getCase(posX, posY);
			if(tmp.getBateau() == null) {
				tmp.setBateau(bateau);
				this.grille.set(this.grille.indexOf(tmp), tmp);
			} else {
				throw new CaseOccupeeException("La case (" + tmp.getPosX() + ";" + tmp.getPosY() + ") possède déjà un bateau");
			}
		} else {
			throw new CaseInexistanteException("La case (" + posX + ";" + posY + ") n'existe pas");
		}
	}
}
