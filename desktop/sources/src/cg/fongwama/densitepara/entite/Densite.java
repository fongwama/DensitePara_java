package cg.fongwama.densitepara.entite;


/**
 * @author CommunautÃ© Fongwama
 * 
 * @version 1.0
 * 
 * @Created 06/07/2015
 * 
 * @Description  Cette classe encapsule les informations nécessaires pour le calcul de
 * la densité parsitaire.
 */

public class Densite
{

	// déclaration des variables

	/**
	 * Représente le nombre de paracite  P
	 */
	private long nombreParasite;


	/**
	 * Représente le nombre de globules blanc GB
	 */
	private long nombreGlobuleBlanc;


	/**
	 * le nombre de globules blancs /µ litre de sang
	 */
	
	private long nombreGloSang;


	/**
	 * ReprÃ©sente la densitÃ©
	 * D ===> densité = parasite * g/µL / globules blancs
	 */
	
	private long densite;
	
	
	/**
	 * échantillon permettant d'indentifier le propriétaire de la densite parasitaire calculée.
	 */
	
	private String echantillon;


	//le constructeur paramÃ©trer

	public Densite(long nombreParasite, long nombreGlobuleBlanc,
			long nombreLeucocite, long densite) {
		super();
		this.nombreParasite = nombreParasite;
		this.nombreGlobuleBlanc = nombreGlobuleBlanc;
		this.nombreGloSang = nombreLeucocite;
		this.densite = densite;
	}


	//le constructeur non paramÃ©trÃ©

	public Densite() {
		super();
		// TODO Auto-generated constructor stub
	}

	// les getters et setters
	
	public long getNombreParasite() {
		return nombreParasite;
	}


	public void setNombreParasite(long nombreParasite) {
		this.nombreParasite = nombreParasite;
	}


	public long getNombreGlobuleBlanc() {
		return nombreGlobuleBlanc;
	}


	public void setNombreGlobuleBlanc(long nombreGlobuleBlanc) {
		this.nombreGlobuleBlanc = nombreGlobuleBlanc;
	}


	public long getNombreGloSang() {
		return nombreGloSang;
	}


	public void setNombreGloSang(long nombreGloSang) {
		this.nombreGloSang = nombreGloSang;
	}


	public long getDensite() {
		return densite;
	}


	public void setDensite(long densite) {
		this.densite = densite;
	}


	public String getEchantillon() {
		return echantillon;
	}


	public void setEchantillon(String echantillon) {
		this.echantillon = echantillon;
	}  
}
