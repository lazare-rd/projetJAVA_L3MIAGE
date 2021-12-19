package commandes;
import java.util.Calendar;
import java.util.Date;

public class Client {
    private static int idCounter = 0; 
    private int id ;

    private String nom ;
    private String prenom ;
    private String adresse ; 
    private Date dateInscription ; 

    public Client(String nom, String prenom, String adresse){
        this.nom = nom ;
        this.prenom = prenom ;
        this.adresse = adresse ;
        this.dateInscription = Calendar.getInstance().getTime();
        this.id = ++idCounter;
    }
    
    public String toString() {
		return "Client [nom=" + nom + ", prenom=" + prenom + ", adresse=" + adresse + ", dateInscription="
				+  getDateInscriptionString() + "]";
	}

	public String getNom() {
		return nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getDateInscriptionString() {
        return dateInscription.toString(); 
	}

	public int getId() {
		return id;
	}	
}
