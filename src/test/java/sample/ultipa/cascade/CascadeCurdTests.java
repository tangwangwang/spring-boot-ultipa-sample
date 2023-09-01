package sample.ultipa.cascade;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import sample.ultipa.domian.cascade.Permission;
import sample.ultipa.domian.cascade.Role;
import sample.ultipa.domian.cascade.User;
import sample.ultipa.repository.cascade.PermissionRepository;
import sample.ultipa.repository.cascade.RoleRepository;
import sample.ultipa.repository.cascade.UserRepository;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class CascadeCurdTests {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private PermissionRepository permissionRepository;

    private User generateCascadeUser() {
        User bob = new User("Bob");
        Role role = new Role("admin");
        Permission queryMenu = new Permission("query_menu");
        Permission createMenu = new Permission("create_menu");
        Permission updateMenu = new Permission("update_menu");
        Permission deleteMenu = new Permission("delete_menu");

        role.setPermissions(Arrays.asList(queryMenu, createMenu, updateMenu, deleteMenu));

        bob.setRoles(Collections.singletonList(role));

        return bob;
    }

    @Test
    public void create() {
        User user = generateCascadeUser();

        try {
            User saved = userRepository.save(user);

            assertThat(saved).extracting(User::getUsername).isEqualTo("Bob");
            assertThat(saved.getRoles()).extracting(Role::getName).containsOnlyOnce("admin");
            assertThat(saved.getRoles().get(0).getPermissions()).extracting(Permission::getName).containsOnlyOnce("query_menu", "create_menu", "update_menu", "delete_menu");

        } finally {
            permissionRepository.deleteAll();
            roleRepository.deleteAll();
            userRepository.deleteAll();
        }
    }

    @Test
    public void update() {
        User saved = userRepository.save(generateCascadeUser());

        try {
            saved.setUsername("Jason");
            saved.getRoles().get(0).setName("user");
            List<Permission> permissions = saved.getRoles().get(0).getPermissions();
            permissions.add(new Permission("test_menu"));
            User updated = userRepository.save(saved);

            assertThat(updated).extracting(User::getUsername).isEqualTo("Jason");
            assertThat(updated.getRoles()).extracting(Role::getName).containsOnlyOnce("user");
            assertThat(updated.getRoles().get(0).getPermissions()).extracting(Permission::getName).containsOnlyOnce("query_menu", "create_menu", "update_menu", "delete_menu");

        } finally {
            permissionRepository.deleteAll();
            roleRepository.deleteAll();
            userRepository.deleteAll();
        }
    }

    @Test
    public void read() {
        User saved = userRepository.save(generateCascadeUser());

        try {
            User user = userRepository.findById(saved.getId()).orElse(null);

            assertThat(user).isNotNull().extracting(User::getUsername).isEqualTo("Bob");
            assertThat(user.getRoles()).extracting(Role::getName).containsOnlyOnce("admin");
            assertThat(user.getRoles().get(0).getPermissions()).extracting(Permission::getName).containsOnlyOnce("query_menu", "create_menu", "update_menu", "delete_menu");

        } finally {
            permissionRepository.deleteAll();
            roleRepository.deleteAll();
            userRepository.deleteAll();
        }
    }

}
