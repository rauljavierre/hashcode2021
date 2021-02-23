package hashcode;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileUtils {

    public static String DATA_IN_PATH = "./resources/data-in/";
    public static String DATA_OUT_PATH = "./resources/data-out/";

    public static List<String> readLines(String filename) throws FileNotFoundException {
        List<String> lines = new ArrayList<>();
        File file = new File(DATA_IN_PATH + filename);
        Scanner reader = new Scanner(file);
        while(reader.hasNextLine()) {
            lines.add(reader.nextLine());
        }
        reader.close();
        return lines;
    }

    public static void writeLines(List<String> lines, String filename) throws IOException {
        FileWriter writer = new FileWriter(DATA_OUT_PATH + filename);
        for (String line : lines) {
            writer.write(line + "\n");
        }
        writer.close();
    }
}
