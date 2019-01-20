package creational.prototype.access;

public interface Prototype extends Cloneable {
    public AccessControl clone() throws CloneNotSupportedException;
}
