import java.util.Observable;
import java.util.Observer;

//Implements Java's Observer interface.
public class BadGuy implements Observer
{
    /*
    Stores the observable object as obs in the constructor, other variables are used to keep track of the number of
    hobbits, elves, dwarves, and men are seen, and name is the name of the observer.
    */
    Observable obs;
    private int hobbits, elves, dwarves, men;
    private String name;

    //Constructor takes in the observable object that this observer will observe, and the name of the observer.
    public BadGuy(Observable o, String name)
    {
        obs = o;
        //Adds this object to the observable object's list of observers.
        obs.addObserver(this);
        this.name = name;
    }

    //Update is called whenever the observable object o's notifyObservers() method has been called.
    public void update(Observable o, Object arg)
    {
        //Checks that the observable is in fact an EyeOfSauron, and not the work of some conjurer of cheap tricks.
        if (o instanceof EyeOfSauron)
        {
            //Casts the observable o to an EyeOfSauron so the methods of an EyeOfSauron can be used.
            EyeOfSauron eye = (EyeOfSauron)o;

            //Retrieves the number of hobbits, elves, dwarves, and men the EyeOfSauron sees.
            hobbits = eye.getHobbits();
            elves = eye.getElves();
            dwarves = eye.getDwarves();
            men = eye.getMen();

            //Display method will say who say what and how many.
            display();
        }
    }

    //Prints out who the observer is and what they saw.
    public void display()
    {
        System.out.println(name + " has spotted " + hobbits + " hobbits, " + elves + " elves, " + dwarves + " dwarves, " + men + " men! Release the Uruks!");
    }

    //Will deregister the observer from the observable's list of observers.
    public void defeated()
    {
        obs.deleteObserver(this);
    }
}
