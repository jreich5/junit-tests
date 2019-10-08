import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class CohortTest {

    Cohort newCohort;
    Cohort cohortWithOneStudent;
    Cohort cohortWithManyStudents;
    Student s1 = new Student(1, "John Smith");
    Student s2 = new Student(2, "Kyle Smith");
    Student s3 = new Student(3, "Fred Smith");

    @Before
    public void setUp() {
        newCohort = new Cohort();
        cohortWithOneStudent = new Cohort();
        cohortWithManyStudents = new Cohort();
        s1.addGrade(100);
        s1.addGrade(0);
        s2.addGrade(100);
        s3.addGrade(0);
        cohortWithOneStudent.addStudent(s1);
        cohortWithManyStudents.addStudent(s1);
        cohortWithManyStudents.addStudent(s2);
        cohortWithManyStudents.addStudent(s3);
    }

    @Test
    public void testGettingAListOfStudents() {
        assertEquals(0, newCohort.getStudents().size());
    }

    @Test
    public void testAddingStudents() {
        assertEquals("John Smith", cohortWithOneStudent.getStudents().get(0).getName());
        assertEquals("John Smith", cohortWithManyStudents.getStudents().get(0).getName());
        assertEquals("Kyle Smith", cohortWithManyStudents.getStudents().get(1).getName());
        assertEquals("Fred Smith", cohortWithManyStudents.getStudents().get(2).getName());
    }

    @Test
    public void testCohortAverage() {
        assertEquals("cohort with one student with grades 100 and 0 should have an average of 50", 50, cohortWithOneStudent.getCohortAverage(), 0);
        assertEquals("cohort with many students with grades 100, 0, 100, 0 should have an average of 50", 50, cohortWithManyStudents.getCohortAverage(), 0);

    }

}
