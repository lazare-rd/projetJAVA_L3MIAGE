import java.io.* ; 

public class Main{

    public static void main(String[] args) {
        try{
            Article velo1 = new Velo(130, 11, "superDescente", "MegaVTT");
            Article velo2 = new Velo(1000, 2, "Viktor", "Shindelhauler");
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("articles.txt"));
            oos.writeObject(velo1);
            oos.writeObject(velo2);
            oos.close();
        }catch(FileNotFoundException e){
            e.printStackTrace() ; 
        }catch(IOException e){
            e.printStackTrace();
        }

        try{
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("articles.txt")) ; 
            Velo vtt = (Velo) ois.readObject() ; 
            System.out.println(vtt.toString());
            ois.close();
        }catch(FileNotFoundException e){
            e.printStackTrace() ; 
        }catch(ClassNotFoundException e){
            e.printStackTrace();
        }catch(IOException e){
            e.printStackTrace();
        }

    }
}