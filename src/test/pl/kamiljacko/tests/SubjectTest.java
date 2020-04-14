package test.pl.kamiljacko.tests;

import org.junit.jupiter.api.Test;
import pl.kamiljacko.tests.Subject;

import static org.junit.jupiter.api.Assertions.*;

class SubjectTest {

    @Test
    void shouldBeAbleToCreateNewClass(){
        assertNotNull(new Subject("Physics"));
    }


    @Test
    void shouldReturnAvrgGrades() {
        Subject subject = new Subject("Mathematics");
        subject.addGrade(3);
        subject.addGrade(5);
        subject.addGrade(4);
        assertEquals(4,subject.avrgGrades(),"returns avrg");
    }
}