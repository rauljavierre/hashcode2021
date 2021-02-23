package hashcode;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileUtils {

    public static List<String> readLines(String path) throws FileNotFoundException {
        List<String> lines = new ArrayList<>();
        File file = new File(path);
        Scanner reader = new Scanner(file);
        while(reader.hasNextLine()) {
            lines.add(reader.nextLine());
        }
        reader.close();
        return lines;
    }

    public static void writeLines(List<String> lines, String path) throws IOException {
        FileWriter writer = new FileWriter(path);
        for (String line : lines) {
            writer.write(line + "\n");
        }
        writer.close();
    }
}
