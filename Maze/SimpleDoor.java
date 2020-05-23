public class SimpleDoor extends MazeDoor
{
    //SimpleDoor will overwrite the locked value as they aren't locked by default, and the description is updated.
    public SimpleDoor()
    {
        locked = false;
        description = "You stand before a simple door, containing no lock";
    }
    
    //solveDoor will always return true as it is always unlocked.
    public boolean solveDoor(String s)
    {
        return true;
    }
}