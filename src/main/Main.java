package main;

import exceptions.readFileException;

/**
 * @author Nicolas Copsidas, Leanne Robert, Lazare Ricour-Dumas
 * @version 0.1
 */
public class Main {

	public static void main(String[] args) {
		Boutique maBoutique = new Boutique();
		try {
			maBoutique.addClients(ProcessFiles.databaseObjectToClient("dataClient.txt"));
			maBoutique.addArticles(ProcessFiles.databaseObjectToArticles(maBoutique, "dataArticles.txt"));
			maBoutique.addCommandes(ProcessFiles.databaseObjectToCommandes(maBoutique, "dataCommandes.txt"));
		} catch (readFileException e) {
			e.printStackTrace();
		}
        maBoutique.initBoutique();		
	}
	

}
