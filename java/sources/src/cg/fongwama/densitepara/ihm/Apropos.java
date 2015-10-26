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
		setBounds(100, 100, 528, 448);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(Color.WHITE);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 0, 522, 409);
		contentPanel.add(panel);
		panel.setLayout(null);
		
		JEditorPane dtrpnDedfeffefeeefdfeedf = new JEditorPane();
		dtrpnDedfeffefeeefdfeedf.setFont(new Font("Tahoma", Font.PLAIN, 12));
		dtrpnDedfeffefeeefdfeedf.setText("DensitePara : logiciel libre et multi-plateforme d'aide au calcul \r\nde la densit\u00E9 parasitaire. \r\nVersion: 1.0.\r\n\r\nMerci \u00E0\u00A0 Pierre Poulain, F\u00E9lix Koukouikila-Koussounda pour \r\nleurs remarques et suggestions.");
		dtrpnDedfeffefeeefdfeedf.setAutoscrolls(false);
		dtrpnDedfeffefeeefdfeedf.setEditable(false);
		dtrpnDedfeffefeeefdfeedf.setBounds(141, 37, 371, 110);
		panel.add(dtrpnDedfeffefeeefdfeedf);
		
		JLabel label = new JLabel("");
		label.setForeground(Color.LIGHT_GRAY);
		label.setIcon(new ImageIcon(Apropos.class.getResource("/img/logo.png")));
		
		label.setBounds(27, 37, 132, 123);
		panel.add(label);
		
		JEditorPane dtrpnCeProgrammeLibre = new JEditorPane();
		dtrpnCeProgrammeLibre.setAlignmentY(Component.BOTTOM_ALIGNMENT);
		dtrpnCeProgrammeLibre.setAlignmentX(Component.RIGHT_ALIGNMENT);
		dtrpnCeProgrammeLibre.setFont(new Font("Tahoma", Font.PLAIN, 12));
		dtrpnCeProgrammeLibre.setText("Ce programme libre est distribu\u00E9 selon les termes de la licence GPL (voir ci-dessous).\r\n\r\nDensitePara est d\u00E9velopp\u00E9 \u00E0\u00A0 partir de l'environnement de d\u00E9veloppement libre et \r\nmulti-plateforme Eclipse.\r\n\r\nDensitePara est d\u00E9velopp\u00E9 par la communaut\u00E9 Fongwama. \r\nCr\u00E9dit\u00A0: Prince YOULOU, Delphin BONDONGO, Aristide NDIELE, Tr\u00E9sor NGASSAKI, \r\nBorel BADILA, Yann BANVI, Steve NDENDE.\r\n\r\nThe GNU General Public License (GPL)\r\nVersion 2, June 1991 \r\nCopyright (C) 1989, 1991 Free Software Foundation, Inc.\r\n59 Temple Place, Suite 330, Boston, MA 02111-1307 USA\r\nEveryone is permitted to copy and distribute verbatim copies\r\nof this license document, but changing it is not allowed.");
		dtrpnCeProgrammeLibre.setEditable(false);
		dtrpnCeProgrammeLibre.setBounds(27, 160, 476, 241);
		panel.add(dtrpnCeProgrammeLibre);

	}
}
