package HomeWork3Modul4;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "comment", schema = "public")
@Data
@NoArgsConstructor
@RequiredArgsConstructor

public class Comment {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column()
    private String text;
    @Column
    private Date created_at = new Date();
    @ManyToOne
    @JoinColumn(name = "post_id", nullable = false)
    @NonNull
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Post post;
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    @NonNull
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private User user;

    public Comment(String text, @NonNull Post post, @NonNull User user) {
        this.text = text;
        this.post = post;
        this.user = user;
    }
}
