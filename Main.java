/**
 * @author Nicolas Copsidas, Leanne Robert, Lazare Ricour-Dumas
 * @version 0.1
 */
public class Main {

	public static void main(String[] args) {

        System.out.println(ProcessFiles.databaseObjectToClient("dataClient.txt").get(0).toString());
	}
	

}
