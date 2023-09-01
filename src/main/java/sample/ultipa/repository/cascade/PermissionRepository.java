package sample.ultipa.repository.cascade;

import org.springframework.data.ultipa.repository.UltipaRepository;
import sample.ultipa.domian.cascade.Permission;

import java.util.UUID;

public interface PermissionRepository extends UltipaRepository<Permission, UUID> {
}
