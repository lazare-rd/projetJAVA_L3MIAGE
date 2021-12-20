package main;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Scanner;
import java.text.ParseException;
import java.text.SimpleDateFormat;

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
public class ProcessFiles {
		
    
    /** 
     * @param filePath
     * @return ArrayList<String[]>
     */
    public static ArrayList<String[]> readDatabaseFile(String filePath){
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
    
    /** 
     * @param filePath
     * @return ArrayList<Client>
     */
    static ArrayList<Client> databaseObjectToClient(String filePath){
        ArrayList<String[]> databaseObject = readDatabaseFile(filePath);
        ArrayList<Client> clients = new ArrayList<Client>(); 
        for (String[] data : databaseObject){
            Client client = new Client(data[0], data[1], data[2]);
            clients.add(client);
        }
        return clients ;
    }
    

    /** 
     * @param boutique
     * @param filePath
     * @return ArrayList<Article>
     */
    static ArrayList<Article> databaseObjectToArticles(Boutique boutique, String filePath){
        ArrayList<String[]> databaseObject = readDatabaseFile(filePath);
        ArrayList<Article> articles = new ArrayList<Article>(); 
        
        for (String[] data : databaseObject){
	        	switch(data[0].toLowerCase()) {
	        		case "accessoire":
	        			articles.add(new Accessoire(Float.parseFloat(data[1]), Integer.parseInt(data[2]), data[3], data[4], data[5]));
	        			break;
	        		case "velo":
	        			articles.add(new Velo(Float.parseFloat(data[1]), Integer.parseInt(data[2]), data[3], data[4], data[5]));
	        			break;
	        		case "piecedetachee":
	        			ArrayList<Article> articlesCompatibles = new ArrayList<Article>();
	        			String[] idsArticlesCompatibles = data[5].split(",");
	        			for(String idArticleCompatible : idsArticlesCompatibles) {
	        				articlesCompatibles.add(boutique.findArticleByID(Integer.parseInt(idArticleCompatible)));
	        			}
	        			articles.add(new PieceDetachee(Float.parseFloat(data[1]), Integer.parseInt(data[2]), data[3], data[4], articlesCompatibles));
	        			break;
	        	}
        }
        return articles;
    }

    
    /** 
     * @param boutique
     * @param filePath
     * @return ArrayList<Commande>
     */
    static ArrayList<Commande> databaseObjectToCommandes(Boutique boutique, String filePath){
        ArrayList<String[]> databaseObject = readDatabaseFile(filePath);
        ArrayList<Commande> commandes = new ArrayList<Commande>(); 
        for (String[] data : databaseObject){
    		int idClient = Integer.parseInt(data[0]);	
        	Client client = boutique.findClientByID(idClient);
        	HashMap<Article, Integer> achats = new HashMap<Article, Integer>(); 
        	String[] achatsString = data[1].split(",");
        	for (String achatString : achatsString) {
        		int idProduit = Integer.parseInt(achatString.split(":")[0]);
        		int quantite = Integer.parseInt(achatString.split(":")[1]);

        		achats.put(boutique.findArticleByID(idProduit), quantite);
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
    
    static void writeFile(String csv, String filename) {
    	
        try {
        		String path = System.getProperty("user.home") + "/" + filename + ".txt";
			File myFile = new File(path); 	
			myFile.createNewFile();
			FileWriter fw = new FileWriter(path);
			fw.write(csv);
			fw.close();
			System.out.print("L'export a bien été réalisé au chemin suivant : " + path);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

    }
    
}
