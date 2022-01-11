package main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

import articles.Accessoire;
import articles.Article;
import articles.PieceDetachee;
import articles.Velo;
import commandes.Client;
import commandes.Commande;
import exceptions.writeFileException;

/**
 * @author Nicolas Copsidas, Leanne Robert, Lazare Ricour-Dumas
 * @version 0.1
 */
public class Boutique {

    ArrayList<Client> clients = new ArrayList<Client>(); 
    ArrayList<Commande> commandes = new ArrayList<Commande>();
    ArrayList<Article> articles = new ArrayList<Article>();
    
    static Scanner input = new Scanner(System.in);

    
    
	/** 
	 * @return ArrayList<Client>
	 */
	public ArrayList<Client> getClients() {
		return clients;
	}

	/**
	 * 
	 * @return the static variable commandes
	 */
	public ArrayList<Commande> getCommandes() {
		return commandes;
	}

	/**
	 * 
	 * @return the static variable articles
	 */
	public ArrayList<Article> getArticles() {
		return articles;
	}
    

	/** initiate the terminal interface with the user
	 * 
	 */
    public void initBoutique() {
		boolean stay = true ;
    	while(stay) {
			System.out.print("\n\nVoici la liste des actions : \n\n"
					+ "Commandes : \n\n"
					+ "[1] Consulter une commande\n"
					+ "[2] Consulter toutes les commandes\n"
					+ "[3] Créer une commande\n"
					+ "[4] Exporter les commandes\n"
					+ "[5] Supprimer une commande\n"
					+ "\n\nClients : \n\n"
					+ "[6] Consulter un client\n"
					+ "[7] Consulter tous les clients\n"
					+ "[8] Créer un client\n"						
					+ "[9] Exporter les clients\n"
					+ "[10] Supprimer un client\n" 
					+ "\n\nArticles : \n\n"
					+ "[11] Consulter un article\n"
					+ "[12] Consulter tous les articles\n"
					+ "[13] Créer un article\n"
					+ "[14] Exporter les articles\n"						
					+ "[15] Supprimer un article\n\n"
					+ "[-1 for quit]\n");
			int action = 0;
			try{
				action = Integer.parseInt(input.nextLine());
			}catch(NumberFormatException e){
				System.out.println("Vous ne pouvez intéragir avec le menu qu'avec des chiffres compris entre 1 et 15");				
			}
			
			switch(action) {
				case 1:
					seeCommande();
					break;
				case 2: 
					seeCommandes();
					break;
				case 3:
					createCommande();
					break;
				case 4:
					exportCommandesCSV();
					break;
				case 5:
					eraseCommande();
					break;
				case 6:
					seeClient();
					break;
				case 7:
					seeClients();
					break;
				case 8:
					createClient();
					break;
				case 9:
					exportClientsCSV();
					break;
				case 10:
					eraseClient();
					break;
				case 11:
					seeArticle();
					break;
				case 12:
					seeArticles();
					break;
				case 13:
					createArticle();
					break;
				case 14:
					exportArticlesCSV();
					break;
				case 15:
					eraseArticle();
					break;
				case -1:
					stay = false;
					break;
			}
    	}
    }

    

	/** create a client from user's input and adds in the 'database'
	 * 
	 */
	public void createClient(){
		String nom = null;
		String prenom = null; 
		String adresse = null;
		while(nom == null || prenom == null || adresse== null) {
			System.out.print("Nom de famille : ");
			nom = input.nextLine();
			System.out.print("Prenom : ");
			prenom = input.nextLine();
			System.out.print("Adresse : ");
			adresse = input.nextLine();
		}
		Client client = new Client(nom, prenom, adresse);
		System.out.print("Le client " + client.toString() + " a bien été ajouté à la base de données\n");
		clients.add(client);
    }

	public void eraseClient(){
		int idToErase = -1 ; 
		String answer = "";
		while ( idToErase == -1 ){
			try{
				System.out.println("Id du client à supprimer : ");
				idToErase = Integer.parseInt(input.nextLine());
				System.out.println("Êtes vous sûr ? [Y/N]");
				answer = input.nextLine();
			}catch(NumberFormatException e){
				idToErase = -1;
			}
		}
		switch(answer){
			case "Y":
				clients.remove(findClientByID(idToErase));
				break;
			case "N":
				break;
		}
	}

	
	public void seeClient() {
    	int idClient = -1;
		while(idClient < 0) {
			System.out.print("Id du client : ");
			try {
				idClient = Integer.parseInt(input.nextLine());
			} catch (NumberFormatException e) {
				idClient = -1;
			}
		}
		System.out.print("Id du client : " + findClientByID(idClient).toString());
	}



