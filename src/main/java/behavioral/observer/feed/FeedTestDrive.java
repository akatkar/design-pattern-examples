package behavioral.observer.feed;

public class FeedTestDrive {

    public static void main(String[] args) {
        Feed f = new Feed();
        f.registerObserver(new NewYorkTimes());
        f.registerObserver(new Guardian());
        f.registerObserver(new LeMonde());

        f.notifyObservers("money for nothing");
        f.notifyObservers("Queen is just like a King");
        f.notifyObservers("Paris Saintgermen");
    }
}
