package cg.fongwama.densitepara.ihm;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import cg.fongwama.densitepara.dao.AccesFichier;

/**
 * @author Communauté Fongwama
 * 
 * @version 1.0
 * 
 * @Created 06/07/2015
 * 
 * @Description FenÃªtre d'édition du nombre de leucocytes
 */





public class EditerNbrLeuco extends JDialog
{

	/**
	 * Class version
	 */
	private static final long serialVersionUID = 1L;

	private final JPanel contentPanel = new JPanel();
	private JTextField tfNbreLeuco;
	private JSeparator separator;
	private JLabel lblNombreDeGlobules;
	private JButton btnValider;
	private JButton btnAnnuler;

	/**
	 * Create the dialog.
	 */
	public EditerNbrLeuco(final DensitePara densitePara)
	{
		setIconImage(Toolkit.getDefaultToolkit().getImage(
				EditerNbrLeuco.class.getResource("/img/logo.png")));
		setResizable(false);
		setTitle("Edition du param\u00E8tre");
		setBounds(100, 100, 307, 200);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(Color.WHITE);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);

		separator = new JSeparator();
		separator.setBounds(0, 142, 301, 2);

		lblNombreDeGlobules = new JLabel(
				"Nombre de globules blancs/\u00B5l de sang");
		lblNombreDeGlobules.setBounds(34, 16, 242, 28);
		lblNombreDeGlobules.setFont(new Font("Tahoma", Font.PLAIN, 14));

		tfNbreLeuco = new JTextField();
		tfNbreLeuco.setToolTipText("Entrez la nouvelle valeur du nombre de globules blancs/\u00B5l de sang");
		tfNbreLeuco.setBounds(34, 48, 198, 27);
		tfNbreLeuco.setColumns(10);

		btnValider = new JButton("Valider");
		btnValider.setBackground(Color.WHITE);
		btnValider.setBounds(34, 97, 94, 27);
		btnValider.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{

				try
				{
					/**
					 * Appel de la méthode de contréle des champs de saisies
					 */
					if(controle())
					{
						/**
						 * Appel de la méthode valider()
						 */
						
						valider(densitePara);
					}

				} catch (Exception ex)
				{
					// TODO Auto-generated catch block

				}

			}
		});
		btnValider.setFont(new Font("Tahoma", Font.BOLD, 12));

		btnAnnuler = new JButton("Annuler");
		btnAnnuler.setBackground(Color.WHITE);
		btnAnnuler.setBounds(138, 97, 94, 27);

		btnAnnuler.setFont(new Font("Tahoma", Font.BOLD, 12));

		btnAnnuler.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				dispose();
			}
		});
		contentPanel.setLayout(null);
		contentPanel.add(btnValider);
		contentPanel.add(btnAnnuler);
		contentPanel.add(lblNombreDeGlobules);
		contentPanel.add(tfNbreLeuco);
		contentPanel.add(separator);

		tfNbreLeuco.addKeyListener(new KeyAdapter()
		{
			// @Override
			public void keyTyped(KeyEvent e)
			{
				char c = e.getKeyChar();
				// le caractère est numérique
				if (c >= '0' && c <= '9')
				{
					// System.out.println(evt);
				} else
				{
					// suppression du caractère
					e.consume();
				}

				if (tfNbreLeuco.getText().length() >= 14)
				{
					e.consume();
				}

			}
		});
	}

	/**
	 * Cette methode effectue le controle de saisie des champs
	 */
	private boolean controle()
	{
		if(tfNbreLeuco.getText().isEmpty())
		{
			JOptionPane.showMessageDialog(this,"Veuillez saisir le nombre de globules blancs/µl de sang!","Erreur saisie", JOptionPane.ERROR_MESSAGE);
			tfNbreLeuco.requestFocus(true);
			
			//emettre le bip sonore
			Toolkit.getDefaultToolkit().beep();
			return false;
		}
		
		int Nlc=Integer.valueOf(tfNbreLeuco.getText());
		
		if(Nlc <= 0)
		{
			//emettre le bip sonore
			Toolkit.getDefaultToolkit().beep();
			JOptionPane.showMessageDialog(this, "Le nombre de leucocytes doit être supérieur à zéro", "DensitePara", JOptionPane.ERROR_MESSAGE);
			return false;
		}
		else
			return true;
	}

	/**
	 * Cette methode permet de changer le nombres de leucocite stocker dans le
	 * fichier
	 */
	private void valider(DensitePara densitePara)
	{
		AccesFichier.sauvegarderValeur(Integer.parseInt(tfNbreLeuco.getText()));
		DensitePara.NBRE_LEUCOCITE = AccesFichier.lireValeur();
		
		densitePara.tfParametre.setText(""+DensitePara.NBRE_LEUCOCITE);
		
		dispose();
	}
}
