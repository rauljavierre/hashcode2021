package hashcode;

import java.io.IOException;
import java.util.List;

public class Main {

    // Working directory: hashcode 2021 (root directory)

    /*
        args[0]: input filename
        args[1]: output filename
     */
    public static void main(String[] args) throws IOException {
        String inputFile = "test";
        String outputFile = "test";

        List<String> lines = FileUtils.readLines(inputFile);

        // Do stuff

        FileUtils.writeLines(lines, outputFile);
    }
}
