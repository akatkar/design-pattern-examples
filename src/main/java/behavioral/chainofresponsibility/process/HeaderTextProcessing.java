package behavioral.chainofresponsibility.process;

/**
 *
 * @author Ali Katkar
 */
public class HeaderTextProcessing extends ProcessingObject<String> {

    @Override
    public String handleWork(String text) {
        return "From Raoul, Mario and Alan: " + text;
    }
}
