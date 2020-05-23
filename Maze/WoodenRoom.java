public class WoodenRoom extends Room
{   
    //WoodenRooms contain wooden doors, upon creation the doors are created, and the description of the room is updated.
    public WoodenRoom()
    {
        desc = "You find yourself in a wooden room that contains a few pieces of funiture, as well as three additional doors on each side of the room.";
        createDoors();
    }
    
    //createDoors will add three new simpleDoors to arrayList of doors in the room.
    public void createDoors()
    {
        for(int i = 0; i < 3; i++)
        {
            doors.add(new SimpleDoor());
        }
    }
    
    //Search will return a basic description of the room as there is nothing to be found in a woodenRoom.
    public String search()
    {
        return "You look around the room, marvelling at the craftsmenhip of the wood, the furniture in this place is quite luxurious but doesn't seem to be hiding anything.";
    }
}