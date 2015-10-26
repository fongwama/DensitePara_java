package cg.fongwama.densitepara.ihm;

import javax.swing.JFrame;
import javax.swing.JProgressBar;

public class ThreadProgression extends Thread
{
	/**
	 * Gestionnaire de la barre de progression
	 * 
	 * cette classe demarrare la barre de progression ensuite la page d'acceuil
	 * 
	 */
	
	private JProgressBar progressBar;
	private JFrame frame;//la fenetre qui afficheur le screenShot

	/**
	 * @wbp.parser.entryPoint
	 */
	public ThreadProgression(JProgressBar progressBar, JFrame frame)
	{
		super();
		this.progressBar = progressBar;
		this.frame = frame;
	}

	/**
	 * simuler une progression
	 */

	@Override
	public void run()
	{
		for(int val = 0; val <= 200; val++)
		{
			//changer à chaque itération la valeur de la progressBar
			progressBar.setValue(val);

			try 
			{
 				sleep(10);
			}
			catch (InterruptedException e) 
			{
				e.printStackTrace();
			}

			//femer le flash screen

			if(val == 100)
			{
				frame.dispose();				
 			} 
		}

		//la page d'accueil est lancer dans ce thread pour qu'elle soit executer apres le screenShot
		//dans le cas échant elle se lance simultanement

		DensitePara frame = new DensitePara();
		
		//obtenir une reference du thread
		frame.setBarreProgression(this);
		
 		frame.setLocationRelativeTo(null);

		frame.setVisible(true);
  	}
}
