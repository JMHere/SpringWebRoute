package Capstone.SpringWebRoute.Repository;

import Capstone.SpringWebRoute.Models.Comment;
import org.hibernate.mapping.Value;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Integer> {

    List<Comment> findCommentsByUserId(int userId);

    @Query(value = "select * from comment where post_post_id = :t1", nativeQuery = true)
    List<Comment> getCommentByPostId(@Param("t1") int postId);


}
