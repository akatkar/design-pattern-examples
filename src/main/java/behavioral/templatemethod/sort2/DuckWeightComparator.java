package behavioral.templatemethod.sort2;

import java.util.Comparator;

public class DuckWeightComparator implements Comparator<Duck> {

    @Override
    public int compare(Duck o1, Duck o2) {
        if (o1.weight < o2.weight) {
            return -1;
        } else if (o1.weight == o2.weight) {
            return 0;
        } else { // this.weight > otherDuck.weight
            return 1;
        }
    }
}
