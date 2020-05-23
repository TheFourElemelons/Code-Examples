public abstract class MazeDoor
{
    //provides default values for doors in case they aren't orverwritten by classes that extend this class
    String description = "You stand before a simple door, containing no lock";
    boolean locked = true;
    
    //solveDoor has to be implemented by any class that extends this class
    public abstract boolean solveDoor(String s);
    
    //description and isLocked are both default implementations that return the values for description and locked.
    public String getDescription() { return description; }
    
    public boolean isLocked() { return locked; }
}