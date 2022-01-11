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
    public String toString(){
        return super.toString() + "  Articles compatibles : " + getArticlesCompatiblesString(); 
    }

	
    /** 
     * @return ArrayList<Article>
     */
    public ArrayList<Article> getarticlesCompatibles() {
		return articlesCompatibles;
	}
    
	/**
	 * 
	 * @return String
	 */
    public String getArticlesCompatiblesString() {
    	String articlesCompatiblesString = "";
    	for (Article articleCompatible : articlesCompatibles) {
    		articlesCompatiblesString = articlesCompatiblesString + articleCompatible.getId() + " - " + articleCompatible.getNom() + "(" + articleCompatible.getMarque() + ") - ";
    	}
    	return articlesCompatiblesString;
    }
	
    /** 
     * @param articlesCompatibles
     */
    public void setVeloCompatibles(ArrayList<Article> articlesCompatibles) {
		this.articlesCompatibles = articlesCompatibles;
	}
    

	/**
	 * 
	 * @return String
	 */
	public String toCSV() {
		return "velo;" + super.toCSV() + ";" + articlesCompatiblesToCSV() + "\n";
	}; 
	

	/**
	 * 
	 * @return String
	 */
	public String articlesCompatiblesToCSV() {
		String articlesCompatiblesCSV = "";
		for(int i = 0; i < articlesCompatibles.size(); i++) {
			if(i !=0) {
				articlesCompatiblesCSV += ",";
			}
			articlesCompatiblesCSV += articlesCompatibles.get(i).getId();
		}
		return articlesCompatiblesCSV;
	}
    
}