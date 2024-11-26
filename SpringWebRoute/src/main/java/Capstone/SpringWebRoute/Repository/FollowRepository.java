package Capstone.SpringWebRoute.Repository;

import Capstone.SpringWebRoute.Models.Follow;
import Capstone.SpringWebRoute.Models.UserPage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FollowRepository extends JpaRepository<Follow, Integer> {

    boolean existsByFollowerAndFollowed(UserPage follower, UserPage Followed);

    Follow findByFollowerAndFollowed(UserPage follower, UserPage followed);
}
