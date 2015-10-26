package cg.fongwama.densitepara.ihm;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFileChooser;
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
import cg.fongwama.densitepara.utilitaire.Beeper;
import cg.fongwama.densitepara.utilitaire.EtatsUtil;
import cg.fongwama.densitepara.utilitaire.Horloge;

/**
 * @author Communautï¿½ Fongwama
 * 
 * @version 1.0
 * 
 * @Created 06/07/2015
 * 
 * @Description Cette classe reprï¿½sente la fenï¿½tre principale de
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
	public static Long NBRE_LEUCOCITE;

	private JPanel contentPane;

	public JTextField tfParametre;

	/** Reprï¿½sente la densitï¿½ parasitaire **/
	private Densite densite;

	/** Champ de saisie du nombre de parasite **/
	private JTextField tfNbreParasit;

	private JLabel lbldate;

	//référence sur le thread de la barre de progessio	
	private Thread barreProgression;


	/** Reprï¿½sente le nombre de leucocytes **/
	private EditerNbrLeuco changeNbrLeuco;
	private JTextField tfNbreGb;
	private JTextField affichage;
	private JLabel lblheure;


	// creation des dates
	Date date=new Date();
	Date newdate=new Date();


	//conversion d'une date en format dd/MM/yyyy

	SimpleDateFormat x=new 	SimpleDateFormat("dd/MM/yyyy");
	String d=x.format(newdate);



	Horloge horloge= new Horloge();
	private JTextField txtFieldEchantillon;

	public JMenuItem mntmImpri;

	public JButton btnReinitialiser;

	public JButton btnCalculer;

	public JButton btnEditer;

	public JButton btnQuitter;

	/**
	 * Constructeur de la classe
	 */
	public DensitePara()
	{
		lblheure = horloge.getHeure();

		//arreter le thread qui a demarre la barre de progression
		if(barreProgression != null)
		{
		}


		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent arg0) {


				// On charge la date et l'heure au lancement de  la page
				lbldate.setText(d+"");

			}
		});
		setIconImage(Toolkit.getDefaultToolkit().getImage(DensitePara.class.getResource("/img/logo.png")));

		setResizable(false);
		setTitle("DensitePara");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 362, 671);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);

		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 356, 30);

		//modifier par Beylhond

		JMenu option = new JMenu("Option");

		mntmImpri = new JMenuItem("Exporter en PDF");
		mntmImpri.setFont(new Font("Tahoma", Font.PLAIN, 12));
		mntmImpri.setEnabled(false);
		mntmImpri.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0)
			{
				imprimer();
			}
		});

		option.add(mntmImpri);

		option.setFont(new Font("Tahoma", Font.PLAIN, 12));
		menuBar.add(option);

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

		btnEditer = new JButton("Editer");
		btnEditer.setBounds(253, 318, 82, 27);
		btnEditer.setBackground(Color.WHITE);
		btnEditer.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnEditer.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				/**
				 * Appel de la mï¿½thode qui permet d'ï¿½diter la valeur du nombre
				 * de leucocyte
				 */
				editer();
			}
		});

		tfParametre = new JTextField();
		tfParametre.setBounds(29, 319, 212, 27);
		tfParametre.setFont(new Font("Tahoma", Font.BOLD, 11));
		tfParametre.setToolTipText("Nombre de globules bancs/µL de sang");
		tfParametre.setBackground(Color.WHITE);
		tfParametre.setEditable(false);
		tfParametre.setColumns(10);


		JLabel label_3 = new JLabel("Nombre de parasites");
		label_3.setBounds(29, 118, 266, 26);
		label_3.setFont(new Font("Dialog", Font.PLAIN, 14));

		tfNbreParasit = new JTextField();
		tfNbreParasit.setBounds(28, 147, 307, 27);
		tfNbreParasit.setToolTipText("Entrez le nombre de parasites");
		tfNbreParasit.setBackground(SystemColor.window);
		tfNbreParasit.addKeyListener(new KeyAdapter()
		{
			@Override
			public void keyTyped(KeyEvent e)
			{
				char c = e.getKeyChar();
				// le caractï¿½re est numï¿½rique
				if (c >= '0' && c <= '9')
				{
					// System.out.println(evt);
				} else
				{
					// suppression du caractï¿½re
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
		lblNombreDeGlobules_1.setBounds(29, 282, 266, 37);
		lblNombreDeGlobules_1.setFont(new Font("Tahoma", Font.PLAIN, 14));

		JLabel lblNombreDeGlobules = new JLabel("Nombre de globules blancs");
		lblNombreDeGlobules.setBounds(27, 196, 268, 37);
		lblNombreDeGlobules.setFont(new Font("Tahoma", Font.PLAIN, 14));

		btnReinitialiser = new JButton("R\u00E9initialiser");
		btnReinitialiser.setBounds(183, 384, 120, 27);
		btnReinitialiser.setBackground(Color.WHITE);
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

		btnCalculer = new JButton("Calculer");
		btnCalculer.setBounds(58, 384, 120, 27);
		btnCalculer.setBackground(Color.WHITE);
		btnCalculer.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0)
			{
				try
				{
					/**
					 * Appel de la mï¿½thode de contrï¿½le des champs de saisies
					 */
					controler();

					/**
					 * Appel de la mï¿½thode qui effectue le calcul de la
					 * densitï¿½
					 */

					calculer();

				} catch (Exception e)
				{
					// JOptionPane.show

				}
			}
		});
		btnCalculer.setFont(new Font("Tahoma", Font.BOLD, 12));

		tfNbreGb = new JTextField();
		tfNbreGb.setBounds(28, 230, 307, 27);
		tfNbreGb.setToolTipText("Entrez le nombre de globules blancs");
		tfNbreGb.setBackground(SystemColor.window);
		tfNbreGb.setColumns(10);
		tfNbreGb.addKeyListener(new KeyAdapter()
		{
			@Override
			public void keyTyped(KeyEvent e)
			{
				char c = e.getKeyChar();
				// le caractï¿½re est numï¿½rique
				if (c >= '0' && c <= '9')
				{
					// System.out.println(evt);
				} else
				{
					// suppression du caractï¿½re
					e.consume();
				}

				if (tfNbreGb.getText().length() >= 13)
				{
					e.consume();
				}

			}
		});

		JLabel lblDensitParasitaire_1 = new JLabel("Densit\u00E9 parasitaire");
		lblDensitParasitaire_1.setBounds(75, 454, 168, 21);
		lblDensitParasitaire_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblDensitParasitaire_1.setFont(new Font("Tahoma", Font.BOLD, 16));


		JLabel lblParasiteslDeSang = new JLabel("parasites/\u00B5l de sang");
		lblParasiteslDeSang.setBounds(88, 562, 168, 16);
		lblParasiteslDeSang.setForeground(Color.BLACK);
		lblParasiteslDeSang.setHorizontalAlignment(SwingConstants.CENTER);
		lblParasiteslDeSang.setFont(new Font("Tahoma", Font.BOLD, 12));
		contentPane.setLayout(null);
		contentPane.add(btnCalculer);
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
		contentPane.add(menuBar);

		btnQuitter = new JButton("Quitter");
		btnQuitter.setBackground(Color.WHITE);
		btnQuitter.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnQuitter.setBounds(246, 604, 89, 28);
		btnQuitter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				quitter();
			}
		});
		btnQuitter.setIcon(null);
		contentPane.add(btnQuitter);

		affichage = new JTextField();
		affichage.setBackground(Color.WHITE);
		affichage.setForeground(Color.BLACK);
		affichage.setEditable(false);
		affichage.setFont(new Font("Tahoma", Font.BOLD, 34));
		affichage.setHorizontalAlignment(SwingConstants.CENTER);
		affichage.setBounds(27, 486, 308, 67);
		contentPane.add(affichage);
		affichage.setColumns(10);

		lbldate = new JLabel("");
		lbldate.setBounds(27, 618, 105, 14);
		contentPane.add(lbldate);


		JLabel lblReference = new JLabel("N\u00B0 Reference");
		lblReference.setFont(new Font("Dialog", Font.PLAIN, 14));
		lblReference.setBounds(27, 41, 188, 27);
		contentPane.add(lblReference);

		txtFieldEchantillon = new JTextField();
		txtFieldEchantillon.setToolTipText("Entrer le numero de référence");
		txtFieldEchantillon.setBounds(27, 72, 308, 27);
		contentPane.add(txtFieldEchantillon);
		txtFieldEchantillon.setColumns(10);


		lblheure.setBounds(28, 593, 65, 14);
		contentPane.add(lblheure);




		//lire les donnees du fichier 

		init();

	}

	/**
	 * quitter le programme
	 */

	private void quitter() 
	{
		dispose();
	}

	/**
	 * imprimer le contenu des champs de textes dans un fichier pdf.
	 */

	private void imprimer() 
	{
		//cet objet permet la sauvegarde d'un fichier
		JFileChooser fileChooser = new JFileChooser();
		fileChooser.showSaveDialog(DensitePara.this);

		//prendre le fichier sélectionné
		File file = fileChooser.getSelectedFile();

		//obliger le choix d'un emplacement 
		if(file != null)
		{
			//emplacememnt parent
			File parent = new File("");

			//l'emplacement de l'état
			File etat = new File(parent.getAbsolutePath()+"\\etats\\etat.jrxml");

			//vérifier l'existance du fichier
			if(etat.exists())
			{
				//obtenir un reference de la fenetre principale
				EtatsUtil.fenetre = this;

				//impression directe
				EtatsUtil.imprimer(densite, etat.getAbsolutePath(), file.getAbsolutePath());
			}
			else
			{
				//renvoi du message d'erreur
				Beeper.beeper();

				JOptionPane.showMessageDialog(this,"Le maquette d'impression est introuvable",
						"Erreur d'impression", JOptionPane.ERROR_MESSAGE);
			}
		}
	} 

	/**
	 * bloque && debloquer les options
	 */

	@SuppressWarnings("deprecation")
	public void bloquerDeloquer(boolean positive)
	{
		btnEditer.setEnabled(positive);
		btnReinitialiser.setEnabled(positive);
		btnQuitter.setEnabled(positive);
		btnCalculer.setEnabled(positive);
		mntmImpri.setEnabled(positive);	

		if(positive)
		{
			setCursor(Cursor.DEFAULT_CURSOR);
		}
		else
		{
			setCursor(Cursor.WAIT_CURSOR);
		}
	}

	/**
	 * Cette mï¿½thode permet de vider les champs de saisie
	 */
	private void reinitialiser()
	{
		tfNbreParasit.setText("");
		tfNbreGb.setText("");
		affichage.setText("");
		txtFieldEchantillon.setText("");

		mntmImpri.setEnabled(false);
	}

	/**
	 * Cette mï¿½thode permet d'initialiser les objets
	 */

	protected void init()
	{
		//crï¿½er le fichier pour la 1ï¿½re fois
		AccesFichier.creerFichier();

		// Au chargement de l'IHM, on rï¿½cupï¿½re le nombre de leucocyte dans le
		// fichier
		NBRE_LEUCOCITE = AccesFichier.lireValeur();
		tfParametre.setText(""+NBRE_LEUCOCITE);
	}

	/**
	 * Cette mï¿½thode permet d'effectuer le calcul de la densitï¿½ parasitaire
	 */

	private void calculer()
	{
		densite = new Densite();

		densite.setEchantillon(txtFieldEchantillon.getText());
		densite.setNombreParasite(Long.parseLong(tfNbreParasit.getText()));
		densite.setNombreGlobuleBlanc(Long.parseLong(tfNbreGb.getText()));
		densite.setNombreGloSang(Long.parseLong(tfParametre.getText()));

		densite.setDensite(Metier.calculer(densite));

		affichage.setText(""+densite.getDensite());

		mntmImpri.setEnabled(true);
	}

	/**
	 * Cette mï¿½thode permet d'effectuer l'ï¿½dition du nombre de leucocytes
	 */
	private void editer()
	{
		changeNbrLeuco = new EditerNbrLeuco(this);
		changeNbrLeuco.setLocationRelativeTo(this);
		changeNbrLeuco.setModal(true);
		changeNbrLeuco.setVisible(true);
	}

	/**
	 * Cette mï¿½thode effectue le contrï¿½le de saisie des champs
	 */

	private void controler()
	{

		if(txtFieldEchantillon.getText().isEmpty())
		{
			Beeper.beeper();

			JOptionPane.showMessageDialog(this,
					"Veillez sasir le numero de référence !",
					"Erreur de saisie", JOptionPane.ERROR_MESSAGE);
			tfNbreGb.requestFocus(true);

			return;
		}
		if (tfNbreParasit.getText().isEmpty())
		{
			Beeper.beeper();

			JOptionPane.showMessageDialog(this,
					"Veuillez saisir le nombre de parasites !", "Erreur de saisie",
					JOptionPane.ERROR_MESSAGE);
			tfNbreParasit.requestFocus(true);
			return;
		}

		if (tfNbreGb.getText().isEmpty())
		{
			Beeper.beeper();

			JOptionPane.showMessageDialog(this,
					"Veuillez saisir le nombre de globules blancs !",
					"Erreur de saisie", JOptionPane.ERROR_MESSAGE);
			tfNbreGb.requestFocus(true);

			return;
		} 

		// On declare puis on converti le contenu des valeurs de saisi en
		// entier

		long nbGB = (Long.valueOf(tfNbreParasit.getText()));
		long nbP = (Long.valueOf(tfNbreGb.getText()));

		// On test si la valeur saisi est inferieur ou egal a zero on renvoi
		// le message
		if (nbGB <= 0)
		{
			JOptionPane.showMessageDialog(null,
					"Le nombre de globules blancs doit ï¿½tre supï¿½rieur ï¿½ zï¿½ro");
			return;
		}

		if (nbP <= 0)
		{
			JOptionPane.showMessageDialog(null,
					"Le nombre de parasites doit ï¿½tre supï¿½rieur ï¿½ zï¿½ro");
			return;
		}
	}

	public Thread getBarreProgression() {
		return barreProgression;
	}

	public void setBarreProgression(Thread barreProgression) {
		this.barreProgression = barreProgression;
	}


}
