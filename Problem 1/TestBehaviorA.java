import java.util.ArrayList;

public class TestBehaviorA implements TestBehavior
{
    /*
    calculateGrade will follow the grading scheme of assignments are worth 60% of the final grade, exams are worth 40%
    of the final grade.
    */
    public double calculateGrade(ArrayList<Double> assignments, ArrayList<Double> exams)
    {
        //Creates variables for the assignment average, exam average.
        double aAverage = 0.0, eAverage = 0.0;

        //Iterates through the assignment grades, calculating the average of the grades.
        for(double grade : assignments)
        {
            aAverage += grade;
        }
        aAverage /= assignments.size();

        //Iterates through the exam grades, calculating the average of the grades.
        for(double grade : exams)
        {
           eAverage += grade;
        }
        eAverage /= exams.size();

        //Calculates and returns the final grade of the course with the averages of assignments and the exams.
        return ((0.4 * aAverage) + (0.6 * eAverage));
    }
}
