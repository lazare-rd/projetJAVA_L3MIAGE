package src.tests;

import java.util.ArrayList;
import java.nio.file.Path;

import src.ProcessFiles ;
import src.articles.Velo;
import src.commandes.Client;
import src.Boutique;
import src.articles.*;

import org.junit.Test; 
import static org.junit.Assert.*;


public class ProcessFilesTest {
    
    Path currentRelativePath = Path.of("");
    String absPath = currentRelativePath.toAbsolutePath().toString();

    @Test
    public void readDatabaseFile_takeFilePath_returnFileContent(){
        String arg = "Jean;Dormeson;33 rue des Batignoles/Leanne;Robert;18 rue Truc/Nicolas;Copsidas;23 avenue machin" ;
        ArrayList<String[]> expectedArray = new ArrayList<String[]>();
        ArrayList<String[]> receivedArray = ProcessFiles.readDatabaseFile(absPath + "/src/tests/DatabaseTest.txt");
        String[] clientInfo = arg.split("/");
        for ( String item : clientInfo ){
            String[] input = item.split(";");
            expectedArray.add(input);
        }
        for ( int i=0 ; i<receivedArray.size() ; i++ ){
            for ( int j=0 ; j<receivedArray.get(0).length ; j++ ){
                assertEquals(expectedArray.get(i)[j], receivedArray.get(i)[j]);
            }
        }
    }

    @Test
    public void databaseObjectToVelo_takeFilePath_returnArrrayOfVelo(){
        ArrayList<Velo> expectedVelos = new ArrayList<Velo>();
        ArrayList<Velo> receivedVelos = ProcessFiles.databaseObjectToVelo(absPath + "/src/tests/DataVeloTest.txt");
        Velo expectedVelo1 = new Velo(10, 3, "Gourde", "Decathlon", "loisir");
        Velo expectedVelo2 = new Velo(20, 5, "Pochette", "Go-Sport", "performance");
        expectedVelos.add(expectedVelo1);
        expectedVelos.add(expectedVelo2);
     
        for ( int i=0 ; i<receivedVelos.size() ; i++ ){
            assertEquals(expectedVelos.get(i).toString().substring(1), receivedVelos.get(i).toString().substring(1));
        }
    }

    @Test
    public void databaseObjectToCLient_takeFilePath_returnArrayOfClient(){
        ArrayList<Client> expectedClients = new ArrayList<Client>();
        ArrayList<Client> receivedClients = ProcessFiles.databaseObjectToClient(absPath + "/src/tests/DatabaseTest.txt");
        Client expectedClient1 = new Client("Jean", "Dormeson", "33 rue des Batignoles");
        Client expectedClient2 = new Client("Leanne", "Robert", "18 rue Truc");
        Client expectedClient3 = new Client("Nicolas", "Copsidas", "23 avenue machin");

        expectedClients.add(expectedClient1);
        expectedClients.add(expectedClient2);
        expectedClients.add(expectedClient3);
     
        for ( int i=0 ; i<receivedClients.size() ; i++){
            assertEquals(expectedClients.get(i).toString().substring(1), receivedClients.get(i).toString().substring(1));
        }
    }

    @Test
    public void databaseObjectToArticles_takeBoutiqueAndFilePath_returnArrayOfArticles(){
        Boutique boutique = new Boutique();
        ArrayList<Article> expectedArticles = new ArrayList<Article>();
        ArrayList<Article> receivedArticles = ProcessFiles.databaseObjectToArticles(boutique, absPath + "/src/tests/DataArticlesTest.txt");
        Accessoire expectedAccess = new Accessoire(10, 3, "Gourde", "Decathlon", "haut-niveau");
        Velo expectedVelo = new Velo(10, 3, "Gourde", "Decathlon", "detente");

        expectedArticles.add(expectedAccess);
        expectedArticles.add(expectedVelo);

        for ( int i=0 ; i<receivedArticles.size() ; i++ ){
            assertEquals(expectedArticles.get(i).toString().substring(1), receivedArticles.get(i).toString().substring(1));
        }


    }




    
}
