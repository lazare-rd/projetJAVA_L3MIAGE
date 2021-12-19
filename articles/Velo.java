package articles;

public class Velo extends Article{
    private String discipline ;

    public Velo(float prix, int stock, String nom, String marque, String discipline){
        super(prix, stock, nom, marque) ; 
        this.discipline = discipline ;
    }

    @Override
    public String toString(){
        return id + " ; " + prix + " ; " + stock + " ; " + nom + " ; " + marque ; 
    }

	public String getDiscipline() {
		return discipline;
	}

	public void setDiscipline(String discipline) {
		this.discipline = discipline;
	}    
}