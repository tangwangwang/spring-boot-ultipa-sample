package sample.ultipa.domian.cascade;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.ultipa.annotation.CascadeType;
import org.springframework.data.ultipa.annotation.Node;
import org.springframework.data.ultipa.annotation.Right;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Data
@Node
public class User {

    @Id
    private UUID id;

    private String username;

    @Right(edge = "user_to_role", cascade = CascadeType.ALL)
    private List<Role> roles = new ArrayList<>();

    public User() {
    }

    public User(String username) {
        this.username = username;
    }
}
