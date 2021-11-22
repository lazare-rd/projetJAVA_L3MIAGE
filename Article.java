public abstract class Article{
    protected static int idCounter ;
    protected int id ; 
    protected float prix ;
    protected int stock ;
    protected String nom ;
    protected String marque ;

    public Article(float prix, int stock, String nom, String marque){
        this.prix = prix ; 
        this.stock = stock;
        this.nom = nom ;
        this.marque = marque ; 
        idCounter+=1 ; 
        this.id = idCounter ; 
    }

    public abstract String toString() ;

    public abstract int getId() ; 
    
    public abstract float getPrix();

    public abstract int getStock();

    public abstract String getNom() ; 

    public abstract String getMarque() ; 

}


