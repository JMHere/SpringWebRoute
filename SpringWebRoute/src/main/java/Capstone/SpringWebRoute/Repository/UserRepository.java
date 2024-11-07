package Capstone.SpringWebRoute.Repository;


import Capstone.SpringWebRoute.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Integer> {

    User findByUsername(String userName);

    User findByUsernameAndPassword(String username, String passWord);

}
