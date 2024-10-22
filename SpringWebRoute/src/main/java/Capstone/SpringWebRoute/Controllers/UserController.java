package Capstone.SpringWebRoute.Controllers;

import Capstone.SpringWebRoute.Models.User;
import Capstone.SpringWebRoute.Models.UserPage;
import Capstone.SpringWebRoute.Service.UserPageService;
import Capstone.SpringWebRoute.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/User")
public class UserController {

    public List<User> Users = new ArrayList<>();

    @Autowired
    private UserService userSer;

    @Autowired
    private UserPageService pageSer;

    @GetMapping("/GetAllUsers")
    public List<User> getAllUsers() {
        return userSer.findAll();
    }

    @GetMapping("/{userId}")
    public User getUserById() {
            User result = userSer.findUserById(1);
            return result;

    }

    @PostMapping("/AddUser")
    public String addNewUser(@RequestBody User newUser) {
        userSer.save(newUser);
        UserPage newPage = new UserPage(newUser.getUserId(), newUser.getUserName());
        newPage.createDate();
        pageSer.save(newPage);

        // Create User Page When A new User is created
        //UserPage userPage = new UserPage( 1, newUser.getUserName(), newUser.getUserId());

        return "User " + newUser.getUserName() + " has been added";
    }

    @PutMapping("/DeleteUser/{id}")
    public String deleteUser(@PathVariable int id) {

        String userName = "";

        User user = userSer.delete(id);
        userName = user.getUserName();
        user.setDeleted(true);

        userSer.save(user);

//        for(User user : Users) {
//            if (user.getUserId() == id) {
//                user.setDeleted(true);
//                userName = user.getUserName();
//            }
//        }
//
//        if (userName == "") {
//            return "User was not found";
//        }

        return "User " + userName + " has been deleted";
    }

    @PutMapping("/RestoreUser/{userId}")
    public String restoreUser(@PathVariable int userId) {

        String userName = "";
        User user = userSer.findUserById(userId);
        userName = user.getUserName();
        user.setDeleted(false);
        userSer.save(user);

        return "User " + userName + " has been restored";

    }


    @PutMapping("/UpdateUser/{id}")
    public String UpdateUserInfo(@PathVariable int id, @RequestBody User newUserInfo) {

        String userName = "";

        User foundUser = userSer.findUserById(id);
        foundUser.setUserId(newUserInfo.getUserId());
        foundUser.setUserName(newUserInfo.getUserName());
        foundUser.setEmail(newUserInfo.getEmail());
        foundUser.setPassWord(newUserInfo.getPassWord());
        foundUser.setUserPageId(newUserInfo.getUserPageId());
        foundUser.setDeleted(newUserInfo.isDeleted());
        userName = foundUser.getUserName();



//        for (User user : Users) {
//            if (user.getUserId() == id) {
//                user.setUserId(newUserInfo.getUserId());
//                user.setUserName(newUserInfo.getUserName());
//                user.setEmail(newUserInfo.getEmail());
//                user.setPassWord(newUserInfo.getPassWord());
//                user.setUserPageId(newUserInfo.getUserPageId());
//                user.setDeleted(newUserInfo.isDeleted());
//                userName = user.getUserName();
//            }
//        }

        return "User " + userName + " has been updated";
    }

}
