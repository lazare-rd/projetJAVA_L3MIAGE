import java.util.Calendar;

public class Client {
    private String nom ;
    private String prenom ;
    private String adresse ; 
    private Calendar dateInscription ; 

    public Client(String nom, String prenom, String adresse){
        this.nom = nom ;
        this.prenom = prenom ;
        this.adresse = adresse ;
        dateInscription = Calendar.getInstance() ;
    }

    public String getDate(){
        return dateInscription.getTime().toString() ; 
    }

    public String getNom(){
        return nom ; 
    }

    public String getPrenom(){
        return prenom ; 
    }

    public String getAdresse(){
        return adresse ; 
    }

}
