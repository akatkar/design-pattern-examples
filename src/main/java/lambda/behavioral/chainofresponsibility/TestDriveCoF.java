package lambda.behavioral.chainofresponsibility;

import java.util.function.Function;
import java.util.function.UnaryOperator;

public class TestDriveCoF {

    public static void main(String[] args) {

        UnaryOperator<String> headerProcessing
                = text -> "From Raoul, Mario and Alan: " + text;

        UnaryOperator<String> spellCheckerProcessing
                = text -> text.replaceAll("labda", "lambda");

        Function<String, String> pipeline
                = headerProcessing
                        .andThen(spellCheckerProcessing);

        String result = pipeline.apply("Aren't labdas really sexy?!!");
        System.out.println(result);
    }
}
