public class Piecedetachee extends Article{
    private String[] marquesCompatibles ; 

    public Piecedetachee(float prix, int stock, String nom, String marque, String[] marquesCompatibles){
        super(prix, stock, nom, marque);
        this.marquesCompatibles = marquesCompatibles ;
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

    public String[] getMarquesCompatibles(){
        return marquesCompatibles ;
    }
}