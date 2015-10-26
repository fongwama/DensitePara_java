package cg.fongwama.densitepara.metier;

import cg.fongwama.densitepara.entite.Densite;


/**
 * @author Communauté Fongwama
 * 
 * @version 1.0
 * 
 * @Created 06/07/2015
 * 
 * @Description Cette classe implémente la logique métier de l'application
 */

public class Metier  {
	
	/**
	 * Méthode permettant de calculer la densité parasitaire. Elle prend en paramètre un objet densité
	 * @param densite
	 * @return
	 */
	public static long  calculer(Densite densite) {
		
		/** Retourne la densité**/
		 return (long)Math.round((float)(densite.getNombreParasite()*densite.getNombreGloSang())/densite.getNombreGlobuleBlanc());
	}

}
