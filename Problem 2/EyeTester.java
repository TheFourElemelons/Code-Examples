public class EyeTester
{
    public static void main(String[] args)
    {
        //Creates the observable object, EyeOfSauron, and it's observers BadGuy Saruman, and BadGuy Angmar.
        EyeOfSauron eye = new EyeOfSauron();
        BadGuy saruman = new BadGuy(eye, "Saruman");
        BadGuy angmar = new BadGuy(eye, "Angmar");
        //Sets the number of enemies to notify both Saruman and Angmar.
        eye.setEnemies(1,1,2,0);

        //Deregisters Saruman from the observables list of observers as he has been defeated.
        saruman.defeated();
        //Sets the number of enemies to notify observers, which is only Angmar.
        eye.setEnemies(3,2,1,35);
    }
}