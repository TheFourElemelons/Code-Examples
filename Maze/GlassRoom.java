public class GlassRoom extends Room
{
    //Upon creation the description of the room will be updated, and the doors for the room will be created with the createDoors() method.
    public GlassRoom()
    {
        desc = "You enter the glass room is and notice it is oddly opaque, giving nothing away as to the greater structure of the maze, except for the other glass doors in the room.";
        createDoors();
    }
    
    //Creates doors for the room, adding three doors to the arrayList.
    public void createDoors()
    {
        for(int i = 0; i < 3; i++)
        {
            doors.add(new QuizLockedDoor());
        }
    }
    
    //search method will return what the player finds in the room frmo the search method.
    public String search()
    {
        return "You wander the room searching for some clue to the questions posed.  It dawns on you as you stare at your reflection on the glass walls. What is life? Why have I been confined to these rooms, forced to solve them over and over again?  This question scares you and you return to the doors to distract yourself from your own mind.";
    }
}