import java.util.ArrayList;
import java.util.Calendar;

public class Commande {
    private static int idCounter ; 
    private int id ; 
    private Client client ; 
    private ArrayList<Achat> achats ;
    private Calendar date ; 

    public Commande(Client client, ArrayList<Achat> achats){
        this.client = client ; 
        this.achats = achats ;
        idCounter+=1 ; 
        id = idCounter ; 
        date = Calendar.getInstance() ;
    }

    public String getDate(){
        return date.getTime().toString() ; 
    }

    public int getId() {
        return this.id;
    }

    public Client getClient() {
        return this.client;
    }

    public ArrayList<Achat> getAchats(){
        return achats ; 
    }





}
