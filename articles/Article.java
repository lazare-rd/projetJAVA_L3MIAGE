package articles;
public abstract class Article {
    protected static int idCounter ;
    protected int id ; 
    protected float prix ;
    protected int stock ;
    protected String nom ;
    protected String marque ;

    public Article(float prix, int stock, String nom, String marque){
        this.prix = prix; 
        this.stock = stock;
        this.nom = nom;
        this.marque = marque; 
        this.id = ++idCounter; 
    }

    public abstract String toString();

	public static int getIdCounter() {
		return idCounter;
	}

	public static void setIdCounter(int idCounter) {
		Article.idCounter = idCounter;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public float getPrix() {
		return prix;
	}

	public void setPrix(float prix) {
		this.prix = prix;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getMarque() {
		return marque;
	}

	public void setMarque(String marque) {
		this.marque = marque;
	}
}


