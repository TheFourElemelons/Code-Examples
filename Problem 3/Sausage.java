public class Sausage extends Topping
{
    //Pizza object will hold the pizza that this topping will be placed on.
    Pizza pizza;

    //Takes in a pizza object that will be used to add onto.
    public Sausage(Pizza pizza)
    {
        this.pizza = pizza;
    }

    //Adds the topping to the description of the pizza.
    public String getDescription()
    {
        return pizza.getDescription() + " Sausage,";
    }

    //Adds the cost of the topping to the existing cost of the pizza.
    public double cost()
    {
        return pizza.cost() + 2.95;
    }

    //Adds the cost of the topping to the existing cost of the pizza.
    public String prettyPrint()
    {
        //Checks if the topping has been added to the description yet, if it has then the word double will be added.
        if (pizza.prettyPrint().contains("Sausage"))
        {
            //Replaces the topping with double (topping), will do this multiple times, allowing for double double (topping).
            return pizza.prettyPrint().replace("Sausage", "Double Sausage");
        }
        else
        {
            return pizza.prettyPrint() + " Sausage,";
        }
    }
}
