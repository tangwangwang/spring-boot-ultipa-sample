package sample.ultipa.repository.cascade;

import org.springframework.data.ultipa.repository.UltipaRepository;
import sample.ultipa.domian.cascade.User;

import java.util.UUID;

public interface UserRepository extends UltipaRepository<User, UUID> {
}
