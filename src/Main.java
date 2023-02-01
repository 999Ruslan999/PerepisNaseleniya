import javax.swing.event.InternalFrameListener;
import java.util.*;
import java.util.random.RandomGenerator;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        List<String> names = Arrays.asList("Jack", "Connor", "Harry", "George", "Samuel", "John");
        List<String> families = Arrays.asList("Evans", "Young", "Harris", "Wilson", "Davies", "Adamson", "Brown");

        Collection<Person> persons = new ArrayList<>();
        for (int i = 0; i < 10_000_000; i++) {
            persons.add(new Person(
                    names.get(new Random().nextInt(names.size())),
                    families.get(new Random().nextInt(families.size())),
                    new Random().nextInt(100),
                    Sex.values()[new Random().nextInt(Sex.values().length)],
                    Education.values()[new Random().nextInt(Education.values().length)])
            );
        }

       long list = persons.stream()
                .filter(x -> x.getAge() < 18).count(); // 17 лет, это не совершенно летний, нужно включить его в фильтр
        System.out.println(list);
       List<Person> priziv = persons.stream()
                .filter(x -> x.getAge() > 17 && x.getAge() < 27) // с 18 лет включительно призывной возраст до 26 лет включительно
                .filter(x -> x.getSex() == Sex.MAN).collect(Collectors.toList());
        System.out.println(priziv);
       List<Person> rabota = persons.stream()
                .filter(education -> education.getEducation().equals(Education.HIGHER))
                .filter(ege -> ege.getAge() > 18)
                .filter(age -> (age.getAge() < 65) && age.getSex().equals(Sex.MAN) || (age.getAge() < 60) && age.getSex().equals(Sex.WOMAN))
                .sorted(Comparator.comparing(Person::getFamily))
                .collect(Collectors.toList());
        System.out.println(rabota);




    }
}