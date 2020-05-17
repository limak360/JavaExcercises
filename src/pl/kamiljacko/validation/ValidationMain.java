package pl.kamiljacko.validation;


import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import javax.validation.constraints.Email;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.Objects;
import java.util.Scanner;

public class ValidationMain {
    public static void main(String[] args) {
        ValidatorFactory validationFactory = Validation.buildDefaultValidatorFactory();
        Validator validator = validationFactory.getValidator();

        User user = getUserFromInput();

        for (ConstraintViolation<User> cv : validator.validate(user)) {
            System.err.println(cv.getPropertyPath().toString() + " " + cv.getMessage());
        }
    }

    private static User getUserFromInput() {
        Scanner input = new Scanner(System.in);
        input.useDelimiter(System.lineSeparator());
        System.out.println("Podaj imię: ");
        String name = input.nextLine();

        System.out.println("Podaj datę urodzenia (YYYY-MM-dd hh:mm): ");
        LocalDateTime birthday = LocalDateTime.parse(
                input.next("\\d{4}-\\d{2}-\\d{2} \\d{2}:\\d{2}"),
                new DateTimeFormatterBuilder()
                        .append(DateTimeFormatter.ISO_LOCAL_DATE)
                        .appendLiteral(' ')
                        .append(DateTimeFormatter.ISO_LOCAL_TIME)
                        .toFormatter()
        );

        System.out.println("Podaj adres email: ");
        String email = input.nextLine();

        return new User(name, email, birthday);
    }
}

//        imię powinno mieć długość co najmniej 3 liter,
//        imię powinno zaczynać się od wielkiej litery,
//        imię powinno składać się wyłącznie z liter,
//        data urodzenia powinna być w przeszłości,
//        użytkownik powinien mieć co najmniej 4 lata.

class User {
    @Size(min = 3)
    @Pattern(regexp = "[A-Z][a-z]+")
    private String name;
    @Email
    private String email;
    @Past
    @AtLeast4YearsOld
    private LocalDateTime birthday;

    public User(@Size(min = 3) @Pattern(regexp = "[A-Z][a-z]+") String name, @Email String email, @Past LocalDateTime birthday) {
        this.name = name;
        this.email = email;
        this.birthday = birthday;
    }
}