package HomeWork3Modul4;

import lombok.*;
import java.util.Date;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
public class UserDto {

    private Integer id;

    private String name;

    private String password;

    private Date createdAt;

    private List<Post> post;

    private List<Comment> comment;
}
