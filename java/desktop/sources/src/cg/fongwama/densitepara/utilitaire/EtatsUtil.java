package cg.fongwama.densitepara.utilitaire;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import cg.fongwama.densitepara.ihm.DensitePara;

public class EtatsUtil
{
	static Logger log = Logger.getLogger(EtatsUtil.class.getName());
	public static DensitePara fenetre;

	/**
	 * imprimer ,en pdf, un objet java à partir d'une maquette construite au préalable
	 * 
	 * @param object
	 * @param fichier
	 * @param liste
	 * @param emplacement
	 * @throws Exception
	 */

	public static void imprimer(Object object, String fichier, String emplacement)
	{
		/**
		 * faire patienter l'utilisateur pendant l'impression
		 */
		
		fenetre.bloquerDeloquer(false); 
		
		List<Object> restant = new ArrayList<Object>(); //liste contenant l'entité restante

		restant.add(object);

		if(restant.isEmpty())
		{
			String msg = "Aucune donnée n'a été trouvée";
			log.warning(msg);
		}
		else
		{
			//déclaration de la maquette
			JasperDesign jasDesi;

			try
			{
				//chargement de la maquette (fichier jrxml) en mémpoire
				jasDesi = JRXmlLoader.load(fichier);

				//compilation de ce fichier
				JasperReport jasReport = JasperCompileManager.compileReport(jasDesi);

				//création d'une source de données
				JRDataSource source = new JRBeanCollectionDataSource(restant);

				//chargement des données dans le rapport
				JasperPrint jasPritn = JasperFillManager.fillReport(jasReport, null, source);

				//exportation dans un emplacement de choix en format pdf
				JasperExportManager.exportReportToPdfFile(jasPritn,emplacement+".pdf");

				//reactivation des options

				fenetre.bloquerDeloquer(true); 

			} catch (JRException e)
			{
				log.warning(e.getMessage());
			}
		}
	}
}
