package creational.factory.pizzafm;

public class DependentPizzaStore {
    
    NYPizzaStore ny = new NYPizzaStore();
    ChicagoPizzaStore ch = new ChicagoPizzaStore();

    public Pizza createPizza(String style, String type) {
        Pizza pizza = null;
        switch (style) {
            case "NY":
               pizza = ny.createPizza(type);
                break;
            case "Chicago":
                pizza = ch.createPizza(type); 
                break;
            default:
                System.out.println("Error: invalid type of pizza");
                return null;
        }        
        pizza.prepare();
        pizza.bake();
        pizza.cut();
        pizza.box();
        return pizza;
    }
}
