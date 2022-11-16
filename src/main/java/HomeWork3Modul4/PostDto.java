package HomeWork3Modul4;

import lombok.*;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@Builder
public class PostDto {
    private Integer id;
    private String text;
    private Date created_at;
    private User user;
    private List<Comment> comment;
}
