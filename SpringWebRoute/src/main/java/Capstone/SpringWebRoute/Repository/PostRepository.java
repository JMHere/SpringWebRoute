package Capstone.SpringWebRoute.Repository;

import Capstone.SpringWebRoute.Models.Post;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Integer> {

    List<Post> findPostsByUserId(int userId);

}
