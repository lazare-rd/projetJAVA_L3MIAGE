package src.tests;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import src.ProcessFiles ;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.params.*;
import org.junit.jupiter.params.provider.*; 
import static org.junit.Assert.*;

public class ProcessFilesTest {
    
    @ParameterizedTest
    @CsvSource({ "Jean;Dormeson;33 rue des Batignoles\nLeanne;Robert;18 rue Truc\nNicolas;Copsidas;23 avenue machin", 
                "accessoire;10;3;Gourde;Decathlon;haut-niveau\nvelo;10;3;Gourde;Decathlon;detente", 
                "1;1:2,2:3;29/10/2000\n1;1:2,2:3;29/10/2000" }) 
    public void readDatabaseFile_takeFilePath_returnFileContent(String arg){
        try{
            File file = new File("DatabaseTest.txt");
            file.createNewFile();
            FileWriter myWritter = new FileWriter("DatabaseTest.txt");
            myWritter.write(arg);
            myWritter.close();
        }catch(IOException e){
            e.printStackTrace();
        }
        ArrayList<String[]> expectedArray = new ArrayList<String[]>();
        String[] clientInfo = arg.split("\n");
        for ( String item : clientInfo ){
            String[] input = item.split(";");
            expectedArray.add(input);
        }
        assertEquals(expectedArray, ProcessFiles.readDatabaseFile("DatabaseTest.txt"));
    }

    @AfterAll
    public void cleanFiles(){
        try{
            File file = new File("DatabaseTest.txt");
            file.delete();
        }catch(NullPointerException e){
            e.printStackTrace();
        }
    }
}
