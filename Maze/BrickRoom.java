import java.util.ArrayList;
import java.util.Arrays;

public class BrickRoom extends Room
{
    //List of places clues can be, random selected when a room is searched.
    final ArrayList<String> places = new ArrayList<>(Arrays.asList(
        "Under a loose floor board", "Behind a bannister", "Carved in a wall", "On some paper crumpled in the corner",
        "Circled in a book on a shelf", "On the floor under the carpet written in a strange liquid(No you can't lick it)",
        "On your forearm", "On a priceless painting(which is probably worthless now)"));
    //clues are stored when they are generated and returned on subsequent searches.
    String clues;
    
    //On creation the description of the room is updated and the createDoors() method is called.
    public BrickRoom()
    {
        desc = "The room you now find yourself in is made of sturdy bricks, stone doors are outlined in the wall for you to open.";
        createDoors();
    }
        
    //createDoors() will create three passwordLockedDoors and add them to the list of doors.
    public void createDoors()
    {
        for (int i = 0; i < 3; i++)
        {
            doors.add(new PasswordLockedDoor());
        }
    }
    
    //search() will return clues the player finds in the room.
    public String search()
    {
        //Checks if the clues have been generated before, creating them if they haven't been.
        if (clues == null)
        {
            //Creates a random number for each room, in the for loop whenever the number associated with a room is reached the solution to that room is printed out.
            int room1 = (int)(Math.random() * 6), room2 = (int)(Math.random() * 6), room3 = (int)(Math.random() * 6);
        
            //Checks that each room has a unique number.
            while(room1 == room2 || room2 == room3 || room1 == room3)
            {
                room1 = (int)(Math.random() * 6); 
                room2 = (int)(Math.random() * 6); 
                room3 = (int)(Math.random() * 6);
            }
        
            //Iterates through each clue, if the number is associated with one of the doors the solution to that door is printed out, otherwise a random word is selected and printed as a clue.
            for (int i = 0; i < 6; i++)
            {
                //Checks if one of the random values generated for one of the rooms has been reached the solution to that room will be printed, otherwise a random word will be selected and printed out as a clue.
                if (i == room1)
                {
                    clues += places.get((int)(Math.random() * places.size())) + " you found the word " + ((PasswordLockedDoor)doors.get(0)).getAnswer() + ".\n";
                }
                else if (i == room2)
                {
                    clues += places.get((int)(Math.random() * places.size())) + " you found the word " + ((PasswordLockedDoor)doors.get(1)).getAnswer() + ".\n";
                }
                else if (i == room3)
                {
                    clues += places.get((int)(Math.random() * places.size())) + " you found the word " + ((PasswordLockedDoor)doors.get(2)).getAnswer() + ".\n";
                }
                else
                {
                    clues += places.get((int)(Math.random() * places.size())) + " you found the word " + PasswordLockedDoor.words.get((int)(Math.random() * PasswordLockedDoor.words.size())) + ".\n";
                }
            }
        }
        
        //Returns the clue generated above.
        return clues;
    }
}