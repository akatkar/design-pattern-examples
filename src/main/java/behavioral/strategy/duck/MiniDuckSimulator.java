package behavioral.strategy.duck;

public class MiniDuckSimulator {

    public static void main(String[] args) {

        MallardDuck mallard = new MallardDuck();
        mallard.performQuack();

        RubberDuck rubberDuckie = new RubberDuck();
        rubberDuckie.performQuack();

        DecoyDuck decoy = new DecoyDuck();
        decoy.performQuack();

        ModelDuck model = new ModelDuck();
        model.performFly();
        model.setFlyBehavior(new FlyRocketPowered());
        model.performFly();
    }
}
