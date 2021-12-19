import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import articles.Accessoire;
import articles.Article;
import articles.PieceDetachee;
import articles.Velo;
import commandes.Achat;
import commandes.Client;
import commandes.Commande;

public class ProcessFiles {
		
    static ArrayList<String[]> readDatabaseFile(String filePath){
        ArrayList<String[]> databaseObject = new ArrayList<String[]>();
        try{
            Scanner s = new Scanner(new File(filePath)) ;
            while (s.hasNextLine()){
                String[] itemData = s.nextLine().split(";");
                databaseObject.add(itemData);
            }
        }catch(NullPointerException e){
            e.printStackTrace();
        }catch(FileNotFoundException e){
            e.printStackTrace();
        }
        return databaseObject; 
    }

    static ArrayList<Velo> databaseObjectToVelo(String filePath){
        ArrayList<String[]> databaseObject = readDatabaseFile(filePath);
        ArrayList<Velo> velos = new ArrayList<Velo>(); 
        for (String[] data : databaseObject){
            Velo velo = new Velo(Integer.parseInt(data[0]), Integer.parseInt(data[1]), data[2], data[3], data[4]);
            velos.add(velo);
        }
        return velos ;
    }

    static ArrayList<Client> databaseObjectToClient(String filePath){
        ArrayList<String[]> databaseObject = readDatabaseFile(filePath);
        ArrayList<Client> clients = new ArrayList<Client>(); 
        for (String[] data : databaseObject){
            Client client = new Client(data[0], data[1], data[2]);
            clients.add(client);
        }
        return clients ;
    }
    
    static ArrayList<Article> databaseObjectToArticles(Boutique boutique, String filePath){
        ArrayList<String[]> databaseObject = readDatabaseFile(filePath);
        ArrayList<Article> articles = new ArrayList<Article>(); 
        for (String[] data : databaseObject){
        	Article article = null;
        	switch(data[0].toLowerCase()) {
        		case "accesoire":
        			article = new Accessoire(Float.parseFloat(data[1]), Integer.parseInt(data[2]), data[3], data[4], data[5]);
        			break;
        		case "velo":
        			article = new Velo(Float.parseFloat(data[1]), Integer.parseInt(data[2]), data[3], data[4], data[5]);
        			break;
        		case "piecedetachee":
        			ArrayList<Article> articlesCompatibles = new ArrayList<Article>();
        			String[] idsArticlesCompatibles = data[5].split(",");
        			for(String idArticleCompatible : idsArticlesCompatibles) {
        				articlesCompatibles.add(boutique.findArticleByID(Integer.parseInt(idArticleCompatible)));
        			}
        			article = new PieceDetachee(Float.parseFloat(data[1]), Integer.parseInt(data[2]), data[3], data[4], articlesCompatibles);
        			break;
        	}
            articles.add(article);
        }
        return articles ;
    }
    
    static ArrayList<Commande> databaseObjectToCommandes(Boutique boutique, String filePath){
        ArrayList<String[]> databaseObject = readDatabaseFile(filePath);
        ArrayList<Commande> commandes = new ArrayList<Commande>(); 
        for (String[] data : databaseObject){
    		int idClient = Integer.parseInt(data[0]);	
        	Client client = boutique.findClientByID(idClient);
        	ArrayList<Achat> achats = new ArrayList<Achat>();
        	String[] achatsString = data[1].split(",");
        	for (String achatString : achatsString) {
        		int idProduit = Integer.parseInt(achatString.split(":")[0]);
        		int quantite = Integer.parseInt(achatString.split(":")[1]);
        		achats.add(new Achat(quantite, boutique.findArticleByID(idProduit)));
        	}
        	
        	Date date;
        	Commande commande;
			try {
				date = new SimpleDateFormat("dd/MM/yyyy").parse(data[2]);
	            commande = new Commande(client, achats, date);
			} catch (ParseException e) {
	            commande = new Commande(client, achats);
			}        	
            commandes.add(commande);
        }
        return commandes ;
    }
    
}
