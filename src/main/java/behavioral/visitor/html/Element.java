package behavioral.visitor.html;

public interface Element {
    void accept(Visitor visitor);
}
