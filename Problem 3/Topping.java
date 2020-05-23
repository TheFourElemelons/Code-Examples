//Topping extends Pizza so it can be passed to the various classes that extend topping, so toppings can be added onto pizzas that have toppings.
public abstract class Topping extends Pizza
{
    //Abstract method for getDescription so every class that extends topping has to implement a getDescription method.
    public abstract String getDescription();

    //Abstract method for prettyPrint so every class that extends topping has to implement a prettyPrint method.
    public abstract String prettyPrint();
}
