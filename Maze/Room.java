import java.util.ArrayList;

public abstract class Room
{
    //doors stores the door objects that are in the room, each door is a more specific type, but since they are all doors they can be stored in this arraylist.
    public ArrayList<MazeDoor> doors = new ArrayList<>();
    //desc will be overwritten by the subclasses that extend this class, but has a default message if they don't overwrite it.
    public String desc = "The room seems to be completely empty of material, as if you stepped into the void";
    
    //abstract methods have to be implemented by an class that extends this class, these methods differ from each class, and therefore need to be declared abstract.
    public abstract void createDoors();
    
    public abstract String search();
    
    //getDescription() returns the description of the room, the description of a room will change with each class that extends it, but this method won't.
    public String getDescription()
    {
        return desc;
    }
    
    //inspectRoom is primarly for testing, but will return the description of all of the doors in the room and their number.
    public String inspectRoom()
    {
        String temp = "";
        for(int i = 0; i < doors.size(); i++)
        {
            temp += "Door #" + (i + 1) + ": " + doors.get(i).getDescription() + "\n";
        }
        return temp;
    }
    
    //inspectDoor will return the description of a specific door.
    public String inspectDoor(int i)
    {
        return "Door #" + i + ": " + doors.get(i - 1).getDescription() + "\n";
    }
    
    //isLocked will check if a specific door is locked.
    public boolean isLocked(int i)
    {
        return doors.get(i - 1).isLocked();
    }
    
    //solveDoor will check if the door is already unlocked, or if the provided answer is a solution to the door.
    public boolean solveDoor(int i, String s)
    {
        return !doors.get(i - 1).isLocked() || doors.get(i - 1).solveDoor(s);
    }
}