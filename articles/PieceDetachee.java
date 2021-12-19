package articles;

import java.util.ArrayList;

/**
 * @author Nicolas Copsidas, Leanne Robert, Lazare Ricour-Dumas
 * @version 0.1
 */
public class PieceDetachee extends Article{
    private ArrayList<Article> articlesCompatibles ; 

    public PieceDetachee(float prix, int stock, String nom, String marque, ArrayList<Article> articlesCompatibles){
        super(prix, stock, nom, marque);
        this.articlesCompatibles = articlesCompatibles ;
    }
    
    
    /** 
     * @return String
     */
    @Override
    public String toString(){
        return id + " ; " + prix + " ; " + stock + " ; " + nom + " ; " + marque ; 
    }

	
    /** 
     * @return ArrayList<Article>
     */
    public ArrayList<Article> getarticlesCompatibles() {
		return articlesCompatibles;
	}

	
    /** 
     * @param articlesCompatibles
     */
    public void setVeloCompatibles(ArrayList<Article> articlesCompatibles) {
		this.articlesCompatibles = articlesCompatibles;
	}
    
}