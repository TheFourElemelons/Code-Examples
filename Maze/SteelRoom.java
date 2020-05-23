import java.util.ArrayList;
import java.util.Arrays;

public class SteelRoom extends Room
{
    //range is the range of numbers that the solution can be.
    final int range = 9999;
    //places are used when searching the room to give a little more immersion to the player.
    final ArrayList<String> places = new ArrayList<>(Arrays.asList(
        "Under a loose floor board", "Behind a bannister", "Carved in a wall", "On some paper crumpled in the corner",
        "Circled in a book on a shelf", "On the floor under the carpet written in a strange liquid (No you can't lick it)",
        "On your forearm", "On a priceless painting (Probably worthless now)"));
    String clues;
    
    //Upon creation the description of the room will be updated and the doors for the room will be created.
    public SteelRoom()
    {
        desc = "As you walk in the room you notice it is made completely of steel, a metal door is on each of the walls of the room.";
        createDoors();
    }
        
    //Creates three doors will random integers as answers.
    public void createDoors()
    {
        for(int i = 0; i < 3; i++)
        {
            doors.add(new NumericLockedDoor((int)(Math.random() * range)));
        }
    }
    
    //Search will return a string of the information the player gathers from the room.
    public String search()
    {
        //Checks clues have already been created, if they haven't they are created, this ensure they are only created once.
        if (clues == null)
        {
            //Gives a random value to each room to be printed on.
            int room1 = (int)(Math.random() * 6), room2 = (int)(Math.random() * 6), room3 = (int)(Math.random() * 6);
        
            //Checks that two rooms don't have the same position.
            while(room1 == room2 || room2 == room3 || room1 == room3)
            {
                room1 = (int)(Math.random() * 6); 
                room2 = (int)(Math.random() * 6); 
                room3 = (int)(Math.random() * 6);
            }
        
            //clues will be returned at the end will the completed string of clues given to the player.
            String clues = "";
        
            //Provides 6 clues for the player to find.
            for (int i = 0; i < 6; i++)
            {
                //Once the loop is on the number randomly assigned to each room the clue for that solution will be provided, this ensures a random order of solutions and random clues.
                if (i == room1)
                {
                    //Each clue added will have the same format, a random place is retrieved, followed by either a random number, or an answer to one of the doors.
                    clues += places.get((int)(Math.random() * places.size())) + " you found the number " + ((NumericLockedDoor)doors.get(0)).getAnswer() + ".\n";
                } 
                else if (i == room2)
                {
                    clues += places.get((int)(Math.random() * places.size())) + " you found the number " + ((NumericLockedDoor)doors.get(1)).getAnswer() + ".\n";
                } 
                else if (i == room3)
                {
                    clues += places.get((int)(Math.random() * places.size())) + " you found the number " + ((NumericLockedDoor)doors.get(2)).getAnswer() + ".\n";
                }
                else
                {
                    //Same as the clues generated above, just with a random integer within the range.
                    clues += places.get((int)(Math.random() * places.size())) + " you found the number " + ((int)(Math.random() * range)) + ".\n";
                }
            }
        }
        
        //Returns the clues generated.
        return clues;
    }
}