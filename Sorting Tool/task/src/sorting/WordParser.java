package sorting;

import java.util.Scanner;

public class WordParser extends AbstractDataParser<String> implements Sortable {

    public WordParser(String typeOfSort) {
        super(typeOfSort);
        dataType = "words";
    }

    @Override
    public void read(Scanner sc) {
        while (sc.hasNext()) {
            list.add(sc.next());
        }
    }
}