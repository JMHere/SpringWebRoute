package Capstone.SpringWebRoute.Service;


import Capstone.SpringWebRoute.Models.User;
import Capstone.SpringWebRoute.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {


    @Autowired
    private UserRepository userRepo;

    public List<User> findAll() {
        return userRepo.findAll();
    }

    public Optional<User> findUserById(int userId) {
        return userRepo.findById(userId);
    }

    public User save(User user) {
        return userRepo.save(user);
    }

    public User delete(int id) {
        User user = userRepo.findById(id).get();
        return user;
    }

    public User restorUser(int id) {
        User user = userRepo.findById(id).get();
        return user;
    }

}
