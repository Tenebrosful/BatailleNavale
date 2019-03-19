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
	 * Constructeur de Joueur.java pour un nom, une grille et une liste de Bateau donnés
	 * @param nomJoueur Nom du joueur
	 * @param grille Grille de jeu appartenant au joueur
	 * @param listeBateau Liste des bateaux de la partie appartenant au joueur
	 * @throws ListeBateauVideException 
	 */
	public Joueur(String nomJoueur, Grille grille, List<Bateau> listeBateau) throws ListeBateauVideException {
		if(listeBateau.isEmpty())
			throw new ListeBateauVideException("La liste de bateau placée en paramètre est vide");
		
		if(nomJoueur == null || nomJoueur.equals("")) {
			this.nomJoueur = ("JeanMarcDu" + (int) Math.rint(Math.random()*99));
		} else {
			this.nomJoueur = nomJoueur;
		}
		
		this.grille = grille;
		this.listeBateau = listeBateau;
	}
	
	/**
	 * Permet de placer un bateau d'un joueur à une coordonnée donnée avec une orientation donnée
	 * @param orientation Orientation du bateau ("Droite","Gauche","Haut","Bas")
	 * @param bateau Bateau à placer
	 * @param posX Future position du bateau en X
	 * @param posY Future position du bateau en Y
	 * @throws CaseInexistanteException Dans le cas où il n'existe pas de case aux coordonnées entrées
	 * @throws CaseOccupeeException Dans le cas où il exisite déjà un bateau dans la zone d'insertion
	 * @throws OrientationException Dans le cas où l'orientation du bateau est érronée
	 */
	public void placerBateau(Bateau bateau, int posX, int posY, String orientation) throws CaseInexistanteException, CaseOccupeeException, OrientationException{
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
			for(int i = posX; i < posX - bateau.getLongueur(); --i) {
				Case tmp = this.grille.getCase(posX, posY);
				if(this.grille.getCase(posX, posY).getBateau() != null) {
					throw new CaseOccupeeException("La case (" + tmp.getPosX() + ";" + tmp.getPosY() + ") est occupée");
				}
			}
			for(int i = posX; i < posX - bateau.getLongueur(); --i) {
				this.grille.setBateauCase(bateau, posX, posY);
			}
			break;
			
		case "Haut" :
			for(int i = posY; i < posX + bateau.getLongueur(); ++i) {
				Case tmp = this.grille.getCase(posX, posY);
				if(this.grille.getCase(posX, posY).getBateau() != null) {
					throw new CaseOccupeeException("La case (" + tmp.getPosX() + ";" + tmp.getPosY() + ") est occupée");
				}
			}
			for(int i = posY; i < posX + bateau.getLongueur(); ++i) {
				this.grille.setBateauCase(bateau, posX, posY);
			}
			break;
			
		case "Bas" :
			for(int i = posY; i < posX - bateau.getLongueur(); --i) {
				Case tmp = this.grille.getCase(posX, posY);
				if(this.grille.getCase(posX, posY).getBateau() != null) {
					throw new CaseOccupeeException("La case (" + tmp.getPosX() + ";" + tmp.getPosY() + ") est occupée");
				}
			}
			for(int i = posY; i < posX - bateau.getLongueur(); --i) {
				this.grille.setBateauCase(bateau, posX, posY);
			}
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
