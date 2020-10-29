package sorting;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Main {
    static Scanner scanner;

    public static void main(final String[] args) {
        Map<String, String> params = new HashMap<>();
        int size = args.length;

        for (int i = 0; i < size; i ++) {

            if (args[i].matches("-(?!dataType|sortingType|inputFile|outputFile)(\\S*)?")) {
                System.out.println("\"" + args[i] + "\"" + " isn't a valid parameter. It's skipped.");
                continue;
            }

            if ("-dataType".equals(args[i])) {
                if (size == 1 || i == size - 1 || args[i + 1].contains("-")) {
                    System.out.println("No data type defined!");
                    return;
                } else {
                    params.put(args[i], args[i + 1]);
                }
            } else if ("-sortingType".equals(args[i])) {
                if (size == 1 || i == size - 1 ||  args[i + 1].contains("-")) {
                    System.out.println("No sorting type defined!");
                    return;
                } else {
                    params.put(args[i], args[i + 1]);
                }
            } else if ("-inputFile".equals(args[i])) {
                if (size == 1 || i == size - 1 ||  args[i + 1].contains("-")) {
                    System.out.println("No input path defined!");
                    return;
                } else {
                    params.put(args[i], args[i + 1]);
                }
            } else if ("-outputFile".equals(args[i])) {
                if (size == 1 || i == size - 1 ||  args[i + 1].contains("-")) {
                    System.out.println("No output path defined!");
                    return;
                } else {
                    params.put(args[i], args[i + 1]);
                }
            }
        }

        String dataType = params.get("-dataType") == null ? "word" : params.get("-dataType");
        String sortType = params.get("-sortingType") == null ? "natural" : params.get("-sortingType");

        if (params.get("-inputFile") == null) {
            scanner = new Scanner(System.in);
        } else {
            try {
                scanner = new Scanner(new File(params.get("-inputFile")));
            } catch (FileNotFoundException e) {
                System.out.println("File not found");
            }
        }

        Sortable input = ParserCreator.create(dataType, sortType);
        input.read(scanner);
        scanner.close();
        input.sort();
        input.output(params.get("-outputFile"));
    }
}
