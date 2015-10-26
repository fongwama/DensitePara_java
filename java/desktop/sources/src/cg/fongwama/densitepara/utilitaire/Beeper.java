package cg.fongwama.densitepara.utilitaire;

import java.awt.Toolkit;


public class Beeper
{
	/**
	 * produire un beep d'avertissement
	 */
	
	public static void beeper() 
	{
		Toolkit.getDefaultToolkit().beep();
	}
}
