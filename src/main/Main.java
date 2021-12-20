package main;

/**
 * @author Nicolas Copsidas, Leanne Robert, Lazare Ricour-Dumas
 * @version 0.1
 */
public class Main {

	public static void main(String[] args) {
		Boutique maBoutique = new Boutique();
		maBoutique.addClients(ProcessFiles.databaseObjectToClient("dataClient.txt"));
		maBoutique.addArticles(ProcessFiles.databaseObjectToArticles(maBoutique, "dataArticles.txt"));
        maBoutique.addCommandes(ProcessFiles.databaseObjectToCommandes(maBoutique, "dataCommandes.txt"));
        maBoutique.initBoutique();		
	}
	

}
