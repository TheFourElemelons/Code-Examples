import java.util.ArrayList;

public class Course
{
    /*
    Variables for the course name and number, as well as an ArrayList for students in the course TestBehavior is
    determined at run time, it is an interface that determines how the course will be graded by the TestBehavior
    assigned to the course.
    */
    private String name, number;
    private ArrayList<Student> students;
    private TestBehavior scheme;

    //Creates the course with the given name and number, as well as an empty ArrayList of students.
    public Course (String name, String number)
    {
        this.name = name;
        this.number = number;
        students = new ArrayList<>();
    }

    //Returns the course name.
    public String getCourseName()
    {
        return name;
    }

    //Returns the course number.
    public String getCourseNumber()
    {
        return number;
    }

    //Adds the student to the ArrayList of students enrolled in the class.
    public void addStudent(Student student)
    {
        students.add(student);
    }

    //Sets the grading scheme of the class to be whatever is given.
    public void setBehavior(TestBehavior t)
    {
        scheme = t;
    }

    //Calculates the final grade of a given student using the given grading scheme.
    public double getFinalGrade (Student student)
    {
        //Checks if a grading scheme has been set, if it hasn't then return 0.0.
        if (scheme != null)
        {
            //Uses the previously selected grading scheme giving it the ArrayList of assignment grades and exam grades.
            return scheme.calculateGrade(student.getAssignmentGrades(this), student.getExamGrades(this));
        }
        else
        {
            return 0.0;
        }
    }
}
