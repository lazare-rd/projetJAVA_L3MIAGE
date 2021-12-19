package commandes;
import java.util.ArrayList;
import java.util.Date;

public class Commande {
    private static int idCounter = 0 ; 
    private int id; 
    private Client client; 
    private ArrayList<Achat> achats;
    private Date date; 

    public Commande(Client client, ArrayList<Achat> achats, Date date){
        this.client = client ; 
        this.achats = achats ;
        this.id = ++idCounter; 
        this.date = new Date();
    }

    public Commande(Client client, ArrayList<Achat> achats){
    	this(client, achats, new Date());
    }
    
    public String toString() {
		return "Commande [id=" + id + ", client=" + client + ", achats=" + achats + ", date=" + date + "]";
	}

	public static int getIdCounter() {
		return idCounter;
	}

	public int getId() {
		return id;
	}

	public Client getClient() {
		return client;
	}

	public ArrayList<Achat> getAchats() {
		return achats;
	}

	public Date getDate() {
		return date;
	}
}
