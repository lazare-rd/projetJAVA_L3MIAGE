package articles;

/**
 * @author Nicolas Copsidas, Leanne Robert, Lazare Ricour-Dumas
 * @version 0.1
 */
public class Accessoire extends Article{
    private String cible ;

    public Accessoire(float prix, int stock, String nom, String marque, String cible){
        super(prix, stock, nom, marque);
        this.cible = cible ;
    }

    
    /** 
     * @return String
     */
    public String toString(){
        return super.toString() + "  Cible : " + cible; 
    }

	
    /** 
     * @return String
     */
    public String getCible() {
		return cible;
	}

	
    /** 
     * @param cible
     */
    public void setCible(String cible) {
		this.cible = cible;
	}
    
	public String toCSV() {
		return "accessoire;" + super.toCSV() + ";" + cible + "\n";
	}; 

    
}