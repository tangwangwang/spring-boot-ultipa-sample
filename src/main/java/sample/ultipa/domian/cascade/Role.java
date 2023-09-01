package sample.ultipa.domian.cascade;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.ultipa.annotation.CascadeType;
import org.springframework.data.ultipa.annotation.Left;
import org.springframework.data.ultipa.annotation.Node;
import org.springframework.data.ultipa.annotation.Right;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Data
@Node
public class Role {

    @Id
    private UUID id;

    private String name;

    @Right(edge = "role_to_permission", cascade = CascadeType.ALL)
    private List<Permission> permissions = new ArrayList<>();

    @Left("user_to_role")
    private List<User> users = new ArrayList<>();

    public Role() {
    }

    public Role(String name) {
        this.name = name;
    }
}
