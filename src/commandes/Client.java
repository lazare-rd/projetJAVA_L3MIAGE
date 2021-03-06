package commandes;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
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
    public Client(String nom, String prenom, String adresse, Date dateInscription){
        this.nom = nom ;
        this.prenom = prenom ;
        this.adresse = adresse ;
        this.dateInscription = dateInscription;
        this.id = idCounter++;
    }
    
    public Client(String nom, String prenom, String adresse) {
    	this(nom, prenom, adresse, new Date());
    }

    
	/** 
	 * @return String
	 */
	public String toString() {
		return id + " ; " + nom + " ; " + prenom + " ; " + adresse + " ; "
				+  getDateInscription() ;
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
	public String getDateInscription() {
        DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		return formatter.format(dateInscription);
	}

	
	/** 
	 * @return int
	 */
	public int getId() {
		return id;
	}	
	

	/**
	 * 
	 * @return String
	 */
	public String toCSV() {
		return prenom + ";" + nom + ";" + adresse + "\n";
	}
}
