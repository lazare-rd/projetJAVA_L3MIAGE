package commandes;
import java.util.ArrayList;
import java.util.Date;

/**
 * @author Nicolas Copsidas, Leanne Robert, Lazare Ricour-Dumas
 * @version 0.1
 */
public class Commande {
    private static int idCounter = 0 ; 
    private int id; 
    private Client client; 
    private ArrayList<Achat> achats;
    private Date date; 

	/**
	 * 
	 * @param client
	 * @param achats
	 * @param date
	 */
    public Commande(Client client, ArrayList<Achat> achats, Date date){
        this.client = client ; 
        this.achats = achats ;
        this.id = ++idCounter; 
        this.date = new Date();
    }

	/**
	 * 
	 * @param client
	 * @param achats
	 */
    public Commande(Client client, ArrayList<Achat> achats){
    	this(client, achats, new Date());
    }
    

    
	/** 
	 * @return String
	 */
	public String toString() {
		return "Commande [id=" + id + ", client=" + client + ", achats=" + achats + ", date=" + date + "]";
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
	public ArrayList<Achat> getAchats() {
		return achats;
	}

	
	/** 
	 * @return Date
	 */
	public Date getDate() {
		return date;
	}
}
