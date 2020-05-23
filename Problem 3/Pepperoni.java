public class Pepperoni extends Topping
{
    //Pizza object will hold the pizza that this topping will be placed on.
    Pizza pizza;

    //Takes in a pizza object that will be used to add onto.
    public Pepperoni (Pizza pizza)
    {
        this.pizza = pizza;
    }

    //Adds the topping to the description of the pizza.
    public String getDescription() { return pizza.getDescription() + " Pepperoni,"; }

    //Adds the cost of the topping to the existing cost of the pizza.
    public double cost()
    {
        return pizza.cost() + 1.45;
    }

    //Adds the cost of the topping to the existing cost of the pizza.
    public String prettyPrint()
    {
        //Checks if the topping has been added to the description yet, if it has then the word double will be added.
        if (pizza.prettyPrint().contains("Pepperoni"))
        {
            //Replaces the topping with double (topping), will do this multiple times, allowing for double double (topping).
            return pizza.prettyPrint().replace("Pepperoni", "Double Pepperoni");
        }
        else
        {
            //Adds the topping to the description if it hasn't been added already.
            return pizza.prettyPrint() + " Pepperoni,";
        }
    }
}