	public void seeClients() { 
		if (articles.isEmpty()) {
			System.out.print("Il n'existe pas de clients\n");
		} else {	
			System.out.println("Clients : \n");
			for(Client client : clients) {
				System.out.print(client.toString() + "\n\n");
			}
		}
	}



	public void exportClientsCSV() {
		String csv = "";
		for(Client client : clients) {
			csv += client.toCSV();
		}
    	String filename = null;
		while(filename == null) {
			System.out.println("Comment souhaitez vous appeler le fichier d'export ?");
			filename = input.nextLine();
		}
		try {
			ProcessFiles.writeFile(csv, filename);
		} catch (writeFileException e) {
			e.printStackTrace();
		}
	}
	
	/** create an article from user's input and adds in the 'database'
	 * 
	 */
	public void createArticle(){
		Article article = null;
		int typeArticle = 0;
		while(typeArticle < 1 ||  typeArticle > 3) {
			try{
				System.out.print("Écrivez le numéro associé au type de produit que vous souhaitez créer : un accessoire [1], un velo [2], une piece détachée [3]");
				typeArticle = Integer.parseInt(input.nextLine());
			}catch(NumberFormatException e){
				typeArticle = 0 ;
			}
		}
		float prix = 0;
		int stock = 0; 
		String nom = null;
		String marque = null;
		while(prix == 0 || stock == 0 || nom == null || marque == null) {
			System.out.print("Nom de l'article : ");
			nom = input.nextLine();
			System.out.print("Marque de l'article : ");
			marque = input.nextLine();
			try{
				System.out.print("Prix de l'article : ");
				prix = Float.parseFloat(input.nextLine());
				System.out.print("Stock : ");
				stock = Integer.parseInt(input.nextLine());
			}catch(NumberFormatException e){
				prix = 0 ;
				stock = 0;
			}
		}
		
		switch(typeArticle) {
			case 1: //accessoire
				String cible = null;
				while(cible == null) {
					System.out.print("Entrez la cible : ");
					cible = input.nextLine();
				}
    			article = new Accessoire(prix, stock, nom, marque, cible);
				break;
			case 2: //velo
				String discipline = null;
				while(discipline == null) {
					System.out.print("Entrez la discipline : ");
					discipline = input.nextLine();
				}
    			article = new Velo(prix, stock, nom, marque, discipline);
				break;
			case 3: //piece détachée
    			ArrayList<Article> articlesCompatibles = new ArrayList<Article>();
				String a = null;
				while(a == null) {
					System.out.print("Entrez les ids des articles associés : ");
					a = input.nextLine();
				}
    			String[] idsArticlesCompatibles = a.split(",");
    			for(String idArticleCompatible : idsArticlesCompatibles) {
    				articlesCompatibles.add(findArticleByID(Integer.parseInt(idArticleCompatible)));
    			}
    			article = new PieceDetachee(prix, stock, nom, marque, articlesCompatibles);
				break;
		}
				System.out.print("L'article a bien été ajouté à la base de données :/n " + article.toString());		
				articles.add(article);
    }




	public void seeArticle() {
    	int idArticle = -1;
		while(idArticle < 0) {
			System.out.print("Id de l'article : ");
			try {
				idArticle = Integer.parseInt(input.nextLine());
			} catch (NumberFormatException e) {
				idArticle = -1;
			}
		}
		System.out.print("Id de l'article : " + findArticleByID(idArticle).toString());
	}
	
	public void eraseArticle(){
		int idToErase = -1 ;
		String answer = "";
		while ( idToErase == -1 ){
			try{
				System.out.println("Id de l'article à supprimer : ");
				idToErase = Integer.parseInt(input.nextLine());
				System.out.println("Êtes vous sûr ? [Y/N]");
				answer = input.nextLine();
			}catch(NumberFormatException e){
				idToErase = -1 ; 
			}
		}
		switch(answer){
			case "Y":
				articles.remove(findArticleByID(idToErase));
				break;
			case "N":
				break;
		}
	}

	public void seeArticles() { 
		if (articles.isEmpty()) {
			System.out.print("Il n'existe pas d'articles");
		} else {	
			System.out.println("Articles : \n");
			for(Article article : articles) {
				System.out.print(article.toString() + "\n\n");
			}
		}
	}




	public void exportArticlesCSV() {
		String csv = "";
		for(Article article : articles) {
			csv += article.toCSV();
		}
    	String filename = null;
		while(filename == null) {
			System.out.println("Comment souhaitez vous appeler le fichier d'export ?");
			filename = input.nextLine();
		}
		try {
			ProcessFiles.writeFile(csv, filename);
		} catch (writeFileException e) {
			e.printStackTrace();
		}
	}
	

