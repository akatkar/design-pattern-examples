package behavioral.templatemethod.sort2;

import java.util.Comparator;

public class DuckWeightComparator implements Comparator<Duck> {

    @Override
    public int compare(Duck o1, Duck o2) {
        return o2.weight - o1.weight;
    }
}
