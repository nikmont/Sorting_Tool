package sorting;

import java.util.Scanner;

public class LineParser extends AbstractDataParser<String> implements Sortable {

    public LineParser(String typeOfSort) {
        super(typeOfSort);
        dataType = "lines";
    }

    @Override
    public void read(Scanner sc) {
        while (sc.hasNextLine()) {
            list.add(sc.nextLine());
        }
    }
}