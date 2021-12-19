import java.util.ArrayList;
import java.util.Scanner;

import articles.Accessoire;
import articles.Article;
import articles.PieceDetachee;
import articles.Velo;
import commandes.Achat;
import commandes.Client;
import commandes.Commande;

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
    

	/** iniate the terminal interface with the user
	 * 
	 */
    public void initBoutique() {
    	while(true) {
	    	int action = 0;
			while(action < 1 || action > 6) {
				System.out.print("Voici la liste des actions :\n"
						+ "1. Consulter une commande\n"
						+ "2. Créer une commande\n"
						+ "3. Consulter un client\n"
						+ "4. Créer un client\n"
						+ "5. Consulter un article\n"
						+ "6. Créer un article\n");
				action = Integer.parseInt(input.nextLine());
			}
			switch(action) {
				case 1:
					
					break;
				case 2:
					createCommande();
					break;
				case 3:
					
					break;
				case 4:
					createClient();
					break;
				case 5:
					break;
				case 6:
					createArticle();
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
		System.out.print("Le client " + client.getPrenom() + " " + client.getNom() + " a bien été ajouté à la base de données\n");
		clients.add(client);
    }
	

	/** create an article from user's input and adds in the 'database'
	 * 
	 */
	public void createArticle(){
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
			System.out.print("Nom de l'article : ");
			nom = input.nextLine();
			System.out.print("Marque de l'article : ");
			marque = input.nextLine();
			System.out.print("Prix de l'article : ");
			prix = Float.parseFloat(input.nextLine());
			System.out.print("Stock : ");
			stock = Integer.parseInt(input.nextLine());
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
		articles.add(article);
    }


	/** create a commande from user's input and adds in the 'database'
	 * 
	 */
	public void createCommande(){
		int idClient = -1;
		ArrayList<Achat> achats = new ArrayList<Achat>(); 
		while(idClient < 0) {
			System.out.print("Insérer le numéro de client associé à la commande");
			idClient = Integer.parseInt(input.nextLine());
		}
		Client client = findClientByID(idClient);
		int etatInsertion = 1;
		while(etatInsertion == 1) {
			System.out.print("Insérer l'id du produit");
			int idProduit = Integer.parseInt(input.nextLine());
			int quantite = Integer.parseInt(input.nextLine());
			achats.add(new Achat(quantite, findArticleByID(idProduit)));
			System.out.print("Écrivez 1 pour ajouter un autre produit, et 2 pour passer à l'étape suivante");
			etatInsertion = Integer.parseInt(input.nextLine());

		}
		commandes.add(new Commande(client, achats));
    }

	/**
	 * 
	 * @param client
	 */
    public void addClient(Client client){
    	clients.add(client);
    }
	
	
	/** 
	 * @param clients
	 */
	public void addClients(ArrayList<Client> clients) {
		clients.addAll(clients);
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
	public void addCommandes(ArrayList<Commande> commandes) {
		commandes.addAll(commandes);
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
	public void addArticles(ArrayList<Article> articles) {
		articles.addAll(articles);
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
        
}
