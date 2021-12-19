public class Main {

	public static void main(String[] args) {
		Boutique maBoutique = new Boutique();
		maBoutique.addClients(ProcessFiles.databaseObjectToClient("dataClient.txt"));
        maBoutique.addCommandes(ProcessFiles.databaseObjectToCommandes(maBoutique, "dataCommandes.txt"));
        maBoutique.initBoutique();		
	}
	

}
