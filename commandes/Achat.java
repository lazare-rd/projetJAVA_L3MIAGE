package commandes;
import articles.Article;

public class Achat {
    private int quantite;
    private Article article; 

    public Achat(int quantite, Article article){
        this.quantite = quantite;
        this.article = article; 
    }

	public int getQuantite() {
		return quantite;
	}

	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}

	public Article getArticle() {
		return article;
	}

	public void setArticle(Article article) {
		this.article = article;
	}
	
	public float getAchatPrice() {
		return quantite * article.getPrix();
	}
}
