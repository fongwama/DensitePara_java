package cg.fongwama.densitepara.dao;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author Communauté Fongwama
 * 
 * @version 1.0
 * 
 * @Created 06/07/2015
 * 
 * @Description  Cette classe permet de lire ou modifier la valeur du nombre de leucocytes stockée dans le fichier NombreLeucocyte.txt
 * 	sachant que la valeur par défaut est 8000.
 */
public class AccesFichier
{

	/**
	 * cr�er le fichier pour la premi�re utilisation de l'application
	 */
	public static void creerFichier()
	{
		try 
		{
			//fichier represent la racine du projet
			File parent=new File("");

			//fichier contenant nombreLeucocyte.txt
			File fils=new File(parent.getAbsolutePath()+"/NombreLeucocyte.txt");

			//Test de non-existence du fichier, si le fichier n'existe pas on le crée et on sauvegarde le nombre
			if(fils.exists() == false)
			{
				// Cr�ation du fichier
				fils.createNewFile();

				// Objet de type FileWriter
				FileWriter f=new FileWriter(fils);

				// Objet de type printwriter
				PrintWriter pw=new PrintWriter(f);
				
				// Ecriture dans le fichier
				pw.print(8000);

				// Fermeture de l'objet printwriter
				pw.close();
			}
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		} 
	}

	/**
	 * Cette methode permet de sauvegarder le nombre de leucocyte dans le fichier
	 * @param nombre
	 */
	public static void sauvegarderValeur(int nombre)
	{

		try 
		{
			//Création du fichier parent, qui permettra de récuperer le chemin absolu du projet
			File parent=new File("");

			//Création du fichier NombreLeucocyte.txt
			File fils=new File(parent.getAbsolutePath()+"/NombreLeucocyte.txt");

			// Objet de type FileWriter
			FileWriter f=new FileWriter(fils);

			// Objet de type printwriter
			PrintWriter pw=new PrintWriter(f);

			//Test de non-existence du fichier, si le fichier n'existe pas on le crée et on sauvegarde le nombre
			if(!fils.exists()){

				// Création du fichier
				fils.createNewFile();

				// Ecriture dans le fichier
				pw.print(nombre);

				// Fermeture de l'objet printwriter
				pw.close();

			}else{
				// Ecriture dans le fichier
				pw.print(nombre);
				// Fermeture de l'objet printwriter
				pw.close();

			}

		} catch (IOException e) {
			e.printStackTrace();
		}

	}


	/**
	 * Cette methode lire le nombre sauvegarde dans un fichier
	 * @return
	 */
	public static int lireValeur()
	{  
		//déclaration des variables
		int valeur=0;

		// Ligne récupérée lors de la lecture du fichier
		String ligne = "";


		try
		{
			//création du fichier parent, qui permettra de récuperer le chemin absolu du projet
			File parent=new File("");


			//création du fichier fils basee sur le parent
			File fils=new File(parent.getAbsolutePath()+"/NombreLeucocyte.txt");

			//création d'un flux de lecture pour le lire fichier fils
			BufferedReader fichier=new BufferedReader(new FileReader(fils));

			//déclaration d'une variable  
			int i = 0;

			//boucle pour lire le fichier
			while((i = fichier.read()) != -1)
			{
				// Lecture caractère par caractère puis concaténation et affectation dans la variable ligne
				ligne +=(char)i;
			}

			//fermeture du fichier
			fichier.close();
		}
		catch (Exception ex)
		{
			// En cas d'erreur, génération d'une exception
			ex.printStackTrace();
		}

		//si la ligne est different de null on converti le contenu de la variable ligne en entier
		if(ligne!=null)
		{	
			valeur=Integer.valueOf(ligne);
		} 

		//On retourne la valeur lue
		return valeur;
	}


}
