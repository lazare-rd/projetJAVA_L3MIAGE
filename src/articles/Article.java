package articles;

/**
 * @author Nicolas Copsidas, Leanne Robert, Lazare Ricour-Dumas
 * @version 0.1
 */
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
        this.id = idCounter++; 
    }

    
	/** 
	 * @return String
	 */
	public String toString() {
		return " Article n" + id + ":\n  Modèle : " + nom + "\n  Marque : " 
				+ marque + "\n  Prix : " + prix + "€\n  Quantité en stock : " + stock + "\n";
	};

	
	/** 
	 * @return int
	 */
	public static int getIdCounter() {
		return idCounter;
	}

	
	/** 
	 * @param idCounter
	 */
	public static void setIdCounter(int idCounter) {
		Article.idCounter = idCounter;
	}

	
	/** 
	 * @return int
	 */
	public int getId() {
		return id;
	}

	
	/** 
	 * @param id
	 */
	public void setId(int id) {
		this.id = id;
	}

	
	/** 
	 * @return float
	 */
	public float getPrix() {
		return prix;
	}

	
	/** 
	 * @param prix
	 */
	public void setPrix(float prix) {
		this.prix = prix;
	}

	
	/** 
	 * @return int
	 */
	public int getStock() {
		return stock;
	}

	
	/** 
	 * @param stock
	 */
	public void setStock(int stock) {
		this.stock = stock;
	}

	
	/** 
	 * @return String
	 */
	public String getNom() {
		return nom;
	}

	
	/** 
	 * @param nom
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}

	
	/** 
	 * @return String
	 */
	public String getMarque() {
		return marque;
	}

	
	/** 
	 * @param marque
	 */
	public void setMarque(String marque) {
		this.marque = marque;
	}


	public String toCSV() {
		return prix + ";" + stock + ";" + nom + ";" + marque;
	}; 
	
	public void updateStock(int soldStock) {
		stock -= soldStock;
	}
	
	public Boolean isStockAvailable(int askedStock) {
		return stock > askedStock;
	}
}


