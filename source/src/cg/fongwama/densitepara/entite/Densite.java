package cg.fongwama.densitepara.entite;


/**
 * @author Communauté Fongwama
 * 
 * @version 1.0
 * 
 * @Created 06/07/2015
 * 
 * @Description  Cette classe encapsule les informations nécessaires pour le calcul de
 * la densité parsitaire.
 */

public class Densite {

	// déclaration des variables

	/**
	 * Représente le nombre de paracite  P
	 */
	private int nombreParasite;


	/**
	 * Représente le nombre de globules blanc GB
	 */
	private int nombreGlobuleBlanc;


	/**
	 * Représente le nombre de leucocyte L
	 */
	private int nombreLeucocite;


	/**
	 * Représente la densité
	 * D ===> D=P*L/GB
	 */
	private int densite;



	//le constructeur paramétrer

	public Densite(int nombreParasite, int nombreGlobuleBlanc,
			int nombreLeucocite, int densite) {
		super();
		this.nombreParasite = nombreParasite;
		this.nombreGlobuleBlanc = nombreGlobuleBlanc;
		this.nombreLeucocite = nombreLeucocite;
		this.densite = densite;
	}


	//le constructeur non paramétré

	public Densite() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
	// les getters et setters

	public int getNombreParasite() {
		return nombreParasite;
	}

	public void setNombreParasite(int nombreParasite) {
		this.nombreParasite = nombreParasite;
	}

	public int getNombreGlobuleBlanc() {
		return nombreGlobuleBlanc;
	}

	public void setNombreGlobuleBlanc(int nombreGlobuleBlanc) {
		this.nombreGlobuleBlanc = nombreGlobuleBlanc;
	}

	public int getNombreLeucocite() {
		return nombreLeucocite;
	}

	public void setNombreLeucocite(int nombreLeucocite) {
		this.nombreLeucocite = nombreLeucocite;
	}

	public int getDensite() {
		return densite;
	}

	public void setDensite(int densite) {
		this.densite = densite;
	}

	// La méthode toString()
	@Override
	public String toString() {
		return "Densite [nombreParasite=" + nombreParasite
				+ ", nombreGlobuleBlanc=" + nombreGlobuleBlanc
				+ ", nombreLeucocite=" + nombreLeucocite + ", densite="
				+ densite + "]";
	}



}
