package Capstone.SpringWebRoute.Repository;

import Capstone.SpringWebRoute.Models.User;
import Capstone.SpringWebRoute.Models.UserPage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserPageRepository extends JpaRepository<UserPage, Integer> {

    @Query(value = "select * from user_page where user_id = ?1", nativeQuery = true)
    UserPage findUserPageByUserID(int userId);

    List<UserPage> findUserPageByUsernameStartsWith(String username);

    UserPage findUserPageByUsername(String username);
}
