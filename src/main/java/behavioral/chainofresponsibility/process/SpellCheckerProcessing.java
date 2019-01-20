package behavioral.chainofresponsibility.process;

/**
 *
 * @author Ali Katkar
 */
public class SpellCheckerProcessing extends ProcessingObject<String> {

    @Override
    public String handleWork(String text) {
        return text.replaceAll("labda", "lambda");
    }
}
