public class NumericLockedDoor extends MazeDoor
{
    //ans stores the answer to the door.
    int ans;
    
    //Creates the door with the passed integer value as the answer to the door, and updates the description of the door
    public NumericLockedDoor (int i)
    {
        ans = i;
        description = "A steel door blocks your path, it has a simple numeric lock";
    }
    
    //Solvedoor will take in a string that should contain an integer
    public boolean solveDoor(String s)
    {
        //If the string doesn't contain an integer an exception will be generated and false will be returned
        try
        {
            //if the integer in the string is the answer to the door the door will be unlocked, and true will be returned, else it will return false
            if(Integer.parseInt(s) == ans)
            {
                locked = false;
                return true;
            }
            return false;
        }
        catch (NumberFormatException e)
        {
            return false;
        }
    }
    
    //Returns the answer to the door, used when displaying clues in the room.
    public int getAnswer()
    {
        return ans;
    }
}