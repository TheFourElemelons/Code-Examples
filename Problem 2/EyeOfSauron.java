import java.util.Observable;

public class EyeOfSauron extends Observable
{
    //Variables to keep track of how many enemies the EyeOfSauron sees.
    private int hobbits, elves, dwarves, men;

    //Empty constructor
    public EyeOfSauron () { }

    //Set enemies will take in an amount of hobbits, elves, dwarves, and men the EyeOfSauron has seen.
    public void setEnemies(int h, int e, int d, int m)
    {
        hobbits = h;
        elves = e;
        dwarves = d;
        men = m;

        //enemiesSpotted() will notify Observers that the data has changed.
        enemiesSpotted();
    }

    //Called after setEnemies as the data set has now changed and the Observers must be notified.
    public void enemiesSpotted()
    {
        setChanged();
        notifyObservers();
    }

    //Getter methods for all of the enemies of Sauron.
    public int getHobbits()
    {
        return hobbits;
    }

    public int getElves()
    {
        return elves;
    }

    public int getDwarves()
    {
        return dwarves;
    }

    public int getMen()
    {
        return men;
    }
}
