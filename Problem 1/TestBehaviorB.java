import java.util.ArrayList;

public class TestBehaviorB implements TestBehavior
{
    /*
    calculateGrade will follow the grading scheme of assignments are worth 60% of the final grade, exams are worth 40%
    of the final grade, if the average of the exam portion is less than 50% the final grade will either be 60% of
    assignments, 40% of exams, or 45% whichever is lower.
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

        //Calculates the final grade of the course with the averages of assignments and the exams.
        double finalGrade = ((0.4 * aAverage) + (0.6 * eAverage));

        /*
        If the student failed the exam portion of the course, and the 45 was lower than the final grade return 45,
        otherwise the final calculated grade will be returned.
         */
        if (eAverage < 50 && finalGrade >= 45)
        {
            return 45;
        }
        else
        {
            return finalGrade;
        }
    }
}
