import javax.swing.event.InternalFrameListener;
import java.util.*;
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

        persons.stream()
                .filter(x -> x.getAge() > 17).count();
        persons.stream()
                .filter(x -> x.getAge() > 17)
                .filter(x -> x.getAge() > 27)
                .filter(x -> x.getSex() == Sex.MAN).collect(Collectors.toList());
        persons.stream()
                .filter(x -> x.getSex() == Sex.MAN)
                .filter(x -> x.getAge() > 17)
                .filter(x -> x.getAge() < 65)
                .filter(x -> x.getEducation() == Education.HIGHER).collect();
        persons.stream()
                .filter(x -> x.getSex() == Sex.WOMAN)
                .filter(x -> x.getAge() > 17)
                .filter(x -> x.getAge() < 60)
                .filter(x -> x.getEducation() == Education.HIGHER).collect();

    }
}