package pl.KamilJacko.lambdaExpressions;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.*;

public class JavaUtilFunctionPackage {

    public static void main(String[] args) {
        Employee Kamil = new Employee("Kamil Jacko", 23);
        Employee Jakub = new Employee("Jakub Markowski", 22);
        Employee Robert = new Employee("Robert Niedzwiedz", 19);
        Employee Marcin = new Employee("Marcin Chleb", 17);
        Employee Jeff = new Employee("Jeff Jackson", 27);
        List<Employee> employees = new ArrayList<>();
        employees.add(Kamil);
        employees.add(Jakub);
        employees.add(Robert);
        employees.add(Marcin);
        employees.add(Jeff);

        //forEach
        employees.forEach(employee -> {
            if (employee.getAge() > 20) {
                System.out.println(employee.getName());
            }
        });

        //predicates/suppliers
        printEmployeesByName(employees, "Employees's names starting with J", employee -> employee.getName().startsWith("J"));
        printEmployeesByName(employees, "Employees's names starting with K", employee -> employee.getName().startsWith("K"));

        IntPredicate intp = i -> i > 30;
        System.out.println(intp.test(29));
        LongPredicate lessThanMillion = l -> l < 1000000;
        LongPredicate moreThan100k = l -> l > 100000;
        System.out.println(moreThan100k.and(lessThanMillion).test(200000));

        Random random = new Random();
        Supplier<Integer> r = () -> random.nextInt(100);
        for (int i = 0; i < 5; i++) {
            System.out.println(r.get());
        }

        //Funtions
        Function<Employee, String> getLastName = employee -> employee.getName().substring(employee.getName().indexOf(' ') + 1);
        Function<Employee, String> getFirstName = employee -> employee.getName().substring(0, employee.getName().indexOf(" "));

        Random random1 = new Random();
        for (Employee employee : employees) {
            if (random1.nextBoolean()) {
                System.out.println(getLastNameOrAge(getFirstName, employee));
            } else {
                System.out.println(getLastNameOrAge(getLastName, employee));
            }
        }

        //chained
        Function<Employee, String> upperCase = employee -> employee.getName().toUpperCase();
        Function<String, String> getName = name -> name.substring(0, name.indexOf(' '));
        Function chainedFunction = upperCase.andThen(getName);
        System.out.println(chainedFunction.apply(employees.get(0)));

        IntUnaryOperator incBy7 = i -> i + 7;
        System.out.println(incBy7.applyAsInt(13));
    }

    private static String getLastNameOrAge(Function<Employee, String> getAName, Employee employee) {
        return getAName.apply(employee);
    }

    private static void printEmployeesByName(List<Employee> employees, String nameText, Predicate<Employee> nameCondition) {
        System.out.println(nameText);
        System.out.println("***************");
        for (Employee employee : employees) {
            if (nameCondition.test(employee)) {
                System.out.println(employee.getName());
            }
        }
    }
}
