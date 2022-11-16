package HomeWork3Modul4;

import lombok.*;

import javax.persistence.*;
import java.util.Date;
@Data
@AllArgsConstructor
@Builder
public class CommentDto {
    private Integer id;
    private String text;
    private Date created_at;
    private Post post;
    private User user;
}
