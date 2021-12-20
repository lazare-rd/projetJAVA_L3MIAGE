package commandes;

import java.util.Calendar;
import java.util.Date;

/**
 * @author Nicolas Copsidas, Leanne Robert, Lazare Ricour-Dumas
 * @version 0.1
 */
public class Client {
    private static int idCounter = 0; 
    private int id ;

    private String nom ;
    private String prenom ;
    private String adresse ; 
    private Date dateInscription ; 

	/**
	 * 
	 * @param nom
	 * @param prenom
	 * @param adresse
	 */
    public Client(String nom, String prenom, String adresse){
        this.nom = nom ;
        this.prenom = prenom ;
        this.adresse = adresse ;
        this.dateInscription = Calendar.getInstance().getTime();
        this.id = ++idCounter;
    }
    


    
	/** 
	 * @return String
	 */
	public String toString() {
		return "Client " + id + "[nom=" + nom + ", prenom=" + prenom + ", adresse=" + adresse + ", dateInscription="
				+  getDateInscriptionString() + "]";
	}

	
	/** 
	 * @return String
	 */
	public String getNom() {
		return nom;
	}

	
	/** 
	 * @return String
	 */
	public String getPrenom() {
		return prenom;
	}

	
	/** 
	 * @return String
	 */
	public String getAdresse() {
		return adresse;
	}

	
	/** 
	 * @param adresse
	 */
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	
	/** 
	 * @return String
	 */
	public String getDateInscriptionString() {
        return dateInscription.toString(); 
	}

	
	/** 
	 * @return int
	 */
	public int getId() {
		return id;
	}	
}
