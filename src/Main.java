package src ; 

import src.articles.Accessoire;
import src.articles.Article;
import src.articles.PieceDetachee;
import src.articles.Velo;
import src.commandes.Achat;
import src.commandes.Client;
import src.commandes.Commande;

/**
 * @author Nicolas Copsidas, Leanne Robert, Lazare Ricour-Dumas
 * @version 0.1
 */
public class Main {

	public static void main(String[] args) {
		Boutique maBoutique = new Boutique();
		maBoutique.addClients(ProcessFiles.databaseObjectToClient("dataClient.txt"));
        maBoutique.addCommandes(ProcessFiles.databaseObjectToCommandes(maBoutique, "dataCommandes.txt"));
        maBoutique.initBoutique();		
	}
	

}
