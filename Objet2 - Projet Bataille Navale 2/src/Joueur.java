import java.util.List;

/**
 * 
 */

/**
 * @author BERNARD Hugo 'Tenebrosful'
 *
 */
public class Joueur {
	
	private String nomJoueur;
	private Grille grille;
	private List<Bateau> listeBateau;

	/**
	 * Constructeur de Joueur.java pour 
	 * @param nomJoueur 
	 * @param grille 
	 * @param listeBateau 
	 */
	public Joueur(String nomJoueur, Grille grille, List<Bateau> listeBateau) {
		this.nomJoueur = nomJoueur;
		this.grille = grille;
		this.listeBateau = listeBateau;
	}
	
	/**
	 *
	 * @param orientation 
	 * @param bateau
	 * @param posX 
	 * @param posY 
	 * @throws PositionException 
	 * @throws CaseOccupeeException 
	 * @throws OrientationException 
	 * @throws CaseInexistanteException 
	 */
	public void placerBateau(Bateau bateau, int posX, int posY, String orientation) throws PositionException, CaseOccupeeException, OrientationException, CaseInexistanteException{
		switch(orientation){
		case "Droite" :
			for(int i = posX; i < posX + bateau.getLongueur(); ++i) {
				Case tmp = this.grille.getCase(posX, posY);
				if(this.grille.getCase(posX, posY).getBateau() != null) {
					throw new CaseOccupeeException("La case (" + tmp.getPosX() + ";" + tmp.getPosY() + ") est occupée");
				}
			}
			for(int i = posX; i < posX + bateau.getLongueur(); ++i) {
				this.grille.setBateauCase(bateau, posX, posY);
			}
			
			break;
		case "Gauche" :
			break;
		case "Haut" :
			break;
		case "Bas" :
			break;
		default :
			throw new OrientationException(orientation + " n'est pas une orientation valide");
		}
	}
	
	/**
	 *
	 * @param ennemi
	 * @param posX
	 * @param posY
	 * @return True si le tir a pu être effectué
	 * @throws PositionException 
	 * @throws CaseInexistanteException 
	 */
	public boolean tirer(Joueur ennemi, int posX, int posY) throws PositionException, CaseInexistanteException {
		if(!ennemi.grille.positionValide(posX, posY)) {
			throw new PositionException("La position (" + posX + ";" + posY + ") est invalide"); 
		}
		if(!ennemi.grille.getCase(posX, posY).isImpact()) {
			ennemi.grille.getCase(posX, posY).setImpact(true);
			return true;
		}
		return false;		
	}

	/**
	 * Retourne nomJoueur
	 * @return nomJoueur
	 */
	public String getNomJoueur() {
		return nomJoueur;
	}

	/**
	 * Retourne grille
	 * @return grille
	 */
	public Grille getGrille() {
		return grille;
	}

	/**
	 * Retourne listeBateau
	 * @return listeBateau
	 */
	public List<Bateau> getListeBateau() {
		return listeBateau;
	}
}
