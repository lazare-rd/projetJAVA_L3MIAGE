import java.util.ArrayList;
import java.util.Scanner;

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
public class Boutique {

    static ArrayList<Client> clients = new ArrayList<Client>(); 
    static ArrayList<Commande> commandes = new ArrayList<Commande>();
    static ArrayList<Article> articles = new ArrayList<Article>();
    
    static Scanner input = new Scanner(System.in);

	/**
	 * 
	 * @return the static variable commandes
	 */
    public static ArrayList<Client> getClients() {
		return clients;
	}

	/**
	 * 
	 * @return the static variable commandes
	 */
	public static ArrayList<Commande> getCommandes() {
		return commandes;
	}

	/**
	 * 
	 * @return the static variable articles
	 */
	public static ArrayList<Article> getArticles() {
		return articles;
	}
    
	/**
	 * 
	 * @return a new client with the prompted caracteristics
	 */
	public Client createClient(){
		String nom = null;
		String prenom = null; 
		String adresse = null;
		while(nom == null || prenom == null || adresse== null) {
			System.out.print("Nom de famille");
			nom = input.nextLine();
			System.out.print("Prenom");
			prenom = input.nextLine();
			System.out.print("Adresse");
			adresse = input.nextLine();
		}
		return new Client(nom, prenom, adresse);
    }
	
	/**
	 * 
	 * @return a new article with the prompted caracteristics
	 */
	public Article createArticle(){
		Article article = null;
		int typeArticle = 0;
		while(typeArticle < 1 ||  typeArticle > 3) {
			System.out.print("Écrivez le numéro associé au type de produit que vous souhaitez créer : un accessoire [1], un velo [2], une piece détachée [3]");
			typeArticle = Integer.parseInt(input.nextLine());
		}
		float prix = 0;
		int stock = 0; 
		String nom = null;
		String marque = null;
		while(prix == 0 || stock == 0 || nom == null || marque == null) {
			System.out.print("Nom de l'article");
			nom = input.nextLine();
			System.out.print("Marque de l'article");
			marque = input.nextLine();
			System.out.print("Prix de l'article");
			prix = Float.parseFloat(input.nextLine());
			System.out.print("Stock");
			stock = Integer.parseInt(input.nextLine());
		}
		
		switch(typeArticle) {
			case 1: //accessoire
				String cible = null;
				while(cible == null) {
					System.out.print("Entrez la cible");
					cible = input.nextLine();
				}
    			article = new Accessoire(prix, stock, nom, marque, cible);
				break;
			case 2: //velo
				String discipline = null;
				while(discipline == null) {
					System.out.print("Entrez la discipline");
					discipline = input.nextLine();
				}
    			article = new Velo(prix, stock, nom, marque, discipline);
				break;
			case 3: //piece détachée
    			ArrayList<Article> articlesCompatibles = new ArrayList<Article>();
				String a = null;
				while(a == null) {
					System.out.print("Entrez les ids des articles associés");
					a = input.nextLine();
				}
    			String[] idsArticlesCompatibles = a.split(",");
    			for(String idArticleCompatible : idsArticlesCompatibles) {
    				articlesCompatibles.add(Boutique.findArticleByID(Integer.parseInt(idArticleCompatible)));
    			}
    			article = new PieceDetachee(prix, stock, nom, marque, articlesCompatibles);
				break;
			
		}
		
		return article;
    }

	/** 
	 * 
	 * @param client
	 */
	public void createClient(Client client){
		String nom = null;
		String prenom = null; 
		String adresse = null;
		while(nom == null || prenom == null || adresse== null) {
			System.out.print("Nom de famille");
			nom = input.nextLine();
			System.out.print("Prenom");
			prenom = input.nextLine();
			System.out.print("Adresse");
			adresse = input.nextLine();
		}
    }

	/**
	 * 
	 * @param client
	 */
    public void addClient(Client client){
    	clients.add(client);
    }
	
	/**
	 * 
	 * @param clients
	 */
	public static void addClients(ArrayList<Client> clients) {
		Boutique.clients.addAll(clients);
	}

    
	/** 
	 * @param commande
	 */
	public void addCommande(Commande commande){
    	commandes.add(commande);
    }
	
	
	/** 
	 * @param commandes
	 */
	public static void addCommandes(ArrayList<Commande> commandes) {
		Boutique.commandes.addAll(commandes);
	}

    
	/** 
	 * @param article
	 */
	public void addArticle(Article article){
    	articles.add(article);
    }
	
	
	/** 
	 * @param articles
	 */
	public static void addArticles(ArrayList<Article> articles) {
		Boutique.articles.addAll(articles);
	}
	        
    
	/** 
	 * @param id
	 * @return Article
	 */
	public static Article findArticleByID(int id){
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
	public static Client findClientByID(int id){
    	for(Client client : clients) {
    		if(client.getId() == id) {
    			return client;
    		}
    	}
		return null;
    }
    
    
    
    

}
