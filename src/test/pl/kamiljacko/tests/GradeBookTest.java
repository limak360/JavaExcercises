package test.pl.kamiljacko.tests;

import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pl.kamiljacko.tests.GradeBook;
import pl.kamiljacko.tests.Subject;

import static org.junit.jupiter.api.Assertions.*;

class GradeBookTest {

    private GradeBook gradeBook;

    @Test
    void shouldBeAbleToCreateNewClass() {
        assertNotNull(new GradeBook());
    }

    @Test
    void shouldntAllowToAddSubjectThatAlreadyExists() {
        GradeBook gradeBooks = new GradeBook();
        gradeBooks.addSubject(new Subject("P.E."));
        assertThrows(IllegalArgumentException.class, () -> gradeBooks.addSubject(new Subject("P.E.")));
    }

    @BeforeEach
    void grades() {
        this.gradeBook = new GradeBook();
        Subject s1 = new Subject("Math");
        s1.addGrade(4.5);
        s1.addGrade(2);
        s1.addGrade(5);
        gradeBook.addSubject(s1);
        Subject s2 = new Subject("P.E");
        s2.addGrade(3);
        s2.addGrade(3.5);
        gradeBook.addSubject(s2);
    }

    @Test
    void shouldGetEqualSubject() {
        assertEquals(new Subject("Math"), gradeBook.getSubject("Math"));
    }

    @Test
    void shouldntAllowToGetNonExistingSubject() {
        assertThrows(IllegalArgumentException.class, () -> gradeBook.getSubject("wt"));
    }

    @Test
    void shouldBeAbleToCountAvarageOfGradesInBook() {
        assertEquals(3.54, gradeBook.avrgGradesOfBook(), 0.01);
    }
}