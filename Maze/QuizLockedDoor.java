import java.util.Map;
import java.util.AbstractMap;
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import java.util.stream.*;

public class QuizLockedDoor extends MazeDoor
{
    //questions stores both the question to ask the player and the answer to the question, multiple answers are stored in the case of multiple accepted answers, such as the number 6 and the word six.
    public final static Map<String, List<String>> questions = Stream.of(
    new AbstractMap.SimpleEntry<>("When Michael Jordan played for the Chicago Bulls, how many NBA Chamionships did he win?", Arrays.asList(new String[]{"6", "six"})),
    new AbstractMap.SimpleEntry<>("Which Williams sister has won more Grand Slam titles?", Arrays.asList(new String[]{"serena", "serena williams"})),
    new AbstractMap.SimpleEntry<>("Which Hockey Team did Wayne Gretzky play for in the '80s?", Arrays.asList(new String[]{"edmonton", "oilers", "edmonton oilers"})),
    new AbstractMap.SimpleEntry<>("How many soccer players should each team have on the field at the start of each match?", Arrays.asList(new String[]{"11", "eleven"})),
    new AbstractMap.SimpleEntry<>("What Year was the vary first model of iPhone released?", Arrays.asList(new String[]{"2007", "07"})),
    new AbstractMap.SimpleEntry<>("What does \"HTTP\" stand for?", Arrays.asList(new String[]{"hypertext transfer protocol", "hyper text transfer protocol", "hyper-text transfer protocol"})),
    new AbstractMap.SimpleEntry<>("Google Chrome, Safari, Firefox, and Explorer are different types of what?", Arrays.asList(new String[]{"web browsers", "browsers", "internet browsers"})),
    new AbstractMap.SimpleEntry<>("Who is often called the father of the computer?", Arrays.asList(new String[]{"charles babbage"})),
    new AbstractMap.SimpleEntry<>("What is meteorology the study of?", Arrays.asList(new String[]{"the weather", "weather"})),
    new AbstractMap.SimpleEntry<>("Who was the first woman to win a Nobel Prize(in 1903)?", Arrays.asList(new String[]{"marie curie", "curie"})),
    new AbstractMap.SimpleEntry<>("What famous '60s Rock song did Ferris sing on his day off in front of thousands?", Arrays.asList(new String[]{"twist and shout", "twist and shout by the beatles", "twist and shout the beatles", "twist and shout beatles"})),
    new AbstractMap.SimpleEntry<>("Which popular TV show featured house Targaryen and Stark?", Arrays.asList(new String[]{"game of thrones", "got"})),
    new AbstractMap.SimpleEntry<>("How many Lord of the Rings files are there?", Arrays.asList(new String[]{"3", "three"})),
    new AbstractMap.SimpleEntry<>("Which cartoon character lives in a pineapple under the sea?", Arrays.asList(new String[]{"spongebob squarepant", "spongebob"})))
    .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    
    //question will store the question that the player is asked to get the answer to the question later on.
    String question;
    
    public QuizLockedDoor ()
    {
        //Gets a random key from the map of questions, to ask the player.
        List<String> keys = new ArrayList<>(questions.keySet());
        question = keys.get((int)(Math.random() * keys.size()));
        
        //Sets the description of the door with the question in the description.
        description = "The glass door holds a quiz, once you answer it the door will unlock. The quiz reads ... " + question;
    }
    
    //solveDoor() will take in a string to check to see if it is an accepted answer to the question.
    public boolean solveDoor(String s)
    {
        //checks if the string is in the list of accepted answers, if it is the door is unlocked, and true is returned, otherwise false is returned.
        if(questions.get(question).contains(s))
        {
            locked = false;
            return true;
        }
        return false;
    }
}