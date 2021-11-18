public class Article{
    protected static int idCounter ;
    protected int id ; 
    protected float prix ;
    protected int stock ;
    protected String nom ;
    protected String marque ;

   //Encore un test, promis c'est le dernier
    public Article(float prix, int stock, String nom, String marque){
        this.prix = prix ; 
        this.stock = stock;
        this.nom = nom ;
        this.marque = marque ; 
        idCounter+=1 ; 
        this.id = idCounter ; 
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

}


