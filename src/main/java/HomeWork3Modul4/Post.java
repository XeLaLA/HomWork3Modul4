package HomeWork3Modul4;

import lombok.*;
import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "post", schema = "public")
@Data
@NoArgsConstructor
@RequiredArgsConstructor

public class Post {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column (nullable = false)
    @NonNull
    private String text;

    @Column
    private Date createdAt = new Date();

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", nullable = false)
    @NonNull
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private User user;

    @OneToMany(mappedBy = "post")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private List<Comment> comment;
}
