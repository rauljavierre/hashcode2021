package hashcode;

import java.io.IOException;
import java.util.List;

public class Main {

    // Working directory: hashcode 2021 (root directory)
    public static void main(String args[]) throws IOException {
        List<String> lines = FileUtils.readLines("./resources/data-in/test");
        FileUtils.writeLines(lines, "./resources/data-out/test");
    }
}
