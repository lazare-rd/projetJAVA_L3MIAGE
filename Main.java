import articles.Accessoire;
import articles.Article;
import articles.PieceDetachee;
import articles.Velo;
import commandes.Client;
import commandes.Commande;

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
