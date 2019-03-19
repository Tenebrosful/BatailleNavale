/**
 * Case 
 */

/**
 * @author BERNARD Hugo 'Tenebrosful'
 *
 */
public class Case {
	
	private int posX;
	private int posY;
	private Bateau bateau;
	private boolean impact;
	/**
	 * Constructeur de Case.java pour 
	 * @param posX
	 * @param posY
	 */
	public Case(int posX, int posY) {
		this.posX = posX;
		this.posY = posY;
	}
	/**
	 * Retourne bateau
	 * @return bateau
	 */
	public Bateau getBateau() {
		return bateau;
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
	 * @param bateau Nouvelle valeur de bateau 
	 */
	public void setBateau(Bateau bateau) {
		this.bateau = bateau;
	}
	/**
	 * Retourne impact
	 * @return impact
	 */
	public boolean isImpact() {
		return impact;
	}
	/**
	 * @param impact Nouvelle valeur de impact 
	 */
	public void setImpact(boolean impact) {
		this.impact = impact;
	}
	

}
