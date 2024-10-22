package Capstone.SpringWebRoute.Service;

import Capstone.SpringWebRoute.Models.Comment;
import Capstone.SpringWebRoute.Repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {

    @Autowired
    CommentRepository commentRepo;


    public Comment getCommentById(int commentId) {
        return commentRepo.findById(commentId).get();
    }

    public List<Comment> getAllComments() {
        return commentRepo.findAll();
    }

    public List<Comment> getAllCommentsByPostId(int postId) {
        return commentRepo.getCommentByPostId(postId);
    }

    public List<Comment> getAllCommentsByUserId(int userId) {
        return commentRepo.findCommentsByUserId(userId);
    }

    public Comment save(Comment comment) {
        commentRepo.save(comment);
        return comment;
    }


}
