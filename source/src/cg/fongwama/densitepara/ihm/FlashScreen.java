package cg.fongwama.densitepara.ihm;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.border.EmptyBorder;

public class FlashScreen extends JFrame
{
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FlashScreen frame = new FlashScreen();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public FlashScreen()
	{
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 398, 226);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JProgressBar progressBar = new JProgressBar();
		progressBar.setBounds(0, 212, 398, 14);
		contentPane.add(progressBar);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(FlashScreen.class.getResource("/img/welcome.JPG")));
		label.setBounds(0, 0, 398, 226);
		contentPane.add(label);
		setLocationRelativeTo(null);
		
		//rendre une fenetre comme un panel simple
		setUndecorated(true);
		
		//progression
		
		progressBar.setMinimum(0);
		progressBar.setMaximum(100);
		progressBar.setForeground(new Color(231, 48, 42));
		
		Demarrer demarrer = new Demarrer(progressBar, this);
		demarrer.start();
	}
}
