package articles;
public class Accessoire extends Article{
    private String cible ;

    public Accessoire(float prix, int stock, String nom, String marque, String cible){
        super(prix, stock, nom, marque);
        this.cible = cible ;
    }

    @Override
    public String toString(){
        return id + " ; " + prix + " ; " + stock + " ; " + nom + " ; " + marque ; 
    }

	public String getCible() {
		return cible;
	}

	public void setCible(String cible) {
		this.cible = cible;
	}
    
}