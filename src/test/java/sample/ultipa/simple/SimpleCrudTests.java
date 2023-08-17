package sample.ultipa.simple;

import com.ultipa.sdk.data.Point;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import sample.ultipa.domian.simple.Person;
import sample.ultipa.repository.simple.PersonRepository;

import java.time.LocalDate;

@SpringBootTest
public class SimpleCrudTests {

    @Autowired
    private PersonRepository personRepository;

    @Test
    public void create() {
        Person person = new Person();
        person.setGender(Person.Gender.MAN);
        person.setBirthday(LocalDate.of(1980, 2, 2));
        person.setAge((short) (LocalDate.now().getYear() - person.getBirthday().getYear() + 1));
        person.setLocation(new Point(120.32, 73.43));
        personRepository.save(person);
    }

}
