package articles;

/**
 * @author Nicolas Copsidas, Leanne Robert, Lazare Ricour-Dumas
 * @version 0.1
 */
public class Velo extends Article{
    private String discipline ;

    public Velo(float prix, int stock, String nom, String marque, String discipline){
        super(prix, stock, nom, marque) ; 
        this.discipline = discipline ;
    }

    
    /** 
     * @return String
     */
    public String toString(){
<<<<<<< HEAD
        return id + " ; " + prix + " ; " + stock + " ; " + nom + " ; " + marque + " ; " + discipline; 
=======
        return super.toString() + "  Discipline : " + discipline; 
>>>>>>> 847137b126da292b1441f7d210bc8549e6376165
    }

	
    /** 
     * @return String
     */
    public String getDiscipline() {
		return discipline;
	}

	
    /** 
     * @param discipline
     */
    public void setDiscipline(String discipline) {
		this.discipline = discipline;
	}    
    
	public String toCSV() {
		return "velo;" + super.toCSV() + ";" + discipline + "\n";
	}; 

}