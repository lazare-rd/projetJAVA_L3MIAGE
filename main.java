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
            Pattern p = Pattern.compile("/"); 
            Scanner s = new Scanner(new File(filePath)) ;
            while (s.hasNextLine()){
                String[] items = p.split(s.nextLine());
                ArrayList<String> liste = new ArrayList<String>();
                for(int i=0; i<items.length; i++){
                    liste.add(items[i]);
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