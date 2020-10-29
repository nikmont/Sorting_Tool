package sorting;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.*;
import java.util.stream.Collectors;

public abstract class AbstractDataParser<T> {
    List<T> list = new ArrayList<>();
    Map<T, Integer> map = new TreeMap<>();
    Map<T, Integer> result;
    String dataType;
    String sortType;

    AbstractDataParser(String type) {
        this.sortType = type;
    }

    public void sort() {
        if ("natural".equals(sortType)) {
            list.sort(null);
        } else if ("byCount".equals(sortType)) {
            for (T num : list) {
                Integer times = Collections.frequency(list, num);
                map.put(num, times);
            }
            result = map.entrySet().stream()
                    .sorted(Map.Entry.comparingByValue())
                    .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                            (oldValue, newValue) -> oldValue, LinkedHashMap::new));
        }
    }

    public void output(String output) {
        PrintStream consoleStream = System.out;

        if (output != null) {
            try {
                File outputFile = new File(output);
                PrintStream out = new PrintStream(new FileOutputStream(outputFile));
                System.setOut(out);
            } catch (FileNotFoundException ex) {
                System.out.println("Output file not found!");
            }
        }

        System.out.printf("Total %s: %d.%n", dataType, list.size());
            if ("natural".equals(sortType)) {
                System.out.print("Sorted data: ");

                if ("lines".equals(dataType))
                    System.out.println();

                for (T num : list) {

                    if ("lines".equals(dataType)) {
                        System.out.println(num);
                    } else {
                        System.out.print(num + " ");
                    }
                }
            } else if ("byCount".equals(sortType)) {
                for (var num: result.entrySet()) {
                    System.out.println(num.getKey() + ": " + num.getValue() + " time(s), " + num.getValue() * 100 / list.size() + "%");
                }
        }
        System.setOut(consoleStream);
    }
}
