package cg.fongwama.densitepara.ihm;

import javax.swing.JFrame;
import javax.swing.JProgressBar;

public class Demarrer extends Thread
{
	private JProgressBar progressBar;
	public int signal = 0;
	private JFrame frame;

	public Demarrer(JProgressBar progressBar, JFrame frame)
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

		//page d'accueil

		DensitePara frame = new DensitePara();
		frame.setLocationRelativeTo(null);

		frame.setVisible(true);
	}
}
