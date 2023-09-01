package sample.ultipa.domian.cascade;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.ultipa.annotation.Left;
import org.springframework.data.ultipa.annotation.Node;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Data
@Node
public class Permission {

    @Id
    private UUID id;

    private String name;

    @Left("role_to_permission")
    private List<Role> roles = new ArrayList<>();

    public Permission() {
    }

    public Permission(String name) {
        this.name = name;
    }
}
