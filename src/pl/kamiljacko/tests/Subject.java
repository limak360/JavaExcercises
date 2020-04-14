package pl.kamiljacko.tests;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Subject {
    private List<Double> grades;
    private String name;

    public Subject(String name) {
        this.name = name;
        this.grades = new ArrayList<>();
    }

    public void addGrade(double grade) {
        grades.add(grade);
    }

    public double avrgGrades() {
        double avrg = 0;
        for (Double grade : grades) {
            avrg += grade.doubleValue();
        }
        return avrg/grades.size();
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Subject subject = (Subject) o;
        return name.equals(subject.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
