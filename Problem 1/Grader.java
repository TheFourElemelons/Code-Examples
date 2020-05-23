public class Grader
{
    public static void main (String [] args)
    {
        //Creates the course for Database Systems, giving it an instance of TestBehaviorA as the grading scheme.
        Course databases = new Course("Database Systems", "CS-3710");
        databases.setBehavior(new TestBehaviorA());

        //Creates a new student, adding various grades for assignments and exams.
        Student ryan = new Student("Ryan");
        ryan.addAssignmentScore(databases, 80.5);
        ryan.addAssignmentScore(databases, 79.6);
        ryan.addAssignmentScore(databases, 75.3);
        ryan.addExamScore(databases, 35.8);
        ryan.addExamScore(databases, 40.8);

        //Calculates the final grade of the course, using the grading scheme TestBehaviorA.
        System.out.printf("Ryan got a %.2f%% in %s using scheme A%n", databases.getFinalGrade(ryan), databases.getCourseName());

        //Switches the grading scheme to TestBehaviorB, then recalculates the final grade.
        databases.setBehavior(new TestBehaviorB());
        System.out.printf("Ryan got a %.2f%% in %s using scheme B%n", databases.getFinalGrade(ryan), databases.getCourseName());
    }
}