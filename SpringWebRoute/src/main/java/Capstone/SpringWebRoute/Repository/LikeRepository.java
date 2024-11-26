package Capstone.SpringWebRoute.Repository;

import Capstone.SpringWebRoute.Models.Userlike;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LikeRepository extends JpaRepository<Userlike, Integer> {

    Userlike findByLikeIdAndPageId(int likeId, int pageId);

    Userlike findByUsername(String username);
}
