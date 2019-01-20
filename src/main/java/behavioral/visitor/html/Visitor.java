package behavioral.visitor.html;

public interface Visitor {

    public void visit(HtmlElement element);

    public void visit(HtmlParentElement parentElement);
}
