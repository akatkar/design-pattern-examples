package lambda.behavioral.observer.feed;

public class FeedTestDrive {

    public static void main(String[] args) {
        Feed f = new Feed();

        f.registerObserver(tweet -> {
            if (tweet != null && tweet.contains("money")) {
                System.out.println("Breaking news in NY! " + tweet);
            }
        });
        f.registerObserver(tweet -> {
            if (tweet != null && tweet.contains("Queen")) {
                System.out.println("news in London... " + tweet);
            }
        });
        f.registerObserver(tweet -> {
            if (tweet != null && tweet.contains("Paris")) {
                System.out.println("Breaking news in Paris! " + tweet);
            }
        });

        f.notifyObservers("money for nothing");
        f.notifyObservers("Queen is just like a King");
        f.notifyObservers("Paris Saintgermen");
    }
}
