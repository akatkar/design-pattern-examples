package behavioral.memento.originator;

/**
 *
 * @author Ali Katkar
 */
public class Memento {

    private final double x;
    private final double y;

    public Memento(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }
}
