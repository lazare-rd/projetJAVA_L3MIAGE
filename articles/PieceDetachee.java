package articles;

import java.util.ArrayList;

public class PieceDetachee extends Article{
    private ArrayList<Article> articlesCompatibles ; 

    public PieceDetachee(float prix, int stock, String nom, String marque, ArrayList<Article> articlesCompatibles){
        super(prix, stock, nom, marque);
        this.articlesCompatibles = articlesCompatibles ;
    }
    
    @Override
    public String toString(){
        return id + " ; " + prix + " ; " + stock + " ; " + nom + " ; " + marque ; 
    }

	public ArrayList<Article> getarticlesCompatibles() {
		return articlesCompatibles;
	}

	public void setVeloCompatibles(ArrayList<Article> articlesCompatibles) {
		this.articlesCompatibles = articlesCompatibles;
	}
    
}