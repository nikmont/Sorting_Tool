package sorting;

import java.util.Scanner;

public class NumberParser extends AbstractDataParser<Long> implements Sortable {

    public NumberParser(String typeOfSort) {
        super(typeOfSort);
        dataType = "numbers";
    }

    @Override
    public void read(Scanner sc) {
        while (sc.hasNext()) {
            String input = sc.next();
            if (input.matches("[-+]?\\d+")) {
                list.add(Long.parseLong(input));
            } else {
                System.out.println("\"" + input + "\" isn't a long. It's skipped.");
            }
        }
    }
}
