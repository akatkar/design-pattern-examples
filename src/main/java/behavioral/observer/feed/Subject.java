package behavioral.observer.feed;

public interface Subject {
    void registerObserver(Observer o);
    void notifyObservers(String tweet);
}
