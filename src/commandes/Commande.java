package commandes;

import articles.Article;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

/**
 * @author Nicolas Copsidas, Leanne Robert, Lazare Ricour-Dumas
 * @version 0.1
 */
public class Commande {
    private static int idCounter = 0 ; 
    private int id; 
    private Client client; 
    private HashMap<Article, Integer> achats = new HashMap<Article, Integer>();
    private Date date; 

	/**
	 * 
	 * @param client
	 * @param achats
	 * @param date
	 */
    public Commande(Client client, HashMap<Article, Integer> achats, Date date){
        this.client = client ; 
        this.achats = achats ;
        this.id = idCounter++; 
        this.date = date;
    }

	/**
	 * 
	 * @param client
	 * @param achats
	 */
    public Commande(Client client, HashMap<Article, Integer> achats){
    	this(client, achats, new Date());
    }
    

    
	/** 
	 * @return String
	 */
	public String toString() {
		return "Commande n"+ id + "\n Client n" + client.getId() + " : "+ client.getPrenom() + " " + client.getNom() + "\n Achats : \n" + getAchatsString() + "Date : " + getDate();
	}

	
	/** 
	 * @return int
	 */
	public static int getIdCounter() {
		return idCounter;
	}

	
	/** 
	 * @return int
	 */
	public int getId() {
		return id;
	}

	
	/** 
	 * @return Client
	 */
	public Client getClient() {
		return client;
	}

	
	/** 
	 * @return ArrayList<Achat>
	 */
	public HashMap<Article, Integer> getAchats() {
		return achats;
	}
	
	/** 
	 * @return ArrayList<Achat>
	 */
	public String getAchatsString() {
		String achatsString ="";
		for (HashMap.Entry<Article, Integer> achat : achats.entrySet()) {
			achatsString += achat.getKey().toString() + " - Quantité : " + achat.getValue() + "\n";
		}
		return achatsString;
	}
	
	/** 
	 * @return Date
	 */
	public String getDate() {
        DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		return formatter.format(date);
	}

	public String achatsToCSV() {
		String achatsCSV ="";
		int index = 0;
		for (HashMap.Entry<Article, Integer> achat : achats.entrySet()) {
			if(index++ != 0) {
				achatsCSV += ",";
			}
			achatsCSV += achat.getKey().getId() + ":" + achat.getValue();
		}
		return achatsCSV;
	}
	
	public String toCSV() {
		return client.getId() + ";" + achatsToCSV() + ";" + getDate() + "\n";
	}

}
