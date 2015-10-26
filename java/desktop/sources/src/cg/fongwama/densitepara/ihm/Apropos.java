package cg.fongwama.densitepara.ihm;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JEditorPane;
import javax.swing.JLabel;
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

public class Apropos extends JDialog {

	/**
	 * Version de la classe
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * Déclaration d'un jpanel
	 */
	private final JPanel contentPanel = new JPanel();

	
	
	/**
	 *  Création d'une boite de dialog.
	 */
	public Apropos()
	{
		setIconImage(Toolkit.getDefaultToolkit().getImage(Apropos.class.getResource("/img/logo.png")));
		setResizable(false);
		setTitle("A Propos de DensitePara");
		setBounds(100, 100, 350, 599);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(Color.WHITE);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 0, 344, 569);
		contentPanel.add(panel);
		panel.setLayout(null);
		
		JEditorPane dtrpnDedfeffefeeefdfeedf = new JEditorPane();
		dtrpnDedfeffefeeefdfeedf.setFont(new Font("Tahoma", Font.PLAIN, 12));
		dtrpnDedfeffefeeefdfeedf.setText("DensitePara : logiciel libre et multi-plateformed'aide au calcul de la densit\u00E9 \r\nparasitaire. \r\n\r\nDensitePara v 1.0");
		dtrpnDedfeffefeeefdfeedf.setAutoscrolls(false);
		dtrpnDedfeffefeeefdfeedf.setEditable(false);
		dtrpnDedfeffefeeefdfeedf.setBounds(114, 27, 219, 81);
		panel.add(dtrpnDedfeffefeeefdfeedf);
		
		JLabel label_DensitePara = new JLabel("");
		label_DensitePara.setForeground(Color.LIGHT_GRAY);
		label_DensitePara.setIcon(new ImageIcon(Apropos.class.getResource("/img/logo.png")));
		
		label_DensitePara.setBounds(0, 11, 104, 110);
		panel.add(label_DensitePara);
		
		JEditorPane dtrpnCeProgrammeLibre = new JEditorPane();
		dtrpnCeProgrammeLibre.setAlignmentY(Component.BOTTOM_ALIGNMENT);
		dtrpnCeProgrammeLibre.setAlignmentX(Component.RIGHT_ALIGNMENT);
		dtrpnCeProgrammeLibre.setFont(new Font("Tahoma", Font.PLAIN, 12));
		dtrpnCeProgrammeLibre.setText("D\u00E9velopp\u00E9 par la communaut\u00E9 Fongwama. \r\nPrince YOULOU, Delphin BONDONGO, Aristide NDIELE,   Tr\u00E9sor NGASSAKI, Borel BADILA, Yann BANVI, Steve      NDENDE.");
		dtrpnCeProgrammeLibre.setEditable(false);
		dtrpnCeProgrammeLibre.setBounds(10, 193, 323, 69);
		panel.add(dtrpnCeProgrammeLibre);
		
		JLabel label_fongwama = new JLabel("");
		label_fongwama.setIcon(new ImageIcon(Apropos.class.getResource("/img/fongwa.jpg")));
		label_fongwama.setForeground(Color.LIGHT_GRAY);
		label_fongwama.setBounds(87, 119, 155, 63);
		panel.add(label_fongwama);
		
		JLabel label_FCM = new JLabel("");
		label_FCM.setIcon(new ImageIcon(Apropos.class.getResource("/img/fcrm.JPG")));
		label_FCM.setForeground(Color.LIGHT_GRAY);
		label_FCM.setBounds(114, 298, 104, 100);
		panel.add(label_FCM);
		
		JLabel label_SKEPSOS = new JLabel("");
		label_SKEPSOS.setIcon(new ImageIcon(Apropos.class.getResource("/img/ecair.JPG")));
		label_SKEPSOS.setForeground(Color.LIGHT_GRAY);
		label_SKEPSOS.setBounds(10, 303, 104, 69);
		panel.add(label_SKEPSOS);
		
		JLabel lblNewLabel = new JLabel("Part\u00E9naires");
		lblNewLabel.setBounds(20, 273, 84, 14);
		panel.add(lblNewLabel);
		
		JEditorPane dtrpnLicenceGplThe = new JEditorPane();
		dtrpnLicenceGplThe.setBounds(10, 409, 323, 147);
		panel.add(dtrpnLicenceGplThe);
		dtrpnLicenceGplThe.setText("Licence : GPL \r\n\r\nThe GNU General Public License (GPL)\r\nVersion 2, June 1991 \r\nCopyright (C) 1989, 1991 Free Software Foundation, Inc.\r\n59 Temple Place, Suite 330, Boston, MA 02111-1307 \r\nUSA Everyone is permitted to copy and distribute \r\nverbatim copies of this license document, but changing it is not allowed.");
		dtrpnLicenceGplThe.setFont(new Font("Tahoma", Font.PLAIN, 12));
		dtrpnLicenceGplThe.setEditable(false);
		dtrpnLicenceGplThe.setAlignmentY(1.0f);
		dtrpnLicenceGplThe.setAlignmentX(1.0f);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(Apropos.class.getResource("/img/skepsos.JPG")));
		label.setForeground(Color.LIGHT_GRAY);
		label.setBounds(228, 303, 114, 63);
		panel.add(label);
		
		
		
		
		
		

	}
}
