package theo.dev.manageMaster.entities;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="users")
public class TenantsUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String role;
    private String email;
    private String status;
    public  String permissions;
    @Column(name = "owner_id")
    private long ownerId;
}
