import java.util.ArrayList;

//TestBehavior is used to implement different grading schemes at run time for different courses.
public interface TestBehavior
{
    double calculateGrade(ArrayList<Double> assignments, ArrayList<Double> exams);
}