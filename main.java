import java.util.ArrayList;
import java.io.*;
import java.util.regex.*;
import java.util.Scanner;



public class Main{
    private static ArrayList<Article> arrayListArticles;
    private static ArrayList<Client> arrayListClients ; 
    private static ArrayList<Achat> arrayListAchat ;
    private static ArrayList<Commande> arrayListCommande ;

    private static ArrayList<ArrayList<String>> fileToLArrayList(String filePath){
        ArrayList<ArrayList<String>> listeOfListe = new ArrayList<ArrayList<String>>();
        try{
            Pattern p = Pattern.compile("([\\w]*)/([\\w]*)/([\\w]*)"); 
            Scanner s = new Scanner(new File(filePath)) ;
            while (s.hasNextLine()){
                Matcher m = p.matcher(s.nextLine());
                ArrayList<String> liste = new ArrayList<String>();
                for(int i=0; i<=m.groupCount(); i++){
                    liste.add(m.group(i));
                }
                listeOfListe.add(liste);
            }
        }catch(NullPointerException e){
            e.printStackTrace();
        }catch(FileNotFoundException e){
            e.printStackTrace();
        }
        return listeOfListe ; 
    }

    public static void main(String[] args) {
        System.out.println(fileToLArrayList("dataClient.txt"));
    }
}