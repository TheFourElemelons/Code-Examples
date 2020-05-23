//Abstract class for Pizza ensures that everything that extends it can be referred to as a Pizza
public abstract class Pizza
{
    //Stores the description of the pizza.
    String description;

    //Default description if a Pizza is instantiated on its own.
    public Pizza()
    {
        description = "UIP (Unidentified Pizza)";
    }

    //getDescription returns the current description of the pizza, later objects overwrite this method.
    public String getDescription()
    {
        return description;
    }

    //prettyPrint does the same as getDescription, but is used later in toppings to make the output nicer.
    public String prettyPrint() { return description; }

    //Abstract method for cost so everything that extends this class has to implement a cost method of their own.
    public abstract double cost();
}
