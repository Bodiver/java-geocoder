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
            file = new File(classLoader.getResource("cities").getFile());
            s = new Scanner(file);
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
