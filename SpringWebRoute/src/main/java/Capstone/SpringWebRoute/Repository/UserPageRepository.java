package Capstone.SpringWebRoute.Repository;

import Capstone.SpringWebRoute.Models.UserPage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserPageRepository extends JpaRepository<UserPage, Integer> {

    UserPage findUserPageByUserId(int userId);
}
