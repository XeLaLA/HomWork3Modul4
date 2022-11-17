package HomeWork3Modul4;

import lombok.*;
import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "user_table", schema = "public")
@Data
@NoArgsConstructor
@RequiredArgsConstructor

public class User {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(unique = true, nullable = false)
    @NonNull
    private String name;

    @Column(nullable = false)
    @NonNull
    private String password;

    @Column
    private Date  createdAt = new Date();

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user", cascade = CascadeType.ALL)
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private List<Post> post;

    @OneToMany(mappedBy = "user")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private List<Comment> comment;
}
