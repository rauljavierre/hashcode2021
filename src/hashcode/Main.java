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
        List<String> lines = FileUtils.readLines(args[0]);

        // Do stuff

        FileUtils.writeLines(lines, args[1]);
    }
}
