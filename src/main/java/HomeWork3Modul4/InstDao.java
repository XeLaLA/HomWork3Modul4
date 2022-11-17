package HomeWork3Modul4;

import lombok.extern.slf4j.Slf4j;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import java.io.Closeable;
import java.io.Serializable;

@Slf4j
public class InstDao implements Closeable {
    private final Session session;

    public InstDao() {
       SessionFactory sessionFactory = HibernateConfig.createSessionFactory();
       session = sessionFactory.openSession();
    }

    public Integer addNewUser(User user) {
        session.beginTransaction();
        session.save(user);
        session.getTransaction().commit();
        session.clear();
        return user.getId();
    }

    public Integer addNewPost(Post post) {
        session.beginTransaction();
        session.save(post);
        session.getTransaction().commit();
        session.clear();
        return post.getId();
    }

    public Integer addNewComment(Comment comment) {
        session.beginTransaction();
        session.save(comment);
        session.getTransaction().commit();
        session.clear();
        return comment.getId();
    }

    public UserDto getUser(Serializable idUser) {
        session.beginTransaction();
        User user = session.load(User.class, idUser);
        Hibernate.initialize(user.getPost());
        Hibernate.initialize(user.getComment());
        UserDto userDto = UserDto.builder()
                .id(user.getId())
                .name(user.getName())
                .password(user.getPassword())
                .createdAt(user.getCreatedAt())
                .post(user.getPost())
                .comment(user.getComment())
                .build();
        session.getTransaction().commit();
        session.clear();
        return userDto;
    }

    public PostDto getPost(Serializable idPost) {
        session.beginTransaction();
        Post post = session.get(Post.class, idPost);
        Hibernate.initialize(post.getUser());
        Hibernate.initialize(post.getComment());
        PostDto postDto = PostDto.builder()
                .id(post.getId())
                .text(post.getText())
                .createdAt(post.getCreatedAt())
                .user(post.getUser())
                .comment(post.getComment())
                .build();
        session.getTransaction().commit();
        session.clear();
        return postDto;
    }

    public CommentDto getComment(Serializable idComment) {
        session.beginTransaction();
        Comment comment = session.get(Comment.class, idComment);
        Hibernate.initialize(comment.getUser());
        Hibernate.initialize(comment.getPost());
        CommentDto commentDto = CommentDto.builder()
                .id(comment.getId())
                .text(comment.getText())
                .createdAt(comment.getCreatedAt())
                .post(comment.getPost())
                .user(comment.getUser())
                .build();
        session.getTransaction().commit();
        session.clear();
        return commentDto;
    }

    @Override
    public void close() {
            if (session != null) {
                try {
                    session.close();
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
    }
}
