package behavioral.observer.feed;

public class Guardian implements Observer {

    @Override
    public void notify(String tweet) {
        if (tweet != null && tweet.contains("Queen")) {
            System.out.println("news in London... " + tweet);
        }
    }
}
