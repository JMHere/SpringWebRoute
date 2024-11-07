package Capstone.SpringWebRoute.Controllers;

import Capstone.SpringWebRoute.Models.Comment;
import Capstone.SpringWebRoute.Models.Post;
import Capstone.SpringWebRoute.Service.CommentService;
import Capstone.SpringWebRoute.Service.PostService;
import Capstone.SpringWebRoute.Service.UserPageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/Comment")
public class CommentController {

    @Autowired
    CommentService commentSer;

    @Autowired
    PostService postService;

    @Autowired
    UserPageService userPageService;

    @PostMapping("/AddComment/{postId}/{userId}")
    public String addComment(@PathVariable int postId, @PathVariable int userId, @RequestBody Comment newComment) {

        newComment.setPost(postService.getPostById(postId));
        newComment.setUserId(userId);
        newComment.setUsername(userPageService.findUserPageByUserId(userId).getUsername());
        newComment.setCommentDate(addDate());
        commentSer.save(newComment);
        postService.getPostById(postId).addComment(newComment);


        return "Comment added";
    }

    public Date addDate() {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Date curentDate = new Date();
        return curentDate;
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
