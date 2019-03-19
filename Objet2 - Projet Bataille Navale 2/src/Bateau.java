/**
 * Modélisation des bateaux
 */

/**
 * @author BERNARD Hugo 'Tenebrosful'
 *
 */
public class Bateau {
	
	private int posX;
	private int posY;
	private int longueur;
	private String orientation;
	private String nom;

	/**
	 * Constructeur de Bateau.java pour 
	 * @param longueur
	 * @param nom
	 * @throws LongueurException 
	 */
	public Bateau(int longueur, String nom) throws LongueurException {
		if(longueur < 0)
			throw new LongueurException("La taille d'un bateau ne peut pas être négative (" + longueur + ")");
		
		this.longueur = longueur;
		this.nom = nom;
	}

	/**
	 * Retourne longueur
	 * @return longueur
	 */
	public int getLongueur() {
		return longueur;
	}

	/**
	 * Retourne nom
	 * @return nom
	 */
	public String getNom() {
		return nom;
	}

	/**
	 * Retourne orientation
	 * @return orientation
	 */
	public String getOrientation() {
		return orientation;
	}

	/**
	 * Retourne posX
	 * @return posX
	 */
	public int getPosX() {
		return posX;
	}

	/**
	 * Retourne posY
	 * @return posY
	 */
	public int getPosY() {
		return posY;
	}

	/**
	 * @param orientation Nouvelle valeur de orientation 
	 */
	public void setOrientation(String orientation) {
		this.orientation = orientation;
	}

	/**
	 * @param posX Nouvelle valeur de posX 
	 */
	public void setPosX(int posX) {
		this.posX = posX;
	}

	/**
	 * @param posY Nouvelle valeur de posY 
	 */
	public void setPosY(int posY) {
		this.posY = posY;
	}
}
