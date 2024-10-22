package Capstone.SpringWebRoute.Service;

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
        return userRepo.findUserPageByUserId(userId);
    }

    public void save(UserPage userPage) {
        userRepo.save(userPage);
    }

}
