import java.util.ArrayList;
import java.util.HashMap;
import java.util.TreeMap;

public class Student
{
    /*
    Assignments holds an ArrayList of grades for the assignments of a given course
    Exams holds an ArrayList of grades for the assignments of the given course
     */
    private String name;
    private HashMap<Course, ArrayList<Double>> assignments;
    private HashMap<Course, ArrayList<Double>> exams;

    //Constructor assigns the name to the student, as well as creating the maps for the assignments and exams.
    public Student (String name)
    {
        this.name = name;
        assignments = new HashMap<>();
        exams = new HashMap<>();
    }

    //addAssignmentScore will add the given score to the assignment ArrayList of the given course.
    public void addAssignmentScore(Course course, double aScore)
    {
        //First checks if the map already has the given course as a key.
        if (!assignments.containsKey(course))
        {
            //If the map doesn't have the given course as a key it will create one and add the student to the course.
            assignments.put(course, new ArrayList<>());
            course.addStudent(this);
        }

        //Retrieves the ArrayList of grades for the given course and adds the grade to the ArrayList.
        assignments.get(course).add(aScore);
    }

    //addExamScore will add the given score to the assignment ArrayList of the given course.
    public void addExamScore(Course course, double eScore)
    {
        //First checks if the map already has the given course as a key.
        if (!exams.containsKey(course))
        {
            //If the mpa doesn't have the given course as a key it will create one and add the student to the course.
            exams.put(course, new ArrayList<>());
            course.addStudent(this);
        }

        //Retrieves the ArrayList of grades for the given course and adds the grade to the ArrayList.
        exams.get(course).add(eScore);
    }

    //Returns the ArrayList of assignment scores of the given course.
    public ArrayList<Double> getAssignmentGrades(Course course)
    {
        return assignments.get(course);
    }

    //Returns the ArrayList of exam scores of the given course.
    public ArrayList<Double> getExamGrades(Course course)
    {
        return exams.get(course);
    }

    //Returns the final grade of the student from the given course, using the courses grading scheme.
    public double getFinalGrade(Course course)
    {
        return course.getFinalGrade(this);
    }
}
