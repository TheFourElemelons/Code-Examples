import java.util.ArrayList;
import java.util.Arrays;

public class PasswordLockedDoor extends MazeDoor
{   
    //list of words that can be the solution to the door.
    public final static ArrayList<String> words =
        new ArrayList<>(Arrays.asList("corn", "pesto", "atlantic", "apricot", "rectangle", 
        "america", "megaphone", "monday", "birthday", "longing", 
        "rusted", "furnace", "daybreak", "seventeen", "benign", 
        "nine", "homecoming", "one", "freight", "car",
        "manage", "realize", "utter", "disease", "apparatus",
        "rich", "stale", "property", "respect", "offset",
        "relation", "eminent", "kittens", "hustle", "solve",
        "stereotyped", "likeable", "malicious", "filthy", "chalk",
        "inconclusive", "brain", "sabotage", "bead", "spiky"));
    //ans stores the answer to the door.
    String ans;
    
    //Upon creation an answer to the door will be randomly selected and the description of the room is updated.
    public PasswordLockedDoor ()    
    {
        ans = words.get((int)(Math.random() * (words.size() - 1)));
        description = "A stone door stands in front of you, a password is required to unlock it";
    }
    
    //solveDoor() takes in a string to compare to the answer, if it's correct the door is unlocked and true is returned, otherwise false is returned.
    public boolean solveDoor(String s)
    {
        if (s.equals(ans))
        {
            locked = false;
            return true;
        }
        return false;
    }
    
    //getAnswer() returns the answer to the door, primarily used in the search method of the room.
    public String getAnswer()
    {
        return ans;
    }
}