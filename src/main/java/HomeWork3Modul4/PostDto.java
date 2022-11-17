package HomeWork3Modul4;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@Builder
public class PostDto {

    private Integer id;

    private String text;

    private Date createdAt;

    private User user;

    private List<Comment> comment;
}
