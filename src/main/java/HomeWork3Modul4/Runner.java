package HomeWork3Modul4;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Runner {
    public static void main(String[] args) {

        InstDao instDao= new InstDao();
        User newUser = new User("Ask","1234");
        Post newPost = new Post("Text", newUser);
        Comment newComment = new Comment("Text", newPost, newUser);
        instDao.addNewUser(newUser);
        log.info(newUser.toString());
        instDao.addNewPost(newPost);
        log.info(newPost.toString());
        instDao.addNewComment(newComment);
        log.info(newComment.toString());
        UserDto user = instDao.getUser(1);
        log.info(user.toString());
        PostDto post = instDao.getPost(1);
        log.info(post.toString());
        CommentDto comment = instDao.getComment(1);
        log.info(comment.toString());
        instDao.close();
    }
}
