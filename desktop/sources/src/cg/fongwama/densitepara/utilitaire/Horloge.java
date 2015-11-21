package cg.fongwama.densitepara.utilitaire;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;

import javax.swing.JLabel;
import javax.swing.Timer;

/**
 * 
 * @author Beylhond/Fongwama
 * @version 1.1
 *
 */

/**
 * cette classe répresentre une horloge
 * 
 * le mécanisme qui la gère est un timer
 * 
 */	

public class Horloge implements ActionListener
{
	private JLabel heure;//afficheur du temps

	public Horloge() 
	{
		//création d'un timer qui s'actualise dans une intervalle d'une seconde (1000 = 1s)
		Timer t = new Timer(1000, this);
		t.start();

		//afficher l'heure initiale	avec un formatage correcte	
		heure = new JLabel(String.format("%tT", Calendar.getInstance()));
	}

	//la méthode qui permet de faire un traitement à chaque séconde

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		//mise à jour du temps avec un formatage correcte
		heure.setText(String.format("%tT", Calendar.getInstance()));
	}

	//getters et setters

	public JLabel getHeure() 
	{
		return heure;
	}

	public void setHeure(JLabel heure) 
	{
		this.heure = heure;
	} 
}
