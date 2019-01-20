package creational.singleton.protect;

import java.io.ObjectStreamException;
import java.io.Serializable;

public class Singleton implements Serializable {

    private static final long serialVersionUID = -1093810940935189395L;
    private static final Singleton sc = new Singleton();

    private Singleton() {
        if (sc != null) {
            throw new IllegalStateException("Already created.");
        }
    }

    public static Singleton getInstance() {
        return sc;
    }

    private Object readResolve() throws ObjectStreamException {
        return sc;
    }

    private Object writeReplace() throws ObjectStreamException {
        return sc;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException("Singleton, cannot be clonned");
    }

    private static Class getClass(String classname) throws ClassNotFoundException {
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        if (classLoader == null) {
            classLoader = Singleton.class.getClassLoader();
        }
        return (classLoader.loadClass(classname));
    }
}
