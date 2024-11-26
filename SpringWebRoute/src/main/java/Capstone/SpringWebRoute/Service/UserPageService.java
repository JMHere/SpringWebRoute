package Capstone.SpringWebRoute.Service;

import Capstone.SpringWebRoute.Models.User;
import Capstone.SpringWebRoute.Models.UserPage;
import Capstone.SpringWebRoute.Repository.UserPageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserPageService {

    @Autowired
    UserPageRepository userRepo;

    public List<UserPage> getAllUserPages() {
        return userRepo.findAll();
    }

    public UserPage findUserPageById(int pageId) {
        return userRepo.findById(pageId).get();
    }

    public UserPage findUserPageByUserId(int userId) {
        return userRepo.findUserPageByUserID(userId);
    }

    public List<UserPage> findUserPageByUsername(String username) {
        return userRepo.findUserPageByUsernameStartsWith(username);
    }

    public UserPage findSingleUserPageByUsername(String username) {
        return userRepo.findUserPageByUsername(username);
    }

    public void save(UserPage userPage) {
        userRepo.save(userPage);
    }
    


}
