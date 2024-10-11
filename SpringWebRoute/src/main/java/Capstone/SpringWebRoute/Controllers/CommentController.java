package Capstone.SpringWebRoute.Controllers;

import Capstone.SpringWebRoute.Models.Comment;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/Comment")
public class CommentController {

    public List<Comment> comments = new ArrayList<>();

    @PostMapping("/AddComment/{postId}/{userId}")
    public String addComment(@PathVariable int postId, @PathVariable int userId, @RequestBody Comment newComment) {

        newComment.setPostId(postId);
        newComment.setUserId(userId);

        comments.add(newComment);

        return "Comment added";
    }

    @GetMapping("/GetAllComments")
    public List<Comment> getAllComments() {
        return comments;
    }

    @GetMapping("/GetComment/{commentId}")
    public Comment getCommentById(@PathVariable int commentId) {

        for (Comment com : comments) {
            if (com.getCommentId() == commentId ) {
                return com;
            }
        }

        return null;
    }

    @PutMapping("/EditComment/{commentId}")
    public Comment updateComment(@PathVariable int commentId, @RequestBody Comment upComment) {

        for (Comment com : comments) {
            if (com.getCommentId() == commentId) {
                com.setComment(upComment.getComment());
                return com;
            }
        }

        return null;
    }


}
