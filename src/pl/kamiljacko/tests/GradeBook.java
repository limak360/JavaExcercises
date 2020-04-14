package pl.kamiljacko.tests;


import java.util.ArrayList;
import java.util.List;

public class GradeBook {

    private List<Subject> subjects;

    public GradeBook() {
        this.subjects = new ArrayList<>();
    }

    public void addSubject(Subject subject) {
        if (subjects.contains(subject)) {
            throw new IllegalArgumentException("Subject is already in");
        }
        subjects.add(subject);
    }

    public Subject getSubject(String name) {
        for (Subject subject : subjects) {
            if (subject.getName().equals(name)) {
                return subject;
            }
        }
        throw new IllegalArgumentException("There is no such subject");
    }

    public double avrgGradesOfBook() {
        double avrg = 0.0;
        for (Subject subject : subjects) {
            avrg += subject.avrgGrades();
        }
        return avrg / subjects.size();
    }
}
