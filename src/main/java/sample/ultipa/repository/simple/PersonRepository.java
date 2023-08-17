package sample.ultipa.repository.simple;

import org.springframework.data.ultipa.repository.UltipaRepository;
import sample.ultipa.domian.simple.Person;

import java.util.UUID;

public interface PersonRepository extends UltipaRepository<Person, UUID> {
}
