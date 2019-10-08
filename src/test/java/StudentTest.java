import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class StudentTest {

    Student newStudent;
    Student studentWithOneGrade;
    Student studentWithManyGrades;
    Student simpleStudentGrades;

    @Before
    public void setUp() {
        this.newStudent = new Student(1, "John Smith");
        this.studentWithOneGrade = new Student(2, "Fred Smith");
        this.studentWithManyGrades = new Student(3, "Cathy Smith");
        this.simpleStudentGrades = new Student(4, "Kyle Smith");
        this.simpleStudentGrades.setGrades(Arrays.asList(50, 100));
    }

    @Test
    public void newStudentConstructorPropertyInitialization() {
        assertEquals(1, this.newStudent.getId());
        assertEquals("John Smith", this.newStudent.getName());
        assertNotNull(this.newStudent.getGrades());
    }

    @Test
    public void testAddGrade() {
        studentWithOneGrade.addGrade(50);
        assertEquals(50, (long) this.studentWithOneGrade.getGrades().get(0));

        studentWithManyGrades.addGrade(100);
        studentWithManyGrades.addGrade(75);
        studentWithManyGrades.addGrade(27);
        assertEquals(100, (long) this.studentWithManyGrades.getGrades().get(0));
        assertEquals(75, (long) this.studentWithManyGrades.getGrades().get(1));
        assertEquals(27, (long) this.studentWithManyGrades.getGrades().get(2));
    }

    @Test
    public void testGetGradeAverage() {
        assertEquals(0, newStudent.getGradeAverage(), 0);
        assertEquals(75, simpleStudentGrades.getGradeAverage(), 0);
    }

}
