package Capstone.SpringWebRoute.Controllers;

import Capstone.SpringWebRoute.Models.Comment;
import Capstone.SpringWebRoute.Models.Post;
import Capstone.SpringWebRoute.Service.CommentService;
import Capstone.SpringWebRoute.Service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/Comment")
public class CommentController {

    @Autowired
    CommentService commentSer;

    @PostMapping("/AddComment/{postId}/{userId}")
    public String addComment(@PathVariable int postId, @PathVariable int userId, @RequestBody Comment newComment) {

        //newComment.setPostId(postId);
        newComment.setUserId(userId);
        commentSer.save(newComment);
//
//        comments.add(newComment);


        return "Comment added";
    }

    @GetMapping("/GetAllComments")
    public List<Comment> getAllComments() {
        return commentSer.getAllComments();
        //return comments;
    }

    @GetMapping("/GetAllCommentsByPost/{postId}")
    public List<Comment> getAllCommentByPostId(@PathVariable int postId) {
        return commentSer.getAllCommentsByPostId(postId);
    }

    @GetMapping("/GetComment/{commentId}")
    public Comment getCommentById(@PathVariable int commentId) {


        return commentSer.getCommentById(commentId);

//        for (Comment com : comments) {
//            if (com.getCommentId() == commentId ) {
//                return com;
//            }
//        }
    }

    @PutMapping("/EditComment/{commentId}")
    public Comment updateComment(@PathVariable int commentId, @RequestBody Comment upComment) {

        Comment currentComment = commentSer.getCommentById(commentId);
        currentComment.setComment(upComment.getComment());
        commentSer.save(currentComment);

        return currentComment;
    }


}
