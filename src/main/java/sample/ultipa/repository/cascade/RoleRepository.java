package sample.ultipa.repository.cascade;

import org.springframework.data.ultipa.repository.UltipaRepository;
import sample.ultipa.domian.cascade.Role;

import java.util.UUID;

public interface RoleRepository extends UltipaRepository<Role, UUID> {
}
