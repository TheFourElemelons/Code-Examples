public class PizzaPlace
{
    public static void main(String[] args)
    {
        //Base example of creating a pizza from a sum of its parts.
        System.out.println("--Example Pizzas without Pretty Print--");
        //Creating a Small Pizza with Sausage, Green Peppers, and Pepperoni.
        Pizza pizza = new Pepperoni(new GreenPeppers(new Sausage(new Pepperoni(new Small()))));
        System.out.printf("%s $%.2f%n", pizza.getDescription(), pizza.cost());

        //Creating a Large Pizza with Sausage, Onions, Mushrooms, and Pepperoni.
        pizza = new Pepperoni(new Mushrooms(new Onions(new Sausage(new Large()))));
        System.out.printf("%s $%.2f%n", pizza.getDescription(), pizza.cost());

        //Adding Green Peppers, Black Olives, and Bacon to previous pizza.
        pizza = new Bacon(new BlackOlives(new GreenPeppers(pizza)));
        System.out.printf("%s $%.2f%n", pizza.getDescription(), pizza.cost());

        //Base example of multiple pizzas using the prettyPrint method.
        System.out.println("\n--Example Pizzas with Pretty Print--");
        pizza = new GreenPeppers(new Pepperoni(new Bacon(new Medium())));
        System.out.printf("%s $%.2f%n", pizza.prettyPrint(), pizza.cost());

        /*
        Adds Onions, Sausage, Extra Bacon and Extra GreenPeppers to the previous pizza,
        resulting in Double Bacon and Double GreenPeppers.
         */
        pizza = new Bacon(new GreenPeppers(new Onions(pizza)));
        System.out.printf("%s $%.2f%n", pizza.prettyPrint(), pizza.cost());

        /*
        Uses the prettyPrintPlus method to tidy up the output, removing the unneeded comma at the end, and replacing
        the last comma with the word and.
         */
        System.out.println("\n--Example Pizza with Prettier Print--");
        System.out.printf("%s $%.2f", prettierPrint(pizza.prettyPrint()), pizza.cost());
    }

    /*
    prettierPrint is used to remove the unneeded comma at the end of a topping's prettyPrint or getDescription method.
    It also replaces the last comma in the description with the word and.
     */
    public static String prettierPrint(String seq)
    {
        //Removes the comma from the end of the string.
        seq = seq.substring(0, seq.length() - 1);

        //Finds the index of the last comma.
        int idx = seq.lastIndexOf(",");

        /*
        Creates a substring of the string before the last comma, then finds the substring of the string after and
        including the last comma then replaces the comma in that substring with the word and.
         */
        return seq.substring(0,idx) + seq.substring(idx).replace(",", " and");
    }
}
