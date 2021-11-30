import java.util.ArrayList;
import java.io.*;
import java.util.regex.*;
import java.util.Scanner;



public class Main{
    private static ArrayList<Velo> arrayListVelo = new ArrayList<Velo>();
    private static ArrayList<Accessoire> arrayListAccessoire = new ArrayList<Accessoire>();
    private static ArrayList<Piecedetachee> arrayListPiecedetachee = new ArrayList<Piecedetachee>();
    private static ArrayList<Client> arrayListClients = new ArrayList<Client>(); 
    private static ArrayList<Achat> arrayListAchat = new ArrayList<Achat>();
    private static ArrayList<Commande> arrayListCommande = new ArrayList<Commande>();
    private static ArrayList<ArrayList<Article>> arrayListArticles = new ArrayList<ArrayList<Article>>() ;
     

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

    private static ArrayList<Velo> ArrayListToVelo(String filePath, int initialCapacity){
        ArrayList<ArrayList<String>> listOfData = fileToLArrayList(filePath);
        ArrayList<Velo> listOfVelo = new ArrayList<Velo>(initialCapacity) ; 
        for (int i=0; i<listOfData.size() ; i++){
            Velo velo = new Velo(Integer.parseInt(listOfData.get(i).get(0)), Integer.parseInt(listOfData.get(i).get(1)), listOfData.get(i).get(2), listOfData.get(i).get(3), listOfData.get(i).get(4));
            listOfVelo.add(velo);
        }
        return listOfVelo ;
    }

    private static ArrayList<Client> ArrayListToClient(String filePath, int initialCapacity){
        ArrayList<ArrayList<String>> listOfData = fileToLArrayList(filePath);
        ArrayList<Client> listOfClient = new ArrayList<Client>(initialCapacity) ; 
        for (int i=0; i<listOfData.size() ; i++){
            Client art = new Client(listOfData.get(i).get(0), listOfData.get(i).get(1), listOfData.get(i).get(2));
            listOfClient.add(art);
        }
        return listOfClient ;
    }

    private static ArrayList<Achat> ArrayListToAchat(String filePath, int initialCapacity){
        ArrayList<ArrayList<String>> listOfData = fileToLArrayList(filePath);
        ArrayList<Achat> listOfAchat = new ArrayList<Achat>(initialCapacity) ; 
        for (int i=0; i<listOfData.size() ; i++){
            Achat achat = new Achat(Integer.parseInt(listOfData.get(i).get(0)), listOfData.get(i).get(1));
            listOfAchat.add(achat);
        }
        return listOfAchat ;
    }



    public static void main(String[] args) {
        System.out.println(fileToLArrayList("dataClient.txt"));
    }
}