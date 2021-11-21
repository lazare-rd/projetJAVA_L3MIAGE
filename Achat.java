public class Achat {
    private int qte ;
    private Article article ; 
    private static int idCounter ; 
    private int id ;

    public Achat(int qte, Article article){
        this.qte = qte ;
        this.article = article ; 
        idCounter+=1 ;
        id = idCounter ; 
    }

    public int getQte() {
        return this.qte;
    }

    public Article getArticle() {
        return this.article;
    }

    public int getId() {
        return this.id;
    }

}
