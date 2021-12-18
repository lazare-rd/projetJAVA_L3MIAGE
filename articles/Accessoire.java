public class Accessoire extends Article{
    private String cible ;

    public Accessoire(float prix, int stock, String nom, String marque, String cible){
        super(prix, stock, nom, marque);
        this.cible = cible ;
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

    public String getCible(){
        return cible ; 
    }

    
}