	/** create a commande from user's input and adds in the 'database'
	 * 
	 */
	public void createCommande(){
		int idClient = -1;
		HashMap<Article, Integer> achats = new HashMap<Article, Integer>(); 
		while(idClient < 0) {
			System.out.print("Insérer le numéro de client associé à la commande");
			try{
				idClient = Integer.parseInt(input.nextLine());
			}catch(NumberFormatException e){
				idClient = -1;
			}
		}
		Client client = findClientByID(idClient);
		int etatInsertion = 1;
		int idProduit = -1;
		int quantite = -1;
		while(etatInsertion == 1 || ( idProduit == -1 && quantite == -1 )) {
			try{
				System.out.print("Insérer l'id du produit");
				idProduit = Integer.parseInt(input.nextLine());
				System.out.print("Insérer la quantité du produit");
				quantite = Integer.parseInt(input.nextLine());
				achats.put(findArticleByID(idProduit), quantite);
				System.out.print("Écrivez 1 pour ajouter un autre produit, et 2 pour passer à l'étape suivante");
				etatInsertion = Integer.parseInt(input.nextLine());
			}catch(NumberFormatException e){
				etatInsertion = 1;
			}catch (Exception e) {
				System.out.print("Le produit est déjà présent dans la commande");
			}
		}
		Commande commande = new Commande(client, achats);
		System.out.print("La commande " + commande.toString() + " a bien été ajouté à la base de données\n");
		if(commande.isStockAvailable()) {
			commandes.add(commande);
		} else {
			System.out.print("Stock insuffisant pour enregistrer la commande");
		}
    }




	public void seeCommande() {
    	int idCommande = -1;
		while(idCommande < 0) {
			System.out.print("Id de la commande : ");
			try {
				idCommande = Integer.parseInt(input.nextLine());
			} catch (NumberFormatException e) {
				idCommande = -1;
			}
		}
		System.out.print("Commande : " + findCommandeByID(idCommande).toString());
	}
	
	public void eraseCommande(){
		int idToErase = -1 ;
		String answer = "";
		while ( idToErase == -1 ){
			try{
				System.out.println("Id de la commande à supprimer : ");
				idToErase = Integer.parseInt(input.nextLine());
				System.out.println("Êtes vous sûr ? [Y/N]");
				answer = input.nextLine();
			}catch(NumberFormatException e){
				idToErase = -1 ; 
			}
		}
		switch(answer){
			case "Y":
				commandes.remove(findCommandeByID(idToErase));
				break;
			case "N":
				break;
		}
	}

	public void seeCommandes() {
		for(Commande commande : commandes) {
			System.out.print(commande.toString() + "\n");
		}
	}


	public void exportCommandesCSV() {
		String csv = "";
		for(Commande commande : commandes) {
			csv += commande.toCSV();
		}
    	String filename = null;
		while(filename == null) {
			System.out.println("Comment souhaitez vous appeler le fichier d'export ?");
			filename = input.nextLine();
		}
		try {
			ProcessFiles.writeFile(csv, filename);
		} catch (writeFileException e) {
			System.out.println("Erreur lors de l'export, veuillez réessayer.");
		}
	}


	
	
	/**
	 * 
	 * @param client
	 */
    public void addClient(Client client){
    	this.clients.add(client);
    }
	
	
	/** 
	 * @param clients
	 */
	public void addClients(ArrayList<Client> clients) {
		this.clients.addAll(clients);
	}

    
	/** 
	 * @param commande
	 */
	public void addCommande(Commande commande){
    	this.commandes.add(commande);
    }
	
	
	/** 
	 * @param commandes
	 */
	public void addCommandes(ArrayList<Commande> commandes) {
		this.commandes.addAll(commandes);
	}

    
	/** 
	 * @param article
	 */
	public void addArticle(Article article){
    	this.articles.add(article);
    }
	
	
	/** 
	 * @param articles
	 */
	public void addArticles(ArrayList<Article> articles) {
		this.articles.addAll(articles);
	}
	        
    
	/** 
	 * @param id
	 * @return Article
	 */
	public Article findArticleByID(int id){
    	for(Article article : articles) {
    		if(article.getId() == id) {
    			return article;
    		}
    	}
		return null;
    }
    
    
	/** 
	 * @param id
	 * @return Client
	 */
	public Client findClientByID(int id){
    	for(Client client : clients) {
    		if(client.getId() == id) {
    			return client;
    		}
    	}
		return null;
    }
    
	
	/** 
	 * @param id
	 * @return Commande
	 */
	public Commande findCommandeByID(int id){
    	for(Commande commande : commandes) {
    		if(commande.getId() == id) {
    			return commande;
    		}
    	}
		return null;
    }

        
}
