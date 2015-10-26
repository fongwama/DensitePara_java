package cg.fongwama.densitepara.ihm;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JDialog;
import javax.swing.JEditorPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


/**
 * @author Communauté Fongwama
 * 
 * @version 1.0
 * 
 * @Created 06/07/2015
 * 
 * @Description  Fenètre de description de l'application
 */
public class Guide extends JDialog
{

	/**
	 * Version de la classe
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * Déclaration d'un jpanel
	 */
	private final JPanel contentPanel = new JPanel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args)
	{
		try
		{
			Guide dialog = new Guide();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Guide()
	{
		setTitle("Aide - DensitePara");
		setIconImage(Toolkit.getDefaultToolkit().getImage(Guide.class.getResource("/img/logo.png")));
		setBounds(100, 100, 581, 351);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(Color.WHITE);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JEditorPane dtrpnCeDocumentEst = new JEditorPane();
		dtrpnCeDocumentEst.setFont(new Font("Tahoma", Font.PLAIN, 12));
		dtrpnCeDocumentEst.setText("Ce document est r\u00E9dig\u00E9 dans le but de faciliter le calcul de la desnit\u00E9 parasitaire d'un individu. \r\n\r\nAper\u00E7u\r\nDensitePara est une application qui permet de calculer la densit\u00E9 parasitaire d\u2019un individu.\r\nPour arriver au r\u00E9sultat, l\u2019utilisateur doit fournir au programme un nombre de param\u00E8tres.\r\nCe calcul s\u2019effectue en deux \u00E9tapes.\r\n\r\nEtape 1 : rentrer le nombre de parasites et de globules blancs.\r\nEtape 2 : lancer le calcul en cliquant sur le bouton \u00AB Calculer \u00BB et observer le \u00AB R\u00E9sultat \u00BB \r\nsur le c\u00F4t\u00E9 droit de l\u2019\u00E9cran\r\n\r\nSavoir plus :\r\nIl faut noter qu\u2019il est possible de modifier le nombre de leucocyte par microlitre de sang en\r\ncliquant sur le bouton \u00AB Editer \u00BB.");
		dtrpnCeDocumentEst.setBounds(21, 56, 537, 246);
		contentPanel.add(dtrpnCeDocumentEst);
	}
}
