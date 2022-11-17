package HomeWork3Modul4;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import java.util.Date;

@Data
@AllArgsConstructor
@Builder
public class CommentDto {

    private Integer id;

    private String text;

    private Date createdAt;

    private Post post;

    private User user;
}
