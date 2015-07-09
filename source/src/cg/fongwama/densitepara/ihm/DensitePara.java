package cg.fongwama.densitepara.ihm;

import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import cg.fongwama.densitepara.dao.AccesFichier;
import cg.fongwama.densitepara.entite.Densite;
import cg.fongwama.densitepara.metier.Metier;

/**
 * @author Communauté Fongwama
 * 
 * @version 1.0
 * 
 * @Created 06/07/2015
 * 
 * @Description Cette classe représente la fenètre principale de
 *              l'application.
 */

public class DensitePara extends JFrame
{

	/**
	 * Version de la classe
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Permet de renvoyer le nombre de leucocytes C'est une variable de classe
	 */
	public static int NBRE_LEUCOCITE;

	private JPanel contentPane;

	public JTextField tfParametre;
	private JLabel lblDensitParasitaire;

	/** Représente la densité parasitaire **/
	private Densite densite;

	/** Champ de saisie du nombre de parasite **/
	private JTextField tfNbreParasit;

	/** Représente le nombre de leucocytes **/
	private EditerNbrLeuco changeNbrLeuco;
	private JTextField tfNbreGb;

	/**
	 * Constructeur de la classe
	 */
	public DensitePara()
	{
		setIconImage(Toolkit.getDefaultToolkit().getImage(DensitePara.class.getResource("/img/logo.png")));

		setResizable(false);
		setTitle("DensitePara");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 553, 422);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);

		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 547, 30);

		JMenu mnAPropos = new JMenu("Aide");
		mnAPropos.setFont(new Font("Tahoma", Font.PLAIN, 12));
		menuBar.add(mnAPropos);

		JMenuItem mntmAPropos = new JMenuItem("A propos");
		mntmAPropos.setFont(new Font("Tahoma", Font.PLAIN, 12));
		mntmAPropos.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
			}
		});
		mntmAPropos.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{

				// Lance IHM Apropos
				Apropos apropos = new Apropos();
				apropos.setLocationRelativeTo(null);
				apropos.setModal(true);
				apropos.setVisible(true);
			}
		});

		JMenuItem mntmGuide = new JMenuItem("Guide");
		mntmGuide.setFont(new Font("Tahoma", Font.PLAIN, 12));
		mntmGuide.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				Guide guide=new Guide();
				guide.setLocationRelativeTo(null);
				guide.setModal(true);
				guide.setVisible(true);
			}
		});
		mnAPropos.add(mntmGuide);

		JSeparator separator_1 = new JSeparator();
		mnAPropos.add(separator_1);
		mnAPropos.add(mntmAPropos);

		JButton btnEditer = new JButton("Editer");
		btnEditer.setBackground(Color.WHITE);
		btnEditer.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnEditer.setBounds(165, 246, 70, 27);
		btnEditer.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				/**
				 * Appel de la méthode qui permet d'éditer la valeur du nombre
				 * de leucocyte
				 */
				editer();
			}
		});

		tfParametre = new JTextField();
		tfParametre.setFont(new Font("Tahoma", Font.BOLD, 11));
		tfParametre.setToolTipText("Entrez le nombre de Leucocytes");
		tfParametre.setBackground(SystemColor.controlHighlight);
		tfParametre.setBounds(24, 247, 131, 27);
		tfParametre.setEditable(false);
		tfParametre.setColumns(10);


		JLabel label_3 = new JLabel("Nombre de parasites");
		label_3.setBounds(24, 46, 131, 26);
		label_3.setFont(new Font("Dialog", Font.PLAIN, 14));

		tfNbreParasit = new JTextField();
		tfNbreParasit.setToolTipText("Entrez le nombre de parasites");
		tfNbreParasit.setBackground(SystemColor.window);
		tfNbreParasit.setBounds(23, 75, 212, 27);
		tfNbreParasit.addKeyListener(new KeyAdapter()
		{
			@Override
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

				if (tfNbreParasit.getText().length() >= 13)
				{
					e.consume();
				}

			}
		});

		tfNbreParasit.setColumns(10);

		JLabel lblNombreDeGlobules_1 = new JLabel(
				"Nombre de globules blancs/\u00B5l de sang");
		lblNombreDeGlobules_1.setBounds(24, 210, 238, 37);
		lblNombreDeGlobules_1.setFont(new Font("Tahoma", Font.PLAIN, 14));

		JLabel lblNombreDeGlobules = new JLabel("Nombre de globules blancs");
		lblNombreDeGlobules.setBounds(22, 124, 212, 37);
		lblNombreDeGlobules.setFont(new Font("Tahoma", Font.PLAIN, 14));

		JButton btnReinitialiser = new JButton("R\u00E9initialiser");
		btnReinitialiser.setBackground(Color.WHITE);
		btnReinitialiser.setBounds(191, 314, 150, 27);
		btnReinitialiser.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0)
			{

				/**
				 * On vide les champs du formulaire
				 */
				reinitialiser();
			}
		});
		btnReinitialiser.setFont(new Font("Tahoma", Font.BOLD, 12));

		JButton btnClaculer = new JButton("Calculer");
		btnClaculer.setBackground(Color.WHITE);
		btnClaculer.setBounds(23, 314, 150, 27);
		btnClaculer.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0)
			{
				try
				{
					/**
					 * Appel de la méthode de contrôle des champs de saisies
					 */
					controle();

					/**
					 * Appel de la méthode qui effectue le calcul de la
					 * densité
					 */
					calculer();

				} catch (Exception e)
				{
					// JOptionPane.show

				}
			}
		});
		btnClaculer.setFont(new Font("Tahoma", Font.BOLD, 12));

		tfNbreGb = new JTextField();
		tfNbreGb.setToolTipText("Entrez le nombre de globules blancs");
		tfNbreGb.setBackground(SystemColor.window);
		tfNbreGb.setBounds(23, 158, 212, 27);
		tfNbreGb.setColumns(10);
		tfNbreGb.addKeyListener(new KeyAdapter()
		{
			@Override
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

				if (tfNbreGb.getText().length() >= 13)
				{
					e.consume();
				}

			}
		});

		JLabel lblDensitParasitaire_1 = new JLabel("Densit\u00E9 parasitaire");
		lblDensitParasitaire_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblDensitParasitaire_1.setBounds(356, 87, 168, 21);
		lblDensitParasitaire_1.setFont(new Font("Tahoma", Font.BOLD, 16));

		lblDensitParasitaire = new JLabel("");
		lblDensitParasitaire.setBounds(357, 111, 168, 68);
		lblDensitParasitaire.setHorizontalAlignment(SwingConstants.CENTER);
		lblDensitParasitaire.setFont(new Font("Tahoma", Font.BOLD, 40));

		JLabel lblParasiteslDeSang = new JLabel("parasites/\u00B5l de sang");
		lblParasiteslDeSang.setForeground(Color.RED);
		lblParasiteslDeSang.setHorizontalAlignment(SwingConstants.CENTER);
		lblParasiteslDeSang.setBounds(356, 178, 168, 16);
		lblParasiteslDeSang.setFont(new Font("Tahoma", Font.BOLD, 12));
		contentPane.setLayout(null);
		contentPane.add(btnClaculer);
		contentPane.add(btnReinitialiser);
		contentPane.add(lblNombreDeGlobules);
		contentPane.add(label_3);
		contentPane.add(tfNbreGb);
		contentPane.add(tfNbreParasit);
		contentPane.add(lblNombreDeGlobules_1);
		contentPane.add(tfParametre);
		contentPane.add(btnEditer);
		contentPane.add(lblDensitParasitaire_1);
		contentPane.add(lblParasiteslDeSang);
		contentPane.add(lblDensitParasitaire);
		contentPane.add(menuBar);

		JSeparator separator = new JSeparator();
		separator.setBounds(-3, 364, 549, 2);
		contentPane.add(separator);

		//lire les données du fichier 

		init();

	}

	/**
	 * Cette méthode permet de vider les champs de saisie
	 */
	private void reinitialiser()
	{
		tfNbreParasit.setText("");
		tfNbreGb.setText("");
		lblDensitParasitaire.setText("");
	}

	/**
	 * Cette méthode permet d'initialiser les objets
	 */

	protected void init()
	{
		//créer le fichier pour la 1ère fois
		AccesFichier.creerFichier();

		// Au chargement de l'IHM, on récupère le nombre de leucocyte dans le
		// fichier
		NBRE_LEUCOCITE = AccesFichier.lireValeur();
		tfParametre.setText(""+NBRE_LEUCOCITE);
	}

	/**
	 * Cette méthode permet d'effectuer le calcul de la densité parasitaire
	 */

	private void calculer()
	{
		densite = new Densite();

		densite.setNombreParasite(Integer.parseInt(tfNbreParasit.getText()));
		densite.setNombreGlobuleBlanc(Integer.parseInt(tfNbreGb.getText()));
		densite.setNombreLeucocite(Integer.parseInt(tfParametre.getText()));

		lblDensitParasitaire.setText(String.valueOf(Metier.calculer(densite)));
	}

	/**
	 * Cette méthode permet d'effectuer l'édition du nombre de leucocytes
	 */
	private void editer()
	{

		int rep = JOptionPane.showConfirmDialog(this,
				"Voulez-vous éditer ce nombre ?", " Edition ",
				JOptionPane.YES_NO_OPTION);

		if (rep == JOptionPane.YES_OPTION)
		{
			changeNbrLeuco = new EditerNbrLeuco(this);
			changeNbrLeuco.setLocationRelativeTo(this);
			changeNbrLeuco.setModal(true);
			changeNbrLeuco.setVisible(true);
		}

	}

	/**
	 * Cette méthode effectue le contrôle de saisie des champs
	 */
	private void controle()
	{

		if (tfNbreParasit.getText().isEmpty())
		{

			JOptionPane.showMessageDialog(this,
					"Veuillez saisir le nombre de parasites !", "Erreur saisie",
					JOptionPane.ERROR_MESSAGE);
			tfNbreParasit.requestFocus(true);
			return;
		}

		if (tfNbreGb.getText().isEmpty())
		{
			JOptionPane.showMessageDialog(this,
					"Veuillez saisir le nombre de globules blancs !",
					"Erreur saisie", JOptionPane.ERROR_MESSAGE);
			tfNbreGb.requestFocus(true);
			return;
		}

		// On declare puis converti le contenu des valeurs de saisi en
		// entier

		int nbGB = (Integer.valueOf(tfNbreParasit.getText()));
		int nbP = (Integer.valueOf(tfNbreGb.getText()));

		// On test si la valeur saisi est inferieur ou egal a zero on renvoi
		// le message
		if (nbGB <= 0)
		{
			JOptionPane.showMessageDialog(null,
					"Le nombre de globules blancs doit être supérieur à zéro");
			return;
		}

		if (nbP <= 0)
		{
			JOptionPane.showMessageDialog(null,
					"Le nombre de parasites doit être supérieur à zéro");
			return;
		}
	}
}
