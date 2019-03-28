package behavioral.observer.feed;

import java.util.ArrayList;
import java.util.List;

class Feed implements Subject {

    private final List<Observer> observers = new ArrayList<>();

    @Override
    public void registerObserver(Observer o) {
        this.observers.add(o);
    }

    @Override
    public void notifyObservers(String tweet) {
        for(Observer o: observers)
            o.notify(tweet);
    }
}
