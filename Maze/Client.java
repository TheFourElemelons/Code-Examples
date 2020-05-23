import java.util.Scanner;

public class Client
{
    public static void main(String [] args)
    {
        //room is used to hold the current room the player is in. in is used to get the players input.  user will store the player's response.
        Room room = getRandomRoom();
        Scanner in = new Scanner(System.in);
        String user = "";
        
        //Prints out the description of the first room the player is in.
        System.out.println("Welcome to the Maze!\nFollow the instructions on screen and enter the keys indicated to procede.\n" + room.getDescription());
        
        //Sentinel while loop on the players input, looking for Q for them to quit.
        while(!user.equals("Q"))
        {
            //Gives the player's their options and gets their response.
            System.out.print("What would you like to do?\nInspect a door - I\nSearch the Room - S\nQuit the Maze - Q\n- "); 
            user = in.nextLine().toUpperCase();
            
            //Checks the player's response, if it isn't one of the options prints an error message.
            if(user.equals("I"))
            {
                //Entering I will inspect one of the doors, player then has to choose what door they want to inspect.
                System.out.print("What door would you like to look at?\nLeft - 1\nForward - 2\nRight - 3\n- ");
                
                //checkIntInput will get the player's input and check that it is a valid input.
                int roomNum = checkIntInput(in, 3);
                
                //Will get the description from inspecting the desired door.
                System.out.println(room.inspectDoor(roomNum));
                
                //userEntry will check their input for what they would like to do to the selected door, returning to the room menu when a 4 is entered.
                int userEntry = 0;
                while(userEntry != 4)
                {
                    //Gives the player their options for the selected door.
                    System.out.print("What would you like to do with the door?\nOpen - 1\nSolve - 2\nInspect - 3\nReturn to Room - 4\n- ");
                
                    //Retrieves their input into user entry.
                    userEntry = checkIntInput(in, 4);
                    if (userEntry == 1)
                    {
                        //When the player tries to open a door that door will be check to see if it's unlocked, if it is they will advance to the next randomly determined room.
                        if(!room.isLocked(roomNum))
                        {
                            //A new room is created and the player is taken to that room.
                           System.out.println("The door is open and you advance through to the next room.");
                           room = getRandomRoom();
                           userEntry = 4;
                           System.out.println(room.getDescription());
                        }
                        else
                        {
                            //The player is told that the door is still locked, and are taken back to the selection menu for the door.
                            System.out.println("The door is still locked.");
                        }
                    }
                    else if (userEntry == 2)
                    {
                        //The player wishes to try and solve the door, so their input is taken and the door solution is attempted.
                        System.out.print("Enter your answer.\n- ");
                        user = in.nextLine().trim();
                        
                        //solveDoor will return a boolean if the door is open, and will print the response.
                        if(room.solveDoor((roomNum), user))
                        {
                            System.out.println("The door is open!");
                        }
                        else
                        {
                            System.out.println("The door is still locked.");
                        }
                    }
                    else if (userEntry == 3)
                    {
                        //Prints out the description of the selected door.
                        System.out.println(room.inspectDoor(roomNum) + "\n");
                    }
                    else if (userEntry != 4)
                    {
                        //If the player inputs 4 the loop will break without anything being printed out. If it's anything else the loop will continue, and an invalid input message will be sent.
                        System.out.print("Invalid input, please enter the number associated with your desired choice.\n-");
                    }
                }
            }
            else if(user.equals("S"))
            {
                //Prints out the result of searching the room.
                System.out.println(room.search());
            }
            else if(user.equals("Q"))
            {
                //The player wants to quit the maze, the loop will break and the program will end.
                System.out.println("I knew you would give up eventually!");
            }
            else
            {
                //If anything else is entered an invalid input message will be printed.
                System.out.println("Incorrect entry.");
            }
        }
    }
    
    //Get random room will return a room object that is one of the four types of rooms in the maze, determined at random.
    public static Room getRandomRoom()
    {
        //Randomly selects the type of room to be created and returned.
        int type = (int)(Math.random() * 4);
        if (type == 0)
        {
            return new WoodenRoom();
        }
        else if (type == 1)
        {
            return new SteelRoom();
        }
        else if (type == 2)
        {
            return new BrickRoom();
        }
        else
        {
            return new GlassRoom();
        }
    }
    
    //Checks if the the player input a valid integer for their response to a question.
    public static int checkIntInput(Scanner in, int upperBound)
    {
        //userInput will store the int that the player enters.
        int userInput;
        
        //Checks if the number entered is an integer, if it's not an error message will be printed.
        while(!in.hasNextInt())
        {
            //in.nextLine() will take in the player's response even if it isn't an integer, empting the buffer.
            in.nextLine();
            System.out.print("Invalid input, please enter the number associated with your desired choice.\n-");
        }
        
        //Takes in the player's response as it is an integer.
        userInput = in.nextInt();
        //Takes in the newLine() character that is left in the buffer.
        in.nextLine();
        
        //Checks if the player's input is between the bounds set by the client, printing an error message if it isn't.
        while(userInput < 1 || userInput > upperBound)
        {
            System.out.print("Invalid input, please enter the number associated with your desired choice.\n-");
                    
            //Checks if the user's new entry is an integer, printing an error message if it isn't an integer
            while(!in.hasNextInt())
            {
               //Consumes what is left in the buffer leaving it clean for the next iteration of the loop.
               in.nextLine();
               System.out.print("Invalid input, please enter the number associated with your desired choice.\n-");
            }
                   
            //Takes in the player's input which is an integer, and the next iteration of the loop will check if it's between the bounds set by the client.
            userInput = in.nextInt();
            in.nextLine();
        } 
        
        //Returns the user's input, which has been checked that it is valid within the confines set by the client.
        return userInput;
    }
}