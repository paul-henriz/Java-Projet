package notesElevesProfesseurs;

/**
 * Classe définissant une date (jour, mois et année)
 **/
public class Date {
	/**
	 * Entier représentant le jour
	 */
	private int jour;

	/**
	 * Entier représentant le mois
	 */
	private int mois;

	/**
	 * Entier représentant l'année
	 */
	private int année;

	/**
	 * Constructeur à 3 paramètres
	 * 
	 * @param jour  Le jour au format numérique (1-31)
	 * @param mois  Le mois au format numérique (1-12)
	 * @param année L'année au format numérique
	 */
	public Date(int jour, int mois, int année) {
		super();
		this.jour = jour;
		this.mois = mois;
		this.année = année;
	}

	/**
	 * Retourne le jour
	 * 
	 * @return entier (1-31) représentant le jour
	 */
	public int getJour() {
		return jour;
	}

	/**
	 * Définit le jour
	 * 
	 * @param jour Entier (1-31) pour le jour à définir
	 */
	public void setJour(int jour) {
		this.jour = jour;
	}

	/**
	 * Retourne le mois
	 * 
	 * @return entier (1-12) représentant le mois
	 */
	public int getMois() {
		return mois;
	}

	/**
	 * Définit le mois
	 * 
	 * @param mois Entier (1-12) pour le mois à définir
	 */
	public void setMois(int mois) {
		this.mois = mois;
	}

	/**
	 * Retourne l'année
	 * 
	 * @return entier représentant l'année
	 */
	public int getAnnée() {
		return année;
	}

	/**
	 * Définit l'année
	 * 
	 * @param année Entier pour l'année à définir
	 */
	public void setAnnée(int année) {
		this.année = année;
	}

}
