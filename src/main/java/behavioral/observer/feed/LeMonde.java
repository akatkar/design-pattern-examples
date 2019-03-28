package behavioral.observer.feed;

public class LeMonde implements Observer {

    @Override
    public void notify(String tweet) {
        if (tweet != null && tweet.contains("Paris")) {
            System.out.println("Breaking news in Paris! " + tweet);
        }
    }
}
