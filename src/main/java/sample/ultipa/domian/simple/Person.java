package sample.ultipa.domian.simple;

import com.ultipa.sdk.data.Point;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.ultipa.annotation.Node;

import java.time.LocalDate;
import java.util.UUID;

@Data
@Node("person")
public class Person {

    @Id
    private UUID id;

    private String name;

    private Gender gender;

    private LocalDate birthday;

    private Short age;

    private Point location;

    public enum Gender {
        MAN, WOMAN, UNKNOWN
    }
}
