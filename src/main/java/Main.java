import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


/**
 * Created by stepanv on 27.10.16.
 */
public class Main {
    public static void main(String[] args) {
        List<String> cities = getCitiesFromFile();
        //For each address send request for coordinates
        for (String city : cities) {
            RequestMaker.getCoordinatesFor(city);
        }
    }

    private static List<String> getCitiesFromFile() {
        Scanner s;
        ClassLoader classLoader = Main.class.getClassLoader();
        File file;
        ArrayList<String> rows = new ArrayList<String>();

        try {
            //Obtain .txt file from resources folder
            file = new File(classLoader.getResource("cities").getFile());
            s = new Scanner(file);
            //Getting each text row from file using Scanner
            while (s.hasNext()) {
                rows.add(s.next());
            }
            s.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return rows;
    }
}
