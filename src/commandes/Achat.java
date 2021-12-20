package commandes;

import articles.Article;

/**
 * @author Nicolas Copsidas, Leanne Robert, Lazare Ricour-Dumas
 * @version 0.1
 */
public class Achat {
    private int quantite;
    private Article article; 

	/**
	 * 
	 * @param quantite
	 * @param article
	 */
    public Achat(int quantite, Article article){
        this.quantite = quantite;
        this.article = article; 
    }

	
	/** 
	 * @return int
	 */
	public int getQuantite() {
		return quantite;
	}

	
	/** 
	 * @param quantite
	 */
	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}

	
	/** 
	 * @return Article
	 */
	public Article getArticle() {
		return article;
	}

	
	/** 
	 * @param article
	 */
	public void setArticle(Article article) {
		this.article = article;
	}
	
	public float getAchatPrice() {
		return quantite * article.getPrix();
	}
}
