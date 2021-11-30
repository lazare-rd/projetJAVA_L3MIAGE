public class Velo extends Article{
    private String discipline ;

    public Velo(float prix, int stock, String nom, String marque, String discipline){
        super(prix, stock, nom, marque) ; 
        this.discipline = discipline ;
    }

    public String toString(){
        return id + " ; " + prix + " ; " + stock + " ; " + nom + " ; " + marque ; 
    }

    public int getId(){
        return id ;
    }
    
    public float getPrix(){
        return prix ; 
    }

    public int getStock(){
        return stock ; 
    }

    public String getNom(){
        return nom ; 
    }

    public String getMarque(){
        return marque ; 
    } 

    public String getDiscipline(){
        return discipline ; 
    }
    
}