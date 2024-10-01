package Capstone.SpringWebRoute.Controllers;

import Capstone.SpringWebRoute.Models.User;
import Capstone.SpringWebRoute.Models.UserPage;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/User")
public class UserController {

    public List<User> Users = new ArrayList<>();

    @GetMapping("/GetAllUsers")
    public List<User> getAllUsers() {
        return Users;
    }

    @PostMapping("/AddUser")
    public String addNewUser(@RequestBody User newUser) {
        Users.add(newUser);

        // Create User Page When A new User is created
        //UserPage userPage = new UserPage( 1, newUser.getUserName(), newUser.getUserId());



        return "User " + newUser.getUserName() + " has been added";
    }

    @PutMapping("/DeleteUser/{id}")
    public String deleteUser(@PathVariable int id) {

        String userName = "";

        for(User user : Users) {
            if (user.getUserId() == id) {
                user.setDeleted(true);
                userName = user.getUserName();
            }
        }

        if (userName == "") {
            return "User was not found";
        }

        return "User " + userName + " has been deleted";
    }

    @PutMapping("/UpdateUser/{id}")
    public String UpdateUserInfo(@PathVariable int id, @RequestBody User newUserInfo) {

        String userName = "";

        for (User user : Users) {
            if (user.getUserId() == id) {
                user.setUserId(newUserInfo.getUserId());
                user.setUserName(newUserInfo.getUserName());
                user.setEmail(newUserInfo.getEmail());
                user.setPassWord(newUserInfo.getPassWord());
                user.setUserPageId(newUserInfo.getUserPageId());
                user.setDeleted(newUserInfo.isDeleted());
                userName = user.getUserName();
            }
        }

        return "User " + userName + " has been updated";
    }

}